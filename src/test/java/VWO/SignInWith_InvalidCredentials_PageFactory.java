package VWO;

import com.Utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage_POM;
import pages.LoginPage_Pagefactory;

import java.io.IOException;

public class SignInWith_InvalidCredentials_PageFactory extends TestBase {

    @BeforeTest
    public void initializeBrowser() throws IOException {
        initializeDriver();
    }
    @Test
    public void signInWithInvalidCred() throws IOException {
        LoginPage_Pagefactory login=new LoginPage_Pagefactory(driver);
        String errormsg_text=login.loginToVWO_InvalidCreds_PF();
        Assert.assertEquals(errormsg_text,"Your email, password, IP address or location did not match");
    }
    @AfterTest
    public void tearDown(){
        super.tearDown();
    }
}
