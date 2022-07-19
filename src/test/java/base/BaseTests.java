package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import pages.HomePage;

import java.time.Duration;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
        driver = new FirefoxDriver();
        homePage = new HomePage(driver);
        driver.manage().deleteAllCookies();
        driver.get("http://automationpractice.com/index.php");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    public void waitForSeconds(long duration) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
    }
}
