package com.emurugova.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final String FORM_TITLE = "Student Registration Form";
    private SelenideElement
            formTitle =  $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userGenderButton = $("#gender-radio-1"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            monthField = $(".react-datepicker__month-select"),
            yearField =  $(".react-datepicker__year-select"),
            subjectField = $("#subjectsInput"),
            hobbyButton = $("#hobbies-checkbox-3"),
            uploadFileButton = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            scrollPageFunction = $("div"),
            stateCityField = $("#stateCity-wrapper"),
            finalFormTitlefield = $("#example-modal-sizes-title-lg"),
            formField = $(".table-responsive"),
            closeButton = $("#closeLargeModal");

    //МЕТОДЫ по заполнению формы
    public void openPage(){
        open("/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
    }

    public RegistrationPage typeFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeUserEmail (String value){
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage selectGender (){
        userGenderButton.parent().click();
        return this;
    }

    public RegistrationPage typeUserNumber (String value){
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDate(String day, String month, String year){
        dateOfBirthInput.click();
        monthField.selectOption(month);
        yearField.selectOption(year);
        $(".react-datepicker__day--0" + day).click();
        return this;
    }

    public RegistrationPage selectSubject (String value){
        subjectField.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage selectHobby (){
        hobbyButton.parent().click();
        return this;
    }

    public RegistrationPage loadFile (String value){
        uploadFileButton.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage typeCurrentAddress (String value){
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage selectState (String value){
        $("#state").click();
        stateCityField.$(byText(value)).click();
        return this;
    }

    public RegistrationPage selectCity (String value){
        $("#city").click();
        stateCityField.$(byText(value)).click();
        return this;
    }

    public RegistrationPage scrollPage (){
        scrollPageFunction.scrollTo();
        return this;
    }

    public RegistrationPage callTheFinalForm (){
        lastNameInput.pressEnter();
        return this;
    }

    //МЕТОДЫ по проверке формы
    public RegistrationPage checkFinalFormTitle (String value){
        finalFormTitlefield.shouldHave(text(value));
        return this;
    }
    public RegistrationPage checkStudentName (String firstName, String lastName){
        formField.shouldHave(text(firstName +" "+ lastName));
        return this;
    }

    public RegistrationPage checkUserEmail (String value){
        formField.shouldHave(text(value));
        return this;
    }

    public RegistrationPage checkUserGender (String value){
        formField.shouldHave(text(value));
        return this;
    }

    public RegistrationPage checkUserNumber (String value){
        formField.shouldHave(text(value));
        return this;
    }

    public RegistrationPage checkUserDate (String day, String month, String year){
        formField.shouldHave(text(day + " " + month + "," + year));
        return this;
    }

    public RegistrationPage checkUserSubject (String value){
        formField.shouldHave(text(value));
        return this;
    }

    public RegistrationPage checkUserHobby (String value){
        formField.shouldHave(text(value));
        return this;
    }

    public RegistrationPage checkLoadedFile (String value){
        formField.shouldHave(text(value));
        return this;
    }

    public RegistrationPage checkCurrentAddress (String value){
        formField.shouldHave(text(value));
        return this;
    }

    public RegistrationPage checkStateAndCity (String state, String city){
        formField.shouldHave(text(state +" "+ city));
        return this;
    }

    public void closeTheForm (){
        closeButton.click();
    }
}
