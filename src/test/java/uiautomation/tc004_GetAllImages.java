package uiautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class tc004_GetAllImages {

    //Find total number of links on the page
    //Print text of each link on the console if text is not empty

    @Test
    public void links() throws InterruptedException {

        System.out.println("-----------  Images  --------------------");

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.flipkart.com/");
        Thread.sleep(10000);
        System.out.println("Navigated to Amazon");

        List<WebElement> imgList = driver.findElements(By.tagName("img"));
        System.out.println("Got All Images");

        System.out.println("Total Images"+imgList.size());

        System.out.println("----------------------------------------------------------------------------------------------------");
        for(WebElement e : imgList){
            String altVal = e.getDomAttribute("alt");
            String srcVal = e.getDomAttribute("src");
            System.out.println(altVal+" : "+srcVal);
        }
        System.out.println("-----------------------------------------------------------------------------------------------------");

        driver.close();
        System.out.println("Closed Browser");
    }

}



