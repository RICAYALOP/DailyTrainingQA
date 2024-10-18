package tests;

import aquality.selenium.browser.AqualityServices;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoogleHomePage;
import pages.GoogleResultsPage;

public class GoogleTest extends BaseTest {

    @Test
    public void testGoogleSearchAndFeelingLucky() {
        browser.goTo("https://www.google.com");
        Assert.assertTrue(AqualityServices.getBrowser().getCurrentUrl().contains("google"), "The Google home page did not load correctly");
        GoogleHomePage googleHomePage = new GoogleHomePage();
        googleHomePage.typeSearchText("QA testing");
        GoogleResultsPage googleResultsPage = new GoogleResultsPage();
        Assert.assertTrue(googleResultsPage.state().waitForDisplayed(), "The search results have not been loaded");
        googleResultsPage.clickImagesTab();
        Assert.assertTrue(AqualityServices.getBrowser().getCurrentUrl().contains("tbm=isch"), "You have not switched to the images tab");
        googleHomePage.clickLogo();
        Assert.assertEquals(AqualityServices.getBrowser().getCurrentUrl(), "https://www.google.com", "It did not return to the Google home page");
        googleHomePage.clickFeelingLucky();
        Assert.assertFalse(AqualityServices.getBrowser().getCurrentUrl().contains("search"), "The 'I'm Feeling Lucky' button has not redirected correctly");
    }
}
