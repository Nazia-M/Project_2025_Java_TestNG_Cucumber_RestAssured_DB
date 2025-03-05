package uiautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class tc005_GoogleSearch {

    @Test
    public void googleSearch() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com/");
        driver.manage().window().maximize();
        Thread.sleep(10000);

        driver.findElement(By.name("q")).sendKeys("Selenium Automation");

        Thread.sleep(3000);

        List<WebElement> sugList = driver.findElements(By.xpath(("//div[@class='wM6W7d']/span")));

        for(WebElement e:sugList){
            String text = e.getText();
            System.out.println(text);
            if(text.contains("python")){
                e.click();
                break;
            }
        }

    }
}
