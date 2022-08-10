package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import pageObjects.EditAddressBook1Page;
import pageObjects.Page;

import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class EditAddressBook1Steps extends GeneralSteps {

    private EditAddressBook1Page editAddressBook1Page = new EditAddressBook1Page(driver);


    @Given("^I am on the shop homepage$")
    public void iAmOnTheShopHomepage() {
        driver.get("http://www.demoshop24.com/index.php?route=common/home");
    }

    @When("^I click on My account$")
    public void iClickOnMyAccountButton() {
        driver.findElement(By.cssSelector("a[title='My Account']")).click();
    }

    @And("^I select Login in My account menu$")
    public void iSelectLoginInMyAccountMenu() {
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
    }

    @And("^I enter Email address and Password$")
    public void iEnterEmailAndPassword(Map<String, String> valuesToEnter) {
        driver.findElement(By.id("input-email")).sendKeys(valuesToEnter.get("email"));
        driver.findElement(By.id("input-password")).sendKeys(valuesToEnter.get("password"));
    }

    @And("^I click Login button$")
    public void iClickLoginButton() throws InterruptedException {
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        Thread.sleep(5000);
    }

    @And("^I click on Address Book button$")
    public void iClickAddressBookButton() {
        driver.findElement(By.xpath("//a[normalize-space()='Address Book']")).click();
    }

    @And("^I click Edit button$")
    public void iClickEditButton() throws InterruptedException {
        driver.findElement(By.xpath("//tbody/tr[1]/td[2]/a[1]")).click();
    }

    @And("^I clear information from City field$")
    public void iClearCityField() {
        driver.findElement(By.id("input-city")).clear();
    }

    @And("^Click continue button$")
    public void iClickContinueButton() {
        driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div[2]/input")).click();
    }


    @Then("^Check error message$")
    public void checkErrorMessage() {
        assertEquals("City must be between 2 and 128 characters!", driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset/div[6]/div/div")).getText());
    }

    @And("^I choose Country Albania from dropdown menu$")
    public void iCChooseCountry() {
        driver.findElement(By.xpath("//*[@id=\"input-country\"]/option[4]")).click();
    }

    @Then("^Check confirmation message$")
    public void checkConfirmationMessage() {
        assertEquals("Your address has been successfully updated", driver.findElement(By.xpath("//*[@id=\"account-address\"]/div[1]")).getText());
    }


    @And("^I choose Region Berat from dropdown menu$")
    public void iChooseRegion() {
        driver.findElement(By.xpath("//*[@id=\"input-zone\"]/option[2]")).click();
    }

//    @And("^Check Country and Region are updated$")
  //  public void iCheckCountryAndRegionUpdated() {
    //    assertEquals("Berat", driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr[1]/td[1]/text()[4]")).getText());;

//}

    @And("^I clear Country from dropdown menu$")
    public void iClearCountryField() {
        driver.findElement(By.xpath("//*[@id=\"input-country\"]/option[1]")).click();
    }

    @Then("^Check error message for Empty Country field$")
    public void checkErrorMessageForCountryEmpty() {
        assertEquals("Please select a country!", driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset/div[8]/div/div")).getText());
    }

    @And("^I clear Region from dropdown menu$")
    public void iClearRegionField() {
        driver.findElement(By.xpath("//*[@id=\"input-zone\"]/option[1]")).click();
    }

    @Then("^Check error message for Empty Region filed$")
    public void checkErrorMessageForRegionMessage() {
        assertEquals("Please select a region / state!", driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset/div[9]/div/div")).getText());


    }
}