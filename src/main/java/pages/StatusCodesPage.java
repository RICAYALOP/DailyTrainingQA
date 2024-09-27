package pages;

import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.List;

public class StatusCodesPage extends Form {

    private final List<ILink> statusLinks = getElementFactory().findElements(By.xpath("//div[@id='content']//a"), ILink.class);

    public StatusCodesPage() {
        super(By.xpath("//h3[contains(text(),'Status Codes')]"), "Status Codes Page");
    }

    public List<ILink> getStatusLinks() {
        return statusLinks;
    }

    public boolean isPageLoaded() {
        return statusLinks.size() > 0;
    }
}