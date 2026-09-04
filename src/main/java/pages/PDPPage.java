package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PDPPage extends BasePage {

    private final By productTitle = By.cssSelector("h1.page-title, div#entry_216816 h1, div#content h1");
    private final By productPrice = By.cssSelector("h3.price-new, div.price h3, div.price-new");
    private final By quantityInput = By.cssSelector("input[name='quantity'], input#input-quantity");
    private final By addToCartButtonPDP = By.cssSelector("div.add-to-cart-container");
    private final By addToWishlistButtonPLP = By.cssSelector("button.btn-wishlist, div#entry_216843 button");
    private final By successAlert = By.cssSelector("div.toast.show, div.alert-success");
    private final By viewCartPopupLink = By
            .cssSelector("a.btn-primary[href*='route=checkout/cart'], a[href*='route=checkout/cart']");

    public PDPPage(WebDriver driver) {
        super(driver);
    }

    public String getProductTitle() {
        return getText(productTitle);
    }

    public String getProductPrice() {
        return getText(productPrice);
    }

    public void setQuantity(String quantity) {
        sendKeys(quantityInput, quantity);
    }

    public void clickAddToCart() {
        waitForPageToLoad();
        click(addToCartButtonPDP);
    }

    public void clickAddToWishlist() {
        click(addToWishlistButtonPLP);
    }

    public CartPage navigateToCart() {
        click(viewCartPopupLink);
        return new CartPage(driver);
    }

    public boolean isSuccessAlertDisplayed() {
        return isElementDisplayed(successAlert);
    }

    public String getSuccessAlertText() {
        return getText(successAlert);
    }
}
