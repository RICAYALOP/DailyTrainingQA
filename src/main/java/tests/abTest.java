package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class abTest extends baseCode {
    private final By splitTestPath = By.xpath("//a[@href='/abtest']");
    private final By headingPath = By.tagName("h3");
    private final String referenceText = "A/B Test Control";

    @Test
    public void selectText() {
        driver.findElement(splitTestPath).click();
        WebElement headingElement = driver.findElement(headingPath);
        String headingText = headingElement.getText();
        Assert.assertEquals(referenceText, headingText, "Not valid test");
    }
}
