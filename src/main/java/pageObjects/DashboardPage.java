package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class DashboardPage {

    WebDriver driver;
    CommonMethods method;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[normalize-space()='Test Project']")
    private WebElement dashboardTitle;

    public String getDashboardTitle(){
        return method.getElementText(dashboardTitle);
    }

    @FindBy(xpath = "//button[contains(@title, 'DATE')]")
    private WebElement dateTimeButton;

    public void clickDateTimeButton(){
        method.clickElement(dateTimeButton);
    }
}
