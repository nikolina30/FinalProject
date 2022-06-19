package tests;

import lombok.Data;
import pages.alertsFrameWindows.AlertsFrameWindowsPage;
import pages.alertsFrameWindows.tabs.BrowserWindowsTab;
import pages.bookStoreApplication.BookStoreApplicationPage;
import pages.bookStoreApplication.tabs.LoginTab;
import pages.elements.ElementsPage;
import pages.elements.tabs.TextBoxTab;
import pages.forms.FormsPage;
import pages.forms.tabs.PracticeFormTab;
import pages.HomePage;
import pages.interactions.InteractionsPage;
import pages.interactions.tabs.SelectableTab;
import pages.widgets.tabs.AccordianTab;
import pages.widgets.WidgetsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

@Data
public class BaseTest {

    private WebDriver driver;
    private WebDriverWait driverWait;
    String parentWindowHandle;
    private HomePage homePage;
    private ElementsPage elementsPage;
    private TextBoxTab textBoxTab;
    private FormsPage formsPage;
    private PracticeFormTab practiceFormTab;
    private AlertsFrameWindowsPage alertsFrameWindowsPage;
    private BrowserWindowsTab browserWindowsTab;
    private WidgetsPage widgetsPage;
    private AccordianTab accordianTab;
    private InteractionsPage interactionsPage;
    private SelectableTab selectableTab;
    private BookStoreApplicationPage bookStoreApplicationPage;
    private LoginTab loginTab;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
        driver = new ChromeDriver();

        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.navigate().to("https://demoqa.com/");
        driver.manage().window().maximize();

        this.parentWindowHandle = driver.getWindowHandle();

        this.homePage = new HomePage(this.driver, this.driverWait);

        this.elementsPage = new ElementsPage(this.driver, this.driverWait);
        this.textBoxTab = new TextBoxTab(this.driver, this.driverWait);

        this.formsPage = new FormsPage(this.driver, this.driverWait);
        this.practiceFormTab = new PracticeFormTab(this.driver, this.driverWait);

        this.alertsFrameWindowsPage = new AlertsFrameWindowsPage(this.driver, this.driverWait);
        this.browserWindowsTab = new BrowserWindowsTab(this.driver, this.driverWait);

        this.widgetsPage = new WidgetsPage(this.driver, this.driverWait);
        this.accordianTab = new AccordianTab(this.driver, this.driverWait);

        this.interactionsPage = new InteractionsPage(this.driver, this.driverWait);
        this.selectableTab = new SelectableTab(this.driver, this.driverWait);

        this.bookStoreApplicationPage = new BookStoreApplicationPage(this.driver, this.driverWait);
        this.loginTab = new LoginTab(this.driver, this.driverWait);
    }

    @AfterClass
    public void afterClass() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.close();
    }
}

