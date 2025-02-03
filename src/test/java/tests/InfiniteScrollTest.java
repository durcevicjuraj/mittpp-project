package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.InfiniteScrollPage;
import utils.DriverFactory;

public class InfiniteScrollTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");
        driver = DriverFactory.getDriver(browser);
        driver.manage().window().maximize();

        driver.get("http://the-internet.herokuapp.com/infinite_scroll");
    }

    @Test
    public void infiniteScrollMultipleScrollsTest() throws InterruptedException {
        InfiniteScrollPage infiniteScrollPage = new InfiniteScrollPage(driver);


        int initialCount = infiniteScrollPage.getContentCount();
        System.out.println("Initial content count: " + initialCount);

        // Odredi broj puta koliko ćemo scrollati
        int scrollTimes = 5;
        int lastCount = initialCount;

        for (int i = 1; i <= scrollTimes; i++) {

            infiniteScrollPage.scrollDown();

            Thread.sleep(3000);

            infiniteScrollPage.waitForContentCountToIncrease(lastCount, 10);

            lastCount = infiniteScrollPage.getContentCount();
            System.out.println("Content count after scroll " + i + ": " + lastCount);
        }


        Assert.assertTrue("Content count did not increase after multiple scrolls.", lastCount > initialCount);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
