package tests;

import aquality.selenium.browser.AqualityServices;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FloatingMenuPage;

public class FloatingMenuTest extends BaseTest {

    private final FloatingMenuPage floatingMenuPage = new FloatingMenuPage();

    @Test
    public void testFloatingMenuNavigation() {
        Assert.assertTrue(floatingMenuPage.isPageLoaded(), "The page should display 'Floating Menu'");
        floatingMenuPage.clickHome();
        Assert.assertTrue(AqualityServices.getBrowser().getCurrentUrl().contains("home"), "The URL should contain 'home'");
        floatingMenuPage.clickNews();
        Assert.assertTrue(AqualityServices.getBrowser().getCurrentUrl().contains("news"), "The URL should contain 'news'");
        floatingMenuPage.clickContact();
        Assert.assertTrue(AqualityServices.getBrowser().getCurrentUrl().contains("contact"), "The URL should contain 'contact'");
        floatingMenuPage.clickAbout();
        Assert.assertTrue(AqualityServices.getBrowser().getCurrentUrl().contains("about"), "The URL should contain 'about'");
        AqualityServices.getBrowser().goBack();
        Assert.assertEquals(AqualityServices.getBrowser().getCurrentUrl(), "https://the-internet.herokuapp.com/floating_menu", "The URL should be the main page URL.");
    }
}
