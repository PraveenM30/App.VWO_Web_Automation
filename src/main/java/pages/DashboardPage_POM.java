package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage_POM {

    WebDriver driver;
    public DashboardPage_POM(WebDriver driver) {
        this.driver=driver;
    }

    By Aman = By.xpath("//span[text()=\", here's an overview of your experience optimization journey\"]");

    public WebElement aman() {
        return driver.findElement(Aman);
    }

    public WebElement WaitUntilvisibilityOfElement(int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(Aman));
    }
}
