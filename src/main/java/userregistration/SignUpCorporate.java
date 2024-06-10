package userregistration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class SignUpCorporate {
    WebDriver driver = new FirefoxDriver();
    private WebDriverWait wait;

    //Locators
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[1]/div[2]/div/div[2]/label[1]/input")
    private WebElement signUpCorporateButton;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[1]/div[2]/div/button[2]")
    private WebElement corporateJoinNow;

    @FindBy(xpath = "//h1")
    private WebElement heading;

    @FindBy(xpath = "//*[class='selector'][1]")
    private WebElement inquiryTypeField;

    @FindBy(xpath = "//*[@id='company_name']")
    private WebElement companyNameField;

    @FindBy(xpath = "//*[@id=\"__next\"]/main/div[3]/section[2]/form/div[2]/div[2]/div/div/div/div[1]")
    private WebElement industryField;

    @FindBy(xpath = "//*[@id='contact_person']")
    private WebElement contactPersonField;

    @FindBy(xpath = "//*[@id='job_title']")
    private WebElement jobTitleField;

    @FindBy(xpath = "//*[@id=\"__next\"]/main/div[3]/section[2]/form/div[4]/div/div/div[1]/div/div/div[2]")
    private WebElement prefixField;

    @FindBy(xpath = "//*[@id='national_number']")
    private WebElement phNumberField;

    @FindBy(xpath = "//*[@id='email']")
    private WebElement emailField;

    @FindBy(xpath = "//*[@type ='submit']")
    private WebElement submitButton;

    @FindBy(xpath ="//*[@id=\"__next\"]/main/div[3]/section[2]/form")
    private WebElement signUpError;

    @FindBy(xpath = "/html/body/div[5]/div/div[2]")
    private WebElement successMsg;

    //Constructor
    public SignUpCorporate(WebDriver driver) {
        this.driver = driver;
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void selectSignUpCorporate() {
        signUpCorporateButton.click();
    }

    public void clickOnJoinNow() {
        corporateJoinNow.click();
    }

    //Check if page is opened
    public boolean isPageOpened() {
        return heading.getText().contains("Yoma Car Share Corporate Account");
    }

    //click on Inquiry List
    public String selectInquiryType(String inquiryType){
        List<WebElement> inquiryItems = driver.findElements(By.className("select__menu"));

        if(!inquiryItems.isEmpty()){
            // Click a random inquiry item
            Random random = new Random();
            int randomIndex = random.nextInt(inquiryItems.size());
            WebElement randomItem = inquiryItems.get(randomIndex);
            randomItem.click();

            inquiryType = randomItem.getText();
        }

        return inquiryType;
    }

    public void setCompanyName(String companyName){
        wait.until(ExpectedConditions.visibilityOf(companyNameField)).clear();
        companyNameField.sendKeys(companyName);
    }

    public String selectIndustry(String industry){
        List<WebElement> industryItems = driver.findElements(By.className("select__control"));

        if(!industryItems.isEmpty()){
            // Click a random inquiry item
            Random random = new Random();
            int randomIndex = random.nextInt(industryItems.size());
            WebElement randomItem = industryItems.get(randomIndex);
            randomItem.click();

            industry = randomItem.getText();
        }
        return industry;
    }

    public void setContactPerson(String contactPerson){
        wait.until(ExpectedConditions.visibilityOf(contactPersonField)).clear();
        contactPersonField.sendKeys(contactPerson);
    }

    public void setJobTitle(String jobTitle){
        wait.until(ExpectedConditions.visibilityOf(jobTitleField)).clear();
        jobTitleField.sendKeys(jobTitle);
    }

    public String selectPrefix(String prefix){
        List <WebElement> prefixItems= driver.findElements(By.className("select__control"));

        if (!prefixItems.isEmpty()) {
            // Click a random inquiry item
            Random random = new Random();
            int randomIndex = random.nextInt(prefixItems.size());
            WebElement randomItem = prefixItems.get(randomIndex);
            randomItem.click();
            prefix= randomItem.getText();
        }
        return prefix;
    }

    public void setPhNumber(String phNumber){
        wait.until(ExpectedConditions.visibilityOf(jobTitleField)).clear();
        phNumberField.sendKeys(phNumber);
    }

    public void setEmail(String email){
        wait.until(ExpectedConditions.visibilityOf(emailField)).clear();
        emailField.sendKeys(email);
    }

    public void clickOnSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    public void registerCorporate(String inquiryType, String companyName, String industry, String contactPerson,
                                  String jobTitle, String prefix, String phNumber, String email){
        if(isPageOpened()){
            selectInquiryType(inquiryType);
            setCompanyName(companyName);
            selectIndustry(industry);
            setContactPerson(contactPerson);
            setJobTitle(jobTitle);
            selectPrefix(prefix);
            setPhNumber(phNumber);
            setEmail(email);
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
