package testClasses;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;

public class PositiveTestCases extends Base{

    @Test
    public void verifyDashboardTitle(){
        ExtentTest test = extent.createTest("Verify Dashboard Title");
        test.assignCategory("Smoke Test");
    }
}