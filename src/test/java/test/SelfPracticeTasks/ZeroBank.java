package test.SelfPracticeTasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * TC #2: Zero Bankheader verification
 *      1.Open Chrome browser
 *      2.Go to http://zero.webappsecurity.com/login.html
 *      3.Verify header textExpected: “Log in to ZeroBank”
 */
public class ZeroBank {

    public static void main(String[] args) {

        // 1.Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // we just maximized web page window

        // 2.Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");

        // 3.Verify header textExpected: “Log in to ZeroBank”
        String ActHeader = driver.findElement(By.className("page-header")).getText();
        // <div class="page-header">
        String ExpHeader="Log in to ZeroBank";

        if(ExpHeader.equals(ActHeader)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed!!!");
        }




    }
}
