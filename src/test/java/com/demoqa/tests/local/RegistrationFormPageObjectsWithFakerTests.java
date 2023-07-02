package com.demoqa.tests.local;

import com.demoqa.tests.local.TestBase;
import com.demoqa.utils.RandomUtils;
import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class RegistrationFormPageObjectsWithFakerTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    
    @Test
    void successfulRegistrationTest() {

        // Faker test data
        String userFirstName = faker.name().firstName(),
                userLastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                userGender = RandomUtils.getRandomFakerGender(),
                userPhone = faker.phoneNumber().subscriberNumber(10),
                userBirthMonth = RandomUtils.getRandomFakerMonth(),
                userBirthYear = String.valueOf(RandomUtils.getRandomInt(1900, 2023)),
                userBirthDay = String.format("%02d", faker.number().numberBetween(1, 28)),
                userSubject = RandomUtils.getRandomFakerSubject(),
                userHobby = RandomUtils.getRandomFakerHobby(),
                userPicture = "prot.jpg",
                userCurrentAddress = faker.address().fullAddress(),
                userState = RandomUtils.getRandomFakerUserState(),
                userCity = RandomUtils.getRandomFakerUserCity(userState);

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
