package test.SelfPracticeTasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * TC #5: Basic authentication Zero Bank
 * 1. Open Chrome browser
 * 2. Go to http://zero.webappsecurity.com/login.html
 * 3. Enter username: username
 * 4. Enter password: password
 * 5. Click sign in button
 * 6. Verify username is displayed on the page
 * 7. Verify the title Zero – Account Summary
 * 8. Verify the link Account Summary’s href value contains: “account-summary”
 * Print out results in validation formats
 */
public class BasicAuthenticationZeroBank {

    public static void main(String[] args) {

        // 1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // we just maximized web page window

        // 2. Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");

        // 3. Enter username: username
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");

        // 4. Enter password: password
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");

        //  5. Click sign in button
        driver.findElement(By.xpath("//input[@name='submit']")).click();

        // 6. Verify username is displayed on the page
        driver.findElement(By.xpath("//li[@class='dropdown'][2]")).isDisplayed();

        if (driver.findElement(By.xpath("//li[@class='dropdown'][2]")).isDisplayed()){
            System.out.println("Verification Passed!!!");
        }else{
            System.out.println("Verification Failed!!!");
        }

        String currentTitle = driver.getTitle();
        String expectedTitle = "Zero - Account Summary";

        System.out.println(currentTitle); // just check current title

        if (currentTitle.equals(expectedTitle)){
            System.out.println("Title verification Passed!!!");
        }else{
            System.out.println("Title verification Failed!!!");
        }

        // 8. Verify the link Account Summary’s href value contains: “account-summary”
        String actualResult = driver.findElement(By.linkText("Account Summary")).getAttribute("href");
        String expectedResult = "account-summary";

        if (actualResult.contains(expectedResult)){
            System.out.println("Link verification passed!");
        }else{
            System.out.println("Link verification failed!");
        }

    }
}
