package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class checkBoxTest extends BaseCode {
    private final By checkBoxPath = By.xpath("//a[@href='/checkboxes']");
    private final By checkBoxesPath = By.xpath("//input[@type='checkbox']");

    @Test
    public void checkBoxTesting() {
        driver.findElement(checkBoxPath).click();
        List<WebElement> checkboxes = driver.findElements(checkBoxesPath);
        for (WebElement checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                checkbox.click();
            }
        }
        for (WebElement checkbox : checkboxes) {
            Assert.assertFalse(checkbox.isSelected(), "Checkbox should be deselected");
        }
    }
}
