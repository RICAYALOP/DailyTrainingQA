package tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    protected Browser browser;

    @BeforeMethod
    public void setUp() {
        browser = AqualityServices.getBrowser();
        browser.maximize();
        browser.goTo("https://the-internet.herokuapp.com/dynamic_controls");
    }

    @AfterMethod
    public void tearDown() {
        if (browser != null) {
            browser.quit();
        }
    }
}
