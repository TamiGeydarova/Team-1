package pageObjects;

import flowWorkers.WebDriverLib;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends Page {

    @FindBy(how = How.ID, using = "hplogo")
    public WebElement logo;
    @FindBy(how = How.CSS, using = ".a4bIc > input")
    public WebElement searchField;
    @FindBy(how = How.ID, using = "gb_70")
    public WebElement loginButton;

    public MainPage(WebDriverLib driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void search(String searchData) {
        driver.waitForElementPresent(searchField);
        searchField.clear();
        searchField.sendKeys(searchData);
        searchField.sendKeys(Keys.ENTER);;
    }

    public void clickLoginButton() {
        driver.waitForElementPresent(loginButton);
        loginButton.click();
    }
}
