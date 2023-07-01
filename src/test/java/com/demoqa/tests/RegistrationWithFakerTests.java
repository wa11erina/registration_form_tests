package com.demoqa.tests;

import com.demoqa.utils.RandomUtils;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationWithFakerTests extends TestBase{


    @Test
    void successfulRegistrationTest() {

        String userFirstName = RandomUtils.getRandomFakerFirstName(),
                userLastName = RandomUtils.getRandomFakerLastName(),
                userEmail = RandomUtils.getRandomFakerEmail(),
                userGender = RandomUtils.getRandomGender(),
                userPhoneNumber = RandomUtils.getRandomFakerPhone(),
                userBirthMonth = RandomUtils.getRandomMonth(),
                userBirthYear = String.valueOf(RandomUtils.getRandomInt(1900, 2023)),
                userSubject = RandomUtils.getRandomSubject(),
                userHobby = RandomUtils.getRandomHobby(),
                userCurrentAddress = RandomUtils.getRandomFakerAddress(),
                userState = RandomUtils.getRandomUserState(),
                userCity = RandomUtils.getRandomUserCity(userState);


        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue(userFirstName);
        $("#lastName").setValue(userLastName);
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
        $(".table-responsive").shouldHave(text(userFirstName + " " + userLastName),
                text(userEmail), text(userGender), text(userPhoneNumber),
                text("01" + " " + userBirthMonth + "," + userBirthYear), text(userSubject),
                text(userHobby), text("prot.jpg"),
                text(userCurrentAddress), text(userState + " " + userCity));

    }
}
