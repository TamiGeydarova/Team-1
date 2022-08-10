package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import pageObjects.EditAddressBookPage;

import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class EditAddressBookSteps extends GeneralSteps{
    private EditAddressBookPage editAddressBookPage = new EditAddressBookPage(driver);

    @Given("^I am on Account login webpage$")
    public void iAmOnMainWebpage(){
        driver.get("http://www.demoshop24.com/index.php?route=account/address");
    }

    @Then("^I login into my account$")
    public void iLoginIn(){
        editAddressBookPage.setLogin();
    }

    @When("^I am on the Address Book page$")
    public void iOnAddressBook(){
        assertEquals("http://www.demoshop24.com/index.php?route=account/address",
                driver.getCurrentUrl());
    };

    @Then("^I click on New Address button$")
    public void iClickOnNewAddressBtn(){
        editAddressBookPage.iClickOnNewAddressBtn(); //doesn't it make recursing?
    };

    @And("^I fill in all the input fields$")
    public void iFillInAllInputs(Map<String, String> valuesToEnter){
        editAddressBookPage.fillInName(valuesToEnter.get("First Name"));
        editAddressBookPage.fillInLastName(valuesToEnter.get("Last Name"));
        editAddressBookPage.fillAddress1((valuesToEnter.get("Address 1")));
        editAddressBookPage.fillCityInput(valuesToEnter.get("City"));
        editAddressBookPage.fillPostcode(valuesToEnter.get("Post Code"));
        editAddressBookPage.selectCountry(valuesToEnter.get("Country"));
        editAddressBookPage.selectRegState(valuesToEnter.get("Region / State"));
    };

    @And("^I press continue$")
    public void IPressContinue(){
        editAddressBookPage.pressContinueBtn();
    };

    @Then("^I see a successful message$")
    public void iSeeASuccessfulMessage(){
        editAddressBookPage.checkTheSuccessMsg();
    };

}
