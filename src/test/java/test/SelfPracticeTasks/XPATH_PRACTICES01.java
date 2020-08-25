package test.SelfPracticeTasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * XPATH PRACTICES
 * DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
 * TC #1: PracticeCybertek.com_ForgotPassword WebElement verification
 * 1. Open Chrome browser
 * 2. Go to http://practice.cybertekschool.com/forgot_password
 * 3. Locate all the WebElements on the page using XPATH locator only (total of 6)
 * a. “Home” link
 * b. “Forgot password” header
 * c. “E-mail” text
 * d. E-mail input box
 * e. “Retrieve password” button
 * f. “Powered byCybertek School” text
 *
 * 4. Verify all WebElements are displayed.
 */
public class XPATH_PRACTICES01 {

    public static void main(String[] args) {

    // 1. Open Chrome browser
    // * 2. Go to http://practice.cybertekschool.com/forgot_password
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize(); // i just maximized size))
    driver.get("http://practice.cybertekschool.com/forgot_password");

    // 3. Locate all the WebElements on the page using XPATH locator only (total of 6)
        // * a. “Home” link
    // WebElement home = driver.findElement(By.xpath("//a[@class='nav-link']"));
    if(driver.findElement(By.xpath("//a[@class='nav-link']")).isDisplayed()){
        System.out.println("Home link verification PASSED!!!");
    }else{
        System.out.println("Home link verification FAILED!!!");
    }

    // b. “Forgot password” header

    //WebElement password = driver.findElement(By.xpath("//div[@id='content']"));
        if (driver.findElement(By.xpath("//div[@id='content']")).isDisplayed()){
            System.out.println("Forgot Password header Verification PASSED!!!");
        }else{
            System.out.println("Forgot Password header Verification FAILED!!!");
        }

        // c. “E-mail” text

        //WebElement email = driver.findElement(By.xpath("//label[@for='email']"));
        if (driver.findElement(By.xpath("//label[@for='email']")).isDisplayed()){
            System.out.println("E-mail text Verification PASSED!!!");
        }else{
            System.out.println("E-mail text Verification FAILED!!!");
        }

        // d. E-mail input box

        //WebElement emailBox = driver.findElement(By.xpath("//input[@type='text']"));
        if (driver.findElement(By.xpath("//input[@type='text']")).isDisplayed()){
            System.out.println("E-mail input box verification PASSED!!!");
        }else{
            System.out.println("E-mail input box verification FAILED!!!");
        }

        // e. “Retrieve password” button

       // WebElement retrievePassword = driver.findElement(By.xpath("//i[@class='icon-2x icon-signin']"));
        if (driver.findElement(By.xpath("//i[@class='icon-2x icon-signin']")).isDisplayed()){
            System.out.println("Retrieve Password button verification PASSED!!!");
        }else{
            System.out.println("Retrieve Password button verification FAILED!!!");
        }

        // f. “Powered byCybertek School” text

        String cybertekSchool = driver.findElement(By.xpath("//div[@style='text-align: center;']")).getText();
        if (driver.findElement(By.xpath("//div[@style='text-align: center;']")).isDisplayed()){
            System.out.println("Powered byCybertek School text verification PASSED!!!");
        }else{
            System.out.println("Powered byCybertek School text verification FAILED!!!");
        }
        //System.out.println(cybertekSchool);

}
}