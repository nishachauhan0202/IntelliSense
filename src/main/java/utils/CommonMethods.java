package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonMethods {

    WebDriver driver;

    public CommonMethods(WebDriver driver){
        this.driver = driver;
    }

    public void clickElement(WebElement element){
        element.click();
    }

    public String getElementText(WebElement element){
        return element.getText();
    }

    public void inputElement(WebElement element, String value){
        element.sendKeys(value);
    }
}
