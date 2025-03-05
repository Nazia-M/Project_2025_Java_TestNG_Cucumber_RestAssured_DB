package uiautomation;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class tc004_navigate {

    static WebDriver driver;

    @Test
    public void getAndNavgiateTo() throws MalformedURLException {
        driver.get("https://www.google.com");
        driver.navigate().to("https://www.amazon.com");
        driver.navigate().to(new URL("https://www.myntra.com"));
    }
}
