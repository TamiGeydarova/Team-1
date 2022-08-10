package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.EditAddressBookPage;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

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

    @Then("^I see a message$")
    public void iSeeASuccessfulMessage() throws Throwable {
        editAddressBookPage.checkTheAlertMsg();
    };

    @Then("^I see warning messages and stay the same page$")
    public void iSeeWarnMsgAndStayTheSamePage(){
        List<WebElement> el = driver.findElements(By.className("text-danger"));
        for (int i = 0; i<el.size(); i++){
            assertTrue(el.get(i).isDisplayed());
        }
        //I have to check url first than the string!
        assertTrue(driver.getCurrentUrl().contains("http://www.demoshop24.com/index.php?route=account/address/edit&address_id="));

//        USELESS STUFF
//        Pattern curPage = Pattern.compile("http://www.demoshop24.com/index.php?route=account/address/edit&address_id=3284");
//        Matcher matcher = curPage.matcher(driver.getCurrentUrl());
//        assertTrue(matcher.find());

//        String curPage = "http://www.demoshop24.com/index.php?route=account/address/edit&address_id=";
//        assertTrue(curPage.contains(driver.getCurrentUrl()));
//        assertTrue(StringUtils.containsIgnoreCase(curPage, driver.getCurrentUrl().toString()));
    }

    @Then("^I see a default address$")
    public void iSeeADefaultAddress(){
        return; //I DON'T KNOW WHAT HTML ELEMENT OR ATTRIBUTE NEED TO TRACK
    }

    @And("^I delete this default address$")
    public void iDeleteDefaultAddress(){
        editAddressBookPage.deleteDefaultBtn();
    }

    @Then("^I confirm the action$")
    public void iConfirmTheAction(){
        editAddressBookPage.iConfirmTheAction();
    }

    @Then("^I click on Edit button")
    public void iClickOnEditBtn(){
        editAddressBookPage.iClickOnEditBtn(0);
    }

    @And("^I change the first name (.*)$")
    public void iChangeTheFirstName(String name){
//        if(name.length() < 3 || name.length()>32){
            editAddressBookPage.fillInName(name);
//        }
    }

    @And("^I clean the first name$")
    public void iCleanTheFirstName(){
        editAddressBookPage.fillInName("");
    }
}
