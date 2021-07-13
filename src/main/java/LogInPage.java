//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
    @FindBy(xpath = "//input[@name='email']")
    private static WebElement emailInputField;
    @FindBy(xpath = "//input[@name='password']")
    private static WebElement passwordInputField;
    @FindBy(xpath = "//input[@id='loginsubmit']")
    private static WebElement entranceButton;

    public static void logIn(){
        PageFactory.initElements(Browser.driver,LogInPage.class);
        Action.type(emailInputField,"emil@thenet.bg");
        Action.type(passwordInputField,"bmwpower");
        Action.click(entranceButton);

    }


}

