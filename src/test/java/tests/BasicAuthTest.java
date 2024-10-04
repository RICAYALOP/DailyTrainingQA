package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicAuthTest extends BaseTest{
    private final By basicAuthXpath = By.xpath("//a[@href='/basic_auth']");
    private final By successMessage = By.xpath("//p[contains(text(),'Congratulations')]");

    @BeforeMethod
    public void basicAuth() {
        HasAuthentication authentication = (HasAuthentication) driver;
        authentication.register(() -> new UsernameAndPassword("admin", "admin"));
    }
    @Test
    public void basicAuthTest() {
        driver.findElement(basicAuthXpath).click();
        Assert.assertTrue(driver.findElement(successMessage).isDisplayed(), "Auth not completed");
    }
}
