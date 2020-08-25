package test.SelfPracticeTasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * TC#7: Cybertek “month” dropdown default value
 * 1. Open browser
 * 2. Go to website: http://practice.cybertekschool.com/dropdowns
 * 3. Verify default value is always showing the current month
 * o Expected: If currently in June, should show June selected.
 *
 * TC#8: Cybertek “month” dropdown list of default values verification
 * 1. Do both verifications in the same test
 * 2. Verify list of months are correct as expected.
 * o Expected: Options should contain all 12 months of the year.
 */
public class CybertekMonthDropdownDefaultValue7_8 {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test() {

        Select year = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        String actYear = year.getFirstSelectedOption().getText();

        Select month = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        String actMonth = month.getFirstSelectedOption().getText();

        Select day = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        String actDay = day.getFirstSelectedOption().getText();

        String expected = "2020 June 26";
        String actual = actYear + " " + actMonth + " " + actDay;
        Assert.assertEquals(actual, expected);

    }


    //1. Do both verifications in the same test
    // * 2. Verify list of months are correct as expected.
    // * o Expected: Options should contain all 12 months of the year.

    @Test
    public void test2() {

        Select selectMonth = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        String actualMonth = selectMonth.getFirstSelectedOption().getText();
        String expectedMonth = "June";

        Assert.assertEquals(actualMonth, expectedMonth);
        List<WebElement> list = selectMonth.getOptions();
        Assert.assertEquals(list.size(), 12);
    }
}