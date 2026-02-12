package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    private static final int TIMEOUT = 10;

    public BasePage() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }

    protected void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void type(By locator, String text) {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        return  wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator))
                .getText();
    }

    protected boolean isDisplayed(By locator) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator))
                .isDisplayed();
    }

    protected void switchToFrame(By locator) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }

    protected void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
}
