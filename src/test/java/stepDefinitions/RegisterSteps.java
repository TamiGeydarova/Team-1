package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Th;
import org.openqa.selenium.By;
import pageObjects.RegisterPage;

import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class RegisterSteps extends GeneralSteps {

private RegisterPage registerPage = new RegisterPage(driver);
String accCreatedMessage = "Your Account Has Been Created!";





    @Given("^I am on the shop homepage$")
    public void iAmOnTheShopHomepage() {
        driver.get("http://www.demoshop24.com/index.php?route=common/home");
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

    @Then("^I see \"([^\"]*)\"message$")
    public void iSeeMessage(String arg0)  {
        assertEquals(accCreatedMessage, driver.findElement(By.xpath("//*[@id='content']/h1")).getText());

    }

    @And("^I click continue in the message window$")
    public void iClickContinueInTheMessageWindow() {
        registerPage.clickContinueInMessageWindow();
    }

    @Then("^I Get redirected to \"([^\"]*)\" page$")
    public void iGetRedirectedToPage(String arg0) throws Throwable {
        assertEquals("http://www.demoshop24.com/index.php?route=account/account", driver.getCurrentUrl());

    }

    @Then("^I get \"([^\"]*)\" warning message$")
    public void iGetWarningMessage(String arg0){
        String pswdDangerMsg = "Password must be between 4 and 20 characters!";
       assertEquals(pswdDangerMsg, driver.findElement(By.xpath("//*[@class=\"text-danger\"]")).getText());
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
    public void iSeeWarningMessage(String arg0) throws Throwable {
        String notMachindPasswdMsg = "Password confirmation does not match password!";
        assertEquals(notMachindPasswdMsg, driver.findElement(By.xpath("//*[@class=\"text-danger\"]")).getText());
    }
    }