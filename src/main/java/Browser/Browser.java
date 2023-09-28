package Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;

import static Browser.Config.BROWSER_TYPE;
import static constants.Constant.IMPLICIT_WAIT;

public class Browser {
    public static WebDriver driver;

    public static WebDriver createDriver(){
        switch (BROWSER_TYPE){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driver\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\driver\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                Assert.fail("Некорректное значение переменной " + BROWSER_TYPE);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        return driver;
    }
}
