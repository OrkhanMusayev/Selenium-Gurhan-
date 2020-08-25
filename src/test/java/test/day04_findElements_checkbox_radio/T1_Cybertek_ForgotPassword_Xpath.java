package test.day04_findElements_checkbox_radio;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *  //TC #1: PracticeCybertek.com_ForgotPassword WebElement verification
 *         // /1. Open Chrome browser
 *         //2. Go to http://practice.cybertekschool.com/forgot_password
 *         //3. Locate all the WebElements on the page using XPATH locator only (total of 6)
 *         // a. "Home" Link
 *         //b. "Forgot Password" header
 *         //c. "E-mail" text
 *         //d. E-mail input box
 *         //e. "Retrieve Password" button
 *         //f. "Powered by Cybertek School" text
 *        //4. Verify all WebElements are displayed.
 */
public class T1_Cybertek_ForgotPassword_Xpath {

    public static void main(String[] args) {

        //TC #1: PracticeCybertek.com_ForgotPassword WebElement verification
        // /1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //3. Locate all the WebElements on the page using XPATH locator only (total of 6)
        // a. "Home" Link
        //tagName[@attribute='value'] --> formula
                  //a[@class='nav-link']
                 //a[@href='/']
        //tagName[.='text'] --> formula
                 //a[.='Home']

        WebElement homeLink = driver.findElement(By.xpath("//a[@class='nav-link']"));

        //b. "Forgot Password" header
        WebElement forgotPasswordHeader = driver.findElement(By.xpath("//h2[.='Forgot Password']"));

        //c. "E-mail" text
        WebElement emailLabel = driver.findElement(By.xpath("//label[@for='email']"));

        //d. E-mail input box
        WebElement emailInput =driver.findElement(By.xpath("//input[@type='text']"));

        //e. "Retrieve Password" button
        WebElement retrieveButton = driver.findElement(By.xpath("//button[@type='submit']"));

        //f. "Powered by Cybertek School" text
        WebElement footerText = driver.findElement(By.xpath("//div[@style='text-align: center;']"));
        // //a[.='Cybertek School']/.. --> second way by text

        //4. Verify all WebElements are displayed.
        if (homeLink.isDisplayed() && forgotPasswordHeader.isDisplayed() && emailLabel.isDisplayed()
        && emailInput.isDisplayed() && retrieveButton.isDisplayed() && footerText.isDisplayed()){
            System.out.println("All of the webElements are displayed. Passed!!!");
        }else{
            System.out.println("One or more of the web elements are not displayed. FAIL!!!");
        }
    }
}
