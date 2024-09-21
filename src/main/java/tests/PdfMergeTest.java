package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PdfMergePage;

import java.nio.file.Paths;

public class PdfMergeTest extends BaseTest {
    private final PdfMergePage pdfMergePage = new PdfMergePage();
    private final String filePath1 = Paths.get("src", "test", "resources", "pdf1.pdf").toAbsolutePath().toString();
    private final String filePath2 = Paths.get("src", "test", "resources", "pdf2.pdf").toAbsolutePath().toString();

    @Test
    public void shouldMergePdfFilesSuccessfully() {
        pdfMergePage.clickSelectFiles();
        pdfMergePage.uploadPdfFiles(filePath1, filePath2);
        pdfMergePage.clickMergePdf();
        Assert.assertTrue(pdfMergePage.waitForProcessingToComplete(), "The PDF merge process should be completed.");
        pdfMergePage.clickDownload();
    }
}
