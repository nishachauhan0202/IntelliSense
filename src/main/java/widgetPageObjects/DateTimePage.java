package widgetPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DateTimePage {

    WebDriver driver;

    public DateTimePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[normalize-space()='Historic']")
    private WebElement historicDate;

    public void clickHistoricLink(){
        historicDate.click();
    }

    public void selectDropdown(WebElement element, String type, String value){
        Select select = new Select(element);
        if (type.equalsIgnoreCase("Value")){
            select.selectByValue(value);
        } else if (type.equalsIgnoreCase("Text")){
            select.selectByVisibleText(value);
        } else {
            select.selectByIndex(Integer.parseInt(value));
        }
    }

    @FindBy(xpath = "//*[@selection='from']//*[@class='control-toggle']")
    private WebElement fromCalendar;

    public void clickFromCalendar(){
        fromCalendar.click();
    }

    @FindBy(xpath = "//div[@selection='from']//child::span[@class='month']")
    private WebElement displayFromMonth;

    public String fromMonthText(){
        return displayFromMonth.getText();
    }

    @FindBy(xpath = "//div[@class='date-control-dropdown']//button[1]")
    private WebElement fromPreviousMonthArrow;

    public void goFromPreviousMonth(){
        fromPreviousMonthArrow.click();
    }

    public void selectFromDate(String date){
        driver.findElement
                (By.xpath("(//div[@selection='from']//div[@class='day-container']/div" +
                        "[normalize-space()='"+date+"'])[1]")).click();
    }

    @FindBy(xpath = "(//*[@class='date-control-dropdown']//*[@name='hours'])[1]")
    private WebElement fromTimeHour;

    public void selectFromTimeHour(String hour){
        selectDropdown(fromTimeHour, "value", hour);
    }

    @FindBy(xpath = "(//*[@class='date-control-dropdown']//*[@name='minutes'])[1]")
    private WebElement fromTimeMinute;

    public void selectFromTimeMinute(String minute){
        selectDropdown(fromTimeMinute, "value", minute);
    }

    public void setFromPastMonth(String month, String date){
        clickFromCalendar();
        String displayedMonth;
        do {
            goFromPreviousMonth();
            displayedMonth = fromMonthText();
        } while (!displayedMonth.equalsIgnoreCase(month));
        selectFromDate(date);
    }

    public void setFromTime(String hour, String minute){
        selectFromTimeHour(hour);
        selectFromTimeMinute(minute);
    }

    @FindBy(xpath = "//*[@selection='to']//*[@class='control-toggle']")
    private WebElement toDate;

    public void clickToDate(){
        toDate.click();
    }

    @FindBy(xpath = "//div[@selection='to']//button[1]")
    private WebElement toPreviousMonthArrow;

    public void goToPreviousMonth(){
        toPreviousMonthArrow.click();
    }

    @FindBy(xpath = "//div[@selection='to']//child::span[@class='month']")
    private WebElement toMonth;

    public void selectToDate(String date){
        driver.findElement
                (By.xpath("(//div[@selection='to']//div[@class='day-container']/div" +
                        "[normalize-space()='"+date+"'])[1]")).click();
    }

    @FindBy(xpath = "(//*[@class='date-control-dropdown']//*[@name='hours'])[2]")
    private WebElement toTimeHour;

    public void selectToTimeHour(String hour){
        selectDropdown(toTimeHour, "value", hour);
    }

    @FindBy(xpath = "(//*[@class='date-control-dropdown']//*[@name='minutes'])[2]")
    private WebElement toTimeMinute;

    public void selectToTimeMinute(String minute){
        selectDropdown(toTimeMinute, "value", minute);
    }

    public void setToPastMonth(String month, String date){
        clickToDate();
        String displayedMonth;
        do {
            goToPreviousMonth();
            displayedMonth = toMonth.getText();
        } while (!displayedMonth.equalsIgnoreCase(month));
        selectToDate(date);
    }

    public void setToTime(String hour, String minute){
        selectToTimeHour(hour);
        selectToTimeMinute(minute);
    }

    @FindBy(xpath = "//form[@id='date-range-selector']//div[@class='control-wrapper text-left']")
    private WebElement submitFromToDate;

    public void clickSubmitFromToDate(){
        submitFromToDate.click();
    }

    @FindBy(xpath = "//div[@class='success show']")
    private WebElement dateChanged;

    public String verifyDateChanged(){
        return dateChanged.getText();
    }

}
