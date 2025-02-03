package pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InfiniteScrollPage {

    private WebDriver driver;

    private By contentLocator = By.cssSelector("div.jscroll-added");

    public InfiniteScrollPage(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public int getContentCount() {
        List<WebElement> elements = driver.findElements(contentLocator);
        return elements.size();
    }

    public void waitForContentCountToIncrease(final int previousCount, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(d -> getContentCount() > previousCount);
    }
}
