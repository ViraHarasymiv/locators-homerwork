import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;
    private static final long TIME = 1000;

    public BasePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void waitForLoadingPage(){
        new WebDriverWait(driver, Duration.ofSeconds(TIME))
                .until(webDriver -> ((JavascriptExecutor) webDriver))
                .executeScript("return document.readyState").equals("complete");
    }

    public void waitForSendingFormBecomeVisible(){
        new WebDriverWait(driver,Duration.ofSeconds(TIME))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='screen__content']")));
    }

    public void waitSendButtonIsClickable(){
        new WebDriverWait(driver,Duration.ofSeconds(TIME))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='button primary compose']")));
    }

    public void waitForSendingMessage(){
        new WebDriverWait(driver,Duration.ofSeconds(TIME))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='sendmsg__ads-ready']")));
    }

    }

