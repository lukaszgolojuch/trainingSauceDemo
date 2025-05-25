package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class InventoryPage extends BasePage {
    //Pola
    private final Locator inventoryList;
    private final Locator inventoryItems;
    private final Locator itemNames;
    private final Locator itemPrices;
    private final Locator cartIcon;
    private static final String PAGE_URL = "inventory.html";

    //Constructor
    public InventoryPage(Page page) {
        super(page, PAGE_URL);
        this.inventoryList = page.locator(".inventory_list");
        this.inventoryItems = page.locator(".inventory_item");
        this.itemNames = page.locator(".inventory_item_name");
        this.itemPrices = page.locator(".inventory_item_price");
        this.cartIcon = page.locator(".shopping_cart_link");
    }

    //Metody
    public void clickCartIcon() {
        cartIcon.click();
    }

    public void assertInventoryListIsDisplayed() {
        assertThat(inventoryList).isVisible();
    }

    public void assertItemsCountIs(int expectedCount) {
        int actualCount = getItemsCount();
        Assertions.assertEquals(expectedCount, actualCount);
    }

    public void assertItemNameAndPriceAreDisplayed() {
        for (int i = 0; i < getItemsCount(); i++) {
            assertThat(getItemNameAt(i)).isVisible();
            assertThat(getItemPriceAt(i)).isVisible();
        }
    }

    public void addItemToTheCart(String itemName) {
        Locator productCard = inventoryItems.filter(new Locator.FilterOptions().setHasText(itemName));
        Locator addToCartButton = productCard.locator("button");
        addToCartButton.click();
    }

    private int getItemsCount() {
        return inventoryItems.count();
    }

    private Locator getItemNameAt(int index) {
        return itemNames.nth(index);
    }

    private Locator getItemPriceAt(int index) {
        return itemPrices.nth(index);
    }

}
