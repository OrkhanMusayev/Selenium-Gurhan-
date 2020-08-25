package test.SelfPracticeTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.utilities.Driver;

/**
 * TC	#16:	Double	ClickTest
 * 1.Go	to	https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
 * 2.Switch	to	iframe.
 * 3.Double	click	on	the	text	“Double-click	me	to	change	my	text	color.
 * ”4.Assert:	Text’s	“style”	attribute	value contained "red".
 */
public class DoubleClickTest16 {


    @Test
    public void test() {

        //1. Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        Driver.getDriver().manage().window().maximize();

        //2. Switch to iframe.
        // 1- index 2- id-name value 3-locate it as a webELement and pass it into
        Driver.getDriver().switchTo().frame("iframeResult");

        //3. Double click on the text “Double-click me to change my text color.”
        WebElement textToDoubleClick = Driver.getDriver().findElement(By.id("demo"));

        Actions actions = new Actions(Driver.getDriver());

        actions.doubleClick(textToDoubleClick).perform();


        //4. Assert: Text’s “style” attribute value contains “red”.

        String actual = textToDoubleClick.getAttribute("style");
        String expected = "color: red;";

        Assert.assertTrue(actual.equals(expected));


    }
}