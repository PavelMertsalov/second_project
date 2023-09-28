package pages.elements;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class TextBoxPage extends BasePage {
    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    public static final String HEADER_TEXT = "//div[@class='main-header']";
    public static final String INPUT_XPATH = "//*[@placeholder='%s']";
    public static final String PERMANENT_ADDRESS = "//textarea[@id='permanentAddress']";
    public static final String SUBMIT = "//button[@id='submit']";

    public static final String FULL_NAME = "Full Name";
    public static final String EMAIL = "name@example.com";
    public static final String CURRENT_ADDRESS = "Current Address";

    public void setFullName (String text){
        String locator = String.format(INPUT_XPATH,FULL_NAME);
        sendKeys(locator, text);
    }
    public void setEmail (String email){
        String locator = String.format(INPUT_XPATH,EMAIL);
        sendKeys(locator, email);
    }
    public void setCurrentAddress(String address){
        String locator = String.format(INPUT_XPATH, CURRENT_ADDRESS);
        sendKeys(locator, address);
    }

    public void setPermanentAddress(String address){
        sendKeys(PERMANENT_ADDRESS,address);
    }

    public void clickSubmit(){
        click(SUBMIT);
    }

    public String getTextHeader(){
        return getText(HEADER_TEXT);
    }

}
