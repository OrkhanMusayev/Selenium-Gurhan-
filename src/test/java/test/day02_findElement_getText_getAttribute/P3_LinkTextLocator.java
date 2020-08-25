package test.day02_findElement_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P3_LinkTextLocator {
    /**
    TC #3: Back and forth navigation
    1-Open a chrome browser
    2-Go to: https://google.com
    3-Click to Gmail from top right.
    4-Verify title contains:Expected: Gmail
    5-Go back to Google by using the .back();
    6-Verify title equals:Expected: Google
     */

    public static void main(String[] args) {

        //1-Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // we just maximized web page window

        // 2-Go to: https://google.com
        driver.get("https://www.google.com");

       // 3-Click to Gmail from top right.
        driver.findElement(By.linkText("Gmail")).click();

        // 4-Verify title contains Gmail, Expected: "Gmail"
        String actualGmailTitle = driver.getTitle();
        String expectedIntTitle = "Gmail";

        if(actualGmailTitle.contains(expectedIntTitle)){
            System.out.println("Gmail verification PASSED!!!");
        }else{
            System.out.println("Gmail verification FAILED!!!");
        }

        // 5-Go back to Google by using the .back();
        driver.navigate().back();

        // 6-Verify title equals to Google, Expected: Google
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Google page title verification PASSED!!!");
        }else{
            System.out.println("Google page title verification FAILED!!!");
        }

    }
}
