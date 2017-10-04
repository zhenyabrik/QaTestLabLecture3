package myprojects.automation.pages;

import myprojects.automation.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class LoginPage {
//    private WebDriver driver;
    private EventFiringWebDriver driver;

    //locators
    private By emailInput = By.id("email");
    private By passwordInput = By.id("passwd");
    private By loginButton = By.cssSelector(".btn.btn-primary.btn-lg.btn-block.ladda-button");

    //variables
    private String login = "webinar.test@gmail.com";
    private String password = "Xcg7299bnSmMuRLp9ITw";

    //constructor
    public LoginPage(EventFiringWebDriver driver){
        this.driver = driver;
    }

    //methods
    public void loginAction(){
        driver.get(Properties.getBaseAdminUrl());
        driver.findElement(emailInput).isDisplayed();
        driver.findElement(emailInput).sendKeys(login);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}
