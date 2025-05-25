package pages;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public abstract class BasePage {
    protected final Page page;
    protected final String pageUrl;
    protected static final String BASE_URL = "https://www.saucedemo.com/v1/";

    public BasePage(Page page, String pageUrl) {
        this.page = page;
        this.pageUrl = pageUrl;
    }

    public void assertCorrectUrlIsDisplayed() {
        assertThat(page).hasURL(BASE_URL + pageUrl);
    }
}
