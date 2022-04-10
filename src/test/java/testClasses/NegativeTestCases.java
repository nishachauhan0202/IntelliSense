package testClasses;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NegativeTestCases extends BaseTest {

    SoftAssert softAssert = new SoftAssert();

    @Test
    @Description("TEST DESCRIPTION: Verify value or cost of Instrumentation Material cannot be " +
            "added if nothing is provided in Value field")
    @Epic("FUNCTIONAL TEST")
    public void test_instrumentation_new_value_negative() {
        setDashboardPage(driver);
        setDateTimePage(driver);
        dashboardPage.clickAddInstrumentationValue();
        dashboardPage.clickSubmitNewValue();
        String actualMessage = dashboardPage.alertMessageDisplayed();
        String expectedMessage = properties.getProperty("valueFailMessage");
        softAssert.assertEquals(actualMessage, expectedMessage);
        softAssert.assertAll();
    }

    @Test
    @Description("TEST DESCRIPTION: Verify user cannot create a duplicate of a Dashboard if no " +
            "name is provided")
    @Epic("FUNCTIONAL TEST")
    public void test_create_duplicate_dashboard_without_name(){
        setDashboardPage(driver);
        setDateTimePage(driver);
        dashboardPage.clickCreateDuplicateDashboard();
        dashboardPage.clickOkForDuplicateDashboard();
        softAssert.assertTrue(
                dashboardPage.dashboardNameMandateErrorDisplayed());
        softAssert.assertAll();
    }


}
