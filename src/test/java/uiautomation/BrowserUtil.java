package uiautomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.URL;

public class BrowserUtil {

    WebDriver driver;

    //Initialize driver give BrowserName=Chrome and it will return WebDriver
    public WebDriver initDriver(String browserName){
        System.out.println("Browser Name "+browserName);
        switch(browserName.trim().toLowerCase())
        {
            case "chrome"  :  driver=new ChromeDriver();
                break;
            case "firefox" :  driver=new FirefoxDriver();
                break;
            case "edge"    :  driver=new EdgeDriver();
                break;
            case "safari"  :  driver=new SafariDriver();
                break;
            default        :
                System.out.println("Please enter Valid Browser"+browserName);
                throw new BrowserException("Invalid Browser");
        }
        return driver;
    }

    //This method handles all exceptions related to urls taking input as String
    public void launchURL(String url){
        lengthChech(url);
        httpCheck(url);
        driver.get(url);
    }

    //This method handles all exceptions related to urls taking input as URL
    public void launchURL(URL url){
        String appUrl = String.valueOf(url);  // Always use String.valueOf() and not toString() method
        lengthChech(appUrl);
        httpCheck(appUrl);
        driver.navigate().to(appUrl);
    }

    private void lengthChech(String value){
        if(value.length()==0){
            System.out.println("Url cannot be empty "+value);
            throw new BrowserException("---------------Empty value ---------");
        }
    }

    //this will check both http and https
    private void httpCheck(String urlValue){
        if(urlValue.indexOf("http") != 0){
            System.out.println("http is missing in the url "+urlValue);
            throw new BrowserException("------------------ http is missing in the urlValue ------------------------");
        }
    }

    public String getPageTitle(){
        String title = driver.getTitle();
        System.out.println("Page Title is "+title);
        return title;
    }

    public String getPageURL(){
        String pageURL = driver.getCurrentUrl();
        System.out.println("Page Title is "+pageURL);
        return pageURL;
    }

    public void closeBrowser(){
        if(driver != null){
            driver.close();
        }

    }

    public void quitBrowser(){
        if(driver != null){
            driver.quit();
        }

    }




}
