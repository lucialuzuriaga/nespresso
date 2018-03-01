package main;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;



public class NespressoPage {

    private ChromeDriver driver;

    @FindBy(id="customer-name")
    public WebElement customerNameLabel;

    @FindBy(id="ta-header-username")
    public WebElement userNameField;

    @FindBy(id="ta-header-password")
    public WebElement passwordField;

    @FindBy(id="ta-header-login-submit")
    public WebElement loginButton;

    @FindBy(css="a[href='/us/en/logout']")
    public WebElement logoutButton;

    @FindBy(id="email-error-message")
    public WebElement emailErrorMessage;

    @FindBy(id="ta-homepage-navigation-dropdown-menu")
    public WebElement dropdownMenuIcon;

    public NespressoPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void login(String user, String password){
    customerNameLabel.click();
    userNameField.sendKeys(user);
    passwordField.sendKeys(password);
    loginButton.click();
    }

    public void logout(){
        dropdownMenuIcon.click();
        logoutButton.click();
    }

    public String getCustomerNameText(){
        return customerNameLabel.getText();
    }

    public String getErrorMessage(){
        return emailErrorMessage.getText();
    }

    public boolean isUserLoggedIn(){
        Assert.assertTrue(driver.findElementByXPath("//*[@data-ng-bind='userName.firstName']").isDisplayed());
        Assert.assertTrue(driver.findElementByXPath("//*[@data-ng-bind='userName.lastName']").isDisplayed());
        Assert.assertTrue(getCustomerNameText().contains("Welcome"));
        return true;
    }


}