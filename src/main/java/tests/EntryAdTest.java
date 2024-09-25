package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EntryAdPage;

public class EntryAdTest extends BaseTest {

    private final EntryAdPage entryAdPage = new EntryAdPage();

    @Test
    public void shouldHandleModalWindowSuccessfully() {
        Assert.assertTrue(entryAdPage.isModalWindowDisplayed(), "The modal window should be displayed.");
        String modalText = entryAdPage.getModalWindowText();
        Assert.assertEquals(modalText, "This is a modal window", "Modal window text should match.");
        entryAdPage.clickCloseButton();
        Assert.assertFalse(entryAdPage.isModalWindowDisplayed(), "The modal window should be closed.");
        entryAdPage.clickHereLink();
        AqualityServices.getBrowser().refresh();
        Assert.assertTrue(entryAdPage.isModalWindowDisplayed(), "The modal window should be displayed again after refresh.");
    }
}