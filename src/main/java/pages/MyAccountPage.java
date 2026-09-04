package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage {

    private final By userGreeting = By.cssSelector("span.logged-in");
    private final By accountHeading = By.cssSelector(
            "h1.page-title, div.page-title-wrapper h1, .block-dashboard-info, div#content h2:first-of-type, h2.card-header");
    private final By editAccountLink = By
            .cssSelector(
                    "a[href*='customer/account/edit'], a.list-group-item[href*='account/edit'], a[href*='route=account/edit']");
    private final By orderHistoryLink = By
            .cssSelector(
                    "a[href*='sales/order/history'], a.list-group-item[href*='account/order'], a[href*='route=account/order']");
    private final By wishlistLink = By
            .cssSelector(
                    "a[href*='wishlist'], a.list-group-item[href*='account/wishlist'], a[href*='route=account/wishlist']");
    private final By logoutLink = By
            .cssSelector(
                    "a[href*='customer/account/logout'], a.list-group-item[href*='account/logout'], a[href*='route=account/logout']");

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public String getUserGreeting() {
        try {
            waitForVisibility(userGreeting);
            return getText(userGreeting);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean isUserGreetingDisplayed() {
        try {
            waitForVisibility(userGreeting);
            return isElementDisplayed(userGreeting);
        } catch (Exception e) {
            return false;
        }
    }

    public String getAccountHeadingText() {
        return getText(accountHeading);
    }

    public boolean isAccountHeadingDisplayed() {
        return isElementDisplayed(accountHeading);
    }

    public WishlistPage navigateToWishlist() {
        click(wishlistLink);
        return new WishlistPage(driver);
    }

    public void clickLogout() {
        click(logoutLink);
    }

    public boolean isEditAccountLinkDisplayed() {
        return isElementDisplayed(editAccountLink);
    }

    public boolean isOrderHistoryLinkDisplayed() {
        return isElementDisplayed(orderHistoryLink);
    }
}
