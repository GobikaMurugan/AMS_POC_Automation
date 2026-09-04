package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By cartTable = By.cssSelector("");
    private final By firstCartItemName = By.cssSelector("");
    private final By quantityInputField = By.cssSelector("");
    private final By updateQuantityButton = By.cssSelector("");
    private final By removeProductButton = By.cssSelector("");
    private final By checkoutButton = By.cssSelector("");
    private final By emptyCartMessage = By.cssSelector("");
    private final By successAlert = By.cssSelector("");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCartTableDisplayed() {
        return isElementDisplayed(cartTable);
    }

    public String getFirstCartItemName() {
        return getText(firstCartItemName);
    }

    public void updateQuantity(String newQuantity) {
        sendKeys(quantityInputField, newQuantity);
        click(updateQuantityButton);
    }

    public void removeFirstItem() {
        click(removeProductButton);
    }

    public CheckoutPage proceedToCheckout() {
        click(checkoutButton);
        return new CheckoutPage(driver);
    }

    public String getEmptyCartMessage() {
        return getText(emptyCartMessage);
    }

    public boolean isSuccessAlertDisplayed() {
        return isElementDisplayed(successAlert);
    }
}
