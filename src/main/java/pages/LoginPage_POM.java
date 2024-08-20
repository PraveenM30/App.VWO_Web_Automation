package pages;

import com.Utils.TestBase;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;

public class LoginPage_POM extends TestBase {

    // Contains
    // Page Locators

    WebDriver driver;
    public  LoginPage_POM(WebDriver driver){
        this.driver = driver;
    }

    private By usernameLocator = By.id("login-username");
    private By passwordLocator = By.id("login-password");
    private By signButtonLocator = By.id("js-login-btn");
    private By error_messageLocator = By.id("js-notification-box-msg");


    // Page Actions
    // loginT
    public String loginToVWO_InvalidCreds() throws IOException {
        LinkedHashMap<String,String> data= getDataFromExcel("app_VWO.xlsx","signIn",true,"app_001");
        String username=data.get("UserName");
        String password=data.get("InvalidPassword");
        String url=data.get("Web_URL");

        driver.get(url);
        driver.findElement(usernameLocator).sendKeys(username);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(signButtonLocator).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement error_msg = driver.findElement(By.className("notification-box-description"));
        String error_msg_text  = error_msg.getText();
        String error_msg_attribute_dataqa  = error_msg.getAttribute("data-qa");
        return error_msg_text;
    }

    public void loginToVWO_ValidCreds() throws IOException, InterruptedException {
        LinkedHashMap<String,String> data= getDataFromExcel("app_VWO.xlsx","signIn",true,"app_001");
        String username=data.get("UserName");
        String password=data.get("Password");
        String url=data.get("Web_URL");

        driver.get(url);
        driver.findElement(usernameLocator).sendKeys(username);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(signButtonLocator);

    }
}
