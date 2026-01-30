package Tests;

import Config.EnvConfig;
import Utils.BasePage;
import org.testng.annotations.Test;

public class appCampaignsTest extends BasePage {

    @Test
    public void verifyValidationMessageForBlankInpOnSignUpPage(){
       common.logPrint("Verify create campaign functionality is working");
       loginPage.loginToAppWithValidUserNamePassInAppUrl();
        appCampaigns.clickOnCampaignMenu();
    }

    @Test
    public void verifyAssignedTemplateIsShowingInApp(){
        common.logPrint("Verify create campaign functionality is working");
        loginPage.loginToAppWithValidUserNamePass();
        String templateName = appCampaigns.createNewTemplate();
        appCampaigns.clickOnBAckBtn();
        appCampaigns.verifyCreatedTemplateIsShowingInTheList(templateName);
        appCampaigns.goToOrganizationPage();
        appCampaigns.searchOrganization();
        appCampaigns.assignTemplateToOrganization(templateName);
        loginPage.logoutFromAdmin();
        loginPage.loginToAppWithValidUserNamePassInAppUrl();
        common.openNewWindow();
        loginPage.loginToAppWithValidUserNamePassInAppUrl();
    }



}