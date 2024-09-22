package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.List;

public class AddRemoveElementsPage extends Form {

    private final IButton btnAddElement = getElementFactory().getButton(By.xpath("//button[text()='Add Element']"), "Add Element");
    private final By btnDeleteLocator = By.xpath("//button[text()='Delete']");

    public AddRemoveElementsPage() {
        super(By.xpath("//h3[contains(text(), 'Add/Remove Elements')]"), "Add/Remove Elements Page");
    }

    public void clickAddElement() {
        btnAddElement.click();
    }

    public List<IButton> getDeleteButtons() {
        return getElementFactory().findElements(btnDeleteLocator, ElementType.BUTTON);
    }

    public void clickAllDeleteButtons() {
        List<IButton> deleteButtons = getDeleteButtons();
        for (IButton deleteButton : deleteButtons) {
            deleteButton.click();
        }
    }

    public boolean areDeleteButtonsAbsent() {
        return getDeleteButtons().isEmpty();
    }
}