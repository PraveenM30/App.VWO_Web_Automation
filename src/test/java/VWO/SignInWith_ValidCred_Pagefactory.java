package VWO;

import com.Utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DashboardPage_POM;
import pages.LoginPage_POM;
import pages.LoginPage_Pagefactory;

import java.io.IOException;

public class SignInWith_ValidCred_Pagefactory extends TestBase {

    @BeforeTest
    public void initializeBrowser() throws IOException {
        initializeDriver();
    }

    @Test
    public void SignInWithValidCred() throws IOException {
        LoginPage_Pagefactory login=new LoginPage_Pagefactory(driver);
        login.loginToVWO_ValidCreds_PF();

        DashboardPage_POM db=new DashboardPage_POM(driver);
        db.WaitUntilvisibilityOfElement(30);

        String aman_Text=db.aman().getText();
        Assert.assertEquals(aman_Text,", here's an overview of your experience optimization journey");
    }
    @AfterTest
    public void tearDown(){
        super.tearDown();
    }

}
