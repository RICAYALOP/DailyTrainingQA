package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddRemoveElementsPage;

public class AddRemoveElementsTest extends BaseTest {

    private final AddRemoveElementsPage addRemoveElementsPage = new AddRemoveElementsPage();

    @Test
    public void shouldAddAndRemoveElementsSuccessfully() {
        addRemoveElementsPage.clickAddElement();
        addRemoveElementsPage.clickAddElement();
        addRemoveElementsPage.clickAddElement();
        Assert.assertEquals(addRemoveElementsPage.getDeleteButtons().size(), 3, "There should be 3 'Delete' buttons.");
        addRemoveElementsPage.clickAllDeleteButtons();
        Assert.assertTrue(addRemoveElementsPage.areDeleteButtonsAbsent(), "There should be no 'Delete' buttons.");
    }
}