package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import com.github.javafaker.Faker;
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
                userGender = getRandomFakerGender(),
                userPhone = faker.phoneNumber().subscriberNumber(10),
                userBirthMonth = getRandomFakerMonth(),
                userBirthYear = String.valueOf(getRandomInt(1900, 2023)),
                userBirthDay = String.format("%02d", faker.number().numberBetween(1, 28)),
                userSubject = getRandomFakerSubject(),
                userHobby = getRandomFakerHobby(),
                userPicture = "prot.jpg",
                userCurrentAddress = faker.address().fullAddress(),
                userState = getRandomFakerUserState(),
                userCity = getRandomFakerUserCity(userState);

        // Filling out Registration Form
        registrationPage.openPage()
                        .closeAds()
                        .setFirstName(userFirstName)
                        .setLastName(userLastName)
                        .setEmail(userEmail)
                        .setGender(userGender)
                        .setUserNumber(userPhone)
                        .setBirthdate(userBirthDay, userBirthMonth, userBirthYear)
                        .setUserSubjects(userSubject)
                        .setHobbies(userHobby)
                        .uploadPicture(userPicture)
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
                        .verifyResults("Date of Birth", userBirthDay + " " + " " + userBirthMonth + "," + userBirthYear)
                        .verifyResults("Subjects", userSubject)
                        .verifyResults("Hobbies", userHobby)
                        .verifyResults("Picture", userPicture)
                        .verifyResults("Address", userCurrentAddress)
                        .verifyResults("State and City", userState + " " + userCity);

    }

}
