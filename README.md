# Automation Practice

# Project Title

This Project aims to test the UI of the website `http://automationpractice.com/index.php` and the APIs using `https://reqres.in`.

The test automation is implemented using Java, Selenium, TestNG, Rest Assured, and Allure Reporting.




## Test Cases - Web UI

#### Create Account and Sign Out

| Test Case | Steps     | Status                |
| :-------- | :------- | :------------------------- |
| Should return valid error on sign up with existing email  | 1. Visit website. 2. Click on sign in. 3. Enter an existing email in to the create account field | Pass |

#### Login

| Test Case | Steps     | Status                |
| :-------- | :------- | :-------------------------------- |
| Should login successfully with valid email and password      | 1. Visit website. 2. Click on sign in. 3. Enter valid email and password in login section. 4. User is granted access | Pass |
| Should display a valid error on enter email and password that do not exist      | 1. Visit website. 2. Click on sign in. 3. Enter email and password that do not exist. 4. An unauthorized error is displayed | Pass |

## Test Cases - APIs

#### Get all Users

| Test Case | Steps     | Status                |
| :-------- | :------- | :-------------------------------- |
| Should return a valid status code      | 1. Query url - `https://reqres.in` 2. Verify status code return is 200. | Pass |
| Should return a valid number of users with default url      | 1. Query url - `https://reqres.in` 2. Verify the size of the user data is 6  | Pass |

#### Add User

| Test Case | Steps     | Status                |
| :-------- | :------- | :-------------------------------- |
| Should return a valid status code on create user      | 1. Query url - `https://reqres.in` 2. Verify status code return is 201. | Pass |
| Should return a name in response same as used in request      | 1. Query url - `https://reqres.in` 2. Verify the size of the data returned is same as request  | Pass |


## Installation

This project code assumes an IDE e.g IntelliJ IDEA is used. The project dependencies is managed using Maven and preconfigured with the required dependencies.

- Clone the project to your local machine.
- Install maven dependencies.
- Ensure Java version is greater then 8.
- Run the project using the TestNG xml file
