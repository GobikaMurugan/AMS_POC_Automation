package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyAccountPage;
import utilities.JsonReader;

public class MyAccountTest extends BaseTest {

    private final String DATA_FILE = "src/test/resources/testdata/loginData.json";

    @Test(description = "Verify user dashboard access upon valid login")
    public void testMyAccountDashboardAccess() {
        String email = JsonReader.getStringValue(DATA_FILE, "validUser", "email");
        String password = JsonReader.getStringValue(DATA_FILE, "validUser", "password");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickAccountHeader();
        MyAccountPage accountPage = loginPage.login(email, password);

        loginPage.clickAccountHeader();

        Assert.assertTrue(accountPage.isUserGreetingDisplayed(), "User is not logged in.");
    }
}
