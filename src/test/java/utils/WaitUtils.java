package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitUtils {

    public static final int DEFAULT_TIMEOUT = 10; // Timeout u sekundama

    public static WebElement waitForVisibility(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForVisibility(WebDriver driver, By locator) {
        return waitForVisibility(driver, locator, DEFAULT_TIMEOUT);
    }

    public static WebElement waitForElementToBeClickable(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitForElementToBeClickable(WebDriver driver, By locator) {
        return waitForElementToBeClickable(driver, locator, DEFAULT_TIMEOUT);
    }

    public static boolean waitForTitleToContain(WebDriver driver, String titleFraction, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.titleContains(titleFraction));
    }

    public static boolean waitForTitleToContain(WebDriver driver, String titleFraction) {
        return waitForTitleToContain(driver, titleFraction, DEFAULT_TIMEOUT);
    }
}
