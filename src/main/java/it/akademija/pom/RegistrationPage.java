package it.akademija.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends AbstractPage {

    @FindBy(xpath = "//input[@id='input-firstname']")
    private WebElement inputFirstName;

    @FindBy(xpath = "//div[@class='text-danger']")
    private WebElement invalidFirstName;

    @FindBy(xpath = "//input[@id='input-lastname']")
    private WebElement inputLastName;

    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//input[@id='input-telephone']")
    private WebElement inputTelephone;

    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//input[@id='input-confirm']")
    private WebElement inputConfirmPassword;

    @FindBy(xpath = "//input[@name='agree']")
    private WebElement checkboxAgree;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement buttonContinue;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage enterFirstName(String firstName) {
        inputFirstName.sendKeys(firstName);
        return this;
    }

    public String getInvalidInputErrorMessage() {
        return invalidFirstName.getText();
    }

    public RegistrationPage enterLastName(String lastName) {
        inputLastName.sendKeys(lastName);
        return this;
    }

    public RegistrationPage enterEmail(String email) {
        inputEmail.sendKeys(email);
        return this;
    }

    public RegistrationPage enterTelephone(String telephone) {
        inputTelephone.sendKeys(telephone);
        return this;
    }

    public RegistrationPage enterPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    public RegistrationPage confirmPassword(String confirmPassword) {
        inputConfirmPassword.sendKeys(confirmPassword);
        return this;
    }

    public RegistrationPage checkAgree() {
        checkboxAgree.click();
        return this;
    }

    public RegistrationPage pressButtonContinue() {
        buttonContinue.click();
        return this;
    }

}
