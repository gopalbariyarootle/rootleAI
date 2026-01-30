package Pages;

import Config.EnvConfig;
import Utils.Common;
import Utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class appCampaigns extends Locators {

    Common common;
    String orgName;

    public appCampaigns(WebDriver driver) {
        super(driver);
        this.common = new Common(driver);
        this.orgName = EnvConfig.getAppOrganization();
    }

    public void clickOnTemplateMenu(){
        common.waitUntilElementToBeVisible(templatesMenu);
        common.click(templatesMenu);
    }

    public void clickOnSaveButton(){
        common.waitUntilElementToBeVisible(saveBtn);
        common.click(saveBtn);
    }

    public void goToOrganizationPage(){
        common.waitUntilElementToBeVisible(organizationMenu);
        common.click(organizationMenu);
    }

    public void assertSuccessMessageTemplateCreate(){
        common.assertElementPresent(templateCreatedSuccessfully);
    }

    public void clickOnCampaignMenu(){
        common.waitUntilElementToBeVisible(campaignsMenuApp);
        common.click(campaignsMenuApp);
    }

    public void clickOnBAckBtn(){
        common.waitUntilElementToBeVisible(backBtn);
        common.click(backBtn);
    }


    public void clickOnTemplateSubMenu(){
        common.waitUntilElementToBeVisible(templateSubMenu);
        common.click(templateSubMenu);
    }

    public void goToTemplatePage(){
        clickOnTemplateMenu();
        clickOnTemplateSubMenu();
    }

    public String createNewTemplate(){
        goToTemplatePage();
        common.waitUntilElementToBeVisible(addTemplateBtn);
        common.click(addTemplateBtn);

        String templateName = common.generateRandomChars(5) + "Automation";
        String templateDescription = common.generateRandomNumberString(20);

        common.waitUntilElementToBeVisible(templateNameInp);
        common.type(templateNameInp, templateName);

        common.waitUntilElementToBeVisible(descriptionInp);
        common.type(descriptionInp, templateDescription);

        common.waitUntilElementToBeVisible(selectLanguageDropDown);
        common.click(selectLanguageDropDown);

        common.waitUntilElementToBeVisible(gujaratiOpt);
        common.scroll_To_Element(gujaratiOpt);
        common.click(gujaratiOpt);

        common.waitUntilElementToBeVisible(saveBtn);
        common.click(saveBtn);

        assertSuccessMessageTemplateCreate();

        return templateName;
    }

    public void verifyCreatedTemplateIsShowingInTheList(String templateName){

        common.pause(2);
        common.waitUntilElementToBeVisible(filterInp);
        common.type(filterInp, templateName);

        String xpathOfTheName = "//div[text()='"+templateName+"']";

        common.assertElementPresent(xpathOfTheName);

        common.logPrint("Template created successfully and showing in the list.");
    }

        public void searchOrganization(){
        common.pause(2);
        common.waitUntilElementToBeVisible(filterInp);
        common.type(filterInp, orgName);
    }

    public void assignTemplateToOrganization(String templateName){

        Actions actions = new Actions(driver);
        String xpathHover = "//td[text()=' "+orgName+" ']";

        common.waitUntilElementToBeVisible(xpathHover);
        WebElement element = driver.findElement(By.xpath(xpathHover));
        actions.moveToElement(element).perform();

        common.waitUntilElementToBeVisible(assignTemplateIconOnGride);
        common.moveToElementAndClick(assignTemplateIconOnGride);

        common.pause(2);
        common.waitUntilElementToBeVisible(filterInp);
        common.type(filterInp, templateName);

        common.waitUntilElementToBeVisible(checkboxTemplate);
        WebElement element1 = driver.findElement(By.xpath(checkboxTemplate));
        element1.click();

        clickOnSaveButton();

        common.assertElementPresent(templatesCopied);

    }



}


