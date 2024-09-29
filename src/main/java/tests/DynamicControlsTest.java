package tests;

import aquality.selenium.browser.AqualityServices;
import pages.DynamicControlsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicControlsTest extends BaseTest {

    private final DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();

    @Test
    public void testDynamicControls() {
        dynamicControlsPage.clickRemove();
        AqualityServices.getConditionalWait().waitFor(() -> !dynamicControlsPage.isCheckboxPresent(), "Waiting for checkbox to be removed");
        Assert.assertFalse(dynamicControlsPage.isCheckboxPresent(), "Checkbox should not be present after clicking Remove");
        dynamicControlsPage.clickAdd();
        AqualityServices.getConditionalWait().waitFor(dynamicControlsPage::isCheckboxPresent, "Waiting for checkbox to be added");
        Assert.assertTrue(dynamicControlsPage.isCheckboxPresent(), "Checkbox should be present after clicking Add");
        dynamicControlsPage.clickCheckbox();
        Assert.assertTrue(dynamicControlsPage.isCheckboxPresent(), "Checkbox should be enabled after clicking it");
        dynamicControlsPage.clickEnable();
        AqualityServices.getConditionalWait().waitFor(dynamicControlsPage::isTextInputEnabled, "Waiting for text input to be enabled");
        Assert.assertTrue(dynamicControlsPage.isTextInputEnabled(), "Text input should be enabled after clicking Enable");
        String randomText = "RandomTest123";
        dynamicControlsPage.enterText(randomText);
        Assert.assertEquals(dynamicControlsPage.getText(), randomText, "The entered text should match the expected text");
        dynamicControlsPage.clickDisable();
        AqualityServices.getConditionalWait().waitFor(() -> !dynamicControlsPage.isTextInputEnabled(), "Waiting for text input to be disabled");
        Assert.assertFalse(dynamicControlsPage.isTextInputEnabled(), "Text input should be disabled after clicking Disable");
    }
}
