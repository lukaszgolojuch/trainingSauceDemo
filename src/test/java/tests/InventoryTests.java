package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class InventoryTests extends BaseTest {

    LoginPage loginPage;
    InventoryPage inventoryPage;

    @Tag("Inventory")
    @Test
    void inventoryItemsVisibilityTests() {
        loginPage = new LoginPage(page);
        inventoryPage = new InventoryPage(page);
        loginPage.navigateTo();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.assertCorrectUrlIsDisplayed();
        inventoryPage.assertInventoryListIsDisplayed();
        inventoryPage.assertItemsCountIs(6);
        inventoryPage.assertItemNameAndPriceAreDisplayed();
    }

}
