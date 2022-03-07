package driver_factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static project_global_variables.GlobalVariables.DEFAULT_WEB_DRIVER;

public class DriverFactory {
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>(){
        protected synchronized WebDriver initialValue(){
            return selectDriverType();
        }
    };

    public static WebDriver getDriver(){
        return threadDriver.get();
    }

    public static void quitDriver(){
        WebDriver localDriver = getDriver();
        if(localDriver != null){
            localDriver.quit();
            localDriver = null;
        }
        if(threadDriver != null){
            threadDriver.remove();
        }
    }

    public static WebDriver selectDriverType(){
        WebDriver driver = null;
        switch (DEFAULT_WEB_DRIVER){
            case "chrome":
                ChromeOptions cOptions = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                cOptions.addArguments("--incognito");
                cOptions.addArguments("start-maximized");
                cOptions.addArguments("enable-automation");
                System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
                DesiredCapabilities dCapabilities = DesiredCapabilities.chrome();
                dCapabilities.setCapability(ChromeOptions.CAPABILITY, cOptions);
                cOptions.merge(dCapabilities);
                driver = new ChromeDriver(cOptions);
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "explorer":
                driver = new InternetExplorerDriver();
                break;
        }
        return driver;
    }

}
