package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    WebDriver driver;

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
    private WebElement costOfInstrumentation;

    public String getCosOfInstrumentation(){
        return costOfInstrumentation.getText();
    }

    @FindBy(xpath = "//td[normalize-space()='Material Model - LITHOLOGY_(ATACAMITE)']")
    private WebElement metricAtacamite;

    public String getMetricNameAtacamite(){
        return metricAtacamite.getText();
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
}
