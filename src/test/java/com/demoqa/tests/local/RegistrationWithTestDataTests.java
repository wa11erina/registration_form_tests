package com.demoqa.tests.local;

import com.demoqa.tests.local.TestBase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.demoqa.tests.TestData.*;
import static io.qameta.allure.Allure.step;

public class RegistrationWithTestDataTests extends TestBase {

    @Test
    void successfulRegistrationTest() {

        step ("Open demoqa Registration Form page", () -> {
            open(baseUrl + "/automation-practice-form");
            $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");
        });
        step ("Fill out the form", () -> {
            $("#firstName").setValue(firstName);
            $("#lastName").setValue(lastName);
            $("#userEmail").setValue(userEmail);
            $("#genterWrapper").$(byText(userGender1)).click();
            $("#userNumber").setValue(userPhoneNumber);
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOption(userBirthMonth);
            $(".react-datepicker__year-select").selectOption(userBirthYear);
            $("div.react-datepicker__day--001:not(.react-datepicker__day--outside-month").click();
            $("#subjectsInput").setValue(subjectFirstLetter);
            $("#subjectsInput").setValue(userSubject).pressEnter();
            $("#hobbiesWrapper").$(byText(hobby2)).click();
            $("#hobbiesWrapper").$(byText(hobby3)).click();
            $("#uploadPicture").uploadFromClasspath(userImg);
            $("#currentAddress").setValue(userCurrentAddress);
            $("#stateCity-wrapper").$("#state").click();
            $("#stateCity-wrapper").$(byText(userState)).click();
            $("#stateCity-wrapper").$("#city").click();
            $("#stateCity-wrapper").$(byText(userCity)).click();
            $("#submit").click();
        });
        step ("Verify results", () -> {
            $(".modal-content").should(appear)
                    .shouldHave(text("Thanks for submitting the form"));
            $(".table-responsive").shouldHave(text(firstName + " " + lastName),
                    text(userEmail), text(userGender1), text(userPhoneNumber),
                    text(userBirthDay + " " + userBirthMonth + "," + userBirthYear), text(userSubject),
                    text(hobby2 + "," + " " + hobby3), text(imgTitle),
                    text(userCurrentAddress), text(userState + " " + userCity));
        });
    }
}
