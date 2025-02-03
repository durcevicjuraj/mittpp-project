package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.AddRemoveElementsPage;
import utils.DriverFactory;

public class AddRemoveElementsTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");
        driver = DriverFactory.getDriver(browser);
        driver.manage().window().maximize();

        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
    }

    @Test
    public void addAndRemoveElementTest() throws InterruptedException {
        AddRemoveElementsPage addRemovePage = new AddRemoveElementsPage(driver);

        Assert.assertFalse("Delete button should not be present initially.", addRemovePage.isDeleteButtonPresent());

        Thread.sleep(2000);

        addRemovePage.clickAddElement();

        Thread.sleep(2000);

        Assert.assertTrue("Delete button should be present after clicking Add Element.", addRemovePage.isDeleteButtonPresent());

        Thread.sleep(2000);

        addRemovePage.clickDeleteButton();

        Thread.sleep(2000);

        Assert.assertFalse("Delete button should not be present after deletion.", addRemovePage.isDeleteButtonPresent());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
