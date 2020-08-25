package test.day11_page_object_model;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import test.utilities.ConfigurationReader;
import test.utilities.Driver;

/**
 * TC#32 : Vytrack positive login test Sales Manager
 * 1. Go to https://qa3.vytrack.com
 * 2. Enter correct username
 * 3. Enter correct password
 * 4. Verify title changedExpected: “Dashboard”
 * Note: Follow Page Object Model design pattern
 */
public class PositiveLoginTests {

    LoginPage loginPage;

    @Test
    public void store_manager_login_test() throws Exception{

        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));
        loginPage = new LoginPage();

        String username = ConfigurationReader.getProperty("storemanager_username");
        String password = ConfigurationReader.getProperty("storemanager_password");

        loginPage.login(username, password);

        //title verification
        String expectedTitle = "Dashboard";


        Thread.sleep(3000);
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);


    }


}
