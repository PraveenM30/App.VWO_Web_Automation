package VWO;

import com.Utils.TestBase;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage_POM;

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
    public void signInWithInvalidCred() throws IOException {
        logger.info("sign in with invalid cred !!");
        LoginPage_POM login=new LoginPage_POM(driver);
        logger.debug("verifying the error message!");
        String errormsg_text=login.loginToVWO_InvalidCreds();
        Assert.assertEquals(errormsg_text,"Your email, password, IP address or location did not match");
    }
    @AfterTest
    public void tearDown(){
       super.tearDown();
    }
}
