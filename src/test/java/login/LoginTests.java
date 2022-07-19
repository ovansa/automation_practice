package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyAccountPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {

    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage = homePage.clickSignInLink();

        loginPage.setLoginEmail("ovansa.im@gmail.com");
        loginPage.setPasswordField("password");
        MyAccountPage myAccountPage = loginPage.clickSignInButton();

        assertEquals(myAccountPage.getAccountHeader(), "MY ACCOUNT");
    }

    @Test
    public void testInvalidLogin() {
        LoginPage loginPage = homePage.clickSignInLink();

        loginPage.setLoginEmail("ovansa@gmail.com");
        loginPage.setPasswordField("password");
        MyAccountPage myAccountPage = loginPage.clickSignInButton();

        assertTrue(loginPage.getErrorStatusMessage().contains("Authentication failed"));
    }
}
