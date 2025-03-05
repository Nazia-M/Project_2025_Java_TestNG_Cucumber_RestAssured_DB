package uiautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class OpenBrowser {

    @Test
    public void openChrome() {

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id=\"APjFqb\"]")));



        String title = driver.getTitle();
        Assert.assertEquals(title, "Google");

        driver.close();
    }
}
