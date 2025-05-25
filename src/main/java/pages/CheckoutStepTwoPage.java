package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckoutStepTwoPage extends BasePage {

    private final Locator finishButton;
    private static final String PAGE_URL = "checkout-step-two.html";

    public CheckoutStepTwoPage(Page page) {
        super(page, PAGE_URL);
        this.finishButton = page.locator(".cart_button");
    }

    public void clickFinishButton() {
        finishButton.click();
    }

}
