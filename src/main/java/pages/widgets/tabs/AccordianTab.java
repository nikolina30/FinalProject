package pages.widgets.tabs;

import lombok.Data;
import pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

@Data
public class AccordianTab extends BasePage {

    private WebElement whatIsLoremIpsum;
    private WebElement whereDoesItComeFrom;
    private WebElement whyDoWeUseIt;

    public AccordianTab(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickWhatIsLoremIpsumField() {
        this.whatIsLoremIpsum = this.getDriver().findElement(By.id("section1Heading"));
        whatIsLoremIpsum.click();
        whatIsLoremIpsum.click();
    }

    public void clickWhereDoesItComeFromField() {
        this.whereDoesItComeFrom = this.getDriver().findElement(By.id("section2Heading"));
        whereDoesItComeFrom.click();
    }

    public void clickWhyDoWeUseItField() {
        this.whyDoWeUseIt = this.getDriver().findElement(By.id("section3Heading"));
        whyDoWeUseIt.click();
    }
}
