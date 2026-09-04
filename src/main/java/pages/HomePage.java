package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By searchInput = By.cssSelector("input.amsearch-input");
    private final By searchButton = By.cssSelector("button.amsearch-button.-loupe.-clear.-icon.-disabled");
    private final By myAccountMenu = By.cssSelector("");
    private final By wishlistHeaderLink = By.cssSelector("");
    private final By cartHeaderLink = By.cssSelector("a.action.showcart");
    private final By mainLogo = By.cssSelector("a.logo");
    private final By miniCart = By.cssSelector("div#minicart-content-wrapper");
    private final By emptyCartMessage = By.cssSelector("strong.subtitle.empty");
    private final By topCategoriesMenu = By.cssSelector("ul.navbar-nav.horizontal");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void enterSearchKeyword(String keyword) {
        waitForPageToLoad();
        sendKeys(searchInput, keyword);
    }

    public void clickSearchButton() {
        click(searchButton);
    }

    public PLPPage searchProduct(String keyword) {
        waitForPageToLoad();
        enterSearchKeyword(keyword);
        clickSearchButton();
        waitForPageToLoad();
        return new PLPPage(driver);
    }

    public LoginPage navigateToLoginPage() {
        click(myAccountMenu);
        return new LoginPage(driver);
    }

    public WishlistPage navigateToWishlistPage() {
        click(wishlistHeaderLink);
        return new WishlistPage(driver);
    }

    public CartPage navigateToCartPage() {
        waitForPageToLoad();
        click(cartHeaderLink);
        return new CartPage(driver);
    }

    public void openMiniCart() {
        click(cartHeaderLink);
        waitForVisibility(miniCart);
    }

    public boolean isEmptyCartMessageDisplayed() {
        return isElementDisplayed(emptyCartMessage);
    }

    public void clickLogo() {
        click(mainLogo);
        waitForPageToLoad();
    }

    public boolean isLogoDisplayed() {
        return isElementDisplayed(mainLogo);
    }

    public boolean isHomePageLoaded() {
        return driver.getTitle().contains("Collectible United States");
    }
}
