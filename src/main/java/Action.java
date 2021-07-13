import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Action {

    public static void type(WebElement element, String text){
        element.sendKeys(text);
    }
    public static void click(WebElement element) {
        element.click();
    }
    public static void dropDownSelect(WebElement element,String value){
        Select select = new Select(element);
        select.selectByValue(value);
    }
}
