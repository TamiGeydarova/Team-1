package pageObjects;
import flowWorkers.WebDriverLib;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import static java.lang.Thread.sleep;

public class LogRegPage extends Page {


    public LogRegPage(WebDriverLib driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = "a[title='My Account']")
    public WebElement myAccountLink;
    @FindBy(xpath = "//a[text()='Login']")
    public WebElement loginFromMA;
    @FindBy(how = How.ID, using = "input-email")
    public WebElement emailInput;
    @FindBy(how = How.ID, using = "input-password")
    public WebElement passwordInput;
    //    @FindBy(how = How.CSS, using = "btn-primary[value='login']")
    @FindBy(how = How.XPATH, using = "//*[@value='Login']")
    public WebElement loginButton;
    @FindBy(how = How.CLASS_NAME, using = "btn-primary")
    public WebElement logoutContButton;
    @FindBy(how = How.XPATH, using = "//*[@id=\"column-right\"]/div/a[13]")
    public WebElement logoutButton;


    public void clickLogoutButton() {
        driver.waitForElementPresent(logoutButton);
        logoutButton.click();
    }

    public void clickMyAccountLink() {
        driver.waitForElementPresent(myAccountLink);
        myAccountLink.click();
    }

    public void clickLogoutContButton() {
        driver.waitForElementPresent(logoutContButton);
        logoutContButton.click();
    }

    public void firstLoginButton() {
        driver.waitForElementPresent(loginFromMA);
        loginFromMA.click();
    }

    public void clickLoginButton() {
        driver.waitForElementPresent(loginButton);
        loginButton.click();
    }

    public void loginInto(String username, String password) {
        driver.waitForElementPresent(emailInput);
        (emailInput).sendKeys(username);
        emailInput.sendKeys(Keys.ENTER);
        driver.waitForElementPresent(passwordInput);
        passwordInput.sendKeys(password);
    }

    public String getMessage1() {
        String message1 = driver.findElement(By.cssSelector("alert-dismissible")).getText();
        // web.findElement(By.xpath("//*[@id='" + elementId + "']/following-sibling::span[@class='error']")
        return message1;
    }
        public String getMessage2() {
            String message2 = driver.findElement(By.cssSelector("alert-dismissible")).getText();
            // web.findElement(By.xpath("//*[@id='" + elementId + "']/following-sibling::span[@class='error']")
            return message2;
    }

}

