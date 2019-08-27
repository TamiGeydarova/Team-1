package pageObjects;

import flowWorkers.WebDriverLib;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Page{

    @FindBy(how = How.CSS, using = "#identifierId")
    public WebElement emailField;
    @FindBy(how = How.CSS, using = "#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input")
    public WebElement passwordField;
    @FindBy(how = How.CSS, using = "#passwordNext")
    public WebElement loginButton;
    @FindBy(how = How.CSS, using = "div.xgOPLd")
    public WebElement errorMessageField;

    public LoginPage(WebDriverLib driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void loginInto(String username, String password) {
        driver.waitForElementPresent(emailField);
        emailField.sendKeys(username);
        emailField.sendKeys(Keys.ENTER);
        driver.waitForElementPresent(passwordField);
        passwordField.sendKeys(username);
    }

    public void clickSumbit() {
        driver.waitForElementPresent(loginButton);
        loginButton.click();
    }

    public String getErrorMessage() {
        driver.waitForElementPresent(errorMessageField);
        return errorMessageField.getText();
    }
}
