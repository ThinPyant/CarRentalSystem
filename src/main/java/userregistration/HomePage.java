package userregistration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    //Page URL
    private static String PAGE_URL = "https://carshare.yomafleet.com/";
    private WebDriver driver;

    //Locators
    //SignIn Button
    @FindBy(xpath = "//*[@id=\"__next\"]/nav/div[1]/div/div[1]/div[3]/div[1]/a[1]")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@id=\"__next\"]/nav/div[1]/div/div[1]/div[3]/div[1]/a[2]")
    private WebElement signUpButton;

    //Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public void clickSignUpButton() {
        signUpButton.click();
    }
}
