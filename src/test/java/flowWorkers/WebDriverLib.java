package flowWorkers;

import core.config.YamlConfig;
import core.config.YamlFileManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WebDriverLib implements WebDriver {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private String driverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/";
    private YamlConfig config = YamlFileManager.getProjectConfigurations();
    private String browser = config.getConfiguration("browser.name");
    private String baseURL = config.getConfiguration("browser.baseUrl");

    public void openBrowser() {
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "ie":
                System.setProperty("webdriver.ie.driver", driverPath + "IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                break;
            default:
                System.out.println("Incorrect Browser");
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 20);
    }

    public void openWebPage(String URL) {
        driver.get(baseURL + URL);
    }

    public void waitForElementPresent(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitForElementPresent(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForTitleExist(String title) {
        wait.until(ExpectedConditions.titleContains(title));
    }

    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForInvisibilityOfElementLocated(By by) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void waitForInvisibilityOfElement(final WebElement element) {
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                if (!isElementPresent(element)) {
                    return true;
                } else {
                    return false;
                }
            }
        });
    }

    public boolean isElementPresent(By by) {
        if (driver.findElements(by).size() > 0) {
            driver.findElement(by);
            if (driver.findElement(by).isDisplayed()) {
                if (driver.findElement(by).isEnabled()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isElementPresent(WebElement element) {
        try {
            element.getTagName();
            return true;
        } catch (NoSuchElementException nsee) {
            return false;
        }
    }

    public WebElement findElement(By arg0) {
        return driver.findElement(arg0);
    }

    public List<WebElement> findElements(By arg0) {
        return driver.findElements(arg0);
    }

    public void get(String arg0) {
        driver.get(arg0);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getPageSource() {
        return driver.getPageSource();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public Options manage() {
        return driver.manage();
    }

    public Navigation navigate() {
        return driver.navigate();
    }

    public void close() {
        driver.close();
    }

    public void quit() {
        driver.quit();
    }

    public TargetLocator switchTo() {
        return driver.switchTo();
    }

}


