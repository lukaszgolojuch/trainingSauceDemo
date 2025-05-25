package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckoutStepOnePage extends BasePage {

    private final Locator firstNameInput;
    private final Locator lastNameInput;
    private final Locator postalCodeInput;
    private final Locator continueButton;
    private static final String PAGE_URL = "checkout-step-one.html";

    public CheckoutStepOnePage(Page page) {
        super(page, PAGE_URL);
        this.firstNameInput = page.locator("#first-name");
        this.lastNameInput = page.locator("#last-name");
        this.postalCodeInput = page.locator("#postal-code");
        this.continueButton = page.locator(".cart_button");
    }

    public void fillAndSubmitCheckoutForm(
            String firstName,
            String lastName,
            String postalCode) {
        firstNameInput.fill(firstName);
        lastNameInput.fill(lastName);
        postalCodeInput.fill(postalCode);
        continueButton.click();
    }

}
