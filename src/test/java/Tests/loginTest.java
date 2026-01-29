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

}