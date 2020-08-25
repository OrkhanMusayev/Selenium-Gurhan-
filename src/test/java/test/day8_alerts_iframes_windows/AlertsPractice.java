package test.day8_alerts_iframes_windows;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

/**
 * TC #1: Information alert practice
 * 1.Open browser
 * 2.Go to website: http://practice.cybertekschool.com/javascript_alerts
 * 3.Click to “Click for JS Alert”button
 * 4.Click to OK button from the alert
 * 5.Verify “You successfully clicked an alert”text is displayed.
 */
public class AlertsPractice {

    WebDriver driver;


    @BeforeMethod
    public void setUp() {

        //1.Open browser
        // * 2.Go to website: http://practice.cybertekschool.com/javascript_alerts
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void p1_information_alert_test() throws InterruptedException {

        // 3.Click to “Click for JS Alert”button
        WebElement infoAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));

        infoAlertButton.click();

        //4.Click to OK button from the alert
        //1- Create the Alert instance and switch to it
        Alert alert = driver.switchTo().alert();

        //2- Use "alert" to accept the alert.
        Thread.sleep(5000);
        alert.accept();

        // locating result web element
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

        //Asserting the result is displayed
        Assert.assertTrue(resultText.isDisplayed());

    }

    /**
     * TC #2: Confirmation alert practice
     * 1.Open browser
     * 2.Go to website: http://practice.cybertekschool.com/javascript_alerts
     * 3.Click to “Click for JS Confirm” button
     * 4.Click to OK button from the alert
     * 5.Verify “You clicked: Ok” text is displayed.
     */
    @Test
    public void p2_confirmation_alert_test() throws InterruptedException {

        WebElement confirmationAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));

        confirmationAlertButton.click();

        Alert alert = driver.switchTo().alert();

        Thread.sleep(5000);

        alert.dismiss();

        //locating result web element
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));
        //WebElement resultText2 = driver.findElement(By.id("result"));

        //Asserting the result text is displayed
        Assert.assertTrue(resultText.isDisplayed());


    }
}