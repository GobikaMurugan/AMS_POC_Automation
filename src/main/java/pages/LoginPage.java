package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By accountHeader = By.cssSelector("li.link.authorization-link");
    private final By emailInput = By.cssSelector("input#email.input-text");
    private final By passwordInput = By.cssSelector("input#password.input-text");
    private final By loginButton = By.cssSelector("button#send2.action.login.primary");
    private final By errorMessageAlert = By.cssSelector("div.message-error.error.message");
    private final By inlineError = By.cssSelector("div#password-error.mage-error");
    private final By forgotPasswordLink = By.cssSelector("a.action.remind");
    private final By newCustomerRegisterBtn = By.cssSelector("a.action.create.primary");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickAccountHeader() {
        try {
            waitForVisibility(accountHeader);
            click(accountHeader);
        } catch (Exception e) {
            System.out.println("Account header not found or not visible.");
        }
    }

    public void enterEmail(String email) {
        waitForVisibility(emailInput);
        sendKeys(emailInput, email);
    }

    public void enterPassword(String password) {
        sendKeys(passwordInput, password);
    }

    public void clickLoginButton() {
        click(loginButton);
        waitForPageToLoad();
    }

    public MyAccountPage login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
        return new MyAccountPage(driver);
    }

    public String getErrorMessage() {
        try {
            waitForVisibility(errorMessageAlert);
            return getText(errorMessageAlert);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean isErrorMessageDisplayed() {
        try {
            waitForVisibility(errorMessageAlert);
            return isElementDisplayed(errorMessageAlert);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isInlineErrorDisplayed() {
        try {
            waitForVisibility(inlineError);
            return isElementDisplayed(inlineError);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isForgotPasswordLinkDisplayed() {
        return isElementDisplayed(forgotPasswordLink);
    }
}
