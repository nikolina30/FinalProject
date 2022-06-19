package pages.interactions;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.util.List;

@Data
public class InteractionsPage extends BasePage {

    public InteractionsPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickInteractionsCard() {
        JavascriptExecutor js = (JavascriptExecutor)this.getDriver();
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
        WebElement interactionsCard = this.getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[5]"));
        interactionsCard.click();
    }

    public void clickSortableSubCard() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement allCardsDiv = this.getDriver().findElement(By.className("accordion"));
        List<WebElement> allCards = allCardsDiv.findElements(By.className("element-group"));
        WebElement selectableTabButton = allCards.get(4).findElement(By.id("item-1"));
        selectableTabButton.click();
    }
}
