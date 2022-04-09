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
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import widgetPageObjects.DateTimePage;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    static WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    DateTimePage dateTimePage;
    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("target/Test - Results.html");
    ExtentTest test;
    Properties properties = new Properties();
    FileInputStream fileInputStream;

    {
        try {
            fileInputStream = new FileInputStream
                    (System.getProperty("user.dir")+"/src/test/java/resources/data.properties");
            properties.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void testSetup() {
        setBrowser();
        driver.manage().window().maximize();
        driver.navigate().to(properties.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        setLoginPage(driver);
        extent.attachReporter(spark);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        test = extent.createTest(methodName).
                assignDevice(properties.getProperty("device"));
        if (result.isSuccess()){
            test.log(Status.PASS, methodName+" - PASSED");
        } else {
            test.log(Status.FAIL, methodName+" - FAILED");
        }
        extent.flush();
        driver.quit();
    }

    public void setBrowser() {
        if (properties.getProperty("browser").equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (properties.getProperty("browser").equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (properties.getProperty("browser").equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
    }

    public void setLoginPage(WebDriver driver) {
        loginPage = new LoginPage(driver);
        loginPage.inputEmailAddress(properties.getProperty("email"));
        loginPage.inputPassword(properties.getProperty("password"));
        loginPage.clickSignIn();
    }

    public void setDateTimePage(WebDriver driver) {
        dateTimePage = new DateTimePage(driver);
        dashboardPage.clickDateTimeButton();
        dateTimePage.clickHistoricLink();
        dateTimePage.setFromPastMonth(
                properties.getProperty("fromMonth"), properties.getProperty("fromDate"));
        dateTimePage.setFromTime(
                properties.getProperty("fromHour"), properties.getProperty("fromMinute"));
        dateTimePage.setToPastMonth(
                properties.getProperty("toMonth"), properties.getProperty("toDate"));
        dateTimePage.setToTime(
                properties.getProperty("toHour"), properties.getProperty("toMinute"));
        dateTimePage.clickSubmitFromToDate();
    }

    public void setDashboardPage(WebDriver driver){
        dashboardPage = new DashboardPage(driver);
    }
}
