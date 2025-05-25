package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPage extends BasePage {
    //Pola
    private final Locator usernameInput;
    private final Locator passwordInput;
    private final Locator submitButton;
    private final Locator errorMessage;
    private static final String PAGE_URL = "";

    //Constructor
    public LoginPage(Page page) {
        super(page, PAGE_URL);
        this.usernameInput = page.locator("#user-name");
        this.passwordInput = page.locator("#password");
        this.submitButton = page.locator("#login-button");
        this.errorMessage = page.locator("[data-test='error']");
    }

    //Metody
    public void navigateTo() {
        page.navigate(BASE_URL);
    }

    public void login(String username, String password) {
        usernameInput.fill(username);
        passwordInput.fill(password);
        submitButton.click();
    }

    public void assertErrorMessageIsDisplayed(String errorMessage) {
        assertThat(this.errorMessage).isVisible();
        assertThat(this.errorMessage).containsText(errorMessage);
    }

}
