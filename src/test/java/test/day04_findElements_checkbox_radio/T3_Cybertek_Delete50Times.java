package test.day04_findElements_checkbox_radio;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

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
public class T3_Cybertek_Delete50Times {
    public static void main(String[] args) {

        // TC #3: PracticeCybertek.com_AddRemoveElements WebElement verification
        // * 1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to http://practice.cybertekschool.com/add_remove_elements/
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");

        // 3. Click to “Add Element” button 50 times
        WebElement addElement = driver.findElement(By.xpath("//button[.='Add Element']"));
        for (int i=0; i <50; i++){
            addElement.click();
        }

        //4. Verify 50 “Delete” button is displayed after clicking.
        List<WebElement> listOfDeleteButtons = driver.findElements(By.xpath("//button[.='Delete']"));
        WebElement deleteButton = driver.findElement(By.xpath("//button[.='Delete']"));
        System.out.println("Number of delete button on the page "+listOfDeleteButtons.size());

        //5. Click to ALL “Delete” buttons to delete them.
        for (WebElement button:listOfDeleteButtons){
            button.click();
        }

        //6. Verify “Delete” button is NOT displayed after clicking.
        try {
            deleteButton.click();

            if (!deleteButton.isDisplayed()) {
                System.out.println("Delete button is NOT displayed after clicking. PASS!");
            } else {
                System.out.println("Delete button is displayed after clicking. FAILED!");
            }

        }catch (StaleElementReferenceException exception){
            System.out.println("StaleElementException has been thrown.");
            System.out.println("It means element has been completely deleted from the HTML.");
            System.out.println("Delete button is not displayed. Verification PASSED!");
        }



    }
}
