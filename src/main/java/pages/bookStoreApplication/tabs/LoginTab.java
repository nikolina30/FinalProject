package pages.bookStoreApplication.tabs;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.BasePage;

@Data
public class LoginTab extends BasePage {

    private WebElement verifyModal;
    private WebElement registerButton;
    private WebElement robotCheckBox;

    public LoginTab(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickNewUserButton() {
        WebElement newUserButton = this.getDriver().findElement(By.id("newUser"));
        newUserButton.click();
    }

    public void fillRegisterForm() {
        try {
            WebElement firstNameField = this.getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("firstname")));
            WebElement lastNameField = this.getDriver().findElement(By.id("lastname"));
            WebElement userNameField = this.getDriver().findElement(By.id("userName"));
            WebElement passwordField = this.getDriver().findElement(By.id("password"));
            this.getDriver().switchTo().defaultContent();
            this.registerButton = this.getDriver().findElement(By.id("register"));

            if (firstNameField.getText().isEmpty()) {
                firstNameField.sendKeys("Paul");
                lastNameField.sendKeys("Carter");
                userNameField.sendKeys("paul30");
                passwordField.sendKeys("Password0!");
            }

            Thread.sleep(1500);

            WebElement checkboxIFrame = this.getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("iFrame[title='reCAPTCHA']")));
            this.getDriver().switchTo().frame(checkboxIFrame);
            this.robotCheckBox = this.getDriver().findElement(By.className("recaptcha-checkbox-border"));
            this.robotCheckBox.click();
            this.getDriver().switchTo().defaultContent();
            WebElement verifyModalIFrame = this.getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("iframe[title='recaptcha challenge expires in two minutes']")));
            this.getDriver().switchTo().frame(verifyModalIFrame);
            this.verifyModal = this.getDriver().findElement(By.id("rc-imageselect"));
            Assert.assertNotNull(this.verifyModal);
            this.getDriver().switchTo().defaultContent();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
