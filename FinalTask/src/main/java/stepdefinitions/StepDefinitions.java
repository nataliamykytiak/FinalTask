package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.HomePage;
import pages.PersonalAccountPage;
import pages.SearchResultsPage;
import pages.SignInPage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.testng.Assert.*;

public class StepDefinitions {
    private static final long DEFAULT_TIMEOUT = 60;
    WebDriver driver;
    HomePage homePage;
    SearchResultsPage searchResultsPage;
    SignInPage signInPage;
    PersonalAccountPage personalAccountPage;

    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @When("User checks search input field visibility")
    public void userChecksSearchInputFieldVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(homePage.isSearchInputFieldVisible());
    }

    @And("User makes search by keyword {string}")
    public void userMakesSearchByKeywordKeyword(String keyword) {
        homePage.enterSearchKeyword(keyword);
    }

    @And("User clicks search button")
    public void userClicksSearchButton() {
        homePage.clickOnSearchButton();
    }

    @And("User checks search results visibility")
    public void userChecksSearchResultsVisibility() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @Then("User checks number of found products equals {string}")
    public void userChecksNumberOfFoundProductsEqualsNumberOfFoundProducts(String numberOfFoundProducts) {
        assertEquals(searchResultsPage.getSearchResultsSize(), numberOfFoundProducts);
    }


    @Then("User checks search results first item name contains {string}")
    public void userChecksSearchResultsFirstItemNameContainsKeyword(String keyword) {
        assertTrue(searchResultsPage.getSearchResultsFirstItemName().toLowerCase().contains(keyword));
    }


    @When("User checks Sign In link visibility")
    public void userChecksSignInButtonVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(homePage.isSignInLinkVisible());
    }


    @And("User clicks Sign In link")
    public void userClicksSignInButton() {
        homePage.clickOnSignInLink();
    }


    @And("User checks Email or mobile phone number field visibility on sign in page")
    public void userChecksEmailOrMobilePhoneNumberFieldVisibilityOnSignInPage() {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.isEmailOrMobilePhoneNumberFieldVisible();
    }

    @And("User checks Continue button visibility on sign in page")
    public void userChecksContinueButtonVisibilityOnSignInPage() {
        signInPage.isContinueButtonVisible();
    }

    @And("User clicks Continue button")
    public void userClicksContinueButton() {
        signInPage.clickOnContinueButton();
    }

    @Then("User checks that current error message is {string}")
    public void userChecksThatCurrentErrorMessageIsErrorMessage(String errorMessage) {
        assertEquals(signInPage.getEnterYourEmailErrorMessageText(), errorMessage);
    }

    @And("User enters his email in Email or mobile phone number field {string}")
    public void userEntersHisEmailInEmailOrMobilePhoneNumberFieldUserEmail(String userEmail) {
        signInPage.enterUserEmail(userEmail);
    }


    @And("User checks Password field visibility on sign in page")
    public void userChecksPasswordFieldVisibilityOnSignInPage() {
        signInPage.isPasswordFieldVisible();
    }


    @And("User enters password {string}")
    public void userEntersPasswordUserPassword(String userPassword) {
        signInPage.enterUserPassword(userPassword);
    }


    @And("User checks Sign-In button visibility on sign in page")
    public void userChecksSignInButtonVisibilityOnSignInPage() {
        signInPage.isSignInButtonVisible();
    }


    @And("User clicks Sign-In button on sign in page")
    public void userClicksSignInButtonOnSignInPage() {
        signInPage.clickOnSignInButton();
    }


    @Then("User checks the greeting text on a personal account page {string}")
    public void userChecksUserWasLoggedInToSiteAsUserName(String greeting) {
        personalAccountPage = pageFactoryManager.getPersonalAccountPage();
        assertEquals(personalAccountPage.getGreetingText(), greeting);
    }

    @And("User clicks Account & Lists button in the header of a page")
    public void userClicksAccountListsButtonInTheHeaderOfAPage() {
        personalAccountPage = pageFactoryManager.getPersonalAccountPage();
        personalAccountPage.isAccountAndListsSectionVisible();
        personalAccountPage.clickOnAccountAndListsSection();
    }


    @And("User checks Login & security section visibility on personal account page")
    public void userChecksLoginSecuritySectionVisibilityOnPersonalAccountPage() {
        personalAccountPage.isLoginAndSecuritySectionVisible();
    }

    @And("User clicks Login & security")
    public void userClicksLoginSecurity() {
        personalAccountPage.clickOnLoginAndSecuritySection();
    }

    @And("User checks Edit button in Name field visibility")
    public void userChecksEditButtonInNameFieldVisibility() {
        personalAccountPage.isEditButtonOfNameFieldVisible();
    }

    @And("User clicks Edit button")
    public void userClicksEditButton() {
        personalAccountPage.clickOnEditButtonOfNameField();
    }

    @And("User checks title of page is {string}")
    public void userChecksTitleOfPageIsChangeNameTitle(String pageTitle) {
        assertEquals(personalAccountPage.getChangeNamePageTitleText(), pageTitle);
    }

    @And("User changes current name to {string} new name")
    public void userChangesCurrentNameToNewNameNewName(String newName) {
        personalAccountPage.enterNewNameForAccount(newName);
    }

    @And("User checks Save changes button visibility")
    public void userChecksSaveChangesButtonVisibility() {
        personalAccountPage.isSaveChangesButtonVisible();
    }

    @And("User clicks Save changes button")
    public void userClicksSaveChangesButton() {
        personalAccountPage.clickOnSaveChangesButton();
    }

    @Then("User checks that current name is {string}")
    public void userChecksThatCurrentNameIsCurrentName(String currentName) {
        assertTrue(personalAccountPage.getGreetingText().contains(currentName));
    }

    @Then("User checks that current error password message is {string}")
    public void userChecksThatCurrentErrorPasswordMessageIsErrorPasswordMessage(String errorMessage) {
        signInPage.isIncorrectPasswordErrorMessageVisible();
        assertEquals(signInPage.getIncorrectPasswordErrorMessageText(), errorMessage);
    }


    @When("User checks Deliver To pop-over link visibility")
    public void userChecksDeliverToPopOverLinkVisibility() {
        homePage.isDeliverToPopOverLinkVisible();
    }

    @And("User clicks on Deliver To pop-over link")
    public void userClicksOnDeliverToPopOverLink() {
        homePage.clickOnDeliverToPopOverLink();
    }

    @And("User checks Location Settings Popup visibility")
    public void userChecksLocationSettingsPopupVisibility() {
        homePage.isLocationSettingsPopOverHeaderVisible();
    }

    @And("User checks Location Settings Popup text equals to {string} text")
    public void userChecksLocationSettingsPopupTextEqualsToLocationSettingsTitleText(String locationText) {
        assertEquals(homePage.getLocationSettingsPopOverHeader(), locationText);
    }

    @And("User checks Zip Code input field visibility")
    public void userChecksZipCodeInputFieldVisibility() {
        homePage.isZipCodeFieldVisible();
    }

    @And("User enters Zip Code {string} in Zip Code input field")
    public void userEntersZipCodeZipCodeInZipCodeInputField(String zipCode) {
        homePage.enterZipCodeInZipCodeField(zipCode);
    }

    @And("User checks Apply button visibility")
    public void userChecksApplyButtonVisibility() {
        homePage.isApplyZipCodeButtonVisible();
    }

    @And("User clicks on Apply button")
    public void userClicksOnApplyButton() {
        homePage.clickApplyZipCodeButton();
    }


    @And("User checks Continue button visibility")
    public void userChecksContinueButtonVisibility() {
        homePage = pageFactoryManager.getHomePage();
        homePage.isApplyZipCodeContinueButtonVisible();
    }

    @And("User clicks on Continue button")
    public void userClicksOnContinueButton() {
        homePage.clickApplyZipCodeContinueButton();
    }

    @Then("User checks current delivery location contains {string}")
    public void userChecksCurrentDeliveryLocationContainsZipCode(String currentZip) {
        assertTrue(homePage.getDeliverToPopOverLinkText().contains(currentZip));
    }




}
