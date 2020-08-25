package test.SeleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementBy_classLinkText {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("Amount of links: "+ allLinks.size() );

        WebElement link = driver.findElement(By.linkText("Broken Images"));
        link.click();

        Thread.sleep(5000);

        driver.close();

    }
}
