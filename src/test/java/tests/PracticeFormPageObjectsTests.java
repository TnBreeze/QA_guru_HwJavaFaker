package tests;

import org.junit.jupiter.api.Test;
import page.RegistrationPage;
import utils.RandomUtils;


public class PracticeFormPageObjectsTests extends TestBase {

    private final RegistrationPage registrationPage = new RegistrationPage();
    private final RandomUtils randomUtils = new RandomUtils();

    @Test
    void successRegistrationTest() {
        String firstName = randomUtils.firstName();
        String lastName = randomUtils.lastName();
        String userEmail = randomUtils.email();
        String gender = randomUtils.gender();
        String userNumber = randomUtils.userNumber();
        String dayOfBirth = randomUtils.dayOfBirth();
        String monthOfBirth = randomUtils.monthOfBirth();
        String yearOfBirth = randomUtils.yearOfBirth();
        String subjects = randomUtils.subjects();
        String hobbies = randomUtils.hobbies();
        String pictureName = randomUtils.pictureName();
        String currentAddress = randomUtils.currentAddress();
        String state = randomUtils.state();
        String city = randomUtils.city(state);


        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setPicture(pictureName)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickSubmit();

        registrationPage
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", subjects)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", pictureName)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    void successRegistrationRequiredFieldsTest() {
        String firstName = randomUtils.firstName();
        String lastName = randomUtils.lastName();
        String gender = randomUtils.gender();
        String userNumber = randomUtils.userNumber();

        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(userNumber)
                .clickSubmit();

        registrationPage
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber);
    }

    @Test
    void negativeRegistrationTest() {
        registrationPage.openPage().removeBanner().clickSubmit();

        registrationPage.negativeCheck();
    }
}