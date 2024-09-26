package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class FloatingMenuPage extends Form {

    private final IButton btnHome = getElementFactory().getButton(By.xpath("//a[text()='Home']"), "Home Link");
    private final IButton btnNews = getElementFactory().getButton(By.xpath("//a[text()='News']"), "News Link");
    private final IButton btnContact = getElementFactory().getButton(By.xpath("//a[text()='Contact']"), "Contact Link");
    private final IButton btnAbout = getElementFactory().getButton(By.xpath("//a[text()='About']"), "About Link");

    public FloatingMenuPage() {
        super(By.id("menu"), "Floating Menu Page");
    }

    public void clickHome() {
        btnHome.click();
    }

    public void clickNews() {
        btnNews.click();
    }

    public void clickContact() {
        btnContact.click();
    }

    public void clickAbout() {
        btnAbout.click();
    }

    public boolean isPageLoaded() {
        return getElementFactory().getLabel(By.tagName("h3"), "Floating Menu Title").getText().contains("Floating Menu");
    }
}
