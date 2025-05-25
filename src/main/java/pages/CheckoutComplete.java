package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CheckoutComplete extends BasePage {
    private final Locator checkoutCompleteContainer;
    private static final String PAGE_URL = "checkout-complete.html";

    public CheckoutComplete(Page page) {
        super(page, PAGE_URL);
        this.checkoutCompleteContainer = page.locator(".checkout_complete_container");
    }

    public void assertCheckoutCompleteContainerIsDisplayed() {
        assertThat(checkoutCompleteContainer).isVisible();
    }

}
