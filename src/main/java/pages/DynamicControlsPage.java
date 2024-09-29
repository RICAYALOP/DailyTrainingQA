package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class DynamicControlsPage extends Form {
    private final IButton btnRemove = getElementFactory().getButton(By.xpath("//button[contains(text(),'Remove')]"), "Remove Button");
    private final IButton btnAdd = getElementFactory().getButton(By.xpath("//button[contains(text(),'Add')]"), "Add Button");
    private final IButton btnEnable = getElementFactory().getButton(By.xpath("//button[contains(text(),'Enable')]"), "Enable Button");
    private final IButton btnDisable = getElementFactory().getButton(By.xpath("//button[contains(text(),'Disable')]"), "Disable Button");
    private final ICheckBox chkBox = getElementFactory().getCheckBox(By.id("checkbox"), "Checkbox");
    private final ITextBox txtInput = getElementFactory().getTextBox(By.xpath("//input[@type='text']"), "Text Input");

    public DynamicControlsPage() {
        super(By.id("content"), "Dynamic Controls Page");
    }

    public void clickRemove() {
        btnRemove.click();
    }

    public void clickAdd() {
        btnAdd.click();
    }

    public boolean isCheckboxPresent() {
        return chkBox.state().isDisplayed();
    }

    public void clickCheckbox() {
        chkBox.click();
    }

    public void clickEnable() {
        btnEnable.click();
    }

    public void clickDisable() {
        btnDisable.click();
    }

    public boolean isTextInputEnabled() {
        return txtInput.state().isEnabled();
    }

    public void enterText(String text) {
        txtInput.clearAndType(text);
    }

    public String getText() {
        return txtInput.getText();
    }
}
