package Tests;

import Config.EnvConfig;
import Config.ReadProperties;
import Utils.BasePage;
import org.testng.annotations.Test;

public class loginTest extends BasePage {

    @Test
    public void verifyLoginPageIsLoadsSuccessfully(){
        common.logPrint("Verify login with valid credential");
        loginPage.loginToAppWithValidUserNamePass();
    }

    @Test
    public void verifyValidationMessageForEmailAndPassField(){
        common.logPrint("Verify that the validation message is showing for the email and pass");
        loginPage.verifyErrorMessageForBlankEmailPass();
    }

    @Test
    public void verifyAllElementsArePresentOnTheLoginPage(){
        common.logPrint("Verify that all the elements are showing on the login page");
        loginPage.verifyAllTheElementsOnTheLoginPage();
    }

    @Test
    public void verifyAllElementsArePresentOnTheForgotPassword(){
        common.logPrint("Verify that all the elements are showing on the forgot password page");
        loginPage.clickOnForgotPasswordButton();
        loginPage.verifyALlTheElementsOnForgotPassPage();
    }

    @Test
    public void verifyValidationMessageForBlankForgotPassEmail(){
        common.logPrint("Verify that validation message for forgot pass page email field");
        loginPage.clickOnForgotPasswordButton();
        loginPage.clickOnTheSubmitButton();
        loginPage.assertEmailError();
    }

    @Test
    public void verifyValidationMessageForInValidEmailAddressOnForgotPassword(){
        common.logPrint("Verify that validation message for invalid email for forgot password");
        loginPage.clickOnForgotPasswordButton();
        loginPage.enterInvalidDataInEmail();
        loginPage.clickOnTheSubmitButton();
        loginPage.assertEmailErrorForInvalidEmail();
    }

    @Test
    public void verifyAllElementsArePresentOnTheSignUpPage(){
        common.logPrint("Verify that all the elements are showing on the SignUp page");
        loginPage.clickOnSignUpLink();
        loginPage.verifyAllTheElementsOnTheSignUpPage();
    }

    @Test
    public void verifyValidationMessageForBlankInpOnSignUpPage(){
        common.logPrint("Verify that validation message for blank field on sign-up page");
        loginPage.clickOnSignUpLink();
        loginPage.clickOnTheSignUpForFreeButton();
        loginPage.verifyValidationMessageForSignUpBlankInputs();
    }



}