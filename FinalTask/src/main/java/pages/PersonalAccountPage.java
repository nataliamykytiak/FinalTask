package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalAccountPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"nav-link-accountList-nav-line-1\"]")
    private WebElement greeting;

    @FindBy(xpath = "//*[@id=\"nav-link-accountList\"]/span")
    private WebElement accountAndListsSection;

    @FindBy(xpath = "//*[@id=\"a-page\"]/div[2]/div/div[2]/div[2]/a/div")
    private WebElement loginAndSecuritySection;

    @FindBy(xpath = "//*[@id=\"auth-cnep-edit-name-button\"]")
    private WebElement editButtonOfNameField;

    @FindBy(xpath = "//*[@id=\"ap_cnep_header\"]")
    private WebElement changeNamePageTitle;

    @FindBy(xpath = "//*[@id=\"ap_customer_name\"]")
    private WebElement newNameField;

    @FindBy(xpath = "//*[@id=\"cnep_1C_submit_button\"]")
    private WebElement saveChangesButton;

    @FindBy(xpath = "/html/body/div[1]/header/div/div[3]/div[2]/div[2]/div/div[2]/a[13]/span")
    private WebElement signOutLink;



    public PersonalAccountPage(WebDriver driver) {
        super(driver);
    }

    public String getGreetingText(){
        return greeting.getText();
    }

    public boolean isAccountAndListsSectionVisible(){
        return accountAndListsSection.isDisplayed();
    }

    public void clickOnAccountAndListsSection () {
        accountAndListsSection.click();
    }

    public boolean isLoginAndSecuritySectionVisible(){
        return loginAndSecuritySection.isDisplayed();
    }

    public void clickOnLoginAndSecuritySection () {
        loginAndSecuritySection.click();
    }

    public boolean isEditButtonOfNameFieldVisible(){
        return editButtonOfNameField.isDisplayed();
    }

    public void clickOnEditButtonOfNameField () {
        editButtonOfNameField.click();
    }

    public boolean isNewNameFieldVisible(){
        return newNameField.isDisplayed();
    }

    public void enterNewNameForAccount(String newName) {
        newNameField.clear();
        newNameField.sendKeys(newName);
    }

    public boolean isSaveChangesButtonVisible(){
        return saveChangesButton.isDisplayed();
    }

    public void clickOnSaveChangesButton() {
        saveChangesButton.click();
    }

    public String getChangeNamePageTitleText(){
        return changeNamePageTitle.getText();
    }


}
