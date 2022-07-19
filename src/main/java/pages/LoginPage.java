package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private WebDriver driver;

    private By emailRegisterField = By.id("email_create");
    private By emailLoginField = By.id("email");
    private By passwordField = By.id("passwd");

    private By createAccountSubmitButton = By.id("SubmitCreate");
    private By signInAccountSubmitButton = By.id("SubmitLogin");

    private By errorStatusMessage = By.cssSelector(".alert-danger");
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void setRegisterEmail(String registerEmail) {
        setText(emailRegisterField, registerEmail);
    }

    public void setLoginEmail(String loginEmail) {
        setText(emailLoginField, loginEmail);
    }

    public void setPasswordField(String password) {
        setText(passwordField, password);
    }

    public CreateAccountPage clickCreateAccountButton() {
        click(createAccountSubmitButton);
        return new CreateAccountPage(driver);
    }

    public MyAccountPage clickSignInButton() {
        click(signInAccountSubmitButton);
        return new MyAccountPage(driver);
    }

    public String getErrorStatusMessage() {
        return getText(errorStatusMessage);
    }
}
