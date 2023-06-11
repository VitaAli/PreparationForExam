package it.akademija.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractPage{

    @FindBy(xpath = "//span[.='My Account']")
    private WebElement myAccount;

    @FindBy(xpath = "//li/a[.='Register']")
    private WebElement registerFromMyAccount;

    public Header(WebDriver driver) {
        super(driver);
    }

    public void openRegistrationPage() {
        myAccount.click();
        registerFromMyAccount.click();
    }
}
