package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class addAndRemoveTest extends BaseCode {
    private final By addAndRemovePath = By.xpath("//a[@href='/add_remove_elements/']");
    private final By addPath = By.xpath("//button[@onclick='addElement()']");
    private final By deleteListPath = By.xpath("//button[@onclick='deleteElement()']");

    @Test
    public void testAddAndRemove() {
        driver.findElement(addAndRemovePath).click();
        for (int i = 0; i < 3; i++) {
            driver.findElement(addPath).click();
        }
        List<WebElement> deleteButtons = driver.findElements(deleteListPath);
        for (WebElement deleteButton : deleteButtons) {
            deleteButton.click();
        }
        boolean areDeleteButtonsPresent = driver.findElements(deleteListPath).size() < 1;
        Assert.assertTrue(areDeleteButtonsPresent, "There still some buttons to erase");
    }
}
