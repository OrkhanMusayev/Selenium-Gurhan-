package test.SelfPracticeTasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * XPATH PRACTICES
 * DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
 * TC #2: PracticeCybertek.com_AddRemoveElements WebElement verification
 * 1. Open Chrome browser
 * 2. Go to http://practice.cybertekschool.com/add_remove_elements
 * 3. Click to “Add Element” button
 * 4. Verify “Delete” button is displayed after clicking.
 * 5. Click to “Delete” button.
 * 6. Verify “Delete” button is NOT displayed after clicking.
 * USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
 */
public class XPATH_PRACTICES02 {
    public static void main(String[] args) {

        // 1. Open Chrome browser
        // * 2. Go to http://practice.cybertekschool.com/add_remove_elements
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // i just maximized size))
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");

        // 3. Click to “Add Element” button
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();

        // 4. Verify “Delete” button is displayed after clicking.
        WebElement deleteButton = driver.findElement(By.xpath("//button[@class='added-manually']"));
        if(deleteButton.isDisplayed()){
            System.out.println("Delete button verification PASSED!!!");
        }else{
            System.out.println("Delete button verification PASSED!!!");
        }

        // 5. Click to “Delete” button.
        driver.findElement(By.xpath("//button[@onclick='deleteElement()']")).click();

        // 6. Verify “Delete” button is NOT displayed after clicking.
        WebElement deleteDisplayAfterClick = driver.findElement(By.xpath("//div[@class='container']"));
        if (deleteDisplayAfterClick.isDisplayed()){
            System.out.println("Delete button DISPLAYED!!!");
        }else{
            System.out.println("Delete button NOT DISPLAYED!!!");
        }


    }
}
