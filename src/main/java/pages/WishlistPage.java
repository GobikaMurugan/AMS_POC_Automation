package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishlistPage extends BasePage {

    private final By wishlistTable = By.cssSelector("form.form-wishlist-items");
    private final By firstWishlistItemName = By.cssSelector("table.table-bordered tbody tr td.text-left a");
    private final By removeFirstItemButton = By.cssSelector(
            "table.table-bordered tbody tr td.text-right a.btn-danger, a[data-original-title='Remove'], a[href*='remove=']");
    private final By successAlert = By.cssSelector("div.alert-success");
    private final By emptyWishlistMessage = By.cssSelector("div#content p");

    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    public boolean isWishlistTableDisplayed() {
        return isElementDisplayed(wishlistTable);
    }

    public String getFirstWishlistItemName() {
        return getText(firstWishlistItemName);
    }

    public void removeFirstItem() {
        click(removeFirstItemButton);
    }

    public boolean isSuccessAlertDisplayed() {
        return isElementDisplayed(successAlert);
    }

    public String getEmptyWishlistMessage() {
        return getText(emptyWishlistMessage);
    }
}
