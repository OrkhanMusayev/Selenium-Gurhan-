package test.SeleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FindElementBy_cssSelector {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/registration_form");
        driver.manage().window().maximize();

         driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("Khabib");
         driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("Nurmagomedov");
         driver.findElement(By.cssSelector("input[name='email']")).sendKeys("khabib@nurmagomedovgmail.com");
         driver.findElement(By.cssSelector("input[name='password']")).sendKeys("ouytr1234");
         driver.findElement(By.cssSelector("input[name='username']")).sendKeys("supersdet");
         driver.findElement(By.cssSelector("input[name='phone']")).sendKeys("412-412-4122");
         driver.findElement(By.cssSelector("input[name='birthday']")).sendKeys("10/10/2010");
         Select select = new Select(driver.findElement(By.cssSelector("select[name='job_title']")));
        driver.findElement(By.cssSelector("input[value='male']")).click();

        select.selectByVisibleText("SDET");
         driver.findElement(By.id("wooden_spoon")).click();

         Thread.sleep(5000);

         driver.close();
    }
}
