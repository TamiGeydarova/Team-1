package stepDefinitions;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import flowWorkers.WebDriverLib;
import pageObjects.EditaccountsPage;
import pageObjects.LoginPage;

import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class Editaccountssteps extends GeneralSteps {

    private EditaccountsPage editaccountsPage = new EditaccountsPage(driver);


    @Given("^User should be on Homepage$")
    public void userShouldBeOnHomepage() {
        driver.get("http://www.demoshop24.com/index.php?route=account/login");

    }

    @When("^User select on my account$")
    public void userSelectOnMyAccount() {
        driver.findElement(By.cssSelector("a[title='My Account']")).click();

    }

    @And("^I enter Email address and password$")
    public void iEnterEmailAddressAndPassword(DataTable table) {
        List<Map<String, String>> logInDetails = table.asMaps(String.class, String.class);
        editaccountsPage.enterMail(logInDetails.get(0).get("E-mail"));
        editaccountsPage.enterPassword(logInDetails.get(0).get("Password"));
    }

    @And("^I click Login$")
    public void iClickLogin() throws InterruptedException {
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        Thread.sleep(4000);
    }

    @Then("^select address book$")
    public void selectAddressBook() {
        driver.findElement(By.xpath("//a[normalize-space()='Address Book']")).click();

    }

    @And("^Fill up the input fields$")
    public void fillUpTheInputFields(Map<String, String> valuesToEnter) throws Exception {
        editaccountsPage.fName(valuesToEnter.get("name"));
        editaccountsPage.lName(valuesToEnter.get("surname"));
        editaccountsPage.add1((valuesToEnter.get("address")));
        editaccountsPage.cty(valuesToEnter.get("cty"));
        editaccountsPage.postalcode(valuesToEnter.get("postcde"));

    }

    @And("^Press Continue$")
    public void pressContinue() {
        editaccountsPage.clickContinueButton();
    }
    //@US21T4

    @And("^Select Change your password from My account$")
    public void selectChangeYourPasswordFromMyAccount() throws Throwable {
        // EditaccountsPage.clickChangePassword();
    }

    @And("^I enter New password and conform password$")
    public void iEnterNewPasswordAndConformPassword(Map<String, String> userData) throws Throwable {
        //  EditaccountsPage.changePassword(userData.get("changepass")), userData.get("confirmpass"));

    }

    @Then("^Select continue button\\.$")
    public void selectContinueButton() throws Throwable {
        // EditaccountsPage.clickContinue();
    }


    //@US2S1T5//

    @And("^I select Address Book$")
    public void iSelectAddressBook() throws InterruptedException {
        driver.findElement(By.xpath("//a[normalize-space()='Address Book']")).click();
    }


    //@And("^I click Edit\\.$")
    // public void iClickEdit()  {
    //driver.findElement(By.xpath//("//td[@class='pull-right']//a[@class='btn btn-info']")).click();
    //  }

    @And("^I mofifying the Company name\\.$")
    public void iMofifyingTheCompanyName() {
        // EditaccountsPage.enterText
    }

    @Then("^select continue\\.$")
    public void selectContinue() {
        driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div[2]/input")).click();
    }


//@US2S1T7

    @And("^i select Edit account information\\.$")
    public void iSelectEditAccountInformation() {
        // driver.findElement(By.xpath())
    }


    @And("^I enter my First name Last name and Telephone Number$")
    public void iEnterMyFirstNameLastNameAndTelephoneNumber() {
    }

    @And("^I click continue$")
    public void iClickContinue() {
    }

    @Then("^Warning message displays\\.$")
    public void warningMessageDisplays() {
    }


    @And("^I click Edit$")
    public void iClickEdit() {
        editaccountsPage.iClickOnEditBtn(0);
    }
}






