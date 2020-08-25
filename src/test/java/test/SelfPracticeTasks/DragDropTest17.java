package test.SelfPracticeTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.utilities.Driver;

/**
 * //1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
 * //2. Drag and drop the small circle to bigger circle.
 * //3. Assert:
 * //-Text in big circle changed to: "You did great!"
 */
public class DragDropTest17 {

    Actions actions;
    @Test
    public void test() throws InterruptedException{


        //1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        //2. Drag and drop the small circle to bigger circle.

        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));

        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));

        //using actions instance to do drag and drop
        actions = new Actions(Driver.getDriver());

        actions.clickAndHold(smallCircle).moveToElement(bigCircle).perform();

        String expectedWhileHover = "Now drop...";
        String actualWhileHover = bigCircle.getText();

        Assert.assertEquals(actualWhileHover, expectedWhileHover);

        Thread.sleep(2000);

        actions.release().perform();

        //actions.dragAndDrop(smallCircle, bigCircle).perform();

        //3. Assert:
        //-Text in big circle changed to: “You did great!”
        String actual = bigCircle.getText();
        String expected = "You did great!";

        Assert.assertEquals(actual, expected);

    }
}
