package test.day7_javafaker_webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * TC #1: Smartbear software link verification
 * 1.Open browser
 * 2.Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
 * 3.Enter username: “Tester”
 * 4.Enter password: “test”
 * 5.Click to Login button
 * 6.Print out count of all the links on landing page
 * 7.Print out each link text on this page
 */
public class SmartBear {

    WebDriver driver;

//    1.Open browser
// * 2.Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx

    @BeforeMethod
    public void setup() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void p1_smartbear_login_test(){
        // 3.Enter username: “Tester”
        WebElement inputUserName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        inputUserName.sendKeys("Tester");

        // * 4.Enter password: “test”
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        inputPassword.sendKeys("test");

        // * 5.Click to Login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        loginButton.click();

        // * 6.Print out count of all the links on landing page
        List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));
        int expectedNumberOfLinks  = 6;
        int actualNumberOfLInks = allLinks.size();
        Assert.assertEquals(actualNumberOfLInks,expectedNumberOfLinks);

        // * 7.Print out each link text on this page
        for (WebElement eachLink : allLinks){
            System.out.println(eachLink.getText());
        }
    }
}