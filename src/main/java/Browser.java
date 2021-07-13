import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Browser {
     public static WebDriver driver;
    // WebDriver dri = new ChromeDriver();


    public  static void setDriver(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ekio\\Desktop\\Pragmatic\\Selenium\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public static void quitDriver() {
        driver.quit();
    }

}

