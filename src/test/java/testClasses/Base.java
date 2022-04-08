package testClasses;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import widgetPageObjects.DateTimePage;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

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
//        driver.manage().window().maximize();
        driver.navigate().to(properties.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        userLogin(driver);
        dataSetup(driver);
        extent.attachReporter(spark);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.manage().getCookies();
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

    public void userLogin(WebDriver driver) {
        loginPage = new LoginPage(driver);
        loginPage.inputEmailAddress(properties.getProperty("email"));
        loginPage.inputPassword(properties.getProperty("password"));
        loginPage.clickSignIn();
    }

    public void dataSetup(WebDriver driver) {
        dashboardPage = new DashboardPage(driver);
        dateTimePage = new DateTimePage(driver);
        dateTimePage.goToSpecificPastMonth(properties.getProperty("month"));
    }
}
