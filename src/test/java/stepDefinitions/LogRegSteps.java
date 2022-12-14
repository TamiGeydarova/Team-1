package stepDefinitions;
import java.util.Map;
import cucumber.api.java.en.And;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import pageObjects.ResultPage;
import pageObjects.LogRegPage;
import static junit.framework.TestCase.assertEquals;

import static org.assertj.core.api.Assertions.assertThat;

public class LogRegSteps extends GeneralSteps {
    private LogRegPage logRegPage = new LogRegPage(driver);
    String error1 = "Warning: No match for E-Mail Address and/or Password.";
    @Before
    public void openBrowser() {
        driver.openBrowser();
    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Given("^I am on the shop webpage$")
    public void openedShop24Homepage() {
        driver.get("http://www.demoshop24.com/index.php?route=common/home");
    }

    @And("^click un My account button$")
    public void goToMyAccount() {
        logRegPage.clickMyAccountLink();
    }

    @And("^click on Login button$")
    public void clicOnLoginButt() throws Throwable {
        logRegPage.firstLoginButton();
    }

    @And("^write user credentials$")
    public void type_user_credentials(Map<String, String> userData) {
        logRegPage.loginInto(userData.get("username"), userData.get("password"));
    }

    @And("^write forgotten email1$")
    public void typeforgottEmail() {
        logRegPage.forgottenEmail("aijai@aijaia.lv");
    }
    @And("^write forgotten email2$")
    public void typeforgottEmail2() {
        logRegPage.forgottenEmail("vijzemite.lv");
    }
    @And("^write forgotten email3$")
    public void typeforgottEmail3() {
        logRegPage.forgottenEmail("vijzemite@con");
    }


    @When("^click on login$")
    public void loginContinue() throws Throwable {
        logRegPage.clickLoginButton();
    }

    @And("^redirect to shop webpage$")
    public void toShopPage() throws Throwable {
        assertEquals("http://www.demoshop24.com/index.php?route=common/home", driver.getCurrentUrl());
    }

    @And("^I redirected to \"Account\" page$")
    public void toAccountPage() throws Throwable {
        assertEquals("http://www.demoshop24.com/index.php?route=account/account", driver.getCurrentUrl());
    }

    @And("^I redirected to \"Login\" page$")
    public void toAccLoginPage() throws Throwable {
        assertEquals("http://www.demoshop24.com/index.php?route=account/login", driver.getCurrentUrl());
    }

    @And("^click logout button$")
    public void goToLogout() throws Throwable {
        logRegPage.clickLogoutButton();
    }

    @And("^redirect to logout page$")
    public void toLogoutPage() throws Throwable {
        assertEquals("http://www.demoshop24.com/index.php?route=account/logout", driver.getCurrentUrl());
    }

    @And("^click logout continue button$")
    public void goToConLogout() throws Throwable {
        logRegPage.clickLogoutContButton();
    }

    @Then("^I see error message$")
    public void iSeeMessage() throws Throwable {
        assertEquals(error1,logRegPage.getMessage1());
    }

    @Then("^I see error message2$")
    public void iSeeMessage2() throws Throwable {
        error1 = "Please fill out empty fields!";
        assertEquals(error1,logRegPage.getMessage1());
    }
    @Then("^I see error messageFP$")
    public void iSeeMessageFP() throws Throwable {
        error1 = "Warning: The E-Mail Address was not found in our records, please try again!";
        assertEquals(error1,logRegPage.getMessage1());
    }

    @Then("^I see error message wrong user or password$")
    public void iSeeMessageUP()  throws Throwable{
      assertEquals("Warning: No match for E-Mail Address and/or Password.",logRegPage.getMessage1());
    }
    @And ("^Click Forgotten$")
    public void clickForgottenEmail()  throws Throwable{
        logRegPage.forgotEmailLink();
    }

}