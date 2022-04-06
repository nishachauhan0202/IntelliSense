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

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public String url = "https://reference-test.intellisense.io/#!/id/dashboards/1471";
    public String email = "menna+testproject@intellisense.io";
    public String password = "AutMaNewTest1#";
    public String browser = "edge";
    public static WebDriver driver;
    public LoginPage loginPage;
    public DashboardPage dashboardPage;


    @BeforeMethod
    public void testSetup() throws InterruptedException {
        setBrowser();
        driver.manage().window().maximize();
        driver.navigate().to(url);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        loginPage.inputEmailAddress(email);
        loginPage.inputPassword(password);
        loginPage.clickSignIn();
        dashboardPage.clickDateTimeButton();
    }

    @AfterMethod
    public void tearDown(ITestResult result){

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
