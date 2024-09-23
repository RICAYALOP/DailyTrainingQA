package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContextMenuPage;

public class ContextMenuTest extends BaseTest {
    private final ContextMenuPage contextMenuPage = new ContextMenuPage();

    @Test
    public void shouldHandleContextMenuAlertSuccessfully() {
        Assert.assertTrue(contextMenuPage.state().isDisplayed(), "The context menu page should be loaded.");
        contextMenuPage.rightClickOnBox();
        Assert.assertTrue(contextMenuPage.isAlertPresent(), "Alert should be displayed after right click.");
        String alertText = contextMenuPage.getAlertText();
        Assert.assertEquals(alertText, "You selected a context menu", "Alert text should match the expected message.");
        contextMenuPage.acceptAlert();
        Assert.assertFalse(contextMenuPage.isAlertPresent(), "Alert should be closed after accepting.");
    }
}