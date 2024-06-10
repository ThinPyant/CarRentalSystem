
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import userregistration.HomePage;
import userregistration.SignIn;
import userregistration.SignUp;

import java.util.concurrent.TimeUnit;
public class SignUpTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        // Ensure headless mode is not set
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless"); // This line should be commented out or removed
        driver = new ChromeDriver(options);

        // Full screen window
        driver.manage().window().maximize();
        // Wait for the element to appear before the exception occurs
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @Test
    public void testSignUpWithValidEmail() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSignUpButton();
        SignUp signUp = new SignUp(driver);
        signUp.clickOnJoinNow();
        Assert.assertTrue(signUp.isPageOpened());

    }

    @Test
    public void testSignUpWithValidCredentials() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSignUpButton();
        //Create object of SignInPage
        SignUp signUp = new SignUp(driver);
        signUp.clickOnJoinNow();
        //Check if page is opened
        signUp.registerUser("Test","thinpyanthlaing94@gmail.com",
                "thin12345","thin12345");
       Assert.assertTrue(signUp.errorMessageIsVisible());

    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
