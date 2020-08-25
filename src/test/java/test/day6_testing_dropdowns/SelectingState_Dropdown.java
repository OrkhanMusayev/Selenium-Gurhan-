package test.day6_testing_dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import test.utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

/**
 * TC #2: Selecting state from State dropdown and verifying result
 * 1. Open Chrome browser
 * 2. Go to http://practice.cybertekschool.com/dropdown
 * 3. Select Illinois
 * 4. Select Virginia
 * 5. Select California
 * 6. Verify final selected option is California.
 * Use all Select options. (visible text, value, index)
 */
public class SelectingState_Dropdown {
    WebDriver driver;

    @AfterMethod
    public void tearDown() throws Exception{
        Thread.sleep(3000);
        driver.close();
    }

    @BeforeMethod
    public void setup() {
        //1. Open Chrome browser
        // * 2. Go to http://practice.cybertekschool.com/dropdown
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void test2_state_dropdown_verification() throws Exception{

        //locating state dropdown
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        // 3. Select Illinois
        //Selecting using .selectByValue(); method --> Expected the attribute value of "value" attribute.
        Thread.sleep(1000);
        stateDropdown.selectByValue("IL");

        // 4. Select Virginia
        Thread.sleep(1000);
        stateDropdown.selectByVisibleText("Virginia");

        // 5. Select California
        Thread.sleep(1000);
        stateDropdown.selectByIndex(5);

        // 6. Verify final selected option is California.
        String expectedOption = "California";
        String actualSelectedOption = stateDropdown.getFirstSelectedOption().getText();

        //Assert.assertEquals(actualSelectedOption, expectedOption);
        // What's different between Assert.assertEquals & Assert.assertTrue ???
        Assert.assertTrue(actualSelectedOption.equals(expectedOption));

    }


}