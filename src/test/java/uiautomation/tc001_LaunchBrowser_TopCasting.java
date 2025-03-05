package uiautomation;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class tc001_LaunchBrowser_TopCasting {

    @Test
    public void launchBrowser() throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();

//        WebDriver driver = new ChromeDriver();
//
//        SearchContext driver = new ChromeDriver();
//
//        WebDriver driver = new RemoteWebDriver(remoteAddress, capacbilities);
//
//        SearchContext driver = new RemoteWebDriver(remoteAddress, capacbilities);
//
//        RemoteWebDriver driver = new ChromeDriver();

//        ChromiumDriver driver = new ChromeDriver();


        driver.get("https://www.google.com");
        Thread.sleep(5000);

        driver.manage().window().maximize();
        Thread.sleep(5000);

        driver.manage().window().minimize();
        Thread.sleep(5000);

        driver.manage().window().fullscreen();
        Thread.sleep(5000);

        driver.quit();
    }
}
