import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;


public class StepsDefinition {
    @Before
    public void startBrowser() {
        Browser.setDriver();
    }

    @AfterTest
    public void quitBrowser() {
        Browser.quitDriver();
    }

    @Given(":user should be logged in successfully")
    public void userShouldBeLoggedInSuccessfully() {
        HomePage.setSubDomain();
        LogInPage.logIn();
        UserHomePage.verifySuccessfulLogIn();
    }

    @Then(":user panel should contain text {string}")
    public void userPanelShouldContainText(String email) {
        UserHomePage.verifyCorrectEmail(email);
    }

    @When("i click on items button")
    public void iClickOnItemsButton() {
        PageFactory.initElements(Browser.driver, UserHomePage.class);
        UserHomePage.itemHeaderButtonClick();
    }

    @Then("items page should be successfully loaded and should contain text {string}.")
    public void itemsPageShouldBeSuccessfullyLoadedAndShouldContainText(String text) {
        UserHomePage.getItemsPageSuccessfullyLoadedMessage(text);
    }

    @And("Tab items should be selected .")
    public void tabItemsShouldBeSelected() {
        UserHomePage.clickOnTabItem();
    }

    @When("i click on new item button.")
    public void iClickOnNewItemButton() {
        UserHomePage.clickOnNewItemBUtton();
    }

    @Then("item add page should be successfully loaded should contain text {string}.")
    public void itemAddPageShouldBeSuccessfullyLoadedShouldContainText(String text) {
        UserHomePage.verifyAddNewItemPageIsSuccessfullyLoaded(text);
    }

    @When("i fill up required information and click add item button")
    public void iFillUpRequiredInformationAndClickAddItemButton() {
        UserHomePage.addNewItemWithCertainParameters();
    }

    @Then("{string} Confirmation message should appear.")
    public void confirmationMessageShouldAppear(String text) {
        UserHomePage.verifySuccessfullyItemInsertion(text);
    }

    @When("delete created new item {string} Confirmation message should appear.")
    public void deleteCreatedNewItemConfirmationMessageShouldAppear(String text) {
        UserHomePage.verifyDeleteLastCreatedItem(text);
    }

    @When("i fill up required information with zero value in quantity filed and click add item button")
    public void iFillUpRequiredInformationWithZeroValueInQuantityFiledAndClickAddItemButton() {
        UserHomePage.addNewItemWithZeroQuantity();
    }

    @Then("{string} Error message should appear.")
    public void errorMessageShouldAppear(String text) {
        UserHomePage.verifyInvalidItemAddMessage(text);
    }

    @And("language should be set on {string}")
    public void languageShouldBeSetOn(String text) {
        UserHomePage.verifyLanguageSetOnBG(text);
    }


    @When("i enter name of item {string}, {string} ,{string},{string},{string}")
    public void iEnterNameOfItem(String name, String nameEng, String singlePrice, String dds, String quantity) {
        UserHomePage.addMultipleItems(name, nameEng, singlePrice, dds, quantity);
    }

    @Then("Confirmation message {string} should be visible.")
    public void confirmationMessageShouldBeVisible(String text) {
        UserHomePage.confirmationMessage(text);
    }
}


