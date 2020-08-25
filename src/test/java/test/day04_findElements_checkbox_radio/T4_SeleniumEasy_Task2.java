package test.day04_findElements_checkbox_radio;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * TC #3: SeleniumEasy Checkbox Verification – Section 2
 * 1. Open Chrome browser
 * 2. Go to https://www.seleniumeasy.com/test/basic-checkbox-demo.html
 * 3. Verify “Check All” button text is “Check All”
 * 4. Click to “Check All” button
 * 5. Verify all check boxes are checked
 * 6. Verify button text changed to “Uncheck All”
 */
public class T4_SeleniumEasy_Task2 {
    public static void main(String[] args) {

        // TC #3: SeleniumEasy Checkbox Verification – Section 2
        // * 1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2. Go to https://www.seleniumeasy.com/test/basic-checkbox-demo.html
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        //3. Verify “Check All” button text is “Check All”
        WebElement checkAllButton = driver.findElement(By.xpath("//input[@value='Check All']"));
        if (checkAllButton.getAttribute("value").equals("Check All")){
            System.out.println("Button text verification Passed!!!");
        }else{
            System.out.println("Button text verification Failed!!!");
        }

        //4. Click to “Check All” button
        checkAllButton.click();

        //5. Verify all check boxes are checked
        List<WebElement> checkBoxList = driver.findElements(By.xpath("//input[@class='cb1-element']"));
        for (WebElement checkbox:checkBoxList){
            if (checkbox.isSelected()){
                System.out.println("Checkbox is selected,Passed!!!");
            }else{
                System.out.println("Checkbox is NOT selected,Failed!!!");
            }
        }

        //6. Verify button text changed to “Uncheck All”
        String actualButtonTextAfterClick = checkAllButton.getAttribute("value");
        String expectedValueAfterClick = "Uncheck All";
        if (actualButtonTextAfterClick.equals(expectedValueAfterClick)){
            System.out.println("Final verification Passed!!!");
        }else{
            System.out.println("Final verification Failed!!!");
        }
    }
}
