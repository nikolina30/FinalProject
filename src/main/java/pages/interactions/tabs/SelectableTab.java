package pages.interactions.tabs;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.BasePage;

import java.util.List;

@Data
public class SelectableTab extends BasePage {

    public SelectableTab(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickAllElements() {
        WebElement listOfClickableElements = this.getDriver().findElement(By.id("verticalListContainer"));
        List<WebElement> clickableElements = listOfClickableElements.findElements(By.tagName("li"));
        for(int i = 0; i < clickableElements.size(); i++) {
            clickableElements.get(i).click();
        }
    }

    public void clickGridTab() {
        WebElement gridTab = this.getDriver().findElement(By.id("demo-tab-grid"));
        gridTab.click();
    }

    public void clickAllBoxesInAllRows() {
        WebElement row1 = this.getDriver().findElement(By.id("row1"));
        List<WebElement> row1Elements = row1.findElements(By.tagName("li"));
        WebElement row2 = this.getDriver().findElement(By.id("row2"));
        List<WebElement> row2Elements = row2.findElements(By.tagName("li"));
        WebElement row3 = this.getDriver().findElement(By.id("row3"));
        List<WebElement> row3Elements = row3.findElements(By.tagName("li"));
        for (int i = 0; i < row1Elements.size(); i++) {
            row1Elements.get(i).click();
            Assert.assertTrue(row1Elements.get(i).getAttribute("class").equals("list-group-item list-group-item-action"));
        }
        for (int i = 0; i < row2Elements.size(); i++) {
            row2Elements.get(i).click();
            Assert.assertTrue(row2Elements.get(i).getAttribute("class").equals("list-group-item list-group-item-action"));
        }
        for (int i = 0; i < row3Elements.size(); i++) {
            row3Elements.get(i).click();
            Assert.assertTrue(row3Elements.get(i).getAttribute("class").equals("list-group-item list-group-item-action"));
        }

    }
}
