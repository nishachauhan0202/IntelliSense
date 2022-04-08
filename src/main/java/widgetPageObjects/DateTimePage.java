package widgetPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.DashboardPage;

public class DateTimePage {

    WebDriver driver;
    DashboardPage dashboardPage;

    public DateTimePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[normalize-space()='Historic']")
    private WebElement historicDate;

    public void clickHistoricLink(){
        historicDate.click();
    }

    @FindBy(xpath = "//*[@selection='from']//*[@class='control-toggle']")
    private WebElement fromDate;

    public void clickFromDate(){
        fromDate.click();
    }

    @FindBy(xpath = "//div[@class='date-control-dropdown']//button[1]")
    private WebElement previousMonthArrow;

    public void goToPreviousMonth(){
        previousMonthArrow.click();
    }

    @FindBy(xpath = "//div[@selection='from']//child::span[@class='month']")
    private WebElement fromMonth;

    public void goToSpecificPastMonth(String month){
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickDateTimeButton();
        clickHistoricLink();
        clickFromDate();
        String displayedMonth = null;
        do {
            goToPreviousMonth();
            displayedMonth = fromMonth.getText();
        } while (!displayedMonth.equalsIgnoreCase(month));
    }




}
