package test.day04_findElements_checkbox_radio;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_Cybertek_AddRemoveElements {
    public static void main(String[] args) throws Exception {

        //TC #2: PracticeCybertek.com_AddRemoveElements WebElementverification
        // 1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to http://practice.cybertekschool.com/add_remove_elements
         driver.get("http://practice.cybertekschool.com/add_remove_elements/");

         //3. Click to "Add Element" button
        WebElement addElementButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        // "//button[.='Add Element'] -- > second way by text
        Thread.sleep(2000);
        addElementButton.click();

        //4. Verify "Delete" button is displayed after clicking
        WebElement deleteButton = driver.findElement(By.xpath("//button[@class='added-manually']"));
        ///button[.='Delete'] --> second way by text
        if (deleteButton.isDisplayed()){
            System.out.println("Delete button is displayed. Verification passed!");
        }else{
            System.out.println("Delete button is NOT displayed. Verification failed!");
        }

        //5. Click to "Delete" button
        //6. Verify "Delete" button is NOT displayed after clicking
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
