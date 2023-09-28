package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static constants.Constant.EXPLICIT_WAIT;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void openUrl(String url){
        driver.get(url);
    }

    public WebElement findElement (String locator){

        return driver.findElement(By.xpath(locator));
    }

    public void waitElementIsVisible(String locator, int second){
        new WebDriverWait(driver, Duration.ofSeconds(second))
                .until(ExpectedConditions.visibilityOf(findElement(locator)));
    }

    public void waitElementsIsVisible(String locator){
        waitElementIsVisible(locator,EXPLICIT_WAIT);
    }

    public void sendKeys (String locator, String text){
        findElement(locator).sendKeys(text);
    }

    public String getText(String locator){
        return findElement(locator).getText();
    }

    public void clear(String locator){
        findElement(locator).clear();
    }

    public boolean isElementDisplayed(String locator){
        try {
            return findElement(locator).isDisplayed();
        } catch (Exception e){
            return false;
        }
    }

    public void click (String locator){
        findElement(locator).click();
    }
}
