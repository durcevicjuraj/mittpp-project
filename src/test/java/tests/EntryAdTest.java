package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.EntryAdPage;
import utils.DriverFactory;

public class EntryAdTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");
        driver = DriverFactory.getDriver(browser);
        driver.manage().window().maximize();

        driver.get("http://the-internet.herokuapp.com/entry_ad");
    }

    @Test
    public void entryAdTest() throws InterruptedException {

        Thread.sleep(3000);

        EntryAdPage entryAdPage = new EntryAdPage(driver);
        Assert.assertTrue("Entry ad modal should be displayed.", entryAdPage.isModalDisplayed());

        Thread.sleep(3000);

        entryAdPage.clickCloseButton();

        Thread.sleep(3000);
        Assert.assertFalse("The entry ad modal should not be displayed after closing.", entryAdPage.isModalDisplayed());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
