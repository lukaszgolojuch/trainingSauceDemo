package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.InventoryPage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    LoginPage loginPage;
    InventoryPage inventoryPage;

    @Tag("InvalidLogin")
    @ParameterizedTest(name = "Invalid login with username={0}, and password={1}")
    @CsvSource({
            "'', secret_sauce, Username is required",
            "standard_user, '', Password is required",
            "'', '', Username is required",
            "wrong_user, wrong_password, Username and password do not match any user in this service",
            "locked_out_user, secret_sauce, Sorry, this user has been locked out."
    })
    void failedLoginTest(String username, String password, String errorMessage) {
        loginPage = new LoginPage(page);
        loginPage.navigateTo();
        loginPage.login(username, password);
        loginPage.assertErrorMessageIsDisplayed(errorMessage);
    }

    @Tag("InvalidLogin")
    @Test
    void multipleFailedLoginTest() {
        loginPage = new LoginPage(page);
        loginPage.navigateTo();

        // Empty username
        loginPage.login("", "secret_sauce");
        loginPage.assertErrorMessageIsDisplayed("Username is required");

        // Empty password
        loginPage.login("standard_user", "");
        loginPage.assertErrorMessageIsDisplayed("Password is required");

        // Both empty
        loginPage.login("", "");
        loginPage.assertErrorMessageIsDisplayed("Username is required");

        // Wrong credentials
        loginPage.login("wrong_user", "wrong_password");
        loginPage.assertErrorMessageIsDisplayed("Username and password do not match any user in this service");

        // Locked out user
        loginPage.login("locked_out_user", "secret_sauce");
        loginPage.assertErrorMessageIsDisplayed("Sorry, this user has been locked out.");
    }

    @Tag("ValidLogin")
    @Test
    void successfulLoginTest() {
        loginPage = new LoginPage(page);
        inventoryPage = new InventoryPage(page);
        loginPage.navigateTo();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.assertCorrectUrlIsDisplayed();
    }

}
