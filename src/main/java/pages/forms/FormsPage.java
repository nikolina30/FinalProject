package pages.forms;
import lombok.Data;
import pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
@Data
public class FormsPage extends BasePage {
    public FormsPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickFormsCard() {
        WebElement formsCard = this.getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[2]"));
        formsCard.click();
    }

    public void clickPracticeFormSubCard() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement allCardsDiv = this.getDriver().findElement(By.className("accordion"));
        List<WebElement> allCards = allCardsDiv.findElements(By.className("element-group"));
        WebElement practiceFormCardButton = allCards.get(1).findElement(By.id("item-0"));
        practiceFormCardButton.click();
    }
}
