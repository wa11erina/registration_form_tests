package demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import demoqa.pages.components.CalendarComponent;
import demoqa.pages.components.VerifyResultsComponent;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    VerifyResultsComponent verifyResultsComponent = new VerifyResultsComponent();
    SelenideElement
        firstNameInput = $("#firstName"),
        lastNameInput = $("#lastName"),
        userEmailInput = $("#userEmail"),
        userGenderChoice = $("#genterWrapper"),
        userNumberInput = $("#userNumber"),
        birthdateInput = $("#dateOfBirthInput"),
        userSubjectInput = $("#subjectsInput"),
        userHobbieChoice = $("#hobbiesWrapper"),
        userPictureUpload = $("#uploadPicture"),
        userCurrentAddress = $("#currentAddress"),
        stateCityChoice = $("#stateCity-wrapper"),
        userStateChoice = stateCityChoice.$("#state"),
        userCityChoice = stateCityChoice.$("#city"),
        submitButton = $("#submit"),
        completedForm = $(".modal-content");


    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }
    public RegistrationPage closeAds() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }
    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }
    public RegistrationPage setGender(String value) {
        userGenderChoice.$(byText(value)).click();

        return this;
    }
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }
    public RegistrationPage setBirthdate(String day, String month, String year) {
        birthdateInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }
    public RegistrationPage setUserSubjects(String value) {
        userSubjectInput.setValue(value).pressEnter();

        return this;
    }
    public RegistrationPage setHobbies(String value) {
        userHobbieChoice.$(byText(value)).click();

        return this;
    }
    public RegistrationPage uploadPicture(String fileName) {
        userPictureUpload.uploadFromClasspath(fileName);

        return this;
    }
    public RegistrationPage setCurrentAddress(String value) {
        userCurrentAddress.setValue(value);

        return this;
    }
    public RegistrationPage setUserState(String value) {
        userStateChoice.click();
        stateCityChoice.$(byText(value)).click();

        return this;
    }
    public RegistrationPage setUserCity(String value) {
        userCityChoice.click();
        stateCityChoice.$(byText(value)).click();

        return this;
    }
    public RegistrationPage pushSubmitButton() {
        submitButton.click();

        return this;
    }
    public RegistrationPage checkCompletedForm() {
        completedForm.should(appear);
        completedForm.shouldHave(text("Thanks for submitting the form"));

        return this;
    }
    public RegistrationPage verifyResults(String key, String value) {
        verifyResultsComponent.verifyTableResults(key, value);

        return this;
    }
}
