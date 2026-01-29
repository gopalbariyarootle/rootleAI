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

    public void assertEmailError(){
        common.assertElementPresent(errorMsgForEmail);
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



}


