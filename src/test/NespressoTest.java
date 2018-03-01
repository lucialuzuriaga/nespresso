package test;

import main.NespressoPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class NespressoTest {

    private ChromeDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.nespresso.com/us");
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testSuccessfulLogin() {
        NespressoPage nespressoPage = new NespressoPage(driver);
        nespressoPage.login("aaa@email.com" ,"Password123");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-ng-show='user.logged']")));
        Assert.assertTrue(nespressoPage.isUserLoggedIn());
    }

    @Test
    public void testLogout() {
        NespressoPage nespressoPage = new NespressoPage(driver);
        nespressoPage.login("aaa@email.com" ,"Password123");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-ng-show='user.logged']")));
        nespressoPage.logout();
        Assert.assertTrue(nespressoPage.getCustomerNameText().equals("Sign in to your account"));
    }

    @Test
    public void testInvalidLogin() {
        NespressoPage nespressoPage = new NespressoPage(driver);
        nespressoPage.login("aaa@email.com", "Password1");
        Assert.assertTrue(nespressoPage.getErrorMessage().equals("The username and/or password entered are not valid. Please check again."));
    }

}