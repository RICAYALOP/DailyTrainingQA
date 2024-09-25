package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class EntryAdPage extends Form {

    private final ILabel lblModalWindow = getElementFactory().getLabel(By.cssSelector(".modal-title"), "Modal Window Title");
    private final IButton btnCloseModal = getElementFactory().getButton(By.cssSelector(".modal-footer p"), "Close Button");
    private final IButton linkClickHere = getElementFactory().getButton(By.xpath("//a[text()='click here']"), "Click Here Link");

    public EntryAdPage() {
        super(By.id("modal"), "Entry Ad Page");
    }

    public boolean isModalWindowDisplayed() {
        return lblModalWindow.state().isDisplayed();
    }

    public String getModalWindowText() {
        return lblModalWindow.getText();
    }

    public void clickCloseButton() {
        btnCloseModal.click();
    }

    public void clickHereLink() {
        linkClickHere.click();
    }
}
