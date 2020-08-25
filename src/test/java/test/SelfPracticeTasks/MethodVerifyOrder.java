package test.SelfPracticeTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.utilities.SmartBearUtilities;
import test.utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * PRACTICE #4: Method: verifyOrder
 * Create a method named verify
 * Order in SmartBearUtils class.
 * •Method takes WebDriver object and String(name).
 * •Method should verify if given name exists in orders.
 * •This method should simply accepts a name(String), and assert whether given name is in the list or not.
 * •Create a new TestNG test to test if the method is working as expected
 */
public class MethodVerifyOrder {

    WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    //Create a method named verify

    public void verify(WebDriver driver, String name) {
        // * Order in SmartBearUtils class.
        SmartBearUtilities.login(driver);

        // * •Method takes WebDriver object and String(name).
        // * •Method should verify if given name exists in orders.
        // * •This method should simply accepts a name(String), and assert whether given name is in the list or not.
        // * •Create a new TestNG test to test if the method is working as expected
        List<WebElement> verifyName =  driver.findElements(By.xpath("//td[2][count(*)=0]")); // 8 names
        String actualName = "";

        for (WebElement each:verifyName){
            if ( each.getText().equals(name)){
                actualName+=each.getText();
            }
        }
        Assert.assertEquals(actualName,name);


    }

    @Test
    public void test() {
            verify(driver,"Steve Johns");
    }

}