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
 * TC #9: SmartBear delete order
 * 1.Open browser and login to SmartBear
 * 2.Delete “Mark Smith” from the list
 * 3.Assert it is deleted from the list
 *
 *TC #10: SmartBear edit order
 * 1.Open browser and login to SmartBear
 * 2.Click to edit button from the right for “Steve Johns”
 * 3.Change name to “Michael Jordan”
 * 4.Click Update5.Assert “Michael Jordan” is in the listTC
 *
 * #11: Create a method called removeName()
 * 1.Accepts two parameters: WebDriver, String name
 * 2.Method will remove the given name from the list of Smartbear
 * 3.Create a new TestNG test, and call your method.
 * 4.Assert that your method removed the given name
 */
public class SmartBearDeleteOrderT9_T10_T11 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBearUtilities.login(driver);
    }

    @Test
    public void task9_deleteOrderTest() {

        //Locating Mark Smith checkbox button using "Mark Smith" text with xpath
        WebElement markSmithCheckBox = driver.findElement(By.xpath("//td[.='Mark Smith']/../td[1]"));

        //Clicking to the checkbox
        markSmithCheckBox.click();

        //Locating the delete button under the table
        WebElement deleteButton = driver.findElement(By.id("ctl00_MainContent_btnDelete"));

        //Clicking to the delete button and deleting the Mark Smith from the table
        deleteButton.click();

        //Locating all the names from the web table and storing them into a list if web elements
        List<WebElement> allNames = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));


        //Looping through the list of names, and asserting Mark Smith is not in the table anymore
        for (WebElement name : allNames) {
            Assert.assertFalse(name.getText().equals("Mark Smith"));
        }

    }

    @Test
    public void task10_editOrderTest() {
        //Storing the Steve's edit button xpath locator in a string.
        String xpathForSteveEditButton = "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[.='Steve Johns']/../td[13]";

        //Passing the locator into driver.findElement method
        WebElement editButtonSteveJohns = driver.findElement(By.xpath(xpathForSteveEditButton));

        //Clicking to the edit button
        editButtonSteveJohns.click();

        //Locating the input box where we enter the new name we want to change to.
        WebElement customerNameInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));

        //Clearing the previously entered name from the input box
        customerNameInput.clear();

        //Sending new name into the input box
        customerNameInput.sendKeys("Michael Jordan");

        //Locating the update button to update the new name
        WebElement updateButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton"));

        //Clicking to the update button
        updateButton.click();

        //Locating all the names from the web table and storing them into a list if web elements
        List<WebElement> allNames = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));

        //Looping through the list of names, and asserting Michael Jackson is in the list.
        for (WebElement name : allNames) {
            if (name.getText().equals("Michael Jordan")) {
                Assert.assertTrue(name.getText().equals("Michael Jordan"));
            }
        }

    }

    @Test
    public void task11_deleteNameTest2() {
        deleteName(driver, "Bob Feather");
    }

    /*

    Accepts 2 arguments:
    1- Webdriver
    2- String nameToBeDeleted --> This string will be used to create dynamic xpath.

    Basically we copy pasted the logic we created in the first test.
    But we made the xpathForCheckboxes dynamic by concatenating the String argument into the xpath itself.

     */
    public static void deleteName(WebDriver driver, String nameToBeDeleted) {

        String xpathForCheckboxes = "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[.='" + nameToBeDeleted + "']/../td[1]";

        //String word = "example";
        //String sentence = "This is "+word+"my sentence";
        //We used similar string concat logic in our xpath above. All we do is we dynamically pass the String argument we
        //  get from our method.
        //  This way we manipulate our xpath locator. Which allows us to delete any name from list.

        //We pass our xpath in the web element locator
        WebElement dynamicCheckBox = driver.findElement(By.xpath(xpathForCheckboxes));

        //WebElement locator dynamically finds the given name's checkbox. Then we click to it.
        dynamicCheckBox.click();

        //Locating and clicking the delete button.
        WebElement deleteButton = driver.findElement(By.id("ctl00_MainContent_btnDelete"));
        deleteButton.click();

        //Locating all the names from the web table and storing them into a list if web elements
        List<WebElement> allNames = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));


        //Looping through the list of names, and asserting nameToBeDeleted is NOT in the list.
        for (WebElement name : allNames) {
            System.out.println(name.getText());
            Assert.assertFalse(name.getText().equals(nameToBeDeleted));

        }


    }
}

