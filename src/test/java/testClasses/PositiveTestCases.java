package testClasses;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import widgetPageObjects.DateTimePage;

import java.util.concurrent.TimeUnit;

public class PositiveTestCases {

    public String url = "https://reference-test.intellisense.io/#!/id/dashboards/1471";
    public String email = "menna+testproject@intellisense.io";
    public String password = "AutMaNewTest1#";
    public String browser = "chrome";
    public static WebDriver driver;
    public LoginPage loginPage;
    public DashboardPage dashboardPage;
    public DateTimePage dateTimePage;
    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("target/Test - Results.html");
    ExtentTest test;

    @Test
    public void TestA(){
        test = extent.createTest("TestA");
        String actualText = dashboardPage.getDashboardTitle();
        String expectedTitle = "Test Projects";
        if (actualText.equalsIgnoreCase(expectedTitle)) {
            test.pass(actualText);
        } else {
            test.fail(actualText);
        }
    }

    @Test
    public void TestB(){
        ExtentTest test = extent.createTest("TestB");
        String actualText = dashboardPage.getDashboardTitle();
        String expectedTitle = "Test Project";
        if (actualText.equalsIgnoreCase(expectedTitle)) {
            test.pass(actualText);
        } else {
            test.fail(actualText);
        }
    }

    @BeforeMethod
    public void testSetup() {
        setBrowser();
        driver.manage().window().maximize();
        driver.navigate().to(url);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        dateTimePage = new DateTimePage(driver);
        loginPage.inputEmailAddress(email);
        loginPage.inputPassword(password);
        loginPage.clickSignIn();
//        dateTimePage.goToSpecificPastDate("Nov 2020");
        extent.attachReporter(spark);

    }

    @AfterMethod
    public void tearDown(ITestResult result){
        if(!result.isSuccess()) {
            test.generateLog(Status.INFO, "Logs");
        }
        extent.flush();
        driver.quit();
    }

    public void setBrowser(){
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
    }

}