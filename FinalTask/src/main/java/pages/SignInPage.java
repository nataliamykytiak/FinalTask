package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"ap_email\"]")
    private WebElement emailOrMobilePhoneNumberField;

    @FindBy(xpath = "//*[@id=\"continue\"]")
    private WebElement continueButton;

    @FindBy(xpath = "//*[@id=\"auth-email-missing-alert\"]/div/div")
    private WebElement enterYourEmailErrorMessage;

    @FindBy(xpath = "//*[@id=\"auth-error-message-box\"]/div/div")
    private WebElement incorrectPasswordErrorMessage;

    @FindBy(xpath = "//*[@id=\"ap_password\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"signInSubmit\"]")
    private WebElement signInButton;


    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public boolean isEmailOrMobilePhoneNumberFieldVisible(){
        return emailOrMobilePhoneNumberField.isDisplayed();
    }

    public void enterUserEmail(String email) {
        emailOrMobilePhoneNumberField.sendKeys(email);
    }

    public boolean isContinueButtonVisible(){
        return continueButton.isDisplayed();
    }

    public void clickOnContinueButton(){
        continueButton.click();
    }

    public String getEnterYourEmailErrorMessageText(){
        return enterYourEmailErrorMessage.getText();
    }

    public boolean isPasswordFieldVisible(){
        return passwordField.isDisplayed();
    }

    public void enterUserPassword(String password) {
        passwordField.sendKeys(password);
    }

    public boolean isSignInButtonVisible(){
        return signInButton.isDisplayed();
    }

    public void clickOnSignInButton() {
        signInButton.click();
    }

    public boolean isIncorrectPasswordErrorMessageVisible(){
        return incorrectPasswordErrorMessage.isDisplayed();
    }
    public String getIncorrectPasswordErrorMessageText(){
        return incorrectPasswordErrorMessage.getText();
    }
}
