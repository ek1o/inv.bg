import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class HomePage {
    @FindBy(xpath = "//a[@onclick='external_open_loginbox()']")
    private static WebElement clientEntranceButton;
    @FindBy(xpath = "//input[@id='login-subdomain']")
    private static WebElement subDomainField;
    @FindBy(xpath = "//input[@id='gologin']")
    private static WebElement  entranceButton;

    public static void openHomePage(){
        Browser.driver.get("https://inv.bg");
        PageFactory.initElements(Browser.driver,HomePage.class);
    }

    public  static void setSubDomain(){
        openHomePage();
        Action.click(clientEntranceButton);
        Action.type(subDomainField,"ekioltd");
        Action.click(entranceButton);

    }
}
