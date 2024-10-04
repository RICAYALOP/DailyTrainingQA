package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class DataTablesTest extends BaseTest{
    private final By dataTablesLinkXpath = By.xpath("//a[@href='/tables']");
    private final By tableDataXpath = By.xpath("//table[@id='table1']//td[4]");
    private final double totalNeeded = 251.0;
    private final String CURRENCY_REGEX = "[^\\d.]";

    @Test
    public void dataTablesTest() {
        driver.findElement(dataTablesLinkXpath).click();
        List<WebElement> dataList = driver.findElements(tableDataXpath);
        Double actualSum = 0.0;
        for(WebElement element: dataList) {
            String elementText = element.getText();
            actualSum += Double.parseDouble(elementText.replaceAll(CURRENCY_REGEX, ""));
        }
        Assert.assertEquals(actualSum, totalNeeded, "The total amount is wrong");
    }
}
