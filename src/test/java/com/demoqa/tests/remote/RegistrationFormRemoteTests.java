package com.demoqa.tests.remote;

import org.junit.jupiter.api.Test;
import com.demoqa.tests.remote.RemoteTestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class RegistrationFormRemoteTests extends RemoteTestBase {

    @Test
    @Tag("remote")
    @Tag("property")
    @DisplayName("Successful registration")
    void successfulRegistrationTest() {

        step ("Open demoqa Registration Form page", () -> {
            open(baseUrl + "/automation-practice-form");
            $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");
        });
        step ("Fill out the form", () -> {
            $("#firstName").setValue("Robert");
            $("#lastName").setValue("Porter");
            $("#userEmail").setValue("prot@kpax.com");
            $("#genterWrapper").$(byText("Male")).click();
            $("#userNumber").setValue("1234567890");
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
        });
        step ("Verify results", () -> {
            $(".modal-content").should(appear)
                    .shouldHave(text("Thanks for submitting the form"));
            $(".table-responsive").shouldHave(text("Robert Porter"),
                    text("prot@kpax.com"), text("Male"), text("1234567890"),
                    text("01 June,1987"), text("Computer Science"),
                    text("Reading, Music"), text("prot.jpg"),
                    text("K-PAX, Lyra constellation"), text("NCR Delhi"));
        });
    }
}
