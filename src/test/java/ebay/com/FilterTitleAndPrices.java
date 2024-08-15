package ebay.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FilterTitleAndPrices {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");

        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@aria-label=\"Search for anything\"]")).sendKeys("macmini");
        driver.findElement(By.xpath("//input[@id=\"gh-btn\"]")).click();
        List<WebElement> MacTitle = driver.findElements(By.className("s-item__title"));
        List<WebElement> MacPrice = driver.findElements(By.className("s-item__price"));
        for (WebElement title : MacTitle) {
            System.out.println(title.getText());
        }
        for (WebElement price : MacPrice) {
            System.out.println(price.getText());
        }
        int size=Math.min(MacTitle.size(),MacPrice.size());
        for (int i=0;i<size;i++){
            System.out.println("Title: "+MacTitle.get(i).getText()+" ||"+"Price: "+ MacPrice.get(i).getText());
        }
        driver.quit();
    }
}
