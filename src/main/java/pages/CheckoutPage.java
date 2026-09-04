package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private final By pageHeader = By.cssSelector("");
    private final By firstNameInput = By.cssSelector("");
    private final By lastNameInput = By.cssSelector("");
    private final By addressInput = By.cssSelector("");
    private final By cityInput = By.cssSelector("");
    private final By postCodeInput = By.cssSelector("");
    private final By termsCheckbox = By.cssSelector("");
    private final By continueButton = By.cssSelector("");
    private final By checkoutAccordion = By.cssSelector("");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public String getPageHeaderTitle() {
        return getText(pageHeader);
    }

    public boolean isCheckoutFormVisible() {
        return isElementDisplayed(checkoutAccordion);
    }

    public void enterBillingDetails(String firstName, String lastName, String address, String city, String postCode) {
        sendKeys(firstNameInput, firstName);
        sendKeys(lastNameInput, lastName);
        sendKeys(addressInput, address);
        sendKeys(cityInput, city);
        sendKeys(postCodeInput, postCode);
    }

    public void acceptTermsAndConditions() {
        click(termsCheckbox);
    }

    public void clickContinue() {
        click(continueButton);
    }
}
