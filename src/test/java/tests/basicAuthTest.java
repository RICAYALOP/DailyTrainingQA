package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class basicAuthTest extends BaseCode {
    private final By basicAuthPath = By.xpath("//a[@href='/basic_auth']");
    private final By successAuth = By.xpath(String.format(PARTICULAR_TEXT_XPATH, "Congratulations! You must have the proper credentials."));

    @BeforeMethod
    public void basicAuthBefore() {
        HasAuthentication authentication = (HasAuthentication) driver;
        authentication.register(() -> new UsernameAndPassword("admin", "admin"));
    }

    @Test
    public void basicAuthTesting() {
        driver.findElement(basicAuthPath).click();
        Assert.assertTrue(driver.findElement(successAuth).isDisplayed(), "Message is not displayed");
    }
}