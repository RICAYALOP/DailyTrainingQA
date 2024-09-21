package tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.MainPage;
import utils.SettingsTestData;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public abstract class BaseTest {
    protected final MainPage mainPage = new MainPage();
    protected Browser browser;

    @BeforeMethod
    public void setup() {
        browser = AqualityServices.getBrowser();
        getBrowser().maximize();
        getBrowser().goTo("https://www.ilovepdf.com/es/unir_pdf");
    }

    @AfterMethod
    public void teardown() {
        if (AqualityServices.isBrowserStarted()) {
            getBrowser().quit();
        }
    }
}