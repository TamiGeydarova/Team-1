package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.RegisterPage;

import java.util.Map;

import static core.utils.Constants.RegistrationForm.*;
import static junit.framework.TestCase.assertEquals;

public class RegisterSteps extends GeneralSteps {

    private RegisterPage registerPage = new RegisterPage(driver);

    @Given("^I am on the shop homepage$")
    public void iAmOnTheShopHomepage() {
        driver.get(homePage);
    }

    @When("^I click on My account$")
    public void iClickOnMyAccountButton() {
        registerPage.clickOnMyAccount();
    }


    @And("^I select Register in My account menu$")
    public void iSelectRegisterInMyAccountMenu() {
        registerPage.clickOnRegister();
    }

    @And("^I fill in all the input fields$")
    public void iFillInAllTheInputFields(Map<String, String> valuesToEnter) throws Exception {
        registerPage.fillInName(valuesToEnter.get("name"));
        registerPage.fillInLastName(valuesToEnter.get("surname"));
        registerPage.fillInEmail(valuesToEnter.get("email"));
        registerPage.fillInTelephone(valuesToEnter.get("telephone"));
        registerPage.fillYourPassword(valuesToEnter.get("password"));
        registerPage.fillConfirmPassword(valuesToEnter.get("confirm password"));
        registerPage.inputForNewsletterSection();
    }

    @And("^I press continue$")
    public void iPressContinue() {
        registerPage.clickContinueOnRegisterPage();
    }

    @Then("^I see \"([^\"]*)\" message$")
    public void iSeeMessage(String name) {
        assertEquals(accCreatedMessage, registerPage.getAccCreatedMessage(name));
    }

    @And("^I click continue in the message window$")
    public void iClickContinueInTheMessageWindow() {
        registerPage.clickContinueInMessageWindow();
    }

    @Then("^I Get redirected to My account page$")
    public void iGetRedirectedToPage() {
        assertEquals(myAccountPage, driver.getCurrentUrl());
    }

    @Then("^I get \"([^\"]*)\" warning message$")
    public void iGetWarningMessage(String name) {

        assertEquals(pswdDangerMsg, registerPage.getPswdDangerMsg(name));
    }

    @And("^I fill password input fields$")
    public void iFillPasswordInputFields(Map<String, String> passwdInput) throws Exception {
        registerPage.fillYourPassword(passwdInput.get("password"));
        registerPage.fillConfirmPassword(passwdInput.get("confirm password"));
    }

    @And("^I fill the input fields no passwd$")
    public void iFillTheInputFieldsNoPasswd(Map<String, String> valuesToEnter) throws Exception {
        registerPage.fillInName(valuesToEnter.get("name"));
        registerPage.fillInLastName(valuesToEnter.get("surname"));
        registerPage.fillInEmail(valuesToEnter.get("email"));
        registerPage.fillInTelephone(valuesToEnter.get("telephone"));
        registerPage.inputForNewsletterSection();
    }

    @And("^I fill in passwd section$")
    public void PasswdAndConfirmPasswdFieldsNotMatch(Map<String, String> passwdInput) throws Exception {
        registerPage.fillYourPassword(passwdInput.get("password"));
        registerPage.fillConfirmPassword(passwdInput.get("confirm password"));
    }


    @Then("^I see \"([^\"]*)\" warning message$")
    public void iSeeWarningMessage(String name) throws Throwable {
        assertEquals(notMachindPasswdMsg, registerPage.getNotMachindPasswdMsg(name));
    }

    @And("^I leave all input fields empty$")
    public void iLeaveAllInputFieldsEmpty(Map<String, String> valuesToEnter) throws Exception {
        registerPage.fillInName(valuesToEnter.get("name"));
        registerPage.fillInLastName(valuesToEnter.get("surname"));
        registerPage.fillInEmail(valuesToEnter.get("email"));
        registerPage.fillInTelephone(valuesToEnter.get("telephone"));
        registerPage.fillYourPassword(valuesToEnter.get("password"));
        registerPage.fillConfirmPassword(valuesToEnter.get("confirm password"));
    }

    @Then("^I see error messages$")
    public void iSeeErrorMessages() throws InterruptedException {
        assertEquals(fNameMessage, registerPage.getfNameMessage());
        assertEquals(lNameMessage, registerPage.getlNameMessage());
        assertEquals(emailMessage, registerPage.getEmailMessage());
        assertEquals(telephMessage, registerPage.getTelephMessage());
        assertEquals(pswdDangerMsg, registerPage.getPswdDangerMsg(pswdDangerMsg));
        assertEquals(privacyPolicyWarningMessage, registerPage.getPrivacyPolicyWarningMessage());
    }

    @Then("^I see error messages for input fields only$")
    public void iSeeErrorMessagesWithNoPrivacyPolicy() {

        assertEquals(fNameMessage, registerPage.getfNameMessage());
        assertEquals(lNameMessage, registerPage.getlNameMessage());
        assertEquals(emailMessage, registerPage.getEmailMessage());
        assertEquals(telephMessage, registerPage.getTelephMessage());
        assertEquals(pswdDangerMsg, registerPage.getPswdDangerMsg(pswdDangerMsg));
    }

    @Then("^I can see \"([^\"]*)\" message$")
    public void iCanSeeMessage(String name) {
        assertEquals(alreadyCreatedMessage, registerPage.getEmailErrorMessage(name));
    }

    @And("^I tick the privacy policy$")
    public void iTickThePrivacyPolicy() {
        registerPage.inputForNewsletterSection();
    }

    @And("^I fill all fields except email$")
    public void iFillAllFieldsExceptEmail(Map<String, String> valuesToEnter) throws Exception {
        registerPage.fillInName(valuesToEnter.get("name"));
        registerPage.fillInLastName(valuesToEnter.get("surname"));
        registerPage.fillInTelephone(valuesToEnter.get("telephone"));
        registerPage.fillYourPassword(valuesToEnter.get("password"));
        registerPage.fillConfirmPassword(valuesToEnter.get("confirm password"));
        registerPage.inputForNewsletterSection();
    }

    @Then("^I see email invalid error message$")
    public void iSeeEmailInvalidErrorMessage() {
        assertEquals(registerPage.getEmailMessage(), registerPage.getEmailMessage());
    }

    @And("^I fill all fields except password$")
    public void iFillAllFieldsExceptPassword(Map<String, String> valuesToEnter) throws Exception {
        registerPage.fillInName(valuesToEnter.get("name"));
        registerPage.fillInLastName(valuesToEnter.get("surname"));
        registerPage.fillInEmail(valuesToEnter.get("email"));
        registerPage.fillInTelephone(valuesToEnter.get("telephone"));
        registerPage.inputForNewsletterSection();
    }

    @Then("^I see password invalid message$")
    public void iSeePasswordInvalidMessage() {
        assertEquals(pswdDangerMsg, registerPage.getPswdDangerMsg(pswdDangerMsg));
    }
}