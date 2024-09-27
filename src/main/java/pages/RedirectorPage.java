package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class RedirectorPage extends Form {

    private final IButton btnHere = getElementFactory().getButton(By.xpath("//a[contains(text(),'here')]"), "Here Link");

    public RedirectorPage() {
        super(By.xpath("//h3[contains(text(),'Redirector')]"), "Redirector Page");
    }

    public void clickHereLink() {
        btnHere.click();
    }

    public boolean isPageLoaded() {
        return btnHere.state().isDisplayed();
    }
}
