package test.day04_findElements_checkbox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * TC #03: FIND ELEMENTS_APPLE
 * 1.Open Chrome browser
 * 2.Go to https://www.apple.com
 * 3.Click to all of the headers one by one
 * a.Mac, iPad, iPhone, Watch, TV, Music, Support
 * 4.Printout how many links on each page with the titles of the pages
 * 5.Loop through all
 * 6.Print out how many link is missing textTOTAL
 * 7.Print out how many link has textTOTAL
 * 8.Print out how many total linkTOTAL
 */
public class P03_Apple_FindElements {

    public static void main(String[] args) throws InterruptedException {

        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // 2. Go to https://www.apple.com
        driver.get("https://www.apple.com");

        // 3. Click to all of the headers one by one
        //  a. Mac, iPad, iPhone, Watch, TV, Music, Support
        //  4. Print out how many links on each page with the titles of the pages
        Thread.sleep(2000);

        //  Mac module
        driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-mac']")).click();
        Thread.sleep(2000);
        List<WebElement> macList = driver.findElements(By.xpath("//body//li"));
        int macLinkWithoutText=0;
        int macLinkWithText=0;
        for (WebElement eachMac:macList){
            String temp = eachMac.getText();
            if (temp.isEmpty()){
                macLinkWithoutText++;
            }else{
                macLinkWithText++;
            }
        }
        String macPageTitle = driver.getTitle();
        int macPageLinks = macList.size();
        System.out.println("Mac Page Title: "+macPageTitle);
        System.out.println("Mac Page Total links: "+macPageLinks);
        System.out.println("Links without text: "+macLinkWithoutText);
        System.out.println("Links with text: "+macLinkWithText);

        System.out.println("======================================================");

        // iPad module
        driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-ipad']")).click();
        Thread.sleep(2000);
        List<WebElement> iPadList = driver.findElements(By.xpath("//body//li"));
        int iPadLinkWithoutText=0;
        int iPadLinkWithText=0;
        for (WebElement eacIpad:iPadList){
            String temp = eacIpad.getText();
            if (temp.isEmpty()){
                iPadLinkWithoutText++;
            }else{
                iPadLinkWithText++;
            }
        }
        String iPadPageTitle = driver.getTitle();
        int iPadPageLinks = macList.size();
        System.out.println("iPad Page Title: "+iPadPageTitle);
        System.out.println("iPad Page Total links: "+iPadPageLinks);
        System.out.println("Links without text: "+iPadLinkWithoutText);
        System.out.println("Links with text: "+iPadLinkWithText);

        System.out.println("======================================================");

        // iPhone module
        driver.findElement(By.xpath("//li[@class='ac-gn-item ac-gn-item-menu ac-gn-iphone']")).click();
        Thread.sleep(2000);
        List<WebElement> iPhoneList = driver.findElements(By.xpath("//body//li"));
        int iPhoneLinkWithoutText=0;
        int iPhoneLinkWithText=0;
        for (WebElement eacIphone:iPhoneList){
            String temp = eacIphone.getText();
            if (temp.isEmpty()){
                iPhoneLinkWithoutText++;
            }else{
                iPhoneLinkWithText++;
            }
        }
        String iPhonePageTitle = driver.getTitle();
        int iPhonePageLinks = macList.size();
        System.out.println("iPhone Page Title: "+iPhonePageTitle);
        System.out.println("iPhone Page Total links: "+iPhonePageLinks);
        System.out.println("Links without text: "+iPhoneLinkWithoutText);
        System.out.println("Links with text: "+iPhoneLinkWithText);

        System.out.println("======================================================");

        // Watch module
        driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-watch']")).click();
        Thread.sleep(2000);
        List<WebElement> watchList = driver.findElements(By.xpath("//body//li"));
        int watchLinkWithoutText=0;
        int watchLinkWithText=0;
        for (WebElement eachWatch:watchList){
            String temp = eachWatch.getText();
            if (temp.isEmpty()){
                watchLinkWithoutText++;
            }else{
                watchLinkWithText++;
            }
        }
        String watchPageTitle = driver.getTitle();
        int watchPageLinks = macList.size();
        System.out.println("Watch Page Title: "+watchPageTitle);
        System.out.println("Watch Page Total links: "+watchPageLinks);
        System.out.println("Links without text: "+watchLinkWithoutText);
        System.out.println("Links with text: "+watchLinkWithText);

        System.out.println("======================================================");

        // TV module
        driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-tv']")).click();
        Thread.sleep(2000);
        List<WebElement> tvList = driver.findElements(By.xpath("//body//li"));
        int tvLinkWithoutText=0;
        int tvLinkWithText=0;
        for (WebElement eachTv:tvList){
            String temp = eachTv.getText();
            if (temp.isEmpty()){
                tvLinkWithoutText++;
            }else{
                tvLinkWithText++;
            }
        }
        String tvPageTitle = driver.getTitle();
        int tvPageLinks = macList.size();
        System.out.println("TV Page Title: "+tvPageTitle);
        System.out.println("TV Page Total links: "+tvPageLinks);
        System.out.println("Links without text: "+tvLinkWithoutText);
        System.out.println("Links with text: "+tvLinkWithText);

        System.out.println("======================================================");

        // Music module
        driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-music']")).click();
        Thread.sleep(2000);
        List<WebElement> musicList = driver.findElements(By.xpath("//body//li"));
        int musicLinkWithoutText=0;
        int musicLinkWithText=0;
        for (WebElement eachMusic:musicList){
            String temp = eachMusic.getText();
            if (temp.isEmpty()){
                musicLinkWithoutText++;
            }else{
                musicLinkWithText++;
            }
        }
        String musicPageTitle = driver.getTitle();
        int musicPageLinks = macList.size();
        System.out.println("Music Page Title: "+musicPageTitle);
        System.out.println("Music Page Total links: "+musicPageLinks);
        System.out.println("Links without text: "+musicLinkWithoutText);
        System.out.println("Links with text: "+musicLinkWithText);

        System.out.println("======================================================");

        // Support module
        driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-support']")).click();
        Thread.sleep(2000);
        List<WebElement> supportList = driver.findElements(By.xpath("//body//li"));
        int supportLinkWithoutText=0;
        int supportLinkWithText=0;
        for (WebElement eachSupport:supportList){
            String temp = eachSupport.getText();
            if (temp.isEmpty()){
                supportLinkWithoutText++;
            }else{
                supportLinkWithText++;
            }
        }
        String supportPageTitle = driver.getTitle();
        int supportPageLinks = macList.size();
        System.out.println("Support Page Title: "+supportPageTitle);
        System.out.println("Support Page Total links: "+supportPageLinks);
        System.out.println("Links without text: "+supportLinkWithoutText);
        System.out.println("Links with text: "+supportLinkWithText);




    }
}


