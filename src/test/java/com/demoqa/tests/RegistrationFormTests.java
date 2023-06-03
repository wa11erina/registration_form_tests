package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;

    }

    @Test
    void successTest() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        $("#firstName").setValue("Robert");
        $("#lastName").setValue("Porter");
        $("#userEmail").setValue("prot@kpax.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("6102458201");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("1987");
        $("div.react-datepicker__day--001:not(.react-datepicker__day--outside-month").click();
        $("#subjectsInput").setValue("c");
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("prot.jpg");
        $("#currentAddress").setValue("K-PAX, Lyra constellation");
        $("#stateCity-wrapper").$("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#stateCity-wrapper").$("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();


        $(".modal-content").should(appear);
        $(".modal-content").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Robert Porter"));
        $(".table-responsive").shouldHave(text("prot@kpax.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("6102458201"));
        $(".table-responsive").shouldHave(text("01 June,1987"));
        $(".table-responsive").shouldHave(text("Computer Science"));
        $(".table-responsive").shouldHave(text("Reading, Music"));
        $(".table-responsive").shouldHave(text("prot.jpg"));
        $(".table-responsive").shouldHave(text("K-PAX, Lyra constellation"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));

    }

}
