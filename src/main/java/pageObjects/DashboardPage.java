package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DashboardPage {

    WebDriver dashboardDriver;

    public DashboardPage(WebDriver driver){
        dashboardDriver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[normalize-space()='Test Project']")
    WebElement dashboardTitle;

    public void verifyDashboardTitle(String expectedText){
        String actualText = dashboardTitle.getText();
        Assert.assertEquals(actualText, expectedText);
    }

    @FindBy(xpath = "//button[contains(@title, 'Date')]")
    WebElement dateTimeButton;

    public void clickDateTimeButton(){
        dateTimeButton.click();
    }
}
