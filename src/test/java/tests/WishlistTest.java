package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PLPPage;
import utilities.JsonReader;

public class WishlistTest extends BaseTest {

    private final String DATA_FILE = "src/test/resources/testdata/productData.json";

    @Test(description = "Verify anonymous user is redirected to Login page when adding product to Wishlist")
    public void testAddProductToWishlist() {
        String keyword = JsonReader.getStringValue(DATA_FILE, "searchProducts", "keyword");

        HomePage homePage = new HomePage(driver);
        PLPPage plpPage = homePage.searchProduct(keyword);

        plpPage.addFirstProductToWishlist();
        LoginPage loginPage = new LoginPage(driver);

        Assert.assertTrue(loginPage.isForgotPasswordLinkDisplayed() || loginPage.isErrorMessageDisplayed(),
                "User was not redirected to Login page.");
    }
}
