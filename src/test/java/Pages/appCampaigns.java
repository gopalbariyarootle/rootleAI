package Pages;

import Config.EnvConfig;
import Utils.Common;
import Utils.Locators;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    public void clickOnAddCampaignButton(){
        common.waitUntilElementToBeVisible(addCampaignsBtnApp);
        common.click(addCampaignsBtnApp);
    }

    public void goToOrganizationPage(){
        common.waitUntilElementToBeVisible(organizationMenu);
        common.click(organizationMenu);
    }

    public void assertSuccessMessageTemplateCreate(){
        common.assertElementPresent(templateCreatedSuccessfully);
    }

    public void goTOCampaignPage(){
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

        common.waitForLoad();

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

        String gujaratiLan = "//mat-chip[text()=' Gujarati (India) ']";

        common.waitUntilElementToBeVisible(gujaratiLan);
        common.assertElementPresent(gujaratiLan);

        common.waitUntilElementToBeVisible(saveBtn);
        common.click(saveBtn);

        assertSuccessMessageTemplateCreate();

        return templateName;
    }

    public void verifyCreatedTemplateIsShowingInTheList(String templateName){

        common.waitForLoad();

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

        Actions actions1 = new Actions(driver);
        common.pause(1);
        actions1.sendKeys(Keys.ENTER);
        common.pause(1);

        String checkboxTemplate = "//td[text()=' "+templateName+" ']/parent::tr//mat-checkbox";
        common.waitUntilElementToBeVisible(checkboxTemplate);

        WebElement element1 = driver.findElement(By.xpath(checkboxTemplate));
        element1.click();

        common.pause(1);

        String selectedTemplate = "//mat-chip[text()=' "+templateName+" ']";
        common.waitUntilElementToBeVisible(selectedTemplate);
        common.assertElementPresent(selectedTemplate);

        clickOnSaveButton();

        common.assertElementPresent(templatesCopied);
    }

    public void verifyTemplateIsShowingInTheDropdown(String templateName){

        common.waitForLoad();

        clickOnAddCampaignButton();

        common.waitUntilElementToBeVisible(addCampaignsBtnApp);
        common.click(addCampaignsBtnApp);

        common.logPrint("Step:: Verify template is showing in the add campaign list");
        String templateXpath = "//span[text()='"+templateName+"']";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
                .until(driver1 -> {
                    try {
                        // ensure page is stable
                        String readyState = (String) ((JavascriptExecutor) driver1)
                                .executeScript("return document.readyState");

                        if (!readyState.equals("complete")) {
                            return false;
                        }

                        WebElement element = driver1.findElement(By.xpath(templateXpath));
                        return element.isDisplayed();

                    } catch (Exception e) {
                        return false;
                    }
                });

        common.assertElementPresent(templateXpath);

    }



}


