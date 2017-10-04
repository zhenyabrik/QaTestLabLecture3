package myprojects.automation.assignment2.tests;

import myprojects.automation.BaseScript;
import myprojects.automation.pages.DashboardPage;
import myprojects.automation.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.Optional;

public class CheckMainMenuTest extends BaseScript{

    public static void main(String[] args) throws InterruptedException {
//        WebDriver driver = getConfiguredDriver();
        EventFiringWebDriver driver = getConfiguredDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAction();

        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.checkDashboardItem();
        dashboardPage.checkOrdersItem();
        dashboardPage.logoutAction();


        driverQuit(driver);
    }
}
