package test.SelfPracticeTasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC3_InformationAlert {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        //TC #3: Information alert practice
        //1. Open browser
        //2. Go to website: http://practice.cybertekschool.com/javascript_alerts
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(" http://practice.cybertekschool.com/javascript_alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void infoAlert() throws InterruptedException{
        //3. Click to "Click for JS Prompt" button
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Thread.sleep(1000);
        //4. Send "hello" text to alert
        driver.switchTo().alert().sendKeys("hello");
        Thread.sleep(1000);
        //5. Click to OK button from the alert
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        //6. Verify "You entered: hello" text is displayed.
        WebElement message = driver.findElement(By.xpath("//p[@style='color:green']"));
        String str = message.getText();
        System.out.println(str);  // just printing text of displayed message
        Assert.assertTrue(message.isDisplayed());
    }
    @AfterMethod
    public void tearDown(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        driver.quit();
    }
}
