package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.*;

public class end2endTesting extends BaseTest {

    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;
    CheckoutStepOnePage checkoutStepOnePage;
    CheckoutStepTwoPage checkoutStepTwoPage;
    CheckoutComplete checkoutComplete;

    @Tag("e2e")
    @Test
    public void fullPaymentProcessTest() {
        loginPage = new LoginPage(page);
        inventoryPage = new InventoryPage(page);
        cartPage = new CartPage(page);
        checkoutStepOnePage = new CheckoutStepOnePage(page);
        checkoutStepTwoPage = new CheckoutStepTwoPage(page);
        checkoutComplete = new CheckoutComplete(page);

        loginPage.navigateTo();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.assertCorrectUrlIsDisplayed();
        inventoryPage.addItemToTheCart("Sauce Labs Backpack");
        inventoryPage.addItemToTheCart("Sauce Labs Bike Light");
        inventoryPage.clickCartIcon();
        cartPage.assertCorrectUrlIsDisplayed();
        cartPage.clickCheckoutButton();
        checkoutStepOnePage.assertCorrectUrlIsDisplayed();
        checkoutStepOnePage.fillAndSubmitCheckoutForm("John", "Doe", "12345");
        checkoutStepTwoPage.assertCorrectUrlIsDisplayed();
        checkoutStepTwoPage.clickFinishButton();
        checkoutComplete.assertCorrectUrlIsDisplayed();
        checkoutComplete.assertCheckoutCompleteContainerIsDisplayed();
    }

}
