package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.FileDownloadPage;
import utils.DriverFactory;

import java.io.File;
import java.time.Duration;
import java.time.Instant;

public class FileDownloadTest {

    private WebDriver driver;
    private String downloadPath;

    @Before
    public void setUp() throws InterruptedException {

        String browser = System.getProperty("browser", "chrome");
        driver = DriverFactory.getDriver(browser);
        driver.manage().window().maximize();

        driver.get("http://the-internet.herokuapp.com/download");

        downloadPath = System.getProperty("user.home") + "/Downloads";

        File downloadedFile = new File(downloadPath, "img.png");
        if (downloadedFile.exists()) {
            downloadedFile.delete();
        }

        Thread.sleep(2000);
    }

    @Test
    public void fileDownloadTest() throws InterruptedException {
        FileDownloadPage fileDownloadPage = new FileDownloadPage(driver);

        fileDownloadPage.clickProfileImage();

        Thread.sleep(5000);

        File downloadedFile = new File(downloadPath, "img.png");
        Instant start = Instant.now();
        while (!downloadedFile.exists() && Duration.between(start, Instant.now()).getSeconds() < 10) {
            Thread.sleep(1000);
        }

        System.out.println("Downloaded file: " + downloadedFile.getAbsolutePath());

        Assert.assertTrue("The downloaded file ProfileImage.png does not exist in the download folder.", downloadedFile.exists());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
