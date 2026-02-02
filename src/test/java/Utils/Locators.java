package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

public class Locators extends BasePage {
    int DRIVER_WAIT = 5;

    protected WebDriver driver;

    public Locators(WebDriver driver) {
        ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, DRIVER_WAIT);
        PageFactory.initElements(finder, this);
        this.driver = driver;
    }

    /*---------- Common locators ------------------*/
    public static String saveBtn = "//span[text()='Save']";
    public static String backBtn = "//span[text()='Back']";
    public static String filterInp = "//input[@placeholder='Filter']";

    /*---------- Messages locators ------------------*/
    public static String templateCreatedSuccessfully = "//div[text()=' Template Successfully created ']";
    public static String templateUpdatedSuccessfully = "//div[text()=' Template Updated Successfully ']";
    public static String templatesCopied = "//div[text()=' Templates copied into an organisation! ']";

    /*---------- Admin Login page Xpath ------------*/
    public static String emailInp = "//input[@placeholder='Enter Email Address']";
    public static String passInp = "//input[@placeholder='Enter Password']";
    public static String loginBtn = "//span[text()=' LOGIN '] | //span[contains(text(),' Log in ')]";
    public static String errorMsgForEmail = "//mat-error[text()=' Please enter email address ']";
    public static String errorMsgForPassword = "//mat-error[text()=' Please enter password ']";
    public static String errorMsgForInvalidEmail = "//mat-error[text()=' Please enter valid email address ']";
    public static String loginHeader = "//h3[text()='Login']";
    public static String matIconOnPassword = "//mat-icon[text()=' visibility ']";
    public static String forgotPasswordLink = "//a[text()='Forgot Your Password?']";
    public static String logoImg = "//div[@class='login_bg']";
    public static String loginWithText = "//h3[text()='Login with']";
    public static String googleLogo = "//app-google-login/parent::span";
    public static String microsoftLogo= "//app-microsoft-login/parent::span";
    public static String linkedinLogo = "//app-linkedin-login/parent::span";
    public static String facebookLogo = "//app-facebook-login/parent::span";
    public static String needAnAccountText = "//span[text()='Need an account?']";
    public static String signUpLink = "//a[text()='Sign Up']";

    /*---------- Admin Logout Xpath ------------*/
    public static String profileMenu = "//span[@class='user-profile-img']/parent::a";
    public static String logoutBtn = "//label[text()='Logout']/parent::button";

    /*---------- Admin Forgot password page Xpath ------------*/
    public static String forgotPasswordHed = "//h3[text()='Forgot Password']";
    public static String forgotPassText = "//span[@class='forgot-password-text']";
    public static String submitButton = "//span[text()='Submit']/parent::button";
    public static String backToText = "//span[text()='Back to ']";
    public static String loginLikeOnForgotPassPage= "//a[text()='Login']";

    /*---------- Admin SignUp page Xpath ------------*/
    public static String signUpHead = "//h3[text()='Sign Up']";
    public static String orgNameInp = "//input[@placeholder='Enter Organization Name']";
    public static String firstNameInp = "//input[@placeholder='Enter First Name']";
    public static String lastNameInp= "//input[@placeholder='Enter Last Name']";
    public static String phoneInp = "//input[@id='phone']";
    public static String passwordInp = "//input[@id='mat-input-4']";
    public static String confirmPassInp = "//input[@id='mat-input-5']";
    public static String websiteInp = "//input[@placeholder='Enter Website']";
    public static String domainDropDown = "//div[@class='mat-select-value']";
    public static String signUpForFreeBtn = "//button[text()='Sign up for a Free trial']";
    public static String get100CallFreeTrielText= "//span[text()='Get 100 calls free on sign up']";
    public static String alreadyAUserText = "//span[text()='Already a user? ']";
    public static String errorMsgForOrgName = "//mat-error[normalize-space()='Please enter organization name']";
    public static String errorMsgForFirstName = "//mat-error[normalize-space()='Please enter first name']";
    public static String errorMsgForLastName = "//mat-error[normalize-space()='Please enter last name']";
    public static String errorMsgForBusinessEmail = "//mat-error[normalize-space()='Please enter business email address']";
    public static String errorMsgForPhone = "//mat-error[normalize-space()='Please enter phone number']";
    public static String errorMsgForConfirmPassword = "//mat-error[normalize-space()='Please enter confirm password']";

    /*---------- App SignUp page Xpath ------------*/
    public static String emailInpApp = "//input[@placeholder='Email Address'] | //input[@placeholder='Enter Email Address']";
    public static String passwordInpApp = "//input[@placeholder='Password']";

    /*---------- App Campaigns page Xpath ------------*/
    public static String campaignsMenuApp = "//span[text()='Campaigns']/parent::span";
    public static String addCampaignsBtnApp= "//span[text()=' Add Campaign ']/parent::button";


    /*---------- Admin Template page Xpath ------------*/
    public static String templatesMenu= "//div[text()='Templates']/parent::span";
    public static String templateSubMenu = "//div[text()='Templates' and @class='submenu-title title']";
    public static String addTemplateBtn = "//span[text()=' Add Template ' ]/parent::a";
    public static String templateNameInp = "//input[@placeholder='Enter Template Name' ]";
    public static String descriptionInp = "//textarea[@placeholder='Enter Description' ]";
    public static String selectLanguageDropDown = "//mat-select[@placeholder='Select language']";
    public static String gujaratiOpt = "//span[text()=' Gujarati (India) ']";

    /*---------- Organization page Xpath ------------*/
    public static String organizationMenu = "//span[text()='Organizations']";
    public static String assignTemplateIconOnGride = "//mat-icon[@ng-reflect-message='Assign Templates']";



    public static String SEARCH = "//input[@placeholder='Search...']";
    public static String FILTERS = "//button[@type='button']//span[normalize-space(.)='Filters']";
    public static String MULTITABHOR = "(//button[@role='tab'])[2]";
    public static String PHFILTERSEACRH = "//input[@placeholder='Select column']";
    public static String PHFILTERVAL = "//input[@placeholder='Enter value']";
    public static String PHFILTEROPERATOR = "//input[@placeholder='Select operator']";
    public static String APPLYFILTER = "//button[@type='button']/child::span[contains(text(),'Apply Filter')]";
    public static String ACCNAMEINPUT = "//input[@placeholder=\"Enter Name\"]";
    public static String ACCCOMPANYNAMEINPUT = "//input[@placeholder=\"Enter Company Name\"]";
    public static String ACCGREETINGINPUT = "//textarea[@name=\"greeting_message\"]";
    public static String ACCPERSONALITYINPUT = "//input[@name='personality']";
    public static String ACCGOALINPUT = "//input[@name=\"goal_type\"]";
    public static String ACCCOREUSPINPUT = "//input[@placeholder=\"Your unique selling proposition\"]";
    public static String ACCCOREFEATURESINPUT = "//input[@name=\"core_features\"]";
    public static String ACCCONTACTINFOINPUT = "//input[@name=\"contact_info\"] | //span[text()='Contact Info']/following::textarea[1]";
    public static String ACCCOMPANYDOMAININPUT = "//input[@name=\"company_domain\"]";
    public static String ACCBUSINESSFOCUINPUT = "//input[@name='business_focus']";
    public static String ACCOFFERINPUT = "//textarea[@name='offer_description']";
    public static String ACCCOMPANYINPUT = "//textarea[@name=\"company_description\"]";
}