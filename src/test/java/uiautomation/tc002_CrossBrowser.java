package uiautomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class tc002_CrossBrowser {

    static WebDriver driver;

    @Test
    public void crossBrowser(){
        String browser = "chrome";

        switch(browser.trim().toLowerCase())
        {
            case "chrome"  :  driver=new ChromeDriver();
                break;
            case "firefox" :  driver=new FirefoxDriver();
                break;
            case "edge"    :  driver=new EdgeDriver();
                break;
            case "safari"  :  driver=new SafariDriver();
                break;
            default        :  System.out.println("Please enter Valid Browser"+browser);

                throw new RuntimeException("Invalid rowser");
        }
        driver.get("https://www.google.com");

        driver.quit();
    }
}
