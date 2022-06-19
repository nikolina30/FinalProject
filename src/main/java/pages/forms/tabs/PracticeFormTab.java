package pages.forms.tabs;

import lombok.Data;
import org.testng.Assert;
import pages.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
public class PracticeFormTab extends BasePage {

    private WebElement firstnameField;
    private WebElement lastnameField;
    private WebElement userEmailField;
    private WebElement genderField;
    private WebElement mobileField;
    private WebElement dateOfBirthField;
    private WebElement subjectField;
    private WebElement hobbiesField;
    private WebElement addPictureButton;
    private WebElement currentAddressField;
    private WebElement stateSelect;
    private Select yearSelect;
    private Select monthSelect;
    private WebElement day;
    private  WebElement stateSelectInputField;
    private WebElement citySelect;
    private WebElement citySelectInputField;
    private WebElement submitButton;
    private WebElement formModalCloseButton;
    private JavascriptExecutor js = (JavascriptExecutor)this.getDriver();

    public PracticeFormTab(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void executeFormTest() {
        getAllFormFields();
        fillAllFields();
    }

    public void getAllFormFields() {
        this.firstnameField = this.getDriverWait().until(ExpectedConditions.elementToBeClickable(By.id("firstName")));
        this.lastnameField = this.getDriver().findElement(By.id("lastName"));
        this.userEmailField = this.getDriver().findElement(By.id("userEmail"));
        this.genderField = this.getDriver().findElement(By.id("gender-radio-2"));
        this.mobileField = this.getDriver().findElement(By.id("userNumber"));
        this.dateOfBirthField = this.getDriver().findElement(By.id("dateOfBirthInput"));
        this.subjectField = this.getDriver().findElement(By.id("subjectsInput"));
        this.hobbiesField = this.getDriver().findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[3]/label"));
        this.addPictureButton = this.getDriver().findElement(By.id("uploadPicture"));
        this.currentAddressField = this.getDriver().findElement(By.xpath("//*[@id=\"currentAddress\"]"));
        this.stateSelect = this.getDriver().findElement(By.id("state"));
        this.citySelect = this.getDriverWait().until(ExpectedConditions.elementToBeClickable(By.id("city")));
        this.submitButton = this.getDriver().findElement(By.id("submit"));
    }

    public void fillAllFields() {
        this.firstnameField.sendKeys("Lena");
        this.lastnameField.sendKeys("Green");
        this.userEmailField.sendKeys("lenagreen.@gmail.com");
        this.js.executeScript("arguments[0].click()", this.genderField);
        this.mobileField.sendKeys("0123456789");
        this.dateOfBirthField.click();
        this.yearSelect = new Select(this.getDriver().findElement(By.className("react-datepicker__year-select")));
        this.yearSelect.selectByVisibleText("1996");
        this.monthSelect = new Select(this.getDriver().findElement(By.className("react-datepicker__month-select")));
        this.monthSelect.selectByVisibleText("March");
        this.day = this.getDriver().findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[5]/div[7]"));
        this.day.click();
        this.subjectField.click();
        this.subjectField.sendKeys("e");
        this.subjectField.sendKeys(Keys.ENTER);
        this.hobbiesField.click();
        this.addPictureButton.sendKeys("C:\\Users\\Administrator\\IdeaProjects\\DamoqaAutomatedTesting\\src\\main\\java\\Assets\\Toolsqa.jpg");
        this.currentAddressField.sendKeys("483 Chardonnay Drive");
        this.js.executeScript("document.getElementById('app').style.height = '2000px'");
        this.js.executeScript("window.scrollBy(0,500)", "");
        this.stateSelect.click();
        this.stateSelectInputField = stateSelect.findElement(By.id("react-select-3-input"));
        this.stateSelectInputField.sendKeys("n");
        this.stateSelectInputField.sendKeys(Keys.ENTER);
        this.citySelect.click();
        this.citySelectInputField = citySelect.findElement(By.id("react-select-4-input"));
        this.citySelectInputField.sendKeys("d");
        this.citySelectInputField.sendKeys(Keys.ENTER);
        this.submitButton.click();
        this.formModalCloseButton = this.getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("closeLargeModal")));
        Assert.assertNotNull(this.formModalCloseButton);
        this.formModalCloseButton.click();
    }

    public void clickSubmitButtonWithoutFillingTheForm() {
        this.js.executeScript("document.getElementById('app').style.height = '2000px'");
        this.js.executeScript("window.scrollBy(0,500)", "");
        this.submitButton = this.getDriver().findElement(By.id("submit"));
        this.submitButton.click();
        WebElement form = this.getDriver().findElement(By.id("userForm"));
        Assert.assertTrue(form.getAttribute("class").equals("was-validated"));
    }
    public void fillFormOnlyWithRequiredFields() {
        this.js.executeScript("document.getElementById('app').style.height = '1000px'");
        this.js.executeScript("window.scrollTo(0, 0);");
        this.firstnameField.sendKeys("Susan");
        this.lastnameField.sendKeys("Lum");
        this.mobileField.sendKeys("0123456789");
        this.js.executeScript("arguments[0].click()", this.genderField);
        this.js.executeScript("arguments[0].scrollIntoView(true);", this.submitButton);
        this.submitButton.click();
        this.formModalCloseButton = this.getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("closeLargeModal")));
        Assert.assertNotNull(this.formModalCloseButton);
        this.formModalCloseButton.click();
    }

    public void fillFormOnlyWithRequiredFieldsIncorrectMobileFieldLessThenTenDigits() {
        this.js.executeScript("document.getElementById('app').style.height = '1000px'");
        this.js.executeScript("window.scrollTo(0, 0);");
        this.firstnameField.sendKeys("Lucy");
        this.lastnameField.sendKeys("Wood");
        this.mobileField.sendKeys("012345678");
        this.js.executeScript("arguments[0].click()", this.genderField);
        this.js.executeScript("arguments[0].scrollIntoView(true);", this.submitButton);
        this.submitButton.click();
        Assert.assertTrue(this.mobileField.getAttribute("value").length() != 10);
    }

    public void fillFormOnlyWithRequiredFieldsIncorrectMobileFieldMoreThenTenDigits() {
        this.js.executeScript("document.getElementById('app').style.height = '1000px'");
        this.js.executeScript("window.scrollTo(0, 0);");
        this.firstnameField.sendKeys("Alexia");
        this.lastnameField.sendKeys("King");
        this.mobileField.sendKeys("01234567890");
        this.js.executeScript("arguments[0].click()", this.genderField);
        this.js.executeScript("arguments[0].scrollIntoView(true);", this.submitButton);
        this.submitButton.click();
        Assert.assertTrue(this.mobileField.getAttribute("value").length() != 10);
    }



    public void fillEmailFieldIncorrectly() {
        this.js.executeScript("document.getElementById('app').style.height = '1000px'");
        this.js.executeScript("window.scrollTo(0, 0);");
        this.firstnameField.sendKeys("Nicol");
        this.lastnameField.sendKeys("Miller");
        this.userEmailField.sendKeys("asd");
        this.mobileField.sendKeys("0123456789");
        this.js.executeScript("arguments[0].click()", this.genderField);
        this.js.executeScript("arguments[0].scrollIntoView(true);", this.submitButton);
        Pattern p = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");
        Matcher m = p.matcher(this.userEmailField.getAttribute("value"));
        Assert.assertTrue(!m.matches());
    }

    public void firstNameLengthTest() {
        this.firstnameField = this.getDriverWait().until(ExpectedConditions.elementToBeClickable(By.id("firstName")));
        String text = "";
        for(int i = 0; i < 250; i++ ) {
            text += "a";
        }
        this.firstnameField.sendKeys(text);
    }

    public void lastNameLengthTest() {
        this.lastnameField = this.getDriver().findElement(By.id("lastName"));
        String text = "";
        for(int i = 0; i < 250; i++ ) {
            text += "a";
        }
        this.lastnameField.sendKeys(text);
    }

    public void fillFirstAndLastNameWithNumbers() {
        this.firstnameField = this.getDriverWait().until(ExpectedConditions.elementToBeClickable(By.id("firstName")));
        this.firstnameField.sendKeys("12345");
        this.lastnameField = this.getDriver().findElement(By.id("lastName"));
        this.lastnameField.sendKeys("12345");
    }

    public void fillFirstAndLastNameWithUpperCase() {
        this.firstnameField = this.getDriverWait().until(ExpectedConditions.elementToBeClickable(By.id("firstName")));
        this.firstnameField.sendKeys("ABCD");
        this.lastnameField = this.getDriver().findElement(By.id("lastName"));
        this.lastnameField.sendKeys("ABCD");
    }

    public void fillFirstAndLastNameWithSpecialCharacters() {
        this.firstnameField = this.getDriverWait().until(ExpectedConditions.elementToBeClickable(By.id("firstName")));
        this.firstnameField.sendKeys("!@#$%^&*");
        this.lastnameField = this.getDriver().findElement(By.id("lastName"));
        this.lastnameField.sendKeys("!@#$%^&*");
    }

    public void fillFirstAndLastNameWithSpacesBeforeaAndInBetweenAndAfterCharacters() {
        this.firstnameField = this.getDriverWait().until(ExpectedConditions.elementToBeClickable(By.id("firstName")));
        this.firstnameField.sendKeys("  Nik ol li na  ");
        this.lastnameField = this.getDriver().findElement(By.id("lastName"));
        this.lastnameField.sendKeys("  Mi lo se vic  ");
    }
}
