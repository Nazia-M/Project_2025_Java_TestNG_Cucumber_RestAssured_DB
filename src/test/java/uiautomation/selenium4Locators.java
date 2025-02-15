package uiautomation;

import org.apache.log4j.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class selenium4Locators {

    WebDriver driver;

    public void highlight(WebElement element) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        Thread.sleep(4000);
        js.executeScript("arguments[0].setAttribute('style', 'background: ; border: ');", element);

    }

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

        //Click Talk to Us Button which is above Percy
        System.out.println("------------------------ Click Talk to Us Button which is above Percy -------------------------");

        WebElement  percy = driver.findElement(By.xpath("//h4[text()='Percy ']"));
        System.out.println("Found Percy");
        highlight(percy);
        Thread.sleep(2000);


        WebElement talkToUs = driver.findElement(RelativeLocator.with(By.tagName("button")).above(percy));
        System.out.println("Found talkToUs Button");
        highlight(talkToUs);
        Thread.sleep(2000);


        talkToUs.click();
        System.out.println("Clicked talkToUs Button");
        Thread.sleep(6000);

        String handle = driver.getWindowHandle();
        driver.switchTo().window(handle);
        System.out.println("Switched window ");


        WebElement close = driver.findElement(By.xpath("//button/span[contains(@class, 'tingle-modal__closeIcon')]"));
        highlight(close);
        close.click();
        System.out.println("Close Button");
    }

    @Test(priority = 3)
    public void belowLocator() throws InterruptedException {

        //
        System.out.println("------------------------ Click Get Started Free Button which is below Text 'App & Browser Testing Made Easy' -------------------------");

        WebElement  ele1 = driver.findElement(By.xpath("//div[@id ='product-text-section']/h1"));
        System.out.println("Found Text");
        highlight(ele1);
        Thread.sleep(2000);


        WebElement ele2 = driver.findElement(RelativeLocator.with(By.tagName("button")).below(ele1));
        highlight(ele2);
        System.out.println("Found Talk To Us Button");
        Thread.sleep(2000);


        ele2.click();
        System.out.println("Clicked Talk To Us Button");
        Thread.sleep(6000);

        String handle = driver.getWindowHandle();
        driver.switchTo().window(handle);
        System.out.println("Switched window ");


        WebElement close = driver.findElement(By.xpath("//button/span[contains(@class, 'tingle-modal__closeIcon')]"));
        highlight(close);
        close.click();
        System.out.println("Close Button");

    }

    @Test(priority = 4)
    public void toRightOfLocator() throws InterruptedException {

        //Click Accessibility Testing which is to right of Percy
        System.out.println("------------------------ Click Accessibility Testing which is to righ tof Percy -------------------------");

        WebElement  percy = driver.findElement(By.xpath("//h4[text()='Percy ']"));
        highlight(percy);
        System.out.println("Found Percy");
        Thread.sleep(2000);


        WebElement at = driver.findElement(RelativeLocator.with(By.tagName("h4")).toRightOf(percy));
        highlight(at);
        System.out.println("Found Accessibility Testing Button");
        Thread.sleep(2000);

        at.click();
        System.out.println("Clicked Accessibility Testing Button");
        Thread.sleep(6000);

        WebElement header = driver.findElement(By.xpath("//h1"));
        String headerValue = header.getText();
        highlight(header);
        System.out.println("Header is : "+headerValue);

        driver.navigate().back();
        System.out.println("Navigated Back");

    }

    @Test(priority = 5)
    public void toLeftOfLocator() throws InterruptedException {

        //Click Automate which is to left of Percy
        System.out.println("------------------------ Click Automate Button which is left of percy -------------------------");

        WebElement  percy = driver.findElement(By.xpath("//h4[text()='Percy ']"));
        System.out.println("Found Percy");
        highlight(percy);
        Thread.sleep(2000);


        WebElement automate = driver.findElement(RelativeLocator.with(By.tagName("h4")).toLeftOf(percy));
        System.out.println("Found Automate Button");
        highlight(automate);
        Thread.sleep(2000);

        automate.click();
        System.out.println("Clicked Automate Button");
        Thread.sleep(6000);

        WebElement header = driver.findElement(By.xpath("//h1"));
        String headerValue = header.getText();
        highlight(header);
        System.out.println("Header is : "+headerValue);

        driver.navigate().back();
        System.out.println("Navigated Back");

    }


    @Test(priority = 6)
    public void tearDown() throws InterruptedException {
        System.out.println("Driver close");
        driver.close();
    }

}
