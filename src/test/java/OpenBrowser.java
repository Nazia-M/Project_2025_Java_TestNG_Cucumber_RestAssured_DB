import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenBrowser {

    @Test
    public void openChrome() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com/");
        Thread.sleep(5000);
        String title = driver.getTitle();
        Assert.assertEquals(title, "Google");
        driver.close();
    }
}
