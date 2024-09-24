package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

public class LoginTest extends BaseTest {

    private final LoginPage loginPage = new LoginPage();
    private final SecureAreaPage secureAreaPage = new SecureAreaPage();

    @Test
    public void shouldLoginAndLogoutSuccessfully() {
        Assert.assertTrue(loginPage.state().isDisplayed(), "Login page should be displayed.");
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isLoginMessageDisplayed(), "Login success message should be displayed.");
        secureAreaPage.clickLogoutButton();
        Assert.assertTrue(loginPage.isLogoutMessageDisplayed(), "Logout success message should be displayed.");
    }
}