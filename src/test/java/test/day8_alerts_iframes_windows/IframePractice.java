package test.day8_alerts_iframes_windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

/**
 * TC #4: Iframe practice
 * 1.Create a new class called: Iframe Practice
 * 2.Create new test and make set ups
 * 3.Go to: http://practice.cybertekschool.com/iframe
 * 4.Assert: “Your content goes here.” Text is displayed.
 * 5.Assert: “An iFrame containing the TinyMCEWYSIWYG Editor
 */
public class IframePractice {


    WebDriver driver;


    @BeforeMethod
    public void setUp() {

        //1.Create a new class called: IframePractice
        // * 2.Create new test and make set ups
        // * 3.Go to: http://practice.cybertekschool.com/iframe
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/iframe");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test(){

        // 1- Locating iframe as web element
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        //WebElement iframe2 = driver.findElement(By.xpath("iframe"));

        // switching to iframe using webElement
        driver.switchTo().frame(iframe);

        //4.Assert: “Your content goes here.” Text is displayed.
        WebElement yourContentGoesHereText = driver.findElement(By.xpath("//p"));

        Assert.assertTrue(yourContentGoesHereText.isDisplayed());

        // WE HAVE TO SWITCH BACK TO DEFAULT HTML TO BE ABLE TO LOCATE ANYTHING IN THERE
        driver.switchTo().parentFrame();

        // * 5.Assert: “An iFrame containing the TinyMCEWYSIWYG Editor
        WebElement h3Text = driver.findElement(By.xpath("//h3"));

        Assert.assertTrue(h3Text.isDisplayed());

    }
}
