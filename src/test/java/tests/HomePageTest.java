package tests;

import pages.HomePage;
import utils.DriverFactory; // Provjeri da li je DriverFactory na odgovarajućem mjestu i s odgovarajućim paketom
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class HomePageTest {

    private WebDriver driver;

    @Before
    public void setUp() {

        String browser = System.getProperty("browser", "chrome");
        driver = DriverFactory.getDriver(browser);
        driver.manage().window().maximize();
    }

    @Test
    public void homePageLoadTest() {

        driver.get("http://the-internet.herokuapp.com/");


        HomePage homePage = new HomePage(driver);
        Assert.assertTrue("Home page did not load correctly.", homePage.isPageLoaded());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
