package pageObjects;

import flowWorkers.WebDriverLib;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import java.util.List;

import static org.junit.Assert.assertEquals;


public class EditaccountsPage extends Page {

    @FindBy(xpath = "a[contains(text(),'Address Book')]")
     WebElement editAddressBook;

    @FindBy(how = How.XPATH, using = "//td[@class='pull-right']//a[@class='btn btn-info']")
     WebElement editButton;



    @FindBy(id = "input-firstname")
    private WebElement firstName;
    @FindBy(id = "input-lastname")
    private WebElement lastName;



    @FindBy(id = "input-address-1" )
    private WebElement addressOne;

    @FindBy(id = "input-city" )
    private WebElement city;

    @FindBy(id = "input-postcode")
    private WebElement postcode;

    @FindBy(id = "input-country")
    private WebElement country;

   @FindBy(id = "input-zone")
   private WebElement zone;

  @FindBy(xpath = "//input[@type = 'radio']")
  private List<WebElement> radioButton;

  @FindBy(xpath = "//input[@type = 'submit' and @value = 'Continue']")
  private WebElement continueButton;


    @FindBy(how = How.ID, using = "input-email")
    private WebElement emailInput;

    @FindBy(how = How.ID, using = "input-password")
    private WebElement passwordInput;

    @FindBy(how = How.XPATH, using = "//input[@value='Login']")
    private WebElement loginButton;

    @FindBy(id = "input-email")
    private WebElement email;

    @FindBy(id = "input-password")
    private WebElement password;

    @FindBy(id = "input-country")
    private WebElement dropdownCountry;

    @FindBy(id = "input-zone")
    private WebElement dropdownRegState;

    public EditaccountsPage(WebDriverLib driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getPageUrl() {
        return "http://www.demoshop24.com/index.php?route=account/login";
    }

    public void enterMail(String emailAddress) {
        email.clear();
        email.sendKeys(emailAddress);
    }

    public void enterPassword(String passcode) {
        password.clear();
        password.sendKeys(passcode);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void checkLoginUrl() {

        String pageUrl="http://www.demoshop24.com/index.php?route=account/login";

        assertEquals(pageUrl, getPageUrl());
    }

    public void addressBook () {
        editAddressBook.click();
    }
    public void selectEdit () throws InterruptedException {
        editButton.click();
        Thread.sleep(3000);
    }
    public void fName (String name) throws InterruptedException {
        driver.waitForElementPresent(firstName);
        firstName.clear();
        Thread.sleep(3000);
        firstName.sendKeys(name);
    }
    public void lName (String surname) throws InterruptedException {
        driver.waitForElementPresent(lastName);
        lastName.clear();
        Thread.sleep(3000);
        lastName.sendKeys(surname);
    }

    public void add1 (String address) {
        addressOne.clear();
        addressOne.sendKeys(address);
    }
    public void cty (String cty) {
        city.clear();
        city.sendKeys(cty);
    }
    public void postalcode (String postCde) {
        postcode.clear();
        city.sendKeys(postCde);
    }
    public void county (String Country) {
        country.clear();
        country.sendKeys(Country);
    }
    public void Szone (String region) {
        zone.clear();
        zone.sendKeys(region);
    }

    public void defaultAddress (String value) {
        for(int i = 0; i<radioButton.size();i++) {
            if(radioButton.get(i).getAttribute("value") == value)
                radioButton.get(i).click();
        }
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



    public void clickContinueButton(){
        continueButton.click();
    }

    public void iClickOnEditBtn(int index) {
        driver.findElements(By.className("btn-info")).get(index).click();
    }


}
