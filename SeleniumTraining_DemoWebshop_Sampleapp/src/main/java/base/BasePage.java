package base;

import driver_factory.DriverFactory;
import generic_methods.GenericMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected static WebDriverWait wait;
    public GenericMethods genericMethods;

    public BasePage(){
        driver = DriverFactory.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        genericMethods = new GenericMethods();
        PageFactory.initElements(driver, this);
    }

    public static WebDriverWait getDefaultWait(){
        return wait;
    }

}
