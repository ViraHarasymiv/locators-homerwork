import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage{
    public LogInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[name='login']")
    public WebElement logIn;

    public void typeEmailInLogInForm(){
        logIn.sendKeys("vira_harasymiv");
    }

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordField;

    public void typePassWord(){
        passwordField.sendKeys("123456789epam");
    }

    @FindBy(xpath = "//button[contains(@class, 'WiMj')]")
    public WebElement submitButton;

    public void clickOnSubmitButton(){
        submitButton.click();
    }


}
