package com.demoqa.tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormPageObjectsTests extends TestBase{
    RegistrationPage registrationPage = new RegistrationPage();
    
    @Test
    void successfulRegistrationTest() {

        registrationPage.openPage()
                        .setFirstName("Robert")
                        .setLastName("Porter")
                        .setEmail("prot@kpax.com")
                        .setGender("Male")
                        .setUserNumber("1234567890")
                        .setBirthdate("1", "June", "1987")
                        .setUserSubjects("c", "Computer Science")
                        .setHobbies("Reading")
                        .setHobbies("Music")
                        .uploadPicture("img/prot.jpg")
                        .setCurrentAddress("K-PAX, Lyra constellation")
                        .setUserState("NCR")
                        .setUserCity("Delhi")
                        .pushSubmitButton();

         registrationPage
                        .verifyResults("Student Name", "Robert Porter")
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
