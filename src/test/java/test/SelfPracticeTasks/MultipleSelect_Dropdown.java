package test.SelfPracticeTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * TC #4: Selecting value from multiple select dropdown
 * 1. Open Chrome browser
 * 2. Go to http://practice.cybertekschool.com/dropdown
 * 3. Select all the options from multiple select dropdown.
 * 4. Print out all selected values.
 * 5. Deselect all values.
 */
public class MultipleSelect_Dropdown {

    WebDriver driver;

    @AfterMethod
    public void tearDown() throws Exception{
        Thread.sleep(3000);
        //driver.close();
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
    public void test_multiple_select_dropdown(){
       // 3. Select all the options from multiple select dropdown.
        Select multipleSel = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
        for (int i=0;i<6;i++){
            multipleSel.selectByIndex(i);

        }

        //4. Print out all selected values.
        List<WebElement> list = multipleSel.getAllSelectedOptions();
        for (WebElement each:list){
            System.out.println(each.getText());
        }

        //  5. Deselect all values.
        multipleSel.deselectAll();

    }
}
