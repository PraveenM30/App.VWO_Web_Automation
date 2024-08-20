package VWO;

import com.Utils.TestBase;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage_POM;

import java.io.File;
import java.io.IOException;

public class SignInWith_InvalidCredentials extends TestBase {

    @BeforeTest
    public void initializeBrowser() throws IOException {
        // Reading The logger
        logger = Logger.getLogger("signin with InvalidCred");// Adding logger
        PropertyConfigurator.configure("log4j.properties");// Adding logger
        logger.info("open browser !!");
        initializeDriver();
    }
    @Test
    public void signInWithInvalidCred() throws IOException, InterruptedException {
        logger.info("sign in with invalid cred !!");
        LoginPage_POM login=new LoginPage_POM(driver);
        logger.debug("verifying the error message!");

        Thread.sleep(10000);
        TakesScreenshot shot=(TakesScreenshot) driver;
        File file=shot.getScreenshotAs(OutputType.FILE);
        String randomName= RandomStringUtils.randomAlphabetic(3);
        File file1=new File("screenShots/"+randomName+".png");
        FileUtils.copyFile(file, file1);


        String errormsg_text=login.loginToVWO_InvalidCreds();
        Assert.assertEquals(errormsg_text,"Your email, password, IP address or location did not match");
    }
    @AfterTest
    public void tearDown(){
       super.tearDown();
    }
}
