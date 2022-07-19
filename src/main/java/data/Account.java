package data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class Account {
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String company;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private String mobilePhone;
    private String addressAlias;

    public Account() {

    }

    public Account(String firstName, String lastName, String email, String address,
                   String company, String city, String state, String zipCode, String country,
                   String mobilePhone, String addressAlias) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.company = company;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
        this.mobilePhone = mobilePhone;
        this.addressAlias = addressAlias;
    }

    public Account generateUserDetails () {
        Faker faker = new Faker(new Locale("nl-NL"));

        String firstName = faker.address().firstName();
        String lastName = faker.address().lastName();
        String email = faker.address().firstName() + "@gmail.com";
        String address = faker.address().fullAddress();
        String company = faker.address().lastName() + " Company";
        String city = faker.address().city();
        String state = faker.address().state();
        String zipCode = faker.address().zipCode();
        String mobilePhone = "09099009909";
        String addressAlias = faker.address().streetAddress();
        String country = faker.address().country();

//        Account userAccount = new Account(firstName, lastName, email, address, company, city, state,
//                zipCode, country, mobilePhone, addressAlias);
        Account userAccount =new Account();
        userAccount.firstName = firstName;
        userAccount.lastName = lastName;
        userAccount.email = email;
        userAccount.address = address;
        userAccount.company = company;
        userAccount.city = city;
        userAccount.state = state;
        userAccount.zipCode = zipCode;
        userAccount.mobilePhone = mobilePhone;
        userAccount.addressAlias = addressAlias;
        userAccount.country = country;

        return userAccount;
    }
}
