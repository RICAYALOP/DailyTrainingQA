package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class SecureAreaPage extends Form {

    private final IButton btnLogout = getElementFactory().getButton(By.cssSelector(".button.secondary.radius"), "Logout Button");

    public SecureAreaPage() {
        super(By.id("flash"), "Secure Area Page");
    }

    public void clickLogoutButton() {
        btnLogout.click();
    }
}