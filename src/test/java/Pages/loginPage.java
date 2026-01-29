package Pages;

import Config.EnvConfig;
import Config.ReadProperties;
import Utils.Common;
import Utils.Locators;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;

public class loginPage extends Locators {

    Common common;

    private String username;
    private String password;

    public loginPage(WebDriver driver) {
        super(driver);
        this.common = new Common(driver);
        this.username = EnvConfig.getDirectorUser();
        this.password = EnvConfig.getDirectorPass();
    }

    public void clickOnLoginButton(){
        common.waitUntilElementToBeVisible(loginBtn);
        common.click(loginBtn);
    }

    public void clickOnForgotPasswordButton(){
        common.waitUntilElementToBeVisible(forgotPasswordLink);
        common.click(forgotPasswordLink);
    }

    public void clickOnSignUpLink(){
        common.waitUntilElementToBeVisible(signUpLink);
        common.click(signUpLink);
    }

    public void clickOnTheSubmitButton(){
        common.waitUntilElementToBeVisible(submitButton);
        common.click(submitButton);
    }

    public void clickOnTheSignUpForFreeButton(){
        common.waitUntilElementToBeVisible(signUpForFreeBtn);
        common.click(signUpForFreeBtn);
    }

    public void assertEmailError(){
        common.assertElementPresent(errorMsgForEmail);
    }

    public void assertEmailErrorForInvalidEmail(){
        common.assertElementPresent(errorMsgForInvalidEmail);
    }

    public void assertPasswordError(){
        common.assertElementPresent(errorMsgForPassword);
    }

    public void loginToAppWithValidUserNamePass(){
        common.waitUntilElementToBeVisible(emailInp);
        common.type(emailInp, username);

        common.waitUntilElementToBeVisible(passInp);
        common.type(passInp, password);

        clickOnLoginButton();
    }

    public void verifyErrorMessageForBlankEmailPass(){
        clickOnLoginButton();
        assertEmailError();
        assertPasswordError();
    }

    public void verifyAllTheElementsOnTheLoginPage(){

        common.logPrint("Step:: Verify login header is showing");
        common.assertElementPresent(loginHeader);

        common.logPrint("Step:: Verify email input field is visible");
        common.assertElementPresent(emailInp);

        common.logPrint("Step:: Verify pass input is visible");
        common.assertElementPresent(passInp);

        common.logPrint("Step:: Verify password visibility icon");
        common.assertElementPresent(matIconOnPassword);

        common.logPrint("Step:: Verify Login button is visible");
        common.assertElementPresent(loginBtn);

        common.logPrint("Step:: Verify Forgot Password link");
        common.assertElementPresent(forgotPasswordLink);

        common.logPrint("Step:: Verify Login page logo");
        common.assertElementPresent(logoImg);

        common.logPrint("Step:: Verify Login with text");
        common.assertElementPresent(loginWithText);

        common.logPrint("Step:: Verify Google login logo");
        common.assertElementPresent(googleLogo);

        common.logPrint("Step:: Verify Microsoft login logo");
        common.assertElementPresent(microsoftLogo);

        common.logPrint("Step:: Verify LinkedIn login logo");
        common.assertElementPresent(linkedinLogo);

        common.logPrint("Step:: Verify Facebook login logo");
        common.assertElementPresent(facebookLogo);

        common.logPrint("Step:: Verify Need an account text");
        common.assertElementPresent(needAnAccountText);

        common.logPrint("Step:: Verify Sign Up link");
        common.assertElementPresent(signUpLink);
    }

    public void verifyALlTheElementsOnForgotPassPage(){
        common.logPrint("Step:: Verify Forgot Password header");
        common.assertElementPresent(forgotPasswordHed);

        common.logPrint("Step:: Verify forgot password description text");
        common.assertElementPresent(forgotPassText);

        common.logPrint("Step:: Verify email input field");
        common.assertElementPresent(emailInp);

        common.logPrint("Step:: Verify Submit button");
        common.assertElementPresent(submitButton);

        common.logPrint("Step:: Verify Back to text");
        common.assertElementPresent(backToText);

        common.logPrint("Step:: Verify Login link on forgot password page");
        common.assertElementPresent(loginLikeOnForgotPassPage);

        common.logPrint("Step:: Verify logo image on forgot password page");
        common.assertElementPresent(logoImg);
    }

    public void enterInvalidDataInEmail(){
        String invalidEmail = common.generateRandomChars(10);

        common.waitUntilElementToBeVisible(emailInp);
        common.type(emailInp, invalidEmail);
    }

    public void verifyAllTheElementsOnTheSignUpPage(){

        common.logPrint("Step:: Verify Sign Up header");
        common.assertElementPresent(signUpHead);

        common.logPrint("Step:: Verify Organization Name input field");
        common.assertElementPresent(orgNameInp);

        common.logPrint("Step:: Verify First Name input field");
        common.assertElementPresent(firstNameInp);

        common.logPrint("Step:: Verify Last Name input field");
        common.assertElementPresent(lastNameInp);

        common.logPrint("Step:: Verify Phone number input field");
        common.assertElementPresent(phoneInp);

        common.logPrint("Step:: Verify Password input field");
        common.assertElementPresent(passwordInp);

        common.logPrint("Step:: Verify Confirm Password input field");
        common.assertElementPresent(confirmPassInp);

        common.logPrint("Step:: Verify Website input field");
        common.assertElementPresent(websiteInp);

        common.logPrint("Step:: Verify Domain dropdown");
        common.assertElementPresent(domainDropDown);

        common.logPrint("Step:: Verify Sign up for Free Trial button");
        common.assertElementPresent(signUpForFreeBtn);

//        common.logPrint("Step:: Verify Get 100 calls free on sign up text");
//        common.assertElementPresent(get100CallFreeTrielText);

        common.logPrint("Step:: Verify Already a user text");
        common.assertElementPresent(alreadyAUserText);

        common.logPrint("Step:: Verify Login link on Sign Up page");
        common.assertElementPresent(loginLikeOnForgotPassPage);

        common.logPrint("Step:: Verify logo image on forgot password page");
        common.assertElementPresent(logoImg);
    }

    public void verifyValidationMessageForSignUpBlankInputs(){

        common.assertElementPresent(errorMsgForOrgName);
        common.assertElementPresent(errorMsgForFirstName);
        common.assertElementPresent(errorMsgForLastName);
        common.assertElementPresent(errorMsgForBusinessEmail);
        common.assertElementPresent(errorMsgForPhone);
        common.assertElementPresent(errorMsgForPassword);
        common.assertElementPresent(errorMsgForConfirmPassword);

    }




}


