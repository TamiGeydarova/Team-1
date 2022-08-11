package pageObjects;
import cucumber.api.java.en.And;
import flowWorkers.WebDriverLib;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EditPasswPage extends LogRegPage {


    public EditPasswPage(WebDriverLib driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(how = How.ID, using = "input-password")
    public WebElement chpassword;
    @FindBy(how = How.ID, using = "input-confirm")
    public WebElement conpassword;

//    @FindBy(how = How.LINK_TEXT, using = "Change your password")
//    public WebElement changePassword;


    public void clickChangePassword() {
//        driver.waitForElementPresent(changePassword);
//        changePassword.click();
        driver.findElement(By.linkText("Change your password")).click();
    }
    public void clickBack() {
        driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div[1]/a")).click();
    }
    public void changePassword(String changepass, String confirmpass) {
        driver.waitForElementPresent(chpassword);
        (chpassword).sendKeys(changepass);
        chpassword.sendKeys(Keys.ENTER);
        driver.waitForElementPresent(conpassword);
        conpassword.sendKeys(confirmpass);
}
    public void clickContinue(){
        driver.findElement(By.className("btn-primary")).click();
    }
    public String getsSuccess() {
          String success = driver.findElement(By.cssSelector(".alert-success")).getText();
        return success;
    }
    public String getsStress() {
        String error = driver.findElement(By.cssSelector(".text-danger")).getText();
        return error;
    }
    public void deletePassword() {
        driver.findElement(By.id("input-password")).clear();
        }

    public void deletePasswordConfirm(){
        driver.findElement(By.id("input-confirm")).clear();

    }
}
