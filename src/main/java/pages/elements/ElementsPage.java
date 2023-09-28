package pages.elements;

import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class ElementsPage extends BasePage {
    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    public final static String URL = "https://demoqa.com/elements";
    public static final String XPATH_ITEM = "//div[@class='element-list collapse show']//li[@class='btn btn-light ']//span[contains(text(),'%s')]";
    public static final String TEXT_BOX = "Text Box";
    public static final String CHECK_BOX = "Check Box";
    public static final String DYNAMIC_PROPERTIES = "Dynamic Properties";

    public static final String HEADER_XPATH = "//header/a[@href='https://demoqa.com'][img[@src='/images/Toolsqa.jpg']]";
    public static final String HEADER_TEXT = "//div[@class='main-header']";

    public boolean isHeaderDisplayed(){
        return isElementDisplayed(HEADER_XPATH);
    }

    public String getTextHeader(){
        return getText(HEADER_TEXT);
    }

    public TextBoxPage openTextBoxPage(){
        click(String.format(XPATH_ITEM, TEXT_BOX));
        return new TextBoxPage(driver);
    }

    public CheckBoxPage openCheckBoxPage(){
        click(String.format(XPATH_ITEM, CHECK_BOX));
        return new CheckBoxPage(driver);
    }

}
