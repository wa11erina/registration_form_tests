package com.demoqa.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.demoqa.utils.RandomUtils.*;


public class RegistrationWithRandomUtilsTests extends TestBase{


    @Test
    void successfulRegistrationTest() {

        String firstName = getRandomString(10),
                lastName = getRandomString(10),
                userEmail = getRandomEmail(),
                userGender = getRandomGender(),
                userPhoneNumber = getRandomSimplePhone(),
                userBirthMonth = getRandomMonth(),
                userBirthYear = String.valueOf(getRandomInt(1900, 2023)),
                userSubject = getRandomSubject(),
                userHobby = getRandomHobby(),
                userCurrentAddress = getRandomStringWithNumbersAndSpaces(30),
                userState = getRandomUserState(),
                userCity = getRandomUserCity(userState);


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
        $("#subjectsInput").setValue(userSubject).pressEnter();
        $("#hobbiesWrapper").$(byText(userHobby)).click();
        $("#uploadPicture").uploadFromClasspath("prot.jpg");
        $("#currentAddress").setValue(userCurrentAddress);
        $("#stateCity-wrapper").$("#state").click();
        $("#stateCity-wrapper").$(byText(userState)).click();
        $("#stateCity-wrapper").$("#city").click();
        $("#stateCity-wrapper").$(byText(userCity)).click();
        $("#submit").click();


        $(".modal-content").should(appear)
                .shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName + " " + lastName),
                text(userEmail), text(userGender), text(userPhoneNumber),
                text("01" + " " + userBirthMonth + "," + userBirthYear), text(userSubject),
                text(userHobby), text("prot.jpg"),
                text(userCurrentAddress), text(userState + " " + userCity));

        }
    }
