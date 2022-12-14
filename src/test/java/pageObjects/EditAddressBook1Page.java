package pageObjects;

import flowWorkers.WebDriverLib;
import jdk.jfr.Threshold;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EditAddressBook1Page extends Page {

    @FindBy(how = How.CSS, using = "a[title='My Account']") WebElement myAccountMenu;
    @FindBy(xpath = "//a[text()='Register']") WebElement registerOption;
    @FindBy(id = "input-firstname") WebElement inputFirstName;
    @FindBy(id = "input-lastname") WebElement inputLastName;
    @FindBy(id = "input-email") WebElement inputEmail;
    @FindBy(id = "input-telephone") WebElement inputPhoneNr;
    @FindBy(id = "input-password") WebElement inputPassword;
    @FindBy(id = "input-confirm") WebElement inputConfirmPassword;
    @FindBy(xpath = "//input[@value=\"0\"]") WebElement radioButtonSubscribe;
    @FindBy(xpath = "//input[@name = \"agree\"]") WebElement checkPrivacyPolicy;
    @FindBy(xpath = "//input[@class=\"btn btn-primary\"]") WebElement continueButtonRegister;
    @FindBy(xpath = "//*[@class='btn btn-primary']") WebElement continueWhenAccCreated;
    @FindBy(xpath = "//a[text()='Login']") WebElement loginOption;



    public EditAddressBook1Page(WebDriverLib driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnMyAccount() {
        driver.waitForElementPresent(myAccountMenu);
        myAccountMenu.click();
    }

    public void  clickOnLogin() {
        driver.waitForElementPresent(loginOption);
        loginOption.click();
    }

    public void  fillInEmail (String email)  {
        driver.waitForElementPresent(inputEmail);
        inputEmail.sendKeys(email);
    }

    public void  fillYourPassword(String password)  {
        driver.waitForElementPresent(inputPassword);
        inputPassword.sendKeys(password);
    }


}
