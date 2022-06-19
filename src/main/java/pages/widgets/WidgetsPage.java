package pages.widgets;

import lombok.Data;
import pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

@Data
public class WidgetsPage extends BasePage {

    public WidgetsPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickWidgetsCard() {
        WebElement widgetsCard = this.getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[4]"));
        widgetsCard.click();
    }

    public void clickAccordianSubCard() {
        try {
            Thread.sleep(1000);
            WebElement allCardsDiv = this.getDriver().findElement(By.className("accordion"));
            List<WebElement> allCards = allCardsDiv.findElements(By.className("element-group"));
            WebElement accordianTabButton = allCards.get(3).findElement(By.id("item-0"));
            accordianTabButton.click();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
