package test.SelfPracticeTasks;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

/**
 * TC#6: Cybertek registration form confirmationNote:
 * Use JavaFaker when possible.
 * 1.Open browser
 * 2.Go to website: http://practice.cybertekschool.com/registration_form
 * 3.Enter first name
 * 4.Enter last name
 * 5.Enter username
 * 6.Enter email address
 * 7.Enter password
 * 8.Enter phone number
 * 9.Select a gender from radio buttons
 * 10.Enter date of birth11.Select Department/Office
 * 12.Select Job Title
 * 13.Select programming language from checkboxes
 * 14.Clickto sign up button
 * 15.Verify success message “You’ve successfully completed registration.”is displayed.
 */
public class CybertekRegistrationFormConfirmation {

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        //   1.Open browser
        // * 2.Go to website: http://practice.cybertekschool.com/registration_form
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/registration_form");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public  void test(){

        Faker faker = new Faker();

        //3.Enter first name
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(faker.name().firstName());

        // * 4.Enter last name
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(faker.name().lastName());



        // * 5.Enter username
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(faker.name().username().replaceAll("[!@#$%^&*()_,.]",""));


        // * 6.Enter email address
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(faker.internet().emailAddress());


        // * 7.Enter password.
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(faker.internet().password());

        // * 8.Enter phone number
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(faker.phoneNumber().cellPhone());


        //9.Select a gender from radio buttons
        driver.findElement(By.xpath("//input[@value='male']")).click();

        // * 10.Enter date of birth
        driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys("11/19/2000");

        // 11.Select Department/Office
        Select dep = new Select(driver.findElement(By.xpath("//select[@name='department']")));
        dep.selectByVisibleText("Tourism Office");

        // * 12.Select Job Title
        Select jobTitle = new Select(driver.findElement(By.xpath("//select[@name='job_title']")));
        jobTitle.selectByVisibleText("SDET");

        // * 13.Select programming language from checkboxes
        driver.findElement(By.xpath("//input[@id='inlineCheckbox2']")).click();

        // * 14.Click to sign up button
        driver.findElement(By.xpath("//button[.='Sign up']")).click();

        // * 15.Verify success message “You’ve successfully completed registration.”is displayed.
        WebElement message = driver.findElement(By.xpath("//div//p"));
        String expectedMessage = "You've successfully completed registration!";
        String actualMessage = message.getText();

        Assert.assertTrue(message.isDisplayed());

        // extra step
        Assert.assertEquals(expectedMessage,actualMessage);


    }


}
