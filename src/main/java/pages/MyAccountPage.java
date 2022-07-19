package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage {
    private WebDriver driver;

    private By myAccountHeader = By.cssSelector(".page-heading");
    private By userHeaderInfo = By.cssSelector(".header_user_info");
    private By signOutButton = By.linkText("Sign out");

    public MyAccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getAccountHeader() {
        return getText(myAccountHeader);
    }

    public String getUserHeaderInfo() {
        return getText(userHeaderInfo);
    }

    public HomePage clickSignOutButton () {
        click(signOutButton);
        return new HomePage(driver);
    }
}
