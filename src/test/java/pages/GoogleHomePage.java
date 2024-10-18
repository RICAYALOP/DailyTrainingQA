package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class GoogleHomePage extends Form {

    private final ITextBox searchField = getElementFactory().getTextBox(By.name("q"), "Search Field");
    private final IButton feelingLuckyButton = getElementFactory().getButton(By.name("btnI"), "I'm Feeling Lucky Button");
    private final IButton logoButton = getElementFactory().getButton(By.id("logo"), "Google Logo");

    public GoogleHomePage() {
        super(By.name("q"), "Google Home Page");
    }

    public void typeSearchText(String text) {
        searchField.clearAndType(text);
        searchField.submit();
    }

    public void clickFeelingLucky() {
        feelingLuckyButton.click();
    }

    public void clickLogo() {
        logoButton.click();
    }
}
