package userregistration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class SignIn {
    WebDriver driver;
    WebDriverWait wait;

    //Locators
    @FindBy(xpath = "//h1")
    private WebElement heading;

    @FindBy(xpath = "//*[@type ='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//*[@id='username']")
    private WebElement userEmail;

    @FindBy(xpath = "//*[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[1]/div[2]/div/form")
    private WebElement signInError;

    @FindBy(xpath = "//*[@tagName='form']")
    private WebElement errMsgPath;

    @FindBy(xpath = "//*[@id=\"__next\"]/nav/div/div/div[1]/div[3]/div[1]/div")
    private WebElement successMsg;

    //Constructor
    public SignIn(WebDriver driver) {
        this.driver = driver;
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void setUserEmail(String usersEmail) {
        userEmail.clear();
        userEmail.sendKeys(usersEmail);
    }

    public void setUserPassword(String usersPassword) {
        password.clear();
        password.sendKeys(usersPassword);
    }

    public void signIn(String usersEmail, String password) {
        if (isPageOpened()) {
            setUserEmail(usersEmail);
            setUserPassword(password);
            clickOnSubmit();
        }
    }

    //Check if page is opened
    public boolean isPageOpened() {
        return heading.getText().contains("Welcome Back");
    }

    public void clickOnSubmit() {
        submitButton.click();
    }

    public boolean errorMessageIsVisible() {
        return signInError.isDisplayed();
    }



    public boolean isSuccessful() {
        return wait.until(ExpectedConditions.visibilityOf(successMsg)).isDisplayed();
    }

}
