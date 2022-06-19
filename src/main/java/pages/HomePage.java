package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
@Data
public class HomePage extends BasePage {
    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickHomeButton() {
        WebElement homePageButton = this.getDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/header/a/img")));
        homePageButton.click();
    }

    public void scrollToBottom() {
        JavascriptExecutor jsx = (JavascriptExecutor)this.getDriver();
        jsx.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
    }

    public void clickElementsCard() {
        try {
        WebElement elementsCard = this.getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]"));
        elementsCard.click();
        Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickFormsCard() {
        try {
            Thread.sleep(1000);
            WebElement formsCard = this.getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[2]"));
            formsCard.click();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickAlertsFrameWindowsCard() {
        try {
            Thread.sleep(1000);
            WebElement alertsFrameWindowsCard = this.getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[3]"));
            alertsFrameWindowsCard.click();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickWidgetsCard() {
        try {
            Thread.sleep(1000);
            WebElement widgetsCard = this.getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[4]"));
            widgetsCard.click();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickInteractions() {
        try {
            Thread.sleep(1000);
            WebElement interactionsCard = this.getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[5]"));
            interactionsCard.click();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickBookStoreAppCard() {
        try {
            Thread.sleep(1000);
            WebElement bookStoreAppCard = this.getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[6]"));
            bookStoreAppCard.click();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
