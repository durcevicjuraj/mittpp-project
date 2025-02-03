package tests;

import java.util.Set;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.MultipleWindowsPage;
import utils.DriverFactory;

public class MultipleWindowsTest {

    private WebDriver driver;
    private String originalWindow;

    @Before
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");
        driver = DriverFactory.getDriver(browser);
        driver.manage().window().maximize();

        driver.get("http://the-internet.herokuapp.com/windows");
        originalWindow = driver.getWindowHandle();
    }

    @Test
    public void multipleWindowsTest() throws InterruptedException {
        MultipleWindowsPage multipleWindowsPage = new MultipleWindowsPage(driver);

        multipleWindowsPage.clickOnClickHere();


        Set<String> windowHandles = driver.getWindowHandles();
        String newWindow = "";
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindow)) {
                newWindow = handle;
                break;
            }
        }

        driver.switchTo().window(newWindow);

        Thread.sleep(2000);


        String bodyText = driver.findElement(By.tagName("body")).getText();
        System.out.println("New window body text: " + bodyText);
        Assert.assertTrue("The new window does not contain the expected text.",
                bodyText.contains("New Window"));


        driver.close();
        driver.switchTo().window(originalWindow);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
