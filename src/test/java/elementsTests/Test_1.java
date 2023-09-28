package elementsTests;

import Browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.elements.ElementsPage;
import pages.elements.TextBoxPage;

public class Test_1 {
    private WebDriver driver;
    private ElementsPage elementsPage;
    private TextBoxPage textBoxPage;


    @BeforeClass
    public void beforeClass() {
        driver = Browser.createDriver();
        elementsPage = new ElementsPage(driver);
        elementsPage.openUrl(ElementsPage.URL);
        Assert.assertTrue(elementsPage.isHeaderDisplayed());
        Assert.assertEquals(elementsPage.getTextHeader(), "Elements");

    }

    private String fio = "Belousov Ivan";
    private String email = "test@test.ru";
    private String curAddr = "г.Курск";
    private String perAddr = "Курчатов";

    public String getText(String field) {
        String locator = "//p[@id='" + field + "']";
        return textBoxPage.getText(locator);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @Test
    public void step_1() {
        textBoxPage = elementsPage.openTextBoxPage();
        Assert.assertEquals(textBoxPage.getTextHeader(), "Text Box");
    }

    @Test
    public void step_2() {
        textBoxPage.setFullName(fio);
        textBoxPage.setEmail(email);
        textBoxPage.setCurrentAddress(curAddr);
        textBoxPage.setPermanentAddress(perAddr);
        textBoxPage.clickSubmit();
        Assert.assertEquals(getText("name"),"Name:" + fio);
        Assert.assertEquals(getText("email"),"Email:" + email);
        Assert.assertEquals(getText("currentAddress"),"Current Address :" + curAddr);
        Assert.assertEquals(getText("permanentAddress"),"Permananet Address :" + perAddr);

    }
}
