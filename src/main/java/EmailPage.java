import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends BasePage{

    public EmailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//button[@class='button primary compose']")
    public WebElement writeEmailButton;


    public void clickOnWriteEmailButton(){
        writeEmailButton.click();
    }


}
