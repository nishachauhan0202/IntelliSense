package testClasses;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PositiveTestCases extends Base {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void verifyDatesChange() {
        setDashboardPage(driver);
        setDateTimePage(driver);
        String actualMessage = dateTimePage.verifyDateChanged();
        String expectedMessage = properties.getProperty("dateChangeSuccessMessage");
        softAssert.assertEquals(actualMessage, expectedMessage);
        softAssert.assertAll();
        test.log(Status.INFO, "Test Verify Dates End");
    }

    @Test
    public void clickSingularTab(){
        setDashboardPage(driver);
        dashboardPage.goToSingularTab();
    }
}