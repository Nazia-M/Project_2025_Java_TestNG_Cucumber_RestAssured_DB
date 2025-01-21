package uiautomation;

import groovy.util.logging.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class OpenBrowser {

    public static Logger log;


    @Test
    public void openChrome() throws InterruptedException {

        log = log.getLogger("ebanking");
        PropertyConfigurator.configure("Log4j.properties");

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com/");
        log.info("Navigated to Google");

        log.info("Waiting for 10 sec starts");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id=\"APjFqb\"]")));
        log.info("Found element so 10 sec wait ended");


        String title = driver.getTitle();
        log.info("Actual Title is : "+title);
        Assert.assertEquals(title, "Google");
        log.info("Actual and expected match");

        driver.close();
        log.info("Closed Browser");
    }
}
