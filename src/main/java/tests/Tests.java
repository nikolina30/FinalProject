package tests;

import lombok.Data;
import org.testng.Assert;
import org.testng.annotations.Test;

@Data
public class Tests extends BaseTest {

    @Test (priority = 1)
    public void openAllElementCards() {
        this.getHomePage().clickElementsCard();
        this.getHomePage().clickHomeButton();
        this.getHomePage().clickFormsCard();
        this.getHomePage().clickHomeButton();
        this.getHomePage().clickAlertsFrameWindowsCard();
        this.getHomePage().clickHomeButton();
        this.getHomePage().clickWidgetsCard();
        this.getHomePage().clickHomeButton();
        this.getHomePage().clickInteractions();
        this.getHomePage().clickHomeButton();
        this.getHomePage().scrollToBottom();
        this.getHomePage().clickBookStoreAppCard();
        this.getHomePage().clickHomeButton();
    }

    @Test (priority = 2)
    public void testTextBoxSubCardFillAllFields() {
        this.getElementsPage().clickElementsCard();
        this.getElementsPage().clickTextBoxSubCard();
        this.getTextBoxTab().fillTextBoxSubCardForm();
        this.getTextBoxTab().fillTextBoxCardEmailFieldCorrectly();
        this.getTextBoxTab().textBoxSubCardClickSubmitButton();
        Assert.assertEquals(this.getTextBoxTab().getEmailFieldCorrectCss(), this.getTextBoxTab().getEmailField().getAttribute("class"));
        this.getTextBoxTab().getTextBoxSubCardResult();
        Assert.assertNotEquals(this.getTextBoxTab().getUsernameResult(), "");
        Assert.assertNotEquals(this.getTextBoxTab().getEmailResult(), "");
        Assert.assertNotEquals(this.getTextBoxTab().getCurrentAddressResult(), "");
        Assert.assertNotEquals(this.getTextBoxTab().getPermanentAddressResult(), "");
        this.getHomePage().clickHomeButton();
    }

    @Test (priority = 3)
    public void testTextBoxSubCardAllFieldsWithIncorrectEmail() {
        this.getElementsPage().clickElementsCard();
        this.getElementsPage().clickTextBoxSubCard();
        this.getTextBoxTab().fillTextBoxSubCardForm();
        this.getTextBoxTab().fillTextBoxCardEmailFieldIncorrectly();
        this.getTextBoxTab().textBoxSubCardClickSubmitButton();
        Assert.assertEquals(this.getTextBoxTab().getEmailFieldErrorCss(), this.getTextBoxTab().getEmailField().getAttribute("class"));
        Assert.assertNotEquals(this.getTextBoxTab().getUsernameResult(), "");
        Assert.assertNotEquals(this.getTextBoxTab().getEmailResult(), "");
        Assert.assertNotEquals(this.getTextBoxTab().getCurrentAddressResult(), "");
        Assert.assertNotEquals(this.getTextBoxTab().getPermanentAddressResult(), "");
        this.getHomePage().clickHomeButton();
    }

    @Test (priority = 4)
    public void testEntireForm() {
        this.getFormsPage().clickFormsCard();
        this.getFormsPage().clickPracticeFormSubCard();
        this.getPracticeFormTab().executeFormTest();
        this.getHomePage().clickHomeButton();
    }

    @Test (priority = 5)
    public void executeSubmitEmptyForm() {
        this.getFormsPage().clickFormsCard();
        this.getFormsPage().clickPracticeFormSubCard();
        this.getPracticeFormTab().clickSubmitButtonWithoutFillingTheForm();
        this.getHomePage().clickHomeButton();
    }

    @Test (priority = 6)
    public void fillFormOnlyWithRequiredFields() {
        this.getFormsPage().clickFormsCard();
        this.getFormsPage().clickPracticeFormSubCard();
        this.getPracticeFormTab().getAllFormFields();
        this.getPracticeFormTab().fillFormOnlyWithRequiredFields();
        this.getPracticeFormTab().clickSubmitButtonWithoutFillingTheForm();
        //this.getHomePage().clickHomeButton();
    }

    @Test (priority = 7)
    public void firstAndLastNameFieldLengthTest() {
        this.getFormsPage().clickFormsCard();
        this.getFormsPage().clickPracticeFormSubCard();
        this.getPracticeFormTab().firstNameLengthTest();
        this.getPracticeFormTab().lastNameLengthTest();
        this.getPracticeFormTab().clickSubmitButtonWithoutFillingTheForm();
        Assert.assertTrue(!this.getPracticeFormTab().getFirstnameField().getAttribute("value").isEmpty());
        Assert.assertTrue(!this.getPracticeFormTab().getLastnameField().getAttribute("value").isEmpty());
        this.getHomePage().clickHomeButton();
    }

    @Test (priority = 8)
    public void fillFirstAndLastNameWithNumbersTest() {
        this.getFormsPage().clickFormsCard();
        this.getFormsPage().clickPracticeFormSubCard();
        this.getPracticeFormTab().fillFirstAndLastNameWithNumbers();
        this.getPracticeFormTab().clickSubmitButtonWithoutFillingTheForm();
        Assert.assertTrue(!this.getPracticeFormTab().getFirstnameField().getAttribute("value").isEmpty());
        Assert.assertTrue(!this.getPracticeFormTab().getLastnameField().getAttribute("value").isEmpty());
        this.getHomePage().clickHomeButton();
    }

    @Test (priority = 9)
    public void fillFirstAndLastNameWithUpperCaseTest() {
        this.getFormsPage().clickFormsCard();
        this.getFormsPage().clickPracticeFormSubCard();
        this.getPracticeFormTab().fillFirstAndLastNameWithUpperCase();
        this.getPracticeFormTab().clickSubmitButtonWithoutFillingTheForm();
        Assert.assertTrue(!this.getPracticeFormTab().getFirstnameField().getAttribute("value").isEmpty());
        Assert.assertTrue(!this.getPracticeFormTab().getLastnameField().getAttribute("value").isEmpty());
        this.getHomePage().clickHomeButton();
    }

    @Test (priority = 10)
    public void fillFirstAndLastNameWithSpecialCharactersTest() {
        this.getFormsPage().clickFormsCard();
        this.getFormsPage().clickPracticeFormSubCard();
        this.getPracticeFormTab().fillFirstAndLastNameWithSpecialCharacters();
        this.getPracticeFormTab().clickSubmitButtonWithoutFillingTheForm();
        Assert.assertTrue(!this.getPracticeFormTab().getFirstnameField().getAttribute("value").isEmpty());
        Assert.assertTrue(!this.getPracticeFormTab().getLastnameField().getAttribute("value").isEmpty());
        this.getHomePage().clickHomeButton();
    }

    @Test (priority = 11)
    public void fillFirstAndLastNameWithSpacesBeforeaAndInBetweenAndAfterCharactersTest() {
        this.getFormsPage().clickFormsCard();
        this.getFormsPage().clickPracticeFormSubCard();
        this.getPracticeFormTab().fillFirstAndLastNameWithSpacesBeforeaAndInBetweenAndAfterCharacters();
        this.getPracticeFormTab().clickSubmitButtonWithoutFillingTheForm();
        Assert.assertTrue(!this.getPracticeFormTab().getFirstnameField().getAttribute("value").isEmpty());
        Assert.assertTrue(!this.getPracticeFormTab().getLastnameField().getAttribute("value").isEmpty());
        this.getHomePage().clickHomeButton();
    }

    @Test (priority = 12)
    public void fillFormOnlyWithRequiredFieldsIncorrectEmailField() {
        this.getFormsPage().clickFormsCard();
        this.getFormsPage().clickPracticeFormSubCard();
        this.getPracticeFormTab().getAllFormFields();
        this.getPracticeFormTab().fillEmailFieldIncorrectly();
        this.getPracticeFormTab().clickSubmitButtonWithoutFillingTheForm();
        this.getHomePage().clickHomeButton();
    }

    @Test (priority = 13)
    public void fillFormOnlyWithRequiredFieldsIncorrectMobileFieldLessThenTenDigitsTest() {
        this.getFormsPage().clickFormsCard();
        this.getFormsPage().clickPracticeFormSubCard();
        this.getPracticeFormTab().getAllFormFields();
        this.getPracticeFormTab().fillFormOnlyWithRequiredFieldsIncorrectMobileFieldLessThenTenDigits();
        this.getHomePage().clickHomeButton();
    }

    @Test (priority = 14)
    public void fillFormOnlyWithRequiredFieldsIncorrectMobileFieldMoreThenTenDigitsTest() {
        this.getFormsPage().clickFormsCard();
        this.getFormsPage().clickPracticeFormSubCard();
        this.getPracticeFormTab().getAllFormFields();
        this.getPracticeFormTab().fillFormOnlyWithRequiredFieldsIncorrectMobileFieldMoreThenTenDigits();
        this.getHomePage().clickHomeButton();
    }

    @Test (priority = 15)
    public void openTabsAndWindowsInAFWPage() {
        this.getAlertsFrameWindowsPage().clickAlertsFrameWindowsCard();
        this.getAlertsFrameWindowsPage().clickBrowserWindowsSubCard();
        this.getBrowserWindowsTab().clickNewTabButton();
        Assert.assertTrue(!this.getBrowserWindowsTab().getNewTabHeader().getText().isEmpty());
        this.getBrowserWindowsTab().closeWindow();

        this.getDriver().switchTo().window(this.getParentWindowHandle());
        this.getBrowserWindowsTab().clickNewWindowButton();
        Assert.assertTrue(!this.getBrowserWindowsTab().getNewWindowHeader().getText().isEmpty());
        this.getBrowserWindowsTab().closeWindow();
        this.getDriver().switchTo().window(this.getParentWindowHandle());

        // Ovo parce koda ne moze da se izvrsi zato sto poslednji prozor nema title i ne
        // moze da se manipulise sa njim
        //this.getBrowserWindowsTab().clickNewWindowMessageButton();
        //this.getBrowserWindowsTab().closeWindow();
        //this.getDriver().switchTo().window(this.getParentWindowHandle());

        this.getHomePage().clickHomeButton();
    }

    @Test (priority = 16)
    public void checkTextAreasAreNotEmpty() {
        this.getWidgetsPage().clickWidgetsCard();
        this.getWidgetsPage().clickAccordianSubCard();
        this.getAccordianTab().clickWhatIsLoremIpsumField();
        Assert.assertTrue(!this.getAccordianTab().getWhatIsLoremIpsum().getText().isEmpty());
        this.getAccordianTab().clickWhereDoesItComeFromField();
        Assert.assertTrue(!this.getAccordianTab().getWhereDoesItComeFrom().getText().isEmpty());
        this.getAccordianTab().clickWhyDoWeUseItField();
        Assert.assertTrue(!this.getAccordianTab().getWhyDoWeUseIt().getText().isEmpty());
        this.getHomePage().clickHomeButton();
    }

    @Test (priority = 17)
    public void openInteractionsPage() {
        this.getInteractionsPage().clickInteractionsCard();
        this.getInteractionsPage().clickSortableSubCard();
        this.getSelectableTab().clickAllElements();
        this.getSelectableTab().clickGridTab();
        this.getSelectableTab().clickAllBoxesInAllRows();
        this.getHomePage().clickHomeButton();
    }

    @Test (priority = 18)
    public void openBookStoreAppPage() {
        this.getBookStoreApplicationPage().scrollToBottom();
        this.getBookStoreApplicationPage().clickBookStoreAppCard();
        this.getBookStoreApplicationPage().clickLoginSubCard();
        this.getLoginTab().clickNewUserButton();
        this.getLoginTab().fillRegisterForm();
    }

}
