package tests;

import org.awaitility.core.ConditionTimeoutException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.awaitility.Awaitility;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class FileDownloadTest extends BaseTest {
    private final By fileDownloadXpath = By.xpath("//a[@href='/download']");
    private final String fileName = "Demo.txt";
    private final By fileXpath = By.xpath("//a[contains(@href,'Demo')]");
    private final File downloadfile = new File(RELATIVE_RESOURCE_PATH + fileName);

    @Test
    public void downloadFileTest() {
        driver.findElement(fileDownloadXpath).click();
        Assert.assertTrue(driver.findElement(fileXpath).isDisplayed(), "The file is missing");
        driver.findElement(fileXpath).click();
        Assert.assertTrue(fileExists(downloadfile), "File is not downloaded");
    }

    private boolean fileExists(File file) {
        try {
            Awaitility.await().atMost(MAX_WAIT, TimeUnit.SECONDS).until(file::exists);
        } catch (ConditionTimeoutException exception) {
            return false;
        }
        return true;
    }

    @AfterMethod
    public void deleteFile() {
        if (downloadfile.exists()) {
            downloadfile.delete();
        }
    }
}
