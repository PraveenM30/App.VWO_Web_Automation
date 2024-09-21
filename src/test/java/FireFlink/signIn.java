package FireFlink;

import com.Utils.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class signIn extends TestBase {

    @BeforeTest
    public void initializeBrowser(){
        initializeBrowser();
    }

    @Test
    public void signIn() throws IOException {
      //  WebDriver driver=new ChromeDriver();
        FileInputStream file=new FileInputStream("TestData/cred.properties");
        Properties p=new Properties();
        p.load(file);
        String url=p.getProperty("url");
        String userName=p.getProperty("userName");
        String Password=p.getProperty("password");

        driver.get(url);
    }

    @AfterTest
    public void closeBrowser(){
        tearDown();
    }
}
