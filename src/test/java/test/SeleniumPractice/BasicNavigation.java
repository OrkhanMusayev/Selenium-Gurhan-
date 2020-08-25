package test.SeleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {

    public static void main(String[] args) throws Exception{
        // to setup chrome browser
        WebDriverManager.chromedriver().setup();

        // to create an object of chromedriver class
        WebDriver driver = new ChromeDriver();

        String url1 = "http://google.com";// google website
        String url2 = "http://amazon.com";

        // will open browser with url
        // open  google.com
        driver.get(url1); // google.com

        // will put on hold current run on 3 seconds
        Thread.sleep(3000);

        // navigate to the Amazon.com
        driver.navigate().to(url2);// amazon.com
        Thread.sleep(3000); // wait for 3 seconds

        // will navigate back to the previous URL
        // in our case it's google.com
        driver.navigate().back(); // google.com -> amazon.com -> navigate().back() -> to google.com
        Thread.sleep(3000); // wait for 3 seconds

        // google.com -> amazon.com -> navigate().back() -> to google.com -> navigate().forward() -> to amazon.com
        driver.navigate().forward();
        Thread.sleep(3000); // wait for 3 seconds

        // will refresh the page
        driver.navigate().refresh();
        Thread.sleep(3000); // wait for 3 seconds

        // will close web browser
        driver.close();



    }
}
