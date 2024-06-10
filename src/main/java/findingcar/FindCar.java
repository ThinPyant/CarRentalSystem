package findingcar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class FindCar {
    private WebDriver driver;
    private WebDriverWait wait;

    //Locators
    @FindBy(xpath = "//h1")
    private WebElement heading;

    @FindBy(xpath = "//*[@id=\"__next\"]/main/div/div[1]/form/div[1]/div")
    private WebElement pickUpField;

    @FindBy(xpath = "//*[@id=\"__next\"]/main/div/div[1]/form/div[2]/div/div")
    private WebElement returnField;

    @FindBy(xpath = "//*[@type ='checkbox']")
    private WebElement diffLocationCheckbox;

    @FindBy(xpath = "//*[@id=\"__next\"]/main/div/div[1]/form/div[2]/a")
    private WebElement findLocation;

    @FindBy(xpath = "//*[@name='pickup_date']")
    private WebElement pickUpDateField;

    @FindBy(xpath = "//*[@name='pickup_time']")
    private WebElement pickUpTimeField;

    @FindBy(xpath = "//*[@name='return_date']")
    private WebElement returnDateField;

    @FindBy(xpath = "//*[@name='return_time']")
    private WebElement returnTimeField;

    @FindBy(xpath = "//*[@id=\"__next\"]/main/div/div[1]/form/div[3]/a")
    private WebElement mapLink;

    @FindBy(xpath = "//*[@id='SimulateButton']")
    private WebElement findCarButton;

    // Constructor
    public FindCar(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // 10-second timeout
        PageFactory.initElements(driver, this);
    }

    // Check if page is opened
    public boolean isPageOpened() {
        return wait.until(ExpectedConditions.textToBePresentInElement(heading, "Find A Car"));
    }

    //click on Pick up Location
    public String selectPickUpLocation(String selectedPickUp){
        List<WebElement> pickUpItems = driver.findElements(By.className("select__control"));

        if(!pickUpItems.isEmpty()){
            // Click a random inquiry item
            Random random = new Random();
            int randomIndex = random.nextInt(pickUpItems.size());
            WebElement randomItem = pickUpItems.get(randomIndex);
            randomItem.click();

            selectedPickUp = randomItem.getText();
        }

        return selectedPickUp;
    }

    public void setDiffLocation(){
        diffLocationCheckbox.click();
    }

    public void isSetDiffLocation(){
        returnField.getText();
    }

    public void setPickUpDate(){

        pickUpDateField.click();
        pickUpTimeField.click();

        // Generate random pickup date (today or later)
        Random random = new Random();

        LocalDate pickupDate = LocalDate.now(); // Today's date
        // Generate random return date (same day or later)
        LocalDate returnDate = pickupDate.plusDays(random.nextInt(30)); // Pickup date + random days between 0 and 2

        // Generate random pickup time
        LocalTime pickupTime = LocalTime.now();

        // Ensure return time is at least 15 minutes after pickup time
        LocalTime returnTime = pickupTime.plusMinutes(15 + random.nextInt(59 - 15)); // Random return time between 15 and 60 minutes after pickup time

        // Combine pickup date and time
        LocalDateTime pickupDateTime = LocalDateTime.of(pickupDate, pickupTime);
        // Combine return date and time
        LocalDateTime returnDateTime = LocalDateTime.of(returnDate, returnTime);

        // Set pickup date
        pickUpDateField.clear();
        pickUpDateField.sendKeys(pickupDate.toString());

        // Set pickup time
        pickUpTimeField.clear();
        pickUpTimeField.sendKeys(pickupTime.toString());

        // Set return date (same as pickup date)
        returnDateField.clear();
        returnDateField.sendKeys(pickupDate.toString());

        // Set return time
        returnTimeField.clear();
        returnTimeField.sendKeys(returnTime.toString());
    }

public void findAvailableCar(String selectedPickUp, )

}
