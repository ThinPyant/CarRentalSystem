
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import userregistration.HomePage;
import userregistration.SignIn;
import userregistration.SignUp;

import java.util.concurrent.TimeUnit;
public class SignInTest {
    private WebDriver driver;
    private WebDriverWait wait;

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
    //Check whether Sign In page is browsed properly
    public void testNavigationTtoSignInPage() throws InterruptedException {
        HomePage homePage= new HomePage(driver);
        homePage.clickSignInButton();
        Assert.assertTrue(driver.getTitle().contains("Sign In"));
    }


    @Test
    //Check Sign In with valid email and password
    public void testSignInWithValidCredentials() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSignInButton();
        //Create object of SignInPage
        SignIn signIn = new SignIn(driver);
        //Check if page is opened

        signIn.signIn("thinpyanthlaing94@gmail.com", "thin12345");
    }

    @Test
    //Check Sign In with invalid password
    public void testSignInWithInvalidPassword() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSignInButton();
        SignIn signIn = new SignIn(driver);
        signIn.signIn("thinpyanthlaing94@gmail.com", "wrongPass");

        //Check the visibility of error message, when the wrong password is entered
        Assert.assertTrue(signIn.errorMessageIsVisible());
    }

    @Test
    //Check Sign In with invalid email
    public void testSignInWithInvalidEmail() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSignInButton();
        SignIn signIn = new SignIn(driver);
        signIn.signIn("wrongEmail", "thin12345");

        //Check the visibility of error message, when the wrong email is entered
        Assert.assertTrue(signIn.errorMessageIsVisible());
    }

    @Test
    //Check Sign In with empty email and password
    public void testSignInWithEmptyFields() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSignInButton();
        SignIn signIn = new SignIn(driver);
        signIn.signIn("", "");

        //Check the visibility of error message, when the wrong email is entered
        Assert.assertTrue(signIn.errorMessageIsVisible());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
