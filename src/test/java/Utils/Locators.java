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

    /*---------- Login page Xpath ------------*/
    public static String emailInp = "//input[@placeholder='Enter Email Address']";
    public static String passInp = "//input[@placeholder='Enter Password']";
    public static String loginBtn = "//span[text()=' LOGIN ']";
    public static String errorMsgForEmail = "//mat-error[text()=' Please enter email address ']";
    public static String errorMsgForPassword = "//mat-error[text()=' Please enter password ']";
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