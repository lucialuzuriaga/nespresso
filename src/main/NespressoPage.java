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

    @FindBy(id="ta-header-logout")
    public WebElement logoutButton;

    @FindBy(id="email-error-message")
    public WebElement emailErrorMessage;

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
        customerNameLabel.click();
        logoutButton.click();
    }

    public String getFirstName(){
        return (driver.findElementByXPath("//*[@id='customer-name']/span[1]").getText());
    }

    public String getLastName(){
        return (driver.findElementByXPath("//*[@id='customer-name']/span[1]/span[2]").getText());
    }

    public String getCustomerNameText(){
        return customerNameLabel.getText();
    }

    public String getErrorMessage(){
        return emailErrorMessage.getText();
    }

    public boolean isUserLoggedIn(String firstName, String lastName, String welcome){
        Assert.assertTrue(getFirstName().contains(firstName));
        Assert.assertTrue(getLastName().contains(lastName));
        Assert.assertTrue(getCustomerNameText().contains(welcome));
        return true;
    }


}