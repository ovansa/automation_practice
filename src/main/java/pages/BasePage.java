package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private WebDriver driver;

    public static final long WAIT = 20;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForVisibility(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void clearText(By element) {
        waitForVisibility(element);
        driver.findElement(element).clear();
    }

    public void click(By element) {
        waitForVisibility(element);
        driver.findElement(element).click();
    }

    public void setText(By element, String text) {
        waitForVisibility(element);
        clearText(element);
        driver.findElement(element).sendKeys(text);
    }

    public String getText(By element) {
        waitForVisibility(element);
        return driver.findElement(element).getText();
    }

    public String getTextFieldValue(By element) {
        waitForVisibility(element);
        return driver.findElement(element).getAttribute("value");
    }
}
