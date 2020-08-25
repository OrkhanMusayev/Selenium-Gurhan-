package test.SelfPracticeTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * XPATH PRACTICES DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
 * TC #3: PracticeCybertek.com_AddRemoveElements WebElement verification
 * 1. Open Chrome browser
 * 2. Go to http://practice.cybertekschool.com/add_remove_elements
 * 3. Click to “Add Element” button 50 times
 * 4. Verify 50 “Delete” button is displayed after clicking.
 * 5. Click to ALL “Delete” buttons to delete them.
 * 6. Verify “Delete” button is NOT displayed after clicking.
 * USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS Hint: Need to use findElements method
 */
public class AddRemoveElements {
    public static void main(String[] args) throws InterruptedException {

        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // 2. Go to http://practice.cybertekschool.com/add_remove_elements
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");

        // 3. Click to “Add Element” button 50 times
        WebElement click = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        for (int i = 1; i <= 50; i++) {
            click.click();
        }

        // 4. Verify 50 “Delete” button is displayed after clicking.
        List<WebElement> deleteButton = driver.findElements(By.xpath("//div[@id='elements']/button"));
        int count = 0;
        for (WebElement eachDelButton : deleteButton) {
            if (eachDelButton.isDisplayed()) {
                System.out.println("Delete Button is DISPLAYED, Passed!!!");
                count++;
            }
        }
        if (count == 50) {
            System.out.println("Verification Passed!!!");
        } else {
            System.out.println("Failed!!!");
        }
        System.out.println("Number of Delete buttons: " + count);
        Thread.sleep(3000);

        // 5. Click to ALL “Delete” buttons to delete them.
        List<WebElement> delete = driver.findElements(By.xpath("//div[@id='elements']"));
        for (int x = 1; x <= count; x++) {
            driver.findElement(By.xpath("//div[@id='elements']/button")).click();
        }

        // 6. Verify “Delete” button is NOT displayed after clicking.
        try {
            if (driver.findElement(By.xpath("//div[@id='elements']/button")).isDisplayed()) {
                System.out.println("Failed!!!");

            }
        } catch (Exception e) {
            System.out.println("Passed!!!");

        }
    }
    }




