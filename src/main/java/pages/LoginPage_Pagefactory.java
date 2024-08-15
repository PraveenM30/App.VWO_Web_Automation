package pages;

import com.Utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.LinkedHashMap;

public class LoginPage_Pagefactory extends TestBase {

    // Contains
    // Page Locators

    WebDriver driver;

    public LoginPage_Pagefactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "login-username")
    WebElement usernameLocator;
    @FindBy(id = "login-password")
    WebElement passwordLocator;
    @FindBy(id = "js-login-btn")
    WebElement signButtonLocator;
    @FindBy(id = "js-notification-box-msg")
    WebElement error_messageLocator;

    // Page Actions
    public String loginToVWO_InvalidCreds_PF() throws IOException {
        LinkedHashMap<String, String> data = getDataFromExcel("app_VWO.xlsx", "signIn", true, "app_001");
        String username = data.get("UserName");
        String password = data.get("InvalidPassword");
        String url = data.get("Web_URL");

        driver.get(url);
        usernameLocator.sendKeys(username);
        passwordLocator.sendKeys(password);
       // signButtonLocator.click(); //no need to click on submit button, automatically it will click
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement error_msg = driver.findElement(By.className("notification-box-description"));
        String error_msg_text = error_msg.getText();
        String error_msg_attribute_dataqa = error_msg.getAttribute("data-qa");
        return error_msg_text;
    }

    public void loginToVWO_ValidCreds_PF() throws IOException {
        LinkedHashMap<String, String> data = getDataFromExcel("app_VWO.xlsx", "signIn", true, "app_001");
        String username = data.get("UserName");
        String password = data.get("Password");
        String url = data.get("Web_URL");

        driver.get(url);
        usernameLocator.sendKeys(username);
        passwordLocator.sendKeys(password);
        //no need to click on submit button, automatically it will click
    }
}
