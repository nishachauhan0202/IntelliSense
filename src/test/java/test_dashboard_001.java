import org.testng.annotations.Test;

public class test_dashboard_001 extends BaseTest{

    @Test
    public void Test_1(){
        dashboardPage.verifyDashboardTitle("Test Project");
    }

}