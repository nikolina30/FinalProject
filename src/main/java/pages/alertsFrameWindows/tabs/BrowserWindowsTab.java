package pages.alertsFrameWindows.tabs;

import lombok.Data;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

@Data
public class BrowserWindowsTab extends BasePage {

    private WebElement newTabHeader;
    private WebElement newWindowHeader;
    private WebElement newWindowMessageHeader;

    public BrowserWindowsTab(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void switchToWindow() {
        String currentHandle = this.getDriver().getWindowHandle();
        Set<String> windowHandles = this.getDriver().getWindowHandles();
        for(String actual : windowHandles )
        {
            if (!actual.equalsIgnoreCase(currentHandle)) {
                System.out.println(this.getDriver().getWindowHandle());
                this.getDriver().switchTo().window(actual);
                break;
            }
        }
    }

    public void clickNewTabButton() {
        WebElement newTabButton = this.getDriver().findElement(By.id("tabButton"));
        newTabButton.click();
        switchToWindow();
        this.newTabHeader = this.getDriver().findElement(By.id("sampleHeading"));
    }

    public void clickNewWindowButton() {
        WebElement newWindowButton = this.getDriver().findElement(By.id("windowButton"));
        newWindowButton.click();
        switchToWindow();
        this.newWindowHeader = this.getDriver().findElement(By.id("sampleHeading"));
    }

    public void clickNewWindowMessageButton() {
        WebElement newWindowMessageButton = this.getDriver().findElement(By.id("messageWindowButton"));
        newWindowMessageButton.click();
        this.getDriverWait().until(ExpectedConditions.numberOfWindowsToBe(2));
        switchToWindow();
        //this.newWindowMessageHeader = this.getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/text()")));
    }

    public void closeWindow() {
        this.getDriver().close();
    }
}
