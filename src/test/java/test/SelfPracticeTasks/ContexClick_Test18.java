package test.SelfPracticeTasks;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import test.utilities.Driver;

/**
 * TC	#18:	Context	Click	–HOMEWORK
 * 1.Go	to	https://the-internet.herokuapp.com/context_menu
 * 2.Right	click	to	the	box.
 * 3.Alert	will	open.
 * 4.Accept	alert
 * No	assertion	needed	for	this practice
 */
public class ContexClick_Test18 {

    Actions actions;
    @Test
    public void tc18_right_click_test() {
        //1. Go to https://the-internet.herokuapp.com/context_menu
        Driver.getDriver().get("https://the-internet.herokuapp.com/context_menu");

        //2. Right click to the box.
        WebElement box = Driver.getDriver().findElement(By.id("hot-spot"));

        actions = new Actions(Driver.getDriver());

        actions.contextClick(box).perform();

        //3. Alert will open.
        Alert alert = Driver.getDriver().switchTo().alert();

        //4. Accept alert
        alert.accept();

        //No assertion needed for this practice.
    }

}
