package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static com.demoqa.utils.RandomUtils.*;

public class RegistrationFormPageObjectsWithFakerTests extends TestBase{
    RegistrationPage registrationPage = new RegistrationPage();
    
    @Test
    void successfulRegistrationTest() {

        // Test data
        String userFirstName = faker.name().firstName(),
                userLastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                userGender = getRandomGender(),
                userPhone = faker.phoneNumber().subscriberNumber(10),
                userBirthMonth = getRandomMonth(),
                userBirthYear = String.valueOf(getRandomInt(1900, 2023)),
                userSubject = getRandomSubject(),
                userHobby = getRandomHobby(),
                userCurrentAddress = faker.address().fullAddress(),
                userState = getRandomUserState(),
                userCity = getRandomUserCity(userState);

        // Filling out Registration Form
        registrationPage.openPage()
                        .closeAds()
                        .setFirstName(userFirstName)
                        .setLastName(userLastName)
                        .setEmail(userEmail)
                        .setGender(userGender)
                        .setUserNumber(userPhone)
                        .setBirthdate("1", userBirthMonth, userBirthYear)
                        .setUserSubjects(userSubject)
                        .setHobbies(userHobby)
                        .uploadPicture("img/prot.jpg")
                        .setCurrentAddress(userCurrentAddress)
                        .setUserState(userState)
                        .setUserCity(userCity)
                        .pushSubmitButton()
                        .checkCompletedForm();
        // Verifying values
        registrationPage.verifyResults("Student Name", userFirstName + " " + userLastName)
                        .verifyResults("Student Email", userEmail)
                        .verifyResults("Gender", userGender)
                        .verifyResults("Mobile", userPhone)
                        .verifyResults("Date of Birth", "01" + " " + userBirthMonth + "," + userBirthYear)
                        .verifyResults("Subjects", userSubject)
                        .verifyResults("Hobbies", userHobby)
                        .verifyResults("Picture", "prot.jpg")
                        .verifyResults("Address", userCurrentAddress)
                        .verifyResults("State and City", userState + " " + userCity);

    }

}
