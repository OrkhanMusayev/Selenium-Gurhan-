package test.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CybertekTitleVerification {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com");

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "cybertekschool";

        String actualTitle = driver.getTitle();
        String excpectedTitle = "practice";

        if(actualURL.contains(expectedURL)){
            System.out.println("URL  PASSED!!!");
        }else{
            System.out.println("URL FAILED!!!");
        }



        if(actualTitle.equalsIgnoreCase(excpectedTitle)){
            System.out.println("Title verification PASSED!!!");
        }else{
            System.out.println("Title verification FAILED!!!");
        }

        driver.close();

    }
}
