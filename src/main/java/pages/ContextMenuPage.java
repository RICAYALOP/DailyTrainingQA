package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.forms.Form;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage extends Form {

    private final IElement contextBox = getElementFactory().getElement(By.id("hot-spot"), ElementType.LABEL);

    public ContextMenuPage() {
        super(By.xpath("//h3[contains(text(), 'Context Menu')]"), "Context Menu Page");
    }

    public void rightClickOnBox() {
        Actions actions = new Actions(AqualityServices.getBrowser().getDriver());
        actions.contextClick(contextBox.getElement()).perform();
    }

    public boolean isAlertPresent() {
        try {
            AqualityServices.getBrowser().getDriver().switchTo().alert();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getAlertText() {
        Alert alert = AqualityServices.getBrowser().getDriver().switchTo().alert();
        return alert.getText();
    }

    public void acceptAlert() {
        Alert alert = AqualityServices.getBrowser().getDriver().switchTo().alert();
        alert.accept();
    }
}
