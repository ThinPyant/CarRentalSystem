package userregistration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SignUp {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    @FindBy(xpath = "//h2")
    private WebElement heading;

    @FindBy(xpath = "//div[@id='__next']//button[contains(text(),'Join Now')]")
    private WebElement individualJoinNow;

    @FindBy(xpath = "//*[@id='fullName']")
    private WebElement fullName;

    @FindBy(xpath = "//*[@id='username']")
    private WebElement email;

    @FindBy(xpath = "//*[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//*[@id='confirmPassword']")
    private WebElement confirmPassword;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[1]/div[2]/div/form/button")
    private WebElement submitButton;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[1]/div[2]/div/form")
    private WebElement signUpError;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[1]/div[2]/div/h2")
    private WebElement successMsg;

    // Constructor
    public SignUp(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // 10-second timeout
        PageFactory.initElements(driver, this);
    }

    public void clickOnJoinNow() {
        wait.until(ExpectedConditions.elementToBeClickable(individualJoinNow)).click();
    }

    // Check if page is opened
    public boolean isPageOpened() {
        return wait.until(ExpectedConditions.textToBePresentInElement(heading, "Join as Individual"));
    }

    public void setFullName(String userFullName) {
        wait.until(ExpectedConditions.visibilityOf(fullName)).clear();
        fullName.sendKeys(userFullName);
    }

    public void setUserEmail(String usersEmail) {
        wait.until(ExpectedConditions.visibilityOf(email)).clear();
        email.sendKeys(usersEmail);
    }

    public void setUserPassword(String usersPassword) {
        wait.until(ExpectedConditions.visibilityOf(password)).clear();
        password.sendKeys(usersPassword);
    }

    public void setConfirmPassword(String usersConfirmPassword) {
        wait.until(ExpectedConditions.visibilityOf(confirmPassword)).clear();
        confirmPassword.sendKeys(usersConfirmPassword);
    }

    public void clickOnSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    public void registerUser(String userFullName, String usersEmail, String usersPassword, String usersConfirmPassword) {
        if (isPageOpened()) {
            setFullName(userFullName);
            setUserEmail(usersEmail);
            setUserPassword(usersPassword);
            setConfirmPassword(usersConfirmPassword);
            clickOnSubmit();
        }
    }

    public boolean errorMessageIsVisible() {
        return wait.until(ExpectedConditions.visibilityOf(signUpError)).isDisplayed();
    }

    public boolean successMsgIsVisible() {
        return wait.until(ExpectedConditions.visibilityOf(successMsg)).isDisplayed();
    }


}