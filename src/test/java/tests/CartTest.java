package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.PDPPage;
import pages.PLPPage;
import utilities.JsonReader;

public class CartTest extends BaseTest {

    private final String DATA_FILE = "src/test/resources/testdata/productData.json";

    @Test(description = "Verify adding product to Cart from PLP")
    public void testAddProductToCartFromPLP() {
        String keyword = JsonReader.getStringValue(DATA_FILE, "searchProducts", "keyword");

        HomePage homePage = new HomePage(driver);
        PLPPage plpPage = homePage.searchProduct(keyword);

        plpPage.addFirstProductToCart();

        Assert.assertTrue(plpPage.isSuccessNotificationDisplayed(),
                "Success notification should appear after adding to cart.");
    }

    @Test(description = "Verify adding product to Cart from PDP")
    public void testAddProductToCartFromPDP() {
        String keyword = JsonReader.getStringValue(DATA_FILE, "searchProducts", "keyword");

        HomePage homePage = new HomePage(driver);
        PLPPage plpPage = homePage.searchProduct(keyword);
        PDPPage pdpPage = plpPage.clickFirstProduct();
        pdpPage.clickAddToCart();

        Assert.assertTrue(pdpPage.isSuccessAlertDisplayed(),
                "Success notification should appear after adding to cart.");
    }

    @Test(description = "Verify viewing empty cart message")
    public void testEmptyCartView() {

        HomePage homePage = new HomePage(driver);
        homePage.openMiniCart();
        Assert.assertTrue(homePage.isEmptyCartMessageDisplayed(), "Empty cart message not displayed.");
    }
}
