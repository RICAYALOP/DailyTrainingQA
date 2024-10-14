package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwagLabsTest extends BaseTest {

    // Definir localizadores (By) como final
    private final By loginButton = By.id("login-button");
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By addToCartBtn = By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']");
    private final By cartBadge = By.className("shopping_cart_badge");
    private final By checkoutButton = By.id("checkout");
    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By postalCodeField = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By finishButton = By.id("finish");
    private final By confirmationMessage = By.className("complete-header");

    @Test
    public void testSwagLabsFlow() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        driver.findElement(loginButton).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo.com"), "Login page not opened");
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        driver.findElement(usernameField).sendKeys("standard_user");
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        driver.findElement(passwordField).sendKeys("secret_sauce");
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"), "Not redirected to inventory page");
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
        driver.findElement(addToCartBtn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge));
        WebElement cartBadgeElement = driver.findElement(cartBadge);
        Assert.assertEquals(cartBadgeElement.getText(), "1", "Product not added to cart");
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        driver.findElement(checkoutButton).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-one.html"), "Not redirected to checkout page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        driver.findElement(firstNameField).sendKeys("John");
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField));
        driver.findElement(lastNameField).sendKeys("Doe");
        wait.until(ExpectedConditions.visibilityOfElementLocated(postalCodeField));
        driver.findElement(postalCodeField).sendKeys("12345");
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        driver.findElement(continueButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(finishButton));
        driver.findElement(finishButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage));
        WebElement confirmationMsg = driver.findElement(confirmationMessage);
        Assert.assertTrue(confirmationMsg.getText().contains("THANK YOU FOR YOUR ORDER"), "Purchase confirmation not displayed");
    }
}
