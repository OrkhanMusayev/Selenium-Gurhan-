package test.day7_javafaker_webtables;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

/**
 * 1.Open browser
 * 2.Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
 * 3.Enter username: “Tester”
 * 4.Enter password: “test”
 * 5.Click on Login button
 * 6.Click on Order
 * 7.Select familyAlbum from product, set quantity to 2
 * 8.Click to “Calculate” button
 * 9.Fill address Info with JavaFaker
 * •Generate: name, street, city, state, zip code
 * 10.Click on “visa” radio button
 * 11.Generate card number using JavaFaker
 * 12.Click on “Process”
 * 13.Verify success message “New order has been successfully added.
 */
public class SmartBearOrderPlacing {
    WebDriver driver;
    @BeforeMethod
    public void setup() {

        //1.Open browser
        // * 2.Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

    }
        @Test
        public void test() throws Exception{

        // 3.Enter username: “Tester”
        WebElement inputUserName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        inputUserName.sendKeys("Tester");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // * 4.Enter password: “test”
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        inputPassword.sendKeys("test");

        // * 5.Click to Login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        loginButton.click();

            //6. Click on Order
            WebElement orderLink = driver.findElement(By.xpath("//a[.='Order']"));
            orderLink.click();

            //7. Select familyAlbum from product, set quantity to 2
            Select productDropdown = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
            productDropdown.selectByVisibleText("FamilyAlbum");

            WebElement quantityInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));

            //quantityInput.clear(); //just deletes if there is any existing input in the input box.
            Thread.sleep(1000);
            //Imitating as if the user is pressing the BACKSPACE key on keyboard to delete something.
            quantityInput.sendKeys(Keys.BACK_SPACE);

            Thread.sleep(1000);
            quantityInput.sendKeys("2");

            //8. Click to “Calculate” button
            WebElement calculateButton = driver.findElement(By.xpath("//input[@value='Calculate']"));
            calculateButton.click();

            //9. Fill address Info with JavaFaker
            WebElement inputCustomerName = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
            WebElement inputStreet = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
            WebElement inputCity = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
            WebElement inputState = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
            WebElement inputZip = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));

            Faker faker = new Faker();

            //• Generate: name, street, city, state, zip code
            // Entering name using javafaker.
            inputCustomerName.sendKeys(faker.name().fullName());

            //Entering street using javafaker
            inputStreet.sendKeys(faker.address().streetName());

            //Entering city using javafaker
            inputCity.sendKeys(faker.address().city());

            //Entering state using javafaker
            inputState.sendKeys(faker.address().state());

            //Entering zipcode using javafaker
            String zipcode = faker.address().zipCode().replaceAll("-","");
            inputZip.sendKeys(zipcode);

            //10. Click on “visa” radio button
            WebElement visaRadioButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));
            visaRadioButton.click();

            //11. Generate card number using JavaFaker
            WebElement inputCardNumber = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));

            //Entering credit card number using faker
            inputCardNumber.sendKeys(faker.finance().creditCard().replaceAll("-",""));

            //Entering date
            WebElement expirationDate = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1"));
            expirationDate.sendKeys("12/25");

            //12. Click on “Process”
            WebElement processButton = driver.findElement(By.xpath("//a[.='Process']"));
            processButton.click();

            //13.Verify success message “New order has been successfully added.”
            //strong

            WebElement successMessage=driver.findElement(By.xpath("//div[@class='buttons_process']/strong"));
            Assert.assertTrue(successMessage.isDisplayed());
            //   Assert.assertTrue(successMessage.getText().equals("New order has been successfully added."));
            System.out.println("New order has been successfully added >> "+successMessage.isDisplayed());

    }
}
