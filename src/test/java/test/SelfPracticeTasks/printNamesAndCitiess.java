package test.SelfPracticeTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Practice #5: Method: printNamesAndCities
 * •Create a method named printNamesAndCities in SmartBearUtils class.
 * •Method takes WebDriver object.
 * •This method should simply print all the names in the List of All Orders.
 * •Create a new TestNG test to test if the method is working as expected.
 * •Output should be like:
 * •Name1: name , City1: city
 * •Name2: name , City2: city
 */
public class printNamesAndCitiess {

    WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    //•Create a method named printNamesAndCities in SmartBearUtils class.
    // * •Method takes WebDriver object.

    public void printNamesAndCities(WebDriver driver){
        WebElement userNameButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        userNameButton.sendKeys("Tester");

        WebElement passwordButton = driver.findElement(By.xpath("//input[@type='password']"));
        passwordButton.sendKeys("test");

        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();

        // •This method should simply print all the names in the List of All Orders.
        // * •Create a new TestNG test to test if the method is working as expected.
        List<WebElement> names = driver.findElements(By.xpath("//td[2][count(*)=0]"));
        List<WebElement> cities = driver.findElements(By.xpath("//td[7][count(*)=0]"));

        //•Output should be like:
        // * •Name1: name , City1: city
        // * •Name2: name , City2: city
        int i=0;
        int count=1;
        for(WebElement each:names){
            System.out.println("Name"+count+": "+each.getText()+", City"+count+": "+cities.get(i).getText());
            count++;
            i++;
        }
    }

    @Test
    public void test(){
        printNamesAndCities(driver);
    }
}
