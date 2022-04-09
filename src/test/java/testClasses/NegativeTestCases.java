package testClasses;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NegativeTestCases extends BaseTest {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void test_instrumentation_new_value_negative() {
        setDashboardPage(driver);
        dashboardPage.clickAddInstrumentationValue();
        dashboardPage.clickSubmitNewValue();
        String actualMessage = dashboardPage.alertMessageDisplayed();
        String expectedMessage = properties.getProperty("valueFailMessage");
        softAssert.assertEquals(actualMessage, expectedMessage);
        softAssert.assertAll();
    }

    @Test
    public void test_create_duplicate_dashboard_without_name(){
        setDashboardPage(driver);
        dashboardPage.clickCreateDuplicateDashboard();
        dashboardPage.clickOkForDuplicateDashboard();
        softAssert.assertTrue(
                dashboardPage.dashboardNameMandateErrorDisplayed());
        softAssert.assertAll();
    }

}
