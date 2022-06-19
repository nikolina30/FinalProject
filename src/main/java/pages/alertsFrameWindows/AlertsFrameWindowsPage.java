package pages.alertsFrameWindows;

import lombok.Data;
import pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

@Data
public class AlertsFrameWindowsPage extends BasePage {

    public AlertsFrameWindowsPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickAlertsFrameWindowsCard() {
        WebElement alertsFrameWindowsCard = this.getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[3]"));
        alertsFrameWindowsCard.click();
    }

    public void clickBrowserWindowsSubCard() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement allCardsDiv = this.getDriver().findElement(By.className("accordion"));
        List<WebElement> allCards = allCardsDiv.findElements(By.className("element-group"));
        WebElement browserTabButton = allCards.get(2).findElement(By.id("item-0"));
        browserTabButton.click();
    }
}
