package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.PLPPage;
import utilities.JsonReader;

public class NavigationTest extends BaseTest {

    private final String DATA_FILE = "src/test/resources/testdata/productData.json";

    @Test(description = "Verify product search navigation to PLP")
    public void testProductSearchNavigation() {
        String keyword = JsonReader.getStringValue(DATA_FILE, "searchProducts", "keyword");

        HomePage homePage = new HomePage(driver);
        PLPPage plpPage = homePage.searchProduct(keyword);

        Assert.assertTrue(plpPage.isProductListVisible(), "Product grid should be visible on search results PLP.");
    }

    @Test(description = "Verify direct navigation via Logo")
    public void testHomeNavigation() {
        String keyword = JsonReader.getStringValue(DATA_FILE, "searchProducts", "keyword");

        HomePage homePage = new HomePage(driver);
        homePage.searchProduct(keyword);

        Assert.assertTrue(homePage.isLogoDisplayed(), "Logo should be displayed on Home Page");
        homePage.clickLogo();
        Assert.assertTrue(homePage.isHomePageLoaded(), "Logo should be displayed on Home Page");

    }
}
