package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage extends BasePage {
    private WebDriver driver;

    private By createAccountPageHeader = By.cssSelector(".page-heading");
    private By createAccountPageSubHeader = By.cssSelector(".page-subheading");
    private By radioSelectGenderMr = By.id("id_gender1");
    private By radioSelectGenderMrs = By.id("id_gender2");
    private By firstNameTextField = By.id("customer_firstname");
    private By lastNameTextField = By.id("customer_lastname");
    private By emailTextField = By.id("email");
    private By passwordTextfield = By.id("passwd");
    private By dayDateSelect = By.id("days");
    private By monthDateSelect = By.id("months");
    private By yearDateSelect = By.id("years");
    private By addressFirstNameField = By.id("firstname");
    private By addressLastNameField = By.id("lastname");
    private By addressCompanyNameField = By.id("company");
    private By addressField = By.id("address1");
    private By cityField = By.id("city");
    private By stateField = By.id("id_state");
    private By postCodeField = By.id("postcode");
    private By countryField = By.id("id_country");
    private By mobilePhoneTextField = By.id("phone_mobile");
    private By aliasAddressTextField = By.id("alias");
    private By registerButton = By.id("submitAccount");


    public CreateAccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void setMaleGender() {
        click(radioSelectGenderMr);
    }

    public void setFemaleGender() {
        click(radioSelectGenderMrs);
    }

    public String getAccountHeader() {
        return getText(createAccountPageHeader);
    }

    public String getAccountSubHeader() {
        return getText(createAccountPageSubHeader);
    }

    public String getAddressFirstNameFieldText() {
        return getTextFieldValue(addressFirstNameField);
    };

    public String getAddressLastNameFieldText() {
        return getTextFieldValue(addressLastNameField);
    };

    public String getEmailFieldText() {
        return getTextFieldValue(emailTextField);
    };

    public void setFirstName(String firstName) {
        setText(firstNameTextField, firstName);
    }

    public void setLastName(String lastName) {
        setText(lastNameTextField, lastName);
    }


    public void setEmail(String email) {
        setText(emailTextField, email);
    }
    public void setPassword(String password) {
        setText(passwordTextfield, password);
    }

    public void setDate(String day, String month, String year) {
        findDropDownElement(dayDateSelect).selectByValue(day);
        findDropDownElement(monthDateSelect).selectByValue(month);
        findDropDownElement(yearDateSelect).selectByValue(year);
    }


    public void setAddress(String address) {
        setText(addressField, address);
    }


    public void setCity(String city) {
        setText(cityField, city);
    }


    public void setState(String state) {
        findDropDownElement(stateField).selectByValue(state);
    }


    public void setPostCode(String postcode) {
        setText(postCodeField, postcode);
    }


    public void setCountry(String country) {
        findDropDownElement(countryField).selectByValue(country);
    }


    public void setMobilePhoneNumber(String phoneNumber) {
        setText(mobilePhoneTextField, phoneNumber);
    }

    public MyAccountPage clickRegisterButton() {
        click(registerButton);
        return new MyAccountPage(driver);
    }

    public void setAliasAddress(String aliasAddress) {
        clearText(aliasAddressTextField);
        setText(aliasAddressTextField, aliasAddress);
    }

    private Select findDropDownElement(By element) {
        return new Select(driver.findElement(element));
    }
}
