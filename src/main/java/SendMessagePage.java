import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.Message;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.http.HttpRequest;
import java.time.Duration;

public class SendMessagePage extends BasePage{
    public SendMessagePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//body[@id='tinymce']")
    public WebElement contentOfLetter;

    @FindBy(xpath = "//div[contains(@class, 'sendmsg__form-label-field auto c')]")
    public WebElement receiverField;

    @FindBy(xpath = "//input[@name='subject']")
    public WebElement subjectField;

    @FindBy(xpath = "//div[@class='controls']//button[text()='Надіслати']")
    public WebElement sendButton;

    public void typeSubject(){
        subjectField.sendKeys("Home_task");
    }

    public void fillContentField(){
       Actions action = new Actions(driver);
       action.clickAndHold(contentOfLetter)
               .sendKeys("homerwork_is_done");
    }

    public void typeReceiver(){
        Actions actions = new Actions(driver);
        actions.moveToElement(receiverField).click().sendKeys("vira.harasymiv@nung.edu.ua").build().perform();
    }

    public void clickOnSendButton(){
        sendButton.click();
    }

}
