package com.demoqa.tests.remote;

import com.demoqa.pages.RegistrationPage;
import com.demoqa.tests.remote.RemoteTestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class RegistrationFormPageObjectsRemoteTests extends RemoteTestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Tag("remote")
    @DisplayName("Successful registration with POM method")
    void successfulRegistrationTest() {

        // Filling out Registration Form
        registrationPage.openPage()
                .closeAds()
                .setFirstName("Robert")
                .setLastName("Porter")
                .setEmail("prot@kpax.com")
                .setGender("Male")
                .setUserNumber("1234567890")
                .setBirthdate("01", "June", "1987")
                .setUserSubjects("Computer Science")
                .setHobbies("Reading")
                .setHobbies("Music")
                .uploadPicture("prot.jpg")
                .setCurrentAddress("K-PAX, Lyra constellation")
                .setUserState("NCR")
                .setUserCity("Delhi")
                .pushSubmitButton()
                .checkCompletedForm();
        // Verifying values
        registrationPage.verifyResults("Student Name", "Robert Porter")
                .verifyResults("Student Email", "prot@kpax.com")
                .verifyResults("Gender", "Male")
                .verifyResults("Mobile", "1234567890")
                .verifyResults("Date of Birth", "01 June,1987")
                .verifyResults("Subjects", "Computer Science")
                .verifyResults("Hobbies", "Reading, Music")
                .verifyResults("Picture", "prot.jpg")
                .verifyResults("Address", "K-PAX, Lyra constellation")
                .verifyResults("State and City", "NCR Delhi");
    }

}
