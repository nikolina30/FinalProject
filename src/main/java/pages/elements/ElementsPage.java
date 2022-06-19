package pages.elements;

import lombok.Data;
import pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

@Data
public class ElementsPage extends BasePage {

    public ElementsPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickElementsCard() {
        WebElement elementsCard = this.getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]"));
        elementsCard.click();
    }

    public void clickTextBoxSubCard() {
        WebElement textBoxSubCard = this.getDriver().findElement(By.id("item-0"));
        textBoxSubCard.click();
    }
}
