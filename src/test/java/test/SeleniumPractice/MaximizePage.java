package test.SeleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MaximizePage {
    public static void main(String[] args) {

        // to setup chrome browser
        WebDriverManager.chromedriver().setup();

        // to create an object of chromedriver class
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://google.com");
    }
}
