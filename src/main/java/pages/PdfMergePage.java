package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class PdfMergePage extends Form {

    private final IButton btnSelectFiles = getElementFactory().getButton(By.xpath("//a[contains(@class, 'uploader__button')]"), "Select Files");
    private final By fileInput = By.xpath("//input[@type='file']");
    private final IButton btnMergePdf = getElementFactory().getButton(By.id("merge"), "Merge PDF");
    private final IButton btnDownload = getElementFactory().getButton(By.xpath("//a[contains(@class, 'download')]"), "Download PDF");
    private final By processingLabel = By.xpath("//span[contains(text(),'Procesando archivos')]");

    public PdfMergePage() {
        super(By.xpath("//h1[contains(text(), 'Unir PDF')]"), "PDF Merge Page");
    }
    
    public void clickSelectFiles() {
        btnSelectFiles.click();
    }

    public void uploadPdfFiles(String filePath1, String filePath2) {
        getElementFactory().getLink(fileInput, "File Input").sendKeys(filePath1 + "\n" + filePath2);
    }

    public void clickMergePdf() {
        btnMergePdf.click();
    }

    public boolean waitForProcessingToComplete() {
        return getElementFactory().getLabel(processingLabel, "Processing Label").state().waitForNotDisplayed();
    }

    public void clickDownload() {
        btnDownload.click();
    }
}
