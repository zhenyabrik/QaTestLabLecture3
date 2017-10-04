package myprojects.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    //driver
    private WebDriver driver;
//   private EventFiringWebDriver driver;

    //locators
    private By userAvatar = By.id("employee_infos");
    private static By logoutButton = By.id("header_logout");
    private By pageTitle = By.cssSelector(".page-title");

    //menu items
    private By dashboardItem = By.id("tab-AdminDashboard");
    private By ordersItem = By.id("subtab-AdminParentOrders");
    private static By catalogItem = By.id("subtab-AdminCatalog");
    private By customersItem = By.id("subtab-AdminParentCustomer");
    private By supportItem = By.id("subtab-AdminParentCustomerThreads");
    private By statisticItem = By.id("subtab-AdminStats");

    //variables
    private String dashboardHeader = "Пульт";
    private String ordersHeader = "Заказы";
    private String catalogHeader = "товары";
    private String customersHeader = "Управление клиентами";
    private String supportHeader = "Customer Service";
    private String statisticHeader = "Статистика";

    //methods
    public void checkDashboardItem(){
        driver.findElement(dashboardItem).click();
        driver.findElement(pageTitle).isDisplayed();
        System.out.println(driver.findElement(pageTitle).getText());
        driver.navigate().refresh();
        driver.findElement(pageTitle).getText().matches(dashboardHeader);
    }
    public void checkOrdersItem(){
        driver.findElement(ordersItem).click();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.urlContains("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/index.php?controller=AdminOrders"));
        driver.findElement(pageTitle).isDisplayed();
        System.out.println(driver.findElement(pageTitle).getText());
        driver.navigate().refresh();
        driver.findElement(pageTitle).getText().matches(ordersHeader);
    }



    public void logoutAction(){
//        WebDriverWait wait = new WebDriverWait(driver, 2);
//        wait.until(ExpectedConditions.elementToBeClickable(userAvatar));
        driver.findElement(userAvatar).click();
        driver.findElement(logoutButton).click();
        driver.manage().getCookies().clear();
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }

    //getters
    public static By getCatalogItem() {
        return catalogItem;
    }

    public static By getLogoutButton() {
        return logoutButton;
    }

    //constructor
    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }
}
