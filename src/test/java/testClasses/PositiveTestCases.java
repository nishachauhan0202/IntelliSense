package testClasses;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PositiveTestCases extends Base{

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void verifyDashboardTitle() {
        test = extent.createTest("Verify Dashboard Title").
                assignDevice(properties.getProperty("device")).
                assignCategory("Smoke Test");
        String actualTitle = dashboardPage.getDashboardTitle();
        String expectedTitle = properties.getProperty("title");
        softAssert.assertEquals(actualTitle, expectedTitle);
        softAssert.assertAll();
        test.log(Status.PASS, "Test Pass");
    }

    @Test
    public void verifyDates() throws InterruptedException {
        test = extent.createTest("Verify Dates").
                assignDevice(properties.getProperty("device")).
                assignCategory("Smoke Test");
    }


}