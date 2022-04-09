package testClasses;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PositiveTestCases extends BaseTest {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void test_dashboard_title(){
        setDashboardPage(driver);
        String actualTitle = dashboardPage.getDashboardTitle();
        String expectedTitle = properties.getProperty("title");
        softAssert.assertEquals(actualTitle, expectedTitle);
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "test_dashboard_title")
    public void test_date_change() {
        setDashboardPage(driver);
        setDateTimePage(driver);
        softAssert.assertTrue(dashboardPage.successAlertDisplayed());
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "test_dashboard_title")
    public void test_default_project(){
        setDashboardPage(driver);
        setDateTimePage(driver);
        dashboardPage.setDefaultHomepage();
        dashboardPage.clickOkForDefaultDashboard();
        softAssert.assertTrue(dashboardPage.successAlertDisplayed());
        softAssert.assertAll();
    }

    @Test
    public void test_instrumentation_new_value() {
        setDashboardPage(driver);
        setDateTimePage(driver);
        dashboardPage.clickAddInstrumentationValue();
        dashboardPage.enterMetricValue(100);
        dashboardPage.clickSubmitNewValue();
        String actualMessage = dashboardPage.alertMessageDisplayed();
        String expectedMessage = properties.getProperty("valueSaveMessage");
        softAssert.assertEquals(actualMessage, expectedMessage);
        softAssert.assertAll();
    }

    @Test
    public void test_atacamite_new_value(){
        setDashboardPage(driver);
        setDateTimePage(driver);
        dashboardPage.clickAddAtacamiteValue();
        dashboardPage.enterMetricValue(100);
        dashboardPage.clickSubmitNewValue();
        String actualMessage = dashboardPage.alertMessageDisplayed();
        String expectedMessage = properties.getProperty("valueSaveMessage");
        softAssert.assertEquals(actualMessage, expectedMessage);
        softAssert.assertAll();
    }

    @Test
    public void test_mesh_new_value(){
        setDashboardPage(driver);
        setDateTimePage(driver);
        dashboardPage.clickAddMeshValue();
        dashboardPage.enterMetricValue(100);
        dashboardPage.clickSubmitNewValue();
        String actualMessage = dashboardPage.alertMessageDisplayed();
        String expectedMessage = properties.getProperty("valueSaveMessage");
        softAssert.assertEquals(actualMessage, expectedMessage);
        softAssert.assertAll();
    }

    @Test
    public void test_instrumentation_value_delete(){
        setDashboardPage(driver);
        setDateTimePage(driver);
        dashboardPage.clickEditInstrumentationValueButton();
        String beforeDelete = dashboardPage.getCountOfValue();
        dashboardPage.clickDeleteLastValue();
        dashboardPage.clickToConfirmDeleteValue();
        dashboardPage.clickCloseEditBox();
        dashboardPage.clickEditInstrumentationValueButton();
        String afterDelete = dashboardPage.getCountOfValue();
        softAssert.assertNotEquals(afterDelete, beforeDelete);
        softAssert.assertAll();
    }

}