package test.SeleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Close_Quit {
    public static void main(String[] args) {

        // to setup chrome browser
        WebDriverManager.chromedriver().setup();

        // to create an object of chromedriver class
        WebDriver driver = new ChromeDriver();

        driver.get("http://google.com");

        driver.close(); // close only one browser's page
       // driver.quit(); // close entire browser's pages
    }
}
