package it.akademija.test;

import it.akademija.pom.Header;
import it.akademija.pom.RegistrationPage;
import it.akademija.pom.SuccessPage;
import org.junit.jupiter.api.Test;

import static it.akademija.utils.GenerateDataUtils.generateRandomNumber;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationPageTest extends BaseTest {

    private Header header;
    private RegistrationPage registrationPage;
    private SuccessPage successPage;

    @Test
    public void accountRegisteredSuccessfully() {
        header = new Header(driver);
        registrationPage = new RegistrationPage(driver);
        successPage = new SuccessPage(driver);

        header.openRegistrationPage();
        String password = "Password" + generateRandomNumber();
        registrationPage
                .enterFirstName("FirstName" + generateRandomNumber())
                .enterLastName("LastName" + generateRandomNumber())
                .enterEmail("Email" + generateRandomNumber() + "@email.com")
                .enterTelephone("+370" + generateRandomNumber())
                .enterPassword(password)
                .confirmPassword(password)
                .checkAgree()
                .pressButtonContinue();
        String expectedMessage = "Your Account Has Been Created!";
        String actualMessage = successPage.getSuccessMessageWhenAccountRegistered().getText();
        assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void accountNotRegisteredIfFirstNameIsNotFilled() {
        header = new Header(driver);
        registrationPage = new RegistrationPage(driver);
        successPage = new SuccessPage(driver);

        header.openRegistrationPage();
        String password = "Password" + generateRandomNumber();
        registrationPage
                .enterLastName("LastName" + generateRandomNumber())
                .enterEmail("Email" + generateRandomNumber() + "@email.com")
                .enterTelephone("+370" + generateRandomNumber())
                .enterPassword(password)
                .confirmPassword(password)
                .checkAgree()
                .pressButtonContinue();
        String expectedErrorMessage = "First Name must be between 1 and 32 characters!";
        String actualErrorMessage = registrationPage.getInvalidInputErrorMessage();
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }
}
