package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public String homePageUrl = "https://www.amazon.com/";
    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement searchInputField;

    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"nav-link-accountList-nav-line-1\"]")
    private WebElement signInLink;

    @FindBy(xpath = "//*[@id=\"nav-global-location-popover-link\"]")
    private WebElement deliverToPopOverLink;

    @FindBy(xpath = "//*[@id=\"glow-ingress-line2\"]")
    private WebElement deliverToPopOverLinkText;

    @FindBy(xpath = "//h4[@class='a-popover-header-content']")
    private WebElement locationSettingsPopOverHeader;

    @FindBy(xpath = "//input[@aria-label='or enter a US zip code']")
    private WebElement zipCodeInputField;

    @FindBy(xpath = "//span[contains(text(),'Apply')]/../input")
    private WebElement applyZipCodeButton;

    @FindBy(xpath = "//*[@id=\"GLUXConfirmClose\"]")
    private WebElement applyZipCodeContinueButton;





    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getHomePageUrl() {
        return homePageUrl;
    }
    public void openHomePage(String url) {
        driver.get(url);
    }

    public boolean isSearchInputFieldVisible() {
        return searchInputField.isDisplayed();
    }

    public void enterSearchKeyword(final String keyword) {
        searchInputField.clear();
        searchInputField.sendKeys(keyword);
    }

    public void clickOnSearchButton() {
        searchButton.click();
    }

    public boolean isSignInLinkVisible(){
        return signInLink.isDisplayed();
    }

    public void clickOnSignInLink(){
        signInLink.click();
    }

    public boolean isDeliverToPopOverLinkVisible(){
        return deliverToPopOverLink.isDisplayed();
    }

    public void clickOnDeliverToPopOverLink(){
        deliverToPopOverLink.click();
    }

    public boolean isLocationSettingsPopOverHeaderVisible() {
        return locationSettingsPopOverHeader.isDisplayed();
    }

    public String getLocationSettingsPopOverHeader() {
        return locationSettingsPopOverHeader.getText();
    }

    public boolean isZipCodeFieldVisible() {
        return zipCodeInputField.isDisplayed();
    }


    public void enterZipCodeInZipCodeField(String zipCode) {
        zipCodeInputField.sendKeys(zipCode);
    }

    public boolean isApplyZipCodeButtonVisible() {
        return applyZipCodeButton.isDisplayed();
    }


    public void clickApplyZipCodeButton() {
        applyZipCodeButton.click();
    }

    public boolean isApplyZipCodeContinueButtonVisible() {
        return applyZipCodeContinueButton.isDisplayed();
    }


    public void clickApplyZipCodeContinueButton() {
        applyZipCodeContinueButton.click();
    }

    public String getDeliverToPopOverLinkText() {
        return deliverToPopOverLinkText.getText();
    }

}
