package test.SeleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageTitle {
    public static void main(String[] args) {

        // to setup chrome browser
        WebDriverManager.chromedriver().setup();

        // to create an object of chromedriver class
        WebDriver driver = new ChromeDriver();

        driver.get("http://google.com");
        String title = driver.getTitle();
        System.out.println(title);
    }
}
