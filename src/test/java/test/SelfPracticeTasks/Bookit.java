package test.SelfPracticeTasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bookit {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://cybertek-reservation-qa.herokuapp.com/sign-in");
        driver.findElement(By.name("email")).sendKeys("ecrasford8s@dagondesign.com");
        driver.findElement(By.name("password")).sendKeys("bricesiddell");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }
}
