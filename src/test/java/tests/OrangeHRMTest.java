package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHRMTest extends BaseTest {
    private final By imageLogo = By.xpath("//img[@alt='company-branding']");
    private final By usernameField = By.xpath("//input[@name='username']");
    private final By passwordField = By.xpath("//input[@name='password']");
    private final By loginButton = By.xpath("//button");
    private final By pimMenu = By.xpath("//a[contains(@href,'PimModule')]");
    private final By addEmployeeButton = By.xpath("//button[.//i[contains(@class, 'bi-plus')]]");
    private final By firstNameField = By.id("firstName");
    private final By lastNameField = By.id("lastName");
    private final By saveButton = By.id("btnSave");
    private final By employeeSearchField = By.id("empsearch_employee_name_empName");
    private final By searchButton = By.id("searchBtn");
    private final By myInfoMenu = By.id("menu_pim_viewMyDetails");
    private final By editButton = By.id("btnSave");

    @Test
    public void testOrangeHRMFlow() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        Assert.assertTrue(driver.findElement(usernameField).isDisplayed(), "Login page not loaded correctly");
        driver.findElement(usernameField).sendKeys("Admin");
        driver.findElement(passwordField).sendKeys("admin123");
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
        wait.until(ExpectedConditions.urlContains("dashboard"));
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Failed to login and redirect to the dashboard");
        wait.until(ExpectedConditions.elementToBeClickable(pimMenu));
        driver.findElement(pimMenu).click();
        wait.until(ExpectedConditions.elementToBeClickable(addEmployeeButton));
        driver.findElement(addEmployeeButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        driver.findElement(firstNameField).sendKeys("John");
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField));
        driver.findElement(lastNameField).sendKeys("Doe");
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        driver.findElement(saveButton).click();
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'message success')]")));
        Assert.assertTrue(successMessage.isDisplayed(), "New employee was not added successfully");
        wait.until(ExpectedConditions.visibilityOfElementLocated(employeeSearchField));
        driver.findElement(employeeSearchField).sendKeys("John Doe");
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        driver.findElement(searchButton).click();
        WebElement searchResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='John Doe']")));
        Assert.assertTrue(searchResult.isDisplayed(), "Employee 'John Doe' not found in search results");
        wait.until(ExpectedConditions.elementToBeClickable(myInfoMenu));
        driver.findElement(myInfoMenu).click();
        wait.until(ExpectedConditions.elementToBeClickable(editButton));
        driver.findElement(editButton).click();
        WebElement nicknameField = driver.findElement(By.id("personal_txtEmpNickName"));
        nicknameField.clear();
        nicknameField.sendKeys("JD");
        driver.findElement(saveButton).click();
        WebElement updateMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'message success')]")));
        Assert.assertTrue(updateMessage.isDisplayed(), "Personal information not updated successfully");
    }
}
