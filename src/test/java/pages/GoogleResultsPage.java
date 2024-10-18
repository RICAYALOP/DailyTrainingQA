package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class GoogleResultsPage extends Form {

    private final IButton imagesTab = getElementFactory().getButton(By.linkText("Images"), "Images Tab");

    public GoogleResultsPage() {
        super(By.id("search"), "Google Results Page");
    }

    public void clickImagesTab() {
        imagesTab.click();
    }
}
