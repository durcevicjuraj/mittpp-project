package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.ContextMenuPage;
import utils.DriverFactory;

public class ContextMenuTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");
        driver = DriverFactory.getDriver(browser);
        driver.manage().window().maximize();

        driver.get("http://the-internet.herokuapp.com/context_menu");
    }

    @Test
    public void contextMenuTest() throws InterruptedException {
        ContextMenuPage contextMenuPage = new ContextMenuPage(driver);
        Actions actions = new Actions(driver);

        actions.contextClick(contextMenuPage.getHotSpot()).perform();

        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert text: " + alertText);

        Thread.sleep(2000);
        alert.accept();
        Thread.sleep(2000);

        Assert.assertTrue("The alert does not contain the expected message.",
                alertText.contains("You selected a context menu"));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
