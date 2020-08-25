package test.SelfPracticeTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

/**
 * TC #5: Selecting value from non-select dropdown
 * 1. Open Chrome browser
 * 2. Go to http://practice.cybertekschool.com/dropdown
 * 3. Click to non-select dropdown
 * 4. Select Facebook from dropdown
 * 5. Verify title is “Facebook - Log In or Sign Up”
 */

public class nonSelect_Dropdown {

        WebDriver driver;

        @AfterMethod
        public void tearDown() throws Exception{
            Thread.sleep(3000);
            driver.close();
        }

        @BeforeMethod
        public void setup() {
            //1. Open Chrome browser
            //2. Go to http://practice.cybertekschool.com/dropdown
            driver = WebDriverFactory.getDriver("chrome");
            driver.get("http://practice.cybertekschool.com/dropdown");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
@Test
public void test() throws Exception {

    //3. Click to non-select dropdown
    WebElement nonSelect = (driver.findElement(By.xpath("//a[@id='dropdownMenuLink']")));
    nonSelect.click();

    Thread.sleep(1000);
    //4. Select Facebook from dropdown
    driver.findElement(By.xpath("//a[.='Facebook']")).click();


    //5. Verify title is “Facebook - Log In or Sign Up”
    String title = driver.getTitle();
    String expectedTitle = "Facebook - Log In or Sign Up";
    Assert.assertEquals(title,expectedTitle);
}
}


