package widgetObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.DashboardPage;

public class DateTimePage {

    WebDriver driver;
    public DashboardPage dashboardPage;

    public DateTimePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@selection='from']//div[@class='control-toggle']")
    WebElement fromDate;

    public void clickFromDate(){
        fromDate.click();
    }

    @FindBy(xpath = "//div[@class='date-control-dropdown']//button[1]")
    WebElement previousDateArrow;

    public void goToPreviousDate(){
        previousDateArrow.click();
    }

    @FindBy(xpath = "//div[@selection='from']//child::span[@class='month']")
    WebElement fromMonth;

    public void goToSpecificPastDate(String date){
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickDateTimeButton();
        while (true){
            goToPreviousDate();
            String currentDate = fromMonth.getText();
            if(currentDate.equalsIgnoreCase(date)){
                break;
            }
        }
    }




}
