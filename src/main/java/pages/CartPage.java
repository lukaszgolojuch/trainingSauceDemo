package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CartPage extends BasePage {

    private final Locator checkoutButton;
    private static final String PAGE_URL = "cart.html";

    public CartPage(Page page) {
        super(page, PAGE_URL);
        this.checkoutButton = page.locator(".checkout_button");
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }

}
