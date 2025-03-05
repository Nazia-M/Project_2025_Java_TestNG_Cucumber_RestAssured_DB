package uiautomation;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.List;

public class tc003_GetAllLinks {

    //Find total number of links on the page
    //Print text of each link on the console if text is not empty

    @Test
    public void links() {

        System.out.println("-----------Links--------------------");

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.amazon.com/");
        System.out.println("Navigated to Amazon");

        List<WebElement> linksList = driver.findElements(By.tagName("a"));
        System.out.println("Got All Links");


        System.out.println("-------------------------- For Loop Links --------------------------------------");
        for(int i=0;i<linksList.size();i++){
            //Get all links some without Text also
            String text = linksList.get(i).getText();
            //Get links with text
            if(text.length() != 0){
                System.out.println(text);
            }
        }

        System.out.println("-------------------------- This is prefeered than above for loop : For Each Loop Links using WebElement--------------------------------------");
        for(WebElement e : linksList){
            //Get all links some without Text also
            String text = e.getText();
            //Get links with text
            if(text.length() != 0){
                System.out.println(text);
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------------------");

        driver.close();
        System.out.println("Closed Browser");
    }

}



