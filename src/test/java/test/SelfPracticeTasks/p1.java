package test.SelfPracticeTasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class p1 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/maps/@40.1541964,45.5106819,7z");

        String excpectedUrl = "https://www.google.com/maps/@40.1541964,45.5106819,7z";
        String actualUrl = driver.getCurrentUrl();

        String excpectedTitle = "Google Maps";
        String actualTitle = driver.getTitle();

        if (excpectedUrl.equals(actualUrl) && excpectedTitle.equals(actualTitle)){
            System.out.println("passed!");
        }else{
            System.out.println("fails !");
        }
    }
}
