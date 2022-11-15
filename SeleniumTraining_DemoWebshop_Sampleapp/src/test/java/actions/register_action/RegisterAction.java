package actions.register_action;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.register_page.RegisterPage;

import static org.openqa.selenium.By.xpath;

public class RegisterAction extends RegisterPage {
    private WebElement genderElement;
    public void registerPageVisibility(){
        genericMethods.validateVisibilityOfElement(registerForm);
    }

    public void selectGenderRadioBox(String gender){
        genderElement = dynamicMapForGender(gender);
        genderElement.click();
    }

    // REUSABLE
    private WebElement dynamicMapForGender(String gender){
        wait.until(ExpectedConditions.presenceOfElementLocated(xpath("//div[@class = 'gender']//*[@for = 'gender-"+gender+"']")));
        return driver.findElement(xpath("//div[@class = 'gender']//*[@for = 'gender-"+gender+"']"));
    }
}
