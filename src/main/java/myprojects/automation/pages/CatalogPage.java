package myprojects.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatalogPage {
    //driver
//    private WebDriver driver;
    private EventFiringWebDriver driver;

    //locators
    private By categorySubItem = By.id("subtab-AdminCategories");
    private By addCategoryButton = By.id("page-header-desc-category-new_category");
    private By newCategoryNameInput = By.id("name_1");
    private By saveCategoryButton = By.id("category_form_submit_btn");
    private By succesSaveCategoryMessageBlock = By.cssSelector(".alert.alert-success");
    private By categoryNameCaretDownIcon = By.xpath(".//*[@id='table-category']/thead/tr[1]/th[3]/span/a[1]/i");
    private By categoryTableBody = By.cssSelector("#table-category>tbody");

    //variables
    private String categoryName = "new category";
    private String categoryName2 = "xxx";
    private String succesSaveCategoryMessage = "Создано";

    //methods
    public void createCategory(){
        WebElement categorySubMenuElement = driver.findElement(DashboardPage.getCatalogItem());
        Actions actions = new Actions(driver);
        actions.moveToElement(categorySubMenuElement).build().perform();
        categorySubMenuElement.findElement(categorySubItem).click();

        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.elementToBeClickable(addCategoryButton));
        driver.findElement(addCategoryButton).click();
        driver.findElement(newCategoryNameInput).sendKeys(categoryName);
        driver.findElement(saveCategoryButton).click();
        driver.findElement(succesSaveCategoryMessageBlock).getText().contains(succesSaveCategoryMessage);
        driver.findElement(DashboardPage.getLogoutButton()).isDisplayed();
    }

    public void findAndCheckNewCategory(){
        driver.findElement(categoryNameCaretDownIcon).click();
        driver.findElement(categoryTableBody).getText().contains(categoryName);
    }

    //constructor
    public CatalogPage(EventFiringWebDriver driver){
        this.driver = driver;
    }
}
