package pageObjects;

import flowWorkers.WebDriverLib;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;

import static org.junit.Assert.*;

public class EditAddressBookPage extends Page{
    //LOGIN PAGE INPUTS
    @FindBy(how = How.ID, using = "input-email")
    private WebElement inputEmail;
    @FindBy(how = How.ID, using = "input-password")
    private WebElement inputPass;
    @FindBy(how = How.XPATH, using = "//*[@value='Login']")
    private WebElement loginBtn;
    @FindBy(how = How.XPATH, using = "//div[@class='pull-right']//a")
    private WebElement addressBookBtn;

    //ADDRESS INPUTS
    @FindBy(id = "input-firstname") private WebElement inputFirstName;
    @FindBy(id = "input-lastname") private WebElement inputLastName;
    @FindBy(id = "input-address-1") private WebElement inputAddress1;
    @FindBy(id ="input-city") private WebElement inputCity;
    @FindBy(id = "input-postcode") private WebElement inputPostcode;
    @FindBy(id = "input-country") private WebElement dropdownCountry;
    @FindBy(id = "input-zone") private WebElement dropdownRegState;

    //BUTTONS
    @FindBy(how = How.XPATH, using = "//*[@value='Continue']")
    private WebElement continueBtn;
    @FindBy(how = How.XPATH, using = "//a[@class='btn btn-danger']")
    private WebElement deleteBtn;

    //MESSAGES
    @FindBy(how = How.CLASS_NAME, using = "alert")
    private WebElement alertMsg;

    //VARIABLES
    private String eMail = "johndoe@gmail.com";
    private String password = "password12345";

    public EditAddressBookPage(WebDriverLib driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void setLogin() {
        inputEmail.sendKeys(eMail);
        inputPass.sendKeys(password);
        loginBtn.click();
    }

    public void iClickOnNewAddressBtn(){
        addressBookBtn.click();
    }

    public void fillInName (String name){
        driver.waitForElementPresent(inputFirstName);
        inputFirstName.sendKeys(name);
    }

    public void fillInLastName (String name){
        driver.waitForElementPresent(inputLastName);
        inputLastName.sendKeys(name);
    }

    public void fillAddress1(String address1){
        driver.waitForElementPresent(inputAddress1);
        inputAddress1.sendKeys(address1);
    }

    public void fillCityInput(String city){
        driver.waitForElementPresent(inputCity);
        inputCity.sendKeys(city);
    }

    public void fillPostcode(String postcode){
        driver.waitForElementPresent(inputPostcode);
        inputPostcode.sendKeys(postcode);
    }

    public void selectCountry(String country){
        driver.waitForElementPresent(dropdownCountry);
        Select dpCountry = new Select(driver.findElement(By.id("input-country")));
        dpCountry.selectByVisibleText(country);
    }

    public void selectRegState(String regState){
        driver.waitForElementPresent(dropdownRegState);
        Select dpCountry = new Select(driver.findElement(By.id("input-zone")));
        dpCountry.selectByVisibleText(regState);
    }

    public void pressContinueBtn(){
        continueBtn.click();
    }

    public void deleteDefaultBtn(){
        deleteBtn.click();
    }

    public void iConfirmTheAction(){
        driver.switchTo().alert().accept();
    }

    public void checkTheAlertMsg(){
        String messages[] = {
                "Your address has been successfully added",
                "Warning: You must have at least one address!",
        };
        assertTrue(Arrays.asList(messages).contains(alertMsg.getText()));
    }
}
