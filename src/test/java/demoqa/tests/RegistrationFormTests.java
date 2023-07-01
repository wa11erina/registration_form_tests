package demoqa.tests;

import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests extends TestBase{

    @Test
    void successfulRegistrationTest() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

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


        $(".modal-content").should(appear)
                .shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Robert Porter"),
                text("prot@kpax.com"), text("Male"), text("1234567890"),
                text("01 June,1987"), text("Computer Science"),
                text("Reading, Music"), text("prot.jpg"),
                text("K-PAX, Lyra constellation"), text("NCR Delhi"));

    }
}
