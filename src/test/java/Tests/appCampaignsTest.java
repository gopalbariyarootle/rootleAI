package Tests;

import Config.EnvConfig;
import Utils.BasePage;
import org.testng.annotations.Test;

public class appCampaignsTest extends BasePage {

    @Test
    public void verifyCreateTemplateFunctionality(){
        common.logPrint("Verify create template functionality is working");
        loginPage.loginToAppWithValidUserNamePass();
        String templateName = appCampaigns.createNewTemplate();
        appCampaigns.clickOnBAckBtn();
        appCampaigns.verifyCreatedTemplateIsShowingInTheList(templateName);
    }

    @Test
    public void verifyAssignedTemplateIsShowingInApp(){
        common.logPrint("Verify created and assigned template is showing in the organization");
        loginPage.loginToAppWithValidUserNamePass();
        String templateName = appCampaigns.createNewTemplate();
        appCampaigns.clickOnBAckBtn();
        appCampaigns.verifyCreatedTemplateIsShowingInTheList(templateName);
        appCampaigns.goToOrganizationPage();
        appCampaigns.searchOrganization();
        appCampaigns.assignTemplateToOrganization(templateName);
        loginPage.logoutFromAdmin();
        common.openNewWindow();
        loginPage.loginToAppWithValidUserNamePassInAppUrl();
        appCampaigns.goTOCampaignPage();
        appCampaigns.verifyTemplateIsShowingInTheDropdown(templateName);

    }




    @Test
    public void verifyValidationMessageForBlankInpOnSignUpPage(){
       common.logPrint("Verify create campaign functionality is working");
       loginPage.loginToAppWithValidUserNamePassInAppUrl();
        appCampaigns.goTOCampaignPage();
    }

}