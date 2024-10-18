package tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import models.EnvData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.SettingsTestData;

import java.io.IOException;

public class BaseTest {
    protected Browser browser;
    private EnvData envData;

    @BeforeMethod
    public void setUp() throws IOException {
        envData = SettingsTestData.loadEnvData("prod");
        browser = AqualityServices.getBrowser();
        browser.maximize();
        browser.goTo(envData.getHost());
    }

    @AfterMethod
    public void tearDown() {
        if (AqualityServices.isBrowserStarted()) {
            browser.quit();
        }
    }
}
