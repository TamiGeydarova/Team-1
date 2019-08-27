package stepDefinitions;

import java.util.Map;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import pageObjects.ResultPage;

import static org.assertj.core.api.Assertions.assertThat;

public class GoogleSteps extends GeneralSteps {
    private MainPage mainPage = new MainPage(driver);
    private ResultPage resultPage = new ResultPage(driver);
    private LoginPage loginPage = new LoginPage(driver);

    @Before
    public void openBrowser() {
        driver.openBrowser();
    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Given("^open Google webpage$")
    public void open_Google_webpage() {
        driver.openWebPage("");
        driver.waitForElementPresent(mainPage.logo);
    }

    @Given("^click login button$")
    public void click_login_button() {
        mainPage.clickLoginButton();
    }

    @Given("^type user credentials$")
    public void type_user_credentials(Map<String, String> userData) {
        loginPage.loginInto(userData.get("username"), userData.get("password"));
    }

    @When("^search \"(.+)\"$")
    public void search(String searchText) {
        mainPage.search(searchText);
    }

    @When("^click login$")
    public void click_login() {
        loginPage.clickSumbit();
    }

    @Then("^result page was opened$")
    public void result_page_was_opened() {
        driver.waitForElementPresent(resultPage.resultManu);
    }

    @Then("^first result is: \"(.+)\"$")
    public void _result_is(String searchResultText) {
        assertThat(resultPage.results.get(0).getText()).contains(searchResultText);
    }

    @Then("^error message: (.+)$")
    public void error_message(String errorMessage) {
        assertThat(loginPage.getErrorMessage()).contains(errorMessage);
    }
}
