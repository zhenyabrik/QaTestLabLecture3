package myprojects.automation;

import myprojects.automation.utils.EventHandler;
import myprojects.automation.utils.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public abstract class BaseScript {

    private static WebDriver getDriver() {
        String browser = Properties.getBrowser();
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver",
                        new File(BaseScript.class.getResource("/chromedriver.exe").getFile()).getPath());
                return new ChromeDriver();
            case "firefox":
            default:
                System.setProperty("webdriver.gecko.driver",
                        new File(BaseScript.class.getResource("/geckodriver.exe").getFile()).getPath());
                return new FirefoxDriver();
            case "ie":
            case "internet explorer":
//            default:
                System.setProperty("webdriver.ie.driver",
                        new File(BaseScript.class.getResource("/IEDriverServer.exe").getFile()).getPath());
                return new InternetExplorerDriver();
        }
    }
    public static EventFiringWebDriver getConfiguredDriver(){
        WebDriver driver = getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        EventFiringWebDriver wrappedDriver = new EventFiringWebDriver(driver);

        wrappedDriver.register(new EventHandler());

        return wrappedDriver;
    }

    //driver without logger
//    public static WebDriver getConfiguredDriver(){
//        WebDriver driver = getDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        return driver;
//    }

//    public static void getscreenshot() throws Exception
//    {
//        File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(scrFile, new File("/screenshot.png"));
//    }

    public static void driverQuit(WebDriver driver){
        driver.quit();
    }
}
