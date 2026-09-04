package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.JsonReader;

public class LoginTest extends BaseTest {

    private final String DATA_FILE = "src/test/resources/testdata/loginData.json";

    @Test(description = "Verify user cannot login with invalid credentials")
    public void testInvalidLogin() {
        String invalidEmail = JsonReader.getStringValue(DATA_FILE, "invalidUser", "email");
        String invalidPass = JsonReader.getStringValue(DATA_FILE, "invalidUser", "password");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickAccountHeader();
        loginPage.login(invalidEmail, invalidPass);

        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed for invalid login.");
    }

    @Test(description = "An inline error message should shown for empty login input")
    public void testEmptyCredentialsLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickAccountHeader();
        loginPage.clickLoginButton();

        Assert.assertTrue(loginPage.isInlineErrorDisplayed(),
                "Error alert or validation error should be displayed on empty submission.");
    }

    @Test(description = "Verify forgot password link is visible")
    public void testLoginPageElements() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickAccountHeader();
        Assert.assertTrue(loginPage.isForgotPasswordLinkDisplayed(), "Forgotten password link should be visible.");
    }
}
