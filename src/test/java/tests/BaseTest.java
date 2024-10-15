package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    protected static String URL = "https://opensource-demo.orangehrmlive.com/?form=MG0AV3";
    protected static int MAX_WAIT = 10;
    protected static String RELATIVE_RESOURCE_PATH = "src/test/resources/";
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void startUp() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", new File(System.getProperty("user.dir"), RELATIVE_RESOURCE_PATH).getAbsolutePath());
        prefs.put("download.prompt_for_download", false);
        prefs.put("safebrowsing.enabled", true);
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_WAIT));
        driver.get(URL);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
