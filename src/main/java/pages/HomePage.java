package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private WebDriver driver;
    private By signInLink = By.linkText("Sign in");

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public LoginPage clickSignInLink() {
        click(signInLink);
        return new LoginPage(driver);
    }
}
