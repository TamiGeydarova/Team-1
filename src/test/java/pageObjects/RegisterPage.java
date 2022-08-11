package pageObjects;

import flowWorkers.WebDriverLib;
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

    private static String accCreatedMessage = "Your Account Has Been Created!";
    private static String pswdDangerMsg = "Password must be between 4 and 20 characters!";
    private static String privacyPolicyWarningMessage = "Warning: You must agree to the Privacy Policy!";
    private static String fNameMessage = "First Name must be between 1 and 32 characters!";
    private static String lNameMessage = "Last Name must be between 1 and 32 characters!";
    private static String emailMessage = "E-Mail Address does not appear to be valid!";
    private String telephMessage = "Telephone must be between 3 and 32 characters!";
    public String getAccCreatedMessage() {
        return accCreatedMessage;
    }
    public String getPswdDangerMsg() {
        return pswdDangerMsg;
    }

    public String getPrivacyPolicyWarningMessage() {
        return privacyPolicyWarningMessage;
    }

    public String getfNameMessage() {
        return fNameMessage;
    }
    public String getlNameMessage() {
        return lNameMessage;
    }

    public String getEmailMessage() {
        return emailMessage;
    }
    public String getTelephMessage() {
        return telephMessage;
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