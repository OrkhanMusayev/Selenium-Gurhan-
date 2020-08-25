package test.day7_javafaker_webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.utilities.SmartBearUtilities;
import test.utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

/**
 * TC#3: Smartbear software order verification
 * 1.Open browser and login to Smartbear software
 * 2.Click on View all orders
 * 3.Verify Susan McLaren has order on date “01/05/2010”
 */
public class SmartBearOrderVerification {

    WebDriver driver;
    @BeforeMethod
    public void setup() {

        //1.Open browser
        // * 2.Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        SmartBearUtilities.login(driver);
    }

    @Test
    public void test(){
        //2. Click on View all orders
        WebElement viewAll = driver.findElement(By.xpath("//a[.='View all orders']"));
        viewAll.click();

        //3. Verify Susan McLaren has order on date “01/05/2010”
        WebElement susansDate = driver.findElement(By.xpath("//td[.='Susan McLaren']/following-sibling::td[3]"));

        String expectedDate = "01/05/2010";
        String actualDate = susansDate.getText();

        Assert.assertEquals(actualDate, expectedDate);



    }
}
