package uiautomation;

import org.apache.log4j.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class selenium4Locators {

    WebDriver driver;

    @Test(priority = 0)
    public void OpenUrl() throws InterruptedException {
        driver = new ChromeDriver();
        driver.navigate().to("https://www.browserstack.com/");
        driver.manage().window().maximize();
        System.out.println("Lauched URL");
        Thread.sleep(8000);
    }


    @Test(priority = 2)
    public void aboveLocator() throws InterruptedException {

        WebElement  percy = driver.findElement(By.xpath("//h4[text()='Percy ']"));
        System.out.println("Found Percy");
        Thread.sleep(2000);


        WebElement talkToUs = driver.findElement(RelativeLocator.with(By.tagName("button")).above(percy));
        System.out.println("Found talkToUs Button");
        Thread.sleep(2000);


        talkToUs.click();
        System.out.println("Clicked talkToUs Button");
        Thread.sleep(6000);

        String handle = driver.getWindowHandle();
        driver.switchTo().window(handle);
        System.out.println("Switched window ");


        WebElement close = driver.findElement(By.xpath("//button/span[contains(@class, 'tingle-modal__closeIcon')]"));
        close.click();
        System.out.println("Close Button");
    }


    @Test(priority = 3)
    public void setUp() throws InterruptedException {
        System.out.println("Driver close");
        driver.close();
    }

}
