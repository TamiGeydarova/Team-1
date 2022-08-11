package pageObjects;

import flowWorkers.WebDriverLib;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
public class RegisterPage extends Page {

    @FindBy(how = How.CSS, using = "a[title='My Account']")
    WebElement myAccountMenu;
    @FindBy(xpath = "//a[text()='Register']")
    WebElement registerOption;
    @FindBy(id = "input-firstname")
    WebElement inputFirstName;
    @FindBy(id = "input-lastname")
    WebElement inputLastName;
    @FindBy(id = "input-email")
    WebElement inputEmail;
    @FindBy(id = "input-telephone")
    WebElement inputPhoneNr;
    @FindBy(id = "input-password")
    WebElement inputPassword;
    @FindBy(id = "input-confirm")
    WebElement inputConfirmPassword;
    @FindBy(xpath = "//input[@value=\"0\"]")
    WebElement radioButtonSubscribe;
    @FindBy(xpath = "//input[@name = \"agree\"]")
    WebElement checkPrivacyPolicy;
    @FindBy(css = "input[value='Continue']")
    WebElement continueButtonRegister;
    @FindBy(xpath = "//*[@class='btn btn-primary']")
    WebElement continueWhenAccCreated;


    public String getNotMachindPasswdMsg(String name) {
        return driver.findElement(By.xpath("//div[text()='" + name + "']")).getText();
    }

    public String getAccCreatedMessage(String name) {
        return driver.findElement(By.xpath("//h1[text()='" + name + "']")).getText();
    }

    public String getPswdDangerMsg(String name) {
        return driver.findElement(By.xpath("//div[text()='" + name + "']")).getText();
    }

    public String getPrivacyPolicyWarningMessage() {
        return driver.findElement(By.xpath("//*[text()=' Warning: You must agree to the Privacy Policy!']")).getText();
    }

    public String getfNameMessage() {
        return driver.findElement(By.xpath("//div[text()='First Name must be between 1 and 32 characters!']")).getText();
    }

    public String getlNameMessage() {
        return driver.findElement(By.xpath("//div[text()='Last Name must be between 1 and 32 characters!']")).getText();
    }

    public String getEmailMessage() {
        return driver.findElement(By.xpath("//div[text()='E-Mail Address does not appear to be valid!']")).getText();
    }

    public String getTelephMessage() {
        return driver.findElement(By.xpath("//div[text()='Telephone must be between 3 and 32 characters!']")).getText();
    }

    public String getEmailErrorMessage(String name) {
        return driver.findElement(By.xpath("//div[text()='" + " " + name + "']")).getText();
    }

    public RegisterPage(WebDriverLib driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnMyAccount() {
        driver.waitForElementPresent(myAccountMenu);
        myAccountMenu.click();
    }

    public void clickOnRegister() {
        driver.waitForElementPresent(registerOption);
        registerOption.click();
    }

    public void fillInName(String name) {
        driver.waitForElementPresent(inputFirstName);
        inputFirstName.sendKeys(name);
    }

    public void fillInLastName(String surname) {
        driver.waitForElementPresent(inputLastName);
        inputLastName.sendKeys(surname);
    }

    public void fillInEmail(String email) {
        driver.waitForElementPresent(inputEmail);
        inputEmail.sendKeys(email);
    }

    public void fillInTelephone(String phoneNr) {
        driver.waitForElementPresent(inputPhoneNr);
        inputPhoneNr.sendKeys(phoneNr);
    }

    public void fillYourPassword(String password) throws Exception {
        driver.waitForElementPresent(inputPassword);
        inputPassword.sendKeys(password);
        Thread.sleep(2000);
    }

    public void fillConfirmPassword(String confirmPassword) throws Exception {
        driver.waitForElementPresent(inputConfirmPassword);
        inputConfirmPassword.sendKeys(confirmPassword);
        Thread.sleep(2000);
    }

    public void inputForNewsletterSection() {
        driver.waitForElementPresent(radioButtonSubscribe);
        radioButtonSubscribe.click();
        driver.waitForElementPresent(checkPrivacyPolicy);
        checkPrivacyPolicy.click();
    }

    public void clickContinueOnRegisterPage() {
        continueButtonRegister.click();
    }

    public void clickContinueInMessageWindow() {
        continueWhenAccCreated.click();
    }


}