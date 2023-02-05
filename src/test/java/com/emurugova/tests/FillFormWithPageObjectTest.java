package com.emurugova.tests;

import com.emurugova.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static com.emurugova.tests.TestData.*;
import static io.qameta.allure.Allure.step;

public class FillFormWithPageObjectTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {
        step("Open students registration form", () -> {
            registrationPage.openPage();
        });
        step("Fill the form", () -> {
            registrationPage.typeFirstName(firstName)
                    .typeLastName(lastName)
                    .typeUserEmail(userEmail)
                    .selectGender()
                    .typeUserNumber(TestData.userNumber);
        });
        step("Set the birth date", () -> {
            registrationPage.setDate(TestData.day, TestData.month, TestData.year);
        });
        step("Set the subject", () -> {
            registrationPage.selectSubject(TestData.subject);
        });
        step("Set the hobby", () -> {
            registrationPage.selectHobby();
        });
        step("Upload the picture", () -> {
            registrationPage.loadFile(TestData.userDirectory);
        });
        step("Set the address", () -> {
            registrationPage.typeCurrentAddress(currentAddress)
                    .scrollPage()
                    .scrollPage()
                    .scrollPage()
                    .selectState(TestData.state)
                    .selectCity(TestData.city);
        });
        step("Submit the form", () -> {
            registrationPage.callTheFinalForm();
        });

        step("Check the form", () -> {
            registrationPage.checkFinalFormTitle(TestData.finalFormTitle);
            registrationPage.checkStudentName(firstName,lastName)
                    .checkUserEmail(userEmail)
                    .checkUserGender(TestData.userGender)
                    .checkUserNumber(TestData.userNumber)
                    .checkUserDate(TestData.day, TestData.month, TestData.year)
                    .checkUserSubject(TestData.subject)
                    .checkUserHobby(TestData.userHobby)
                    .checkLoadedFile(TestData.userFile)
                    .checkCurrentAddress(currentAddress)
                    .checkStateAndCity(TestData.state, TestData.city);
        });
    }
}

