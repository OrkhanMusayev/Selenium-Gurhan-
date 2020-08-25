package test.day8_alerts_iframes_windows;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.utilities.SmartBearUtilities;
import test.utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

/**
 * **
 *  * PRACTICE #4: Method: verifyOrder
 *  * Create a method named verify
 *  * Order in SmartBearUtils class.
 *  * •Method takes WebDriver object and String(name).
 *  * •Method should verify if given name exists in orders.
 *  * •This method should simply accepts a name(String), and assert whether given name is in the list or not.
 *  * •Create a new TestNG test to test if the method is working as expected
 *  */

public class WebtablePracticesTask4 {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        //TC #1: Smartbear software link verification
        //1. Open browser
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void p4_verifyOrder_test(){
        //Logging into smartbear
        SmartBearUtilities.login(driver);

        //Call my method the verify if given name is in the list or not.
        SmartBearUtilities.verifyOrder(driver, "Ricky Martin");

    }

    @Test
    public void p5_print_names_cities_test(){
        SmartBearUtilities.login(driver);
        SmartBearUtilities.printNamesAndCities(driver);

    }
    }


