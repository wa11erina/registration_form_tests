package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successTest() {
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Robert");
        $("#lastName").setValue("Porter");
        $("#userEmail").setValue("prot@kpax.com");
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue("6102458201");
        $("#dateOfBirthInput").click();
        $(byText("June")).click();
        $(byText("1987")).click();
        $("div.react-datepicker__day--001").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("[for=hobbies-checkbox-2]").click();
        $("[for=hobbies-checkbox-3]").click();
        $("#uploadPicture").uploadFile(new File("D:\\Pictures\\Different\\prot.jpg"));
        $("#currentAddress").setValue("K-PAX, Lyra constellation");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();



        $("#firstName").shouldHave(value("Robert"));
        $("#lastName").shouldHave(value("Porter"));
        $("#userEmail").shouldHave(value("prot@kpax.com"));
        $("[for=gender-radio-1]").shouldHave(text("Male"));
        $("#userNumber").shouldHave(value("6102458201"));
        $("#dateOfBirthInput").shouldHave(value("01 Jun 1987"));
        $("#subjectsContainer").shouldHave(text("Computer Science"));
        $("[for=hobbies-checkbox-2]").shouldHave(text("Reading"));
        $("[for=hobbies-checkbox-3]").shouldHave(text("Music"));
        $("#currentAddress").shouldHave(value("K-PAX, Lyra constellation"));
        $("#state").shouldHave(text("NCR"));
        $("#city").shouldHave(text("Delhi"));
        $(".modal-content").shouldHave(text("Thanks for submitting the form"));


    }

}
