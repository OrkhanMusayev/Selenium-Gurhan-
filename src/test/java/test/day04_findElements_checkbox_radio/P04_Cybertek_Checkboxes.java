package test.day04_findElements_checkbox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

/**
 * Practice:	Cybertek	Checkboxes
 * 1.Go	to	http://practice.cybertekschool.com/checkboxes
 * 2.Confirm checkbox #1 is	NOT	selected	by	default
 * 3.Confirm	checkbox	#2	is	SELECTED	by	default.
 * 4.Click	checkbox	#1	to	select	it.
 * 5.Click	checkbox	#2	to	deselect	it.
 * 6.Confirm	checkbox	#1	is	SELECTED.
 * 7.Confirm	checkbox	#2	is	NOT
 */
public class P04_Cybertek_Checkboxes {
    public static void main(String[] args) throws InterruptedException {

        // 1.Go	to	http://practice.cybertekschool.com/checkboxes
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/checkboxes");

        // 2.Confirm checkbox #1 is	NOT	selected	by	default
        WebElement checkBox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        if (!checkBox1.isSelected()){
            System.out.println("Check box 1 is Not selected by default!!!");
        }else{
            System.out.println("Check box 1 is  selected by default!!!");
        }

        // 3.Confirm	checkbox	#2	is	SELECTED	by	default.
        WebElement checkBox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        if (checkBox2.isSelected()){
            System.out.println("Check box 2 is  selected by default!!!");
        }else{
            System.out.println("Check box 2 is NOT selected by default!!!");
        }

        // 4.Click	checkbox	#1	to	select	it.
        Thread.sleep(2000);
        checkBox1.click();

        // 5.Click	checkbox	#2	to	deselect	it.
        Thread.sleep(2000);
        checkBox2.click();

        // 6.Confirm	checkbox	#1	is	SELECTED.
        if (checkBox1.isSelected()){
            System.out.println("Check box 1 is  selected by default!!!");
        }else{
            System.out.println("Check box 1 is NOT selected by default!!!");
        }

        // 7.Confirm	checkbox	#2	is	NOT SELECTED
        if (!checkBox2.isSelected()){
            System.out.println("Check box 2 is NOT selected by default!!!");
        }else{
            System.out.println("Check box 2 is  selected by default!!!");
        }




    }
}
