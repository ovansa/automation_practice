package register;

import base.BaseTests;
import com.github.javafaker.Faker;
import data.Account;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;

import java.util.Locale;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RegisterTests extends BaseTests {
    @Test
    public void testRegister() {
        Faker faker = new Faker(new Locale("nl-NL"));
        double emailSuffix = Math.random() * 3000;
        String randomEmail = faker.address().firstName() + emailSuffix + "@gmail.com";
        LoginPage loginPage = homePage.clickSignInLink();

        loginPage.setRegisterEmail(randomEmail);
        CreateAccountPage createAccountPage = loginPage.clickCreateAccountButton();

        createAccountPage.setMaleGender();
        createAccountPage.setFirstName("Ali");
        createAccountPage.setLastName("Mansur");
        createAccountPage.setPassword("password");
        createAccountPage.setDate("14", "6", "1980");

        createAccountPage.setAddress("Block 120, Flat 6");
        createAccountPage.setCity("Laos");
        createAccountPage.setState("1");
        createAccountPage.setPostCode("10001");
        createAccountPage.setCountry("21");
        createAccountPage.setMobilePhoneNumber("09022334432");
        createAccountPage.setAliasAddress("My Big House");

        MyAccountPage myAccountPage = createAccountPage.clickRegisterButton();

        assertEquals(myAccountPage.getAccountHeader(), "MY ACCOUNT");
        assertEquals(myAccountPage.getUserHeaderInfo(), "Ali Mansur");

        HomePage home = myAccountPage.clickSignOutButton();
    }

    @Test
    public void testPrefillFirstNameInAddressFirstName() {
        Faker faker = new Faker(new Locale("nl-NL"));
        double emailSuffix = Math.random() * 3000;
        String randomEmail = faker.address().firstName() + emailSuffix + "@gmail.com";

        LoginPage loginPage = homePage.clickSignInLink();

        loginPage.setRegisterEmail(randomEmail);
        CreateAccountPage createAccountPage = loginPage.clickCreateAccountButton();

        createAccountPage.setFirstName("Ali");
        assertEquals(createAccountPage.getAddressFirstNameFieldText(), "Ali");
    }

    @Test
    public void testPrefillLastNameInAddressLastName() {
        Faker faker = new Faker(new Locale("nl-NL"));
        double emailSuffix = Math.random() * 3000;
        String randomEmail = faker.address().firstName() + emailSuffix + "@gmail.com";

        LoginPage loginPage = homePage.clickSignInLink();

        loginPage.setRegisterEmail(randomEmail);
        CreateAccountPage createAccountPage = loginPage.clickCreateAccountButton();

        createAccountPage.setLastName("Mansur");
        assertEquals(createAccountPage.getAddressLastNameFieldText(), "Mansur");
    }

    @Test
    public void testRegisterWithExistingEmail() {
        String existingEmail = "ovansa.im@gmail.com";

        LoginPage loginPage = homePage.clickSignInLink();

        loginPage.setRegisterEmail(existingEmail);
        CreateAccountPage createAccountPage = loginPage.clickCreateAccountButton();

        assertTrue(loginPage.getErrorStatusMessage().contains("An account using this email address has already been registered."));
    }
}
