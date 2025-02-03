package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.FormAuthPage;
import utils.DriverFactory;

public class FormAuthenticationTest {

    private WebDriver driver;

    @Before
    public void setUp() {

        String browser = System.getProperty("browser", "chrome");
        driver = DriverFactory.getDriver(browser);
        driver.manage().window().maximize();

        driver.get("http://the-internet.herokuapp.com/login");
    }

    @Test
    public void validLoginTest() throws InterruptedException{
        FormAuthPage formAuthPage = new FormAuthPage(driver);

        Thread.sleep(2000);
        formAuthPage.validLogin("tomsmith", "SuperSecretPassword!");
        Thread.sleep(2000);

        String flashText = formAuthPage.getFlashMessage();
        System.out.println("Flash message: " + flashText);

        Thread.sleep(1000);
        Assert.assertTrue("Flash message does not indicate successful login.",
                flashText.contains("You logged into a secure area!"));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
