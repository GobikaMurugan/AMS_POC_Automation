package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;
import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        int timeoutInSeconds = ConfigReader.getTimeout();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    }

    public BasePage(WebDriver driver, int customTimeoutSeconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(customTimeoutSeconds));
    }

    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForClickability(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForPageToLoad() {
        try {
            wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                    .executeScript("return document.readyState").equals("complete"));
        } catch (Exception ignored) {}
    }

    public void scrollToElement(WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", element);
        } catch (Exception ignored) {}
    }

    public void click(By locator) {
        waitForPageToLoad();
        try {
            WebElement element = waitForClickability(locator);
            scrollToElement(element);
            element.click();
        } catch (Exception e) {
            try {
                WebElement element = waitForVisibility(locator);
                scrollToElement(element);
                ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('disabled'); arguments[0].click();", element);
            } catch (Exception ex) {
                // If element isn't visible yet, attempt direct JS trigger
                WebElement element = driver.findElement(locator);
                ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('disabled'); arguments[0].click();", element);
            }
        }
    }

    public void sendKeys(By locator, String text) {
        WebElement element = waitForVisibility(locator);
        scrollToElement(element);
        element.clear();
        element.sendKeys(text);
    }

    public String getText(By cssLocator) {
        WebElement element = waitForVisibility(cssLocator);
        return element.getText().trim();
    }

    public boolean isElementDisplayed(By locator) {
        try {
            List<WebElement> elements = driver.findElements(locator);
            return !elements.isEmpty() && elements.get(0).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getPageTitle() {
        waitForPageToLoad();
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        waitForPageToLoad();
        return driver.getCurrentUrl();
    }
}
