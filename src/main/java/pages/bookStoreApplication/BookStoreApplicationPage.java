package pages.bookStoreApplication;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import java.util.List;

@Data
public class BookStoreApplicationPage extends BasePage {

    public BookStoreApplicationPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickLoginSubCard() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        JavascriptExecutor js = (JavascriptExecutor)this.getDriver();
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");

        WebElement allCardsDiv = this.getDriver().findElement(By.className("accordion"));
        List<WebElement> allCards = allCardsDiv.findElements(By.className("element-group"));
        WebElement loginCardButton = allCards.get(5).findElement(By.id("item-0"));
        loginCardButton.click();
    }

    public void clickBookStoreAppCard() {
        try {
            Thread.sleep(1000);
            JavascriptExecutor js = (JavascriptExecutor)this.getDriver();
            js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
            WebElement bookStoreAppCard = this.getDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[6]")));
            bookStoreAppCard.click();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void scrollToBottom() {
        JavascriptExecutor jsx = (JavascriptExecutor)this.getDriver();
        jsx.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
    }
}
