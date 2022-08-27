import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class HomeTask {
    private WebDriver driver;
    private static final String UKRNET_ACCOUNT_PAGE = "https://accounts.ukr.net/login?client_id=9GLooZH9KjbBlWnuLkVX";

    public void driverSetUp(){
       chromedriver().setup();
       driver=new ChromeDriver();
       driver.manage().window().maximize();
    }

    public void openGoogleAccountPage(){
        driver.get(UKRNET_ACCOUNT_PAGE);
    }

    public WebDriver getDriver(){
        return driver;
    }

    public LogInPage getLogInPage(){
        return new LogInPage(getDriver());
    }

    public EmailPage getEmailPage(){ return new EmailPage(getDriver()); }

    public SendMessagePage getSendMessagePage(){ return new SendMessagePage(getDriver());}
    
    public void closeDriver(){
        driver.quit();
    }

    public void sendEmail(){
        driverSetUp();
        openGoogleAccountPage();
        getLogInPage().typeEmailInLogInForm();
        getLogInPage().typePassWord();
        getLogInPage().clickOnSubmitButton();
        getEmailPage().waitForLoadingPage();
        getEmailPage().waitSendButtonIsClickable();
        getEmailPage().clickOnWriteEmailButton();
        getSendMessagePage().waitForLoadingPage();
        getSendMessagePage().waitForSendingFormBecomeVisible();
        getSendMessagePage().typeReceiver();
        getSendMessagePage().typeSubject();
        getSendMessagePage().fillContentField();
        getSendMessagePage().waitSubmitButtonIsClickable();
        getSendMessagePage().clickOnSendButton();
        getSendMessagePage().waitForSendingMessage();
        closeDriver();
    }
}
