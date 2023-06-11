package it.akademija.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessPage extends AbstractPage {
    @FindBy(xpath = "//h1[.='Your Account Has Been Created!']")
    private WebElement successMessageWhenUserRegistered;

    public SuccessPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSuccessMessageWhenAccountRegistered() {
        return successMessageWhenUserRegistered;
    }
}
