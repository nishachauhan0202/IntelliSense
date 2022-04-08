package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class DashboardPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    SoftAssert softAssert = new SoftAssert();

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
}
