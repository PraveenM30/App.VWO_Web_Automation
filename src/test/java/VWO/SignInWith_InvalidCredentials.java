package VWO;

import com.Utils.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage_POM;

import java.io.IOException;

public class SignInWith_InvalidCredentials extends TestBase {

private static final Logger logger= LogManager.getLogger(SignInWith_InvalidCredentials.class);

    @BeforeTest
    public void initializeBrowser() throws IOException {
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
