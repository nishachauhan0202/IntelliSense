package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage {

    WebDriver driver;
    CommonMethods method;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='emailAddress']")
    private WebElement emailAddress;

    public void inputEmailAddress(String email){
        method.inputElement(emailAddress, email);
    }

    @FindBy(xpath = "//input[@id='password']")
    private WebElement userPassword;

    public void inputPassword(String password){
        userPassword.sendKeys(password);
    }

    @FindBy(xpath = "//span[@class='MuiButton-label']")
    private WebElement signInButton;

    public void clickSignIn(){
        signInButton.click();
    }

}
