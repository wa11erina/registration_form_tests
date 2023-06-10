package com.demoqa.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.demoqa.tests.TestData.*;


public class RegistrationWithTestDataTests extends TestBase{

//    String firstName, lastName, userEmail, userGender,
//            userPhoneNumber, userBirthMonth, userBirthYear,
//            subjectFirstLetter, subjectChosen, currentAddress;

//    @BeforeEach
//    void prepareTestData() {
//
//    String firstName = "Robert";
//            lastName = "Porter";
//            userEmail = "prot@kpax.com";
//            userGender = "Male";
//            userPhoneNumber = "1234567890";
//            userBirthMonth = "June";
//            userBirthYear = "1987";
//            subjectFirstLetter = "c";
//            subjectChosen = "Computer Science";
//            currentAddress = "K-PAX, Lyra constellation";
//    }
    @Test
    void successfulRegistrationTest() {


        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(userGender)).click();
        $("#userNumber").setValue(userPhoneNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(userBirthMonth);
        $(".react-datepicker__year-select").selectOption(userBirthYear);
        $("div.react-datepicker__day--001:not(.react-datepicker__day--outside-month").click();
        $("#subjectsInput").setValue(subjectFirstLetter);
        $("#subjectsInput").setValue(subjectChosen).pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("img/prot.jpg");
        $("#currentAddress").setValue(currentAddress);
        $("#stateCity-wrapper").$("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#stateCity-wrapper").$("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();


        $(".modal-content").should(appear)
                .shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName + " " + lastName),
                text(userEmail), text(userGender), text(userPhoneNumber),
                text("01" + " " + userBirthMonth + "," + userBirthYear), text(subjectChosen),
                text("Reading, Music"), text("prot.jpg"),
                text(currentAddress), text("NCR Delhi"));

    }
}
