package tests;

import aquality.selenium.browser.AqualityServices;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RedirectorPage;
import pages.StatusCodesPage;

public class RedirectorTest extends BaseTest {

    private final RedirectorPage redirectorPage = new RedirectorPage();
    private final StatusCodesPage statusCodesPage = new StatusCodesPage();

    @Test
    public void testRedirectorAndStatusCodes() {
        Assert.assertTrue(redirectorPage.isPageLoaded(), "The Redirector page should be loaded.");
        redirectorPage.clickHereLink();
        Assert.assertTrue(statusCodesPage.isPageLoaded(), "The Status Codes page should be loaded.");
        statusCodesPage.getStatusLinks().forEach(link -> {
            String currentUrl = AqualityServices.getBrowser().getCurrentUrl();
            link.click();
            AqualityServices.getBrowser().goBack();
            Assert.assertEquals(AqualityServices.getBrowser().getCurrentUrl(), currentUrl, "Should return to the Status Codes page.");
        });
    }
}
