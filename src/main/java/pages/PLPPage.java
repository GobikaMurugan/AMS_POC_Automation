package pages;

import base.BasePage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PLPPage extends BasePage {

    private final By pageHeader = By.cssSelector("div#content h1, h1.page-title");
    private final By productGrid = By.cssSelector("div.products.wrapper.grid.products-grid");
    private final By firstProduct = By.cssSelector("strong.product.name.product-item-name");
    private final By ProductAddToCartBtn = By.cssSelector("button.action.tocart.primary");
    private final By wishlistButton = By.cssSelector("a.action.towishlist");
    private final By successNotificationAlert = By.cssSelector("div.message-success.success.message");

    public PLPPage(WebDriver driver) {
        super(driver);
    }

    public String getPageHeaderTitle() {
        return getText(pageHeader);
    }

    public PDPPage clickFirstProduct() {
        waitForPageToLoad();
        List<WebElement> products = driver.findElements(productGrid);
        products.get(0).findElement(firstProduct).click();
        waitForPageToLoad();
        return new PDPPage(driver);
    }

    public void addFirstProductToCart() {
        waitForPageToLoad();
        List<WebElement> products = driver.findElements(productGrid);
        products.get(0).findElement(ProductAddToCartBtn).click();
        waitForPageToLoad();
    }

    public void addFirstProductToWishlist() {

        List<WebElement> products = driver.findElements(productGrid);
        products.get(0).findElement(wishlistButton).click();
        waitForPageToLoad();

    }

    public String getFirstProductTitle() {
        return getText(firstProduct);
    }

    public boolean isProductListVisible() {
        waitForPageToLoad();
        return isElementDisplayed(productGrid);
    }

    public boolean isSuccessNotificationDisplayed() {
        waitForVisibility(successNotificationAlert);
        return isElementDisplayed(successNotificationAlert);
    }
}
