package uiautomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class tc003_Sessionid {

    @Test
    public void sessionIdQuit() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.quit();
        System.out.println(driver.getTitle());
    }

    @Test
    public void sessionIdClose() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.close();
        System.out.println(driver.getTitle());
    }
}
