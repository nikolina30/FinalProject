package pages.elements.tabs;

import lombok.Data;
import org.openqa.selenium.JavascriptExecutor;
import pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

@Data
public class TextBoxTab extends BasePage {
    private String emailFieldErrorCss = "mr-sm-2 field-error form-control";
    private String emailFieldCorrectCss = "mr-sm-2 form-control";
    private String usernameFieldInput;
    private WebElement emailField;
    private String emailFieldInput;
    private String currentAddressFieldInput;
    private String permanentAddressFieldInput;
    private String usernameResult;
    private String emailResult;
    private String currentAddressResult;
    private String permanentAddressResult;
    private JavascriptExecutor js = (JavascriptExecutor)this.getDriver();

    public TextBoxTab(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void textBoxSubCardClickSubmitButton() {
        this.js.executeScript("document.getElementById('app').style.height = '2000px'");
        this.js.executeScript("window.scrollBy(0,500)", "");
        WebElement submitButton = this.getDriver().findElement(By.id("submit"));
        submitButton.click();
    }

    public void fillTextBoxCardEmailFieldIncorrectly() {
        this.emailField.sendKeys("asd");
    }

    public void fillTextBoxCardEmailFieldCorrectly() {
        this.emailField.clear();
        this.emailField.sendKeys("joanna.smith30@gmail.com");
    }

    public void fillTextBoxSubCardForm() {
        WebElement usernameInputField = this.getDriver().findElement(By.id("userName"));
        this.usernameFieldInput = usernameInputField.getText();
        this.emailField = this.getDriver().findElement(By.id("userEmail"));
        this.emailFieldInput = emailField.getText();
        WebElement currentAddressField = this.getDriver().findElement(By.id("currentAddress"));
        this.currentAddressFieldInput = currentAddressField.getText();
        WebElement permanentAddressField = this.getDriver().findElement(By.id("permanentAddress"));
        this.permanentAddressFieldInput = permanentAddressField.getText();
        usernameInputField.sendKeys("Joanna Smith");
        currentAddressField.sendKeys("2076 Gregoey Lane");
        permanentAddressField.sendKeys("2076 Gregoey Lane");
    }

    public void getTextBoxSubCardResult() {
        List<WebElement> resultParagraphElements = this.getDriver().findElements(By.tagName("p"));
        this.usernameResult = resultParagraphElements.get(0).getText();
        this.emailResult = resultParagraphElements.get(1).getText();
        this.currentAddressResult = resultParagraphElements.get(2).getText();
        this.permanentAddressResult = resultParagraphElements.get(3).getText();
    }
}
