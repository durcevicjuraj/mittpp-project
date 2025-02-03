package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.CheckboxesPage;
import utils.DriverFactory;

public class CheckboxesTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");
        driver = DriverFactory.getDriver(browser);
        driver.manage().window().maximize();

        driver.get("http://the-internet.herokuapp.com/checkboxes");
    }

    @Test
    public void checkboxesTest() throws InterruptedException {
        CheckboxesPage checkboxesPage = new CheckboxesPage(driver);

        boolean firstSelected = checkboxesPage.getCheckboxes().get(0).isSelected();
        boolean secondSelected = checkboxesPage.getCheckboxes().get(1).isSelected();
        Assert.assertFalse("The first checkbox should be unchecked..", firstSelected);
        Assert.assertTrue("The second checkbox should be checked.", secondSelected);

        Thread.sleep(2000);

        checkboxesPage.checkCheckbox(0);
        Thread.sleep(2000);

        checkboxesPage.uncheckCheckbox(1);
        Thread.sleep(2000);

        firstSelected = checkboxesPage.getCheckboxes().get(0).isSelected();
        secondSelected = checkboxesPage.getCheckboxes().get(1).isSelected();
        Assert.assertTrue("The first checkbox should be checked after clicking.", firstSelected);
        Assert.assertFalse("The second checkbox should be unchecked after clicking.", secondSelected);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
