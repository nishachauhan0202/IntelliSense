package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[normalize-space()='Test Project']")
    private WebElement dashboardTitle;

    public String getDashboardTitle(){
        return dashboardTitle.getText();
    }

    @FindBy(xpath = "//button[contains(@title, 'DATE')]")
    private WebElement dateTimeButton;

    public void clickDateTimeButton(){
        dateTimeButton.click();
    }

    @FindBy(xpath = "//span[normalize-space()='Singular']")
    private WebElement singularTab;

    public void goToSingularTab(){
        singularTab.click();
    }

    @FindBy(xpath = "//span[normalize-space()='Interval']")
    private WebElement intervalTab;

    public void goToIntervalTab(){
        intervalTab.click();
    }

    @FindBy(xpath = "//span[normalize-space()='Constant']")
    private WebElement constantTab;

    public void goToConstantTab(){
        constantTab.click();
    }

    @FindBy(xpath = "//th[normalize-space()='Metric Name']")
    private WebElement columnMetricName;

    public String columnHeadingMetricName(){
        return  columnMetricName.getText();
    }

    @FindBy(xpath = "//th[normalize-space()='Unit']")
    private WebElement columnUnit;

    public String columnHeadingUnit(){
        return columnUnit.getText();
    }

    @FindBy(xpath = "//th[normalize-space()='Unit']")
    private WebElement columnDate;

    public String columnHeadingDate(){
        return columnDate.getText();
    }

    @FindBy(xpath = "//th[@class='MuiTableCell-root MuiTableCell-head MuiTableCell-stickyHeader'][normalize-space()='Value']")
    private WebElement columnValue;

    public String columnHeadingValue(){
        return columnValue.getText();
    }

    @FindBy(xpath = "//th[normalize-space()='Add']")
    private WebElement columnAdd;

    public String columnHeadingAdd(){
        return columnAdd.getText();
    }

    @FindBy(xpath = "//th[normalize-space()='Edit']")
    private WebElement columnEdit;

    public String columnHeadingEdit(){
        return columnEdit.getText();
    }

    @FindBy(xpath = "//td[normalize-space()='Material Model - COST_(INSTRUMENTATION)']")
    private WebElement metricInstrumentation;

    public String getMetricNameInstrumentation(){
        return metricInstrumentation.getText();
    }

    @FindBy(xpath = "//td[contains(.,'COST_(INSTRUMENTATION)')]/following-sibling::td[3]")
    private WebElement valueOfInstrumentation;

    public String getValueOfInstrumentation(){
        return valueOfInstrumentation.getText();
    }

    @FindBy(xpath = "//td[contains(.,'COST_(INSTRUMENTATION)')]/following-sibling::td[4]/child::div")
    private WebElement addInstrumentationValue;

    public void clickAddInstrumentationValue(){
        addInstrumentationValue.click();
    }

    @FindBy(xpath = "//td[contains(.,'COST_(INSTRUMENTATION)')]/following-sibling::td[5]/child::div")
    private WebElement editInstrumentationValueButton;

    public void clickEditInstrumentationValueButton(){
        editInstrumentationValueButton.click();
    }

    @FindBy(xpath = "//td[normalize-space()='Material Model - LITHOLOGY_(ATACAMITE)']")
    private WebElement metricAtacamite;

    public String getMetricNameAtacamite(){
        return metricAtacamite.getText();
    }

    @FindBy(xpath = "//td[normalize-space()='Material Model - LITHOLOGY_(ATACAMITE)']/following-sibling::td[4]/child::div")
    private WebElement addAtacamiteValue;

    public void clickAddAtacamiteValue(){
        addAtacamiteValue.click();
    }

    @FindBy(xpath = "//td[normalize-space()='Material Model - LITHOLOGY_(ATACAMITE)']/following-sibling::td[3]")
    private WebElement costOfAtacamite;

    public String getCostOfAtacamite(){
        return costOfAtacamite.getText();
    }

    @FindBy(xpath = "//td[normalize-space()='Material Model - FEED_MESH']")
    private WebElement metricMesh;

    public String getMetricNameMesh(){
        return metricMesh.getText();
    }

    @FindBy(xpath = "//td[normalize-space()='Material Model - FEED_MESH']/following-sibling::td[3]")
    private WebElement costOfMesh;

    public String getCostOfMesh(){
        return costOfMesh.getText();
    }

    @FindBy(xpath = "//td[normalize-space()='Material Model - FEED_MESH']/following-sibling::td[4]/child::div")
    private WebElement addMeshValue;

    public void clickAddMeshValue(){
        addMeshValue.click();
    }

    @FindBy(xpath = "//ng-include[@ng-if='!dashboard.minimal']//li[@title='Set as Homepage']")
    private WebElement setHomepageButton;

    public void setDefaultHomepage(){
        setHomepageButton.click();
    }

    @FindBy(xpath = "//button[normalize-space()='OK']")
    private WebElement okButtonDefaultDashboard;

    public void clickOkForDefaultDashboard(){
        okButtonDefaultDashboard.click();
    }

    @FindBy(xpath = "//div[@class='alertify-logs bottom right']//div[@class='success show']")
    private WebElement successAlert;

    public boolean successAlertDisplayed(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(successAlert));
        return successAlert.isDisplayed();
    }

    @FindBy(xpath = "//input[@id='value']")
    private WebElement inputMetricValue;

    public void enterMetricValue(int value){
        inputMetricValue.sendKeys(String.valueOf(value));
    }

    @FindBy(xpath = "//span[normalize-space()='Submit']")
    private WebElement submitNewValue;

    public void clickSubmitNewValue(){
        submitNewValue.click();
    }

    @FindBy(xpath = "//div[contains(@class, 'MuiAlert-message')]")
    private WebElement alertMessage;

    public String alertMessageDisplayed(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(alertMessage));
        return alertMessage.getText();
    }

    @FindBy(xpath = "//tbody//tr[1]//*[local-name()='svg'][contains(@class, 'delete-icon')]")
    private WebElement deleteValue;

    public void clickDeleteLastValue(){
        actions = new Actions(driver);
        actions.moveToElement(deleteValue).click().build().perform();
    }

    @FindBy(xpath = "//span[normalize-space()='Confirm']")
    private WebElement confirmDelete;
    @FindBy(xpath = "//p[@id='alert-dialog-description']")
    private WebElement confirmDeleteAlertMessage;

    public String verifyDeleteBox(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(confirmDeleteAlertMessage));
        return confirmDeleteAlertMessage.getText();
    }

    public void clickToConfirmDeleteValue(){
        confirmDelete.click();
    }

    @FindBy(xpath = "//p[last()]")
    private WebElement countOfValue;

    public String getCountOfValue() {
        String count = countOfValue.getText();
        String[] split = count.split("of");
        return split[1];
    }

    @FindBy(xpath = "//button[@aria-label='close']//span[@class='MuiIconButton-label']")
    private WebElement closeEditBox;

    public void clickCloseEditBox(){
        closeEditBox.click();
    }

    @FindBy(xpath = "//div[@class='error show']")
    private WebElement dashboardNameMandateError;

    public boolean dashboardNameMandateErrorDisplayed(){
        return dashboardNameMandateError.isDisplayed();
    }

    @FindBy(xpath = "(//li[@title='Duplicate Dashboard'])[1]")
    private WebElement createDuplicateDashboard;

    public void clickCreateDuplicateDashboard(){
        createDuplicateDashboard.click();
    }

    @FindBy(xpath = "//button[normalize-space()='OK']")
    private WebElement okButtonDuplicateDashboard;

    public void clickOkForDuplicateDashboard(){
        okButtonDuplicateDashboard.click();
    }
}
