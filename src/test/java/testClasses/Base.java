package testClasses;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public static WebDriver driver;
    public LoginPage loginPage;
    public DashboardPage dashboardPage;
    public DateTimePage dateTimePage;
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
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        userLogin(driver);
        dataSetup(driver);
        extent.attachReporter(spark);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            test.info(result.getThrowable());
            extent.flush();
            driver.quit();
        } else if (result.getStatus() == ITestResult.SKIP){
            test.info(result.getThrowable());
            extent.flush();
            driver.quit();
        } else {
            extent.flush();
            driver.quit();
        }
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

    public void userLogin(WebDriver driver) {
        loginPage = new LoginPage(driver);
        loginPage.inputEmailAddress(properties.getProperty("email"));
        loginPage.inputPassword(properties.getProperty("password"));
        loginPage.clickSignIn();
    }

    public void dataSetup(WebDriver driver) {
        dashboardPage = new DashboardPage(driver);
        dateTimePage = new DateTimePage(driver);
        dashboardPage.verifyDashboardTitle(properties.getProperty("title"));
        dateTimePage.goToSpecificPastDate("Nov 2020");
    }
}
