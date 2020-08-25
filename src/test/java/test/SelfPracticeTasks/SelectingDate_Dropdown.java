package test.SelfPracticeTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * TC #3: Selecting date on dropdown and verifying
 * 1. Open Chrome browser
 * 2. Go to http://practice.cybertekschool.com/dropdown
 * 3. Select “December 1st, 1921” and verify it is selected.
 * Select year using : visible text
 * Select month using : value attribute
 * Select day using : index number
 */
public class SelectingDate_Dropdown {

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
    public void test_date_dropdown_verification(){
        // 3. Select “December 1st, 1921” and verify it is selected.
        // * Select year using : visible text
        // * Select month using : value attribute
        // * Select day using : index number
        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        // * Select year using : visible text
        yearDropdown.selectByVisibleText("1921");
         String actualYear = yearDropdown.getFirstSelectedOption().getText();

        // Select month using : value attribute
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        monthDropdown.selectByValue("11");
        String actualMonth = monthDropdown.getFirstSelectedOption().getText();

        // * Select day using : index number
        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        dayDropdown.selectByIndex(0);
        String actualDay = dayDropdown.getFirstSelectedOption().getText();

        List<WebElement> list = dayDropdown.getOptions();
        for (WebElement each:list){ // optional ))
            System.out.println(each.getText());
        }


        String expectedYear="1921";
        String expectedMonth="December";
        String expectedDay="1";

        Assert.assertEquals(actualYear,expectedYear);
        Assert.assertEquals(actualMonth,expectedMonth);
        Assert.assertEquals(actualDay,expectedDay);




    }
}
