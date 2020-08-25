package test.SelfPracticeTasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * TC #3: PracticeCybertek/ForgotPassword URL verification
 * 1. Open Chrome browser
 * 2. Go to http://practice.cybertekschool.com/forgot_password
 * 3. Enter any email into input box
 * 4. Click on Retrieve password
 * 5. Verify URL contains:
 * Expected: “email_sent”
 * 6. Verify textbox displayed the content as expected.
 * Expected: “Your e-mail’s been sent!”
 *
 * Hint: You need to use getText method for this practice.
 */
public class PracticeCybertek_ForgotPassword_URLVerification {


    public static void main(String[]args){

        // 1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // we just maximized web page window

        // 2. Go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        // 3. Enter any email into input box
        driver.findElement(By.name("email")).sendKeys("orkhan123@gmail.com");

        // 4. Click on Retrieve password
        driver.findElement(By.id("form_submit")).click();

        // 5. Verify URL contains, Expected: “email_sent”

        String actualUrlText = driver.getCurrentUrl();
        String expectedUrlText = "email_sent";

        if (actualUrlText.contains(expectedUrlText)){
            System.out.println("Passed!!!");
        }else{
            System.out.println("Failed!!!");
        }

        // 6. Verify textbox displayed the content as expected.
        //  Expected: “Your e-mail’s been sent!”

        String actualTextBox = driver.findElement(By.name("confirmation_message")).getText();
        String expectedTextBox = "Your e-mail's been sent!"; // mistake was (')

        if (actualTextBox.equals(expectedTextBox)){
            System.out.println("Text Box PASSED!!!");
        }else{
            System.out.println("Text Box FAILED!!!"); // failed do not know why
        }


    }
}
