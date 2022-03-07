package hooks;

import driver_factory.DriverFactory;
import generic_methods.GenericMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import static generic_methods.GenericMethods.writeOnScren;
import static project_global_variables.GlobalVariables.DEFAULT_WEB_DRIVER;

public class serviceHooks {

    private WebDriver driver;
    public static Scenario scenario;
    public GenericMethods genericMethods = new GenericMethods();

    @Before
    public void before(Scenario currentScenario){
        writeOnScren(" ############## BEFORE ##############");
        scenario = currentScenario;
        writeOnScren("Scenario Name - " + scenario.getName());
        driver = DriverFactory.getDriver();
        writeOnScren("Executing scenario on: " + DEFAULT_WEB_DRIVER);
        writeOnScren(" ############## BEFORE ##############");
    }

    @After
    public void after(){
        writeOnScren(" ############## AFTER ##############");
        writeOnScren("Scenario Name - " + scenario.getName());
        writeOnScren("Status - " + scenario.getStatus());
        DriverFactory.quitDriver();
    }
}
