package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class FileDownloadPage {

    private WebDriver driver;

    private By profileImageLink = By.linkText("img.png");

    public FileDownloadPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickProfileImage() {
        WebElement link = WaitUtils.waitForVisibility(driver, profileImageLink);
        link.click();
    }
}
