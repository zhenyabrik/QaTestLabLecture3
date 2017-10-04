package myprojects.automation.assignment3.tests;

import myprojects.automation.BaseScript;
import myprojects.automation.pages.CatalogPage;
import myprojects.automation.pages.DashboardPage;
import myprojects.automation.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class CreateCategoryTest extends BaseScript {

    public static void main(String[] args) throws InterruptedException {
//        WebDriver driver = getConfiguredDriver();
        EventFiringWebDriver driver = getConfiguredDriver();

        //login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAction();

        //create category
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.createCategory();

        //check that new category appears in Categories table
        catalogPage.findAndCheckNewCategory();

        //logout
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.logoutAction();

        driverQuit(driver);
    }
}
