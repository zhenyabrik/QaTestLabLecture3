package myprojects.automation.utils;

import myprojects.automation.BaseScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;

public class EventHandler implements WebDriverEventListener{

//    @Override
//    public void beforeAlertAccept(WebDriver webDriver) {
//
//    }
//
//    @Override
//    public void afterAlertAccept(WebDriver webDriver) {
//
//    }
//
//    @Override
//    public void afterAlertDismiss(WebDriver webDriver) {
//
//    }
//
//    @Override
//    public void beforeAlertDismiss(WebDriver webDriver) {
//
//    }

    @Override
    public void beforeNavigateTo(String s, WebDriver webDriver) {
        System.out.println("navigate to: " + s);
    }

    @Override
    public void afterNavigateTo(String s, WebDriver webDriver) {
        System.out.println("Open URL: " + s);

    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {
        System.out.println("reload page");
    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {
        System.out.println("page is reloaded, cookies are deleted");
    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        System.out.println("Search for element: " + by.toString());

    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        System.out.println("Element found successfully");

    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        System.out.println("Click on element: " + webElement.getTagName() + " " + webElement.getAttribute("name"));
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        System.out.println("Element successfully clicked");

    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        System.out.println("Fill input " + webElement.getAttribute("id") + " with value " + charSequences.toString());
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        System.out.println("Element successfully changed");
    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {
        System.out.println(Time.valueOf(LocalTime.MAX));
    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {
        System.out.println(Time.valueOf(LocalTime.MAX));
    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {
//        try {
//            BaseScript.getscreenshot();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
