package test.SelfPracticeTasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * TC #4: Zero Bank URL verification
 * 1. Open Chrome browser
 * 2. Go to http://zero.webappsecurity.com/login.html
 * 3. Get attribute value of href from the “forgot your password” link
 * 4. Verify attribute value contains
 * Expected: “/forgot-password.html”
 *
 * SOLUTION: NEXT PAGE. Try to solve yourself before looking at the solution.
 * Hint: Locate the “Forgot your password ?” link, and use getAttribute value method to get the link
 * behind the attribute within.
 */
public class ZeroBankURLVerification {

    public static void main(String[] args) {

        // 1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // maximize page

        // 2. Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");

        // 3. Get attribute value of href from the “forgot your password” link
        // 4. Verify attribute value contains
        //  Expected: “/forgot-password.html”
        String actualAttribute = driver.findElement(By.linkText("Forgot your password ?")).getAttribute("href");
        String expectedAttribute = "/forgot-password.html";

        System.out.println(actualAttribute);

        if (actualAttribute.contains(expectedAttribute)){
            System.out.println("Attribute PASSED!!!");
        }else{
            System.out.println("Attribute FAILED!!!"); //  FAILED :(
        }

    }
}
