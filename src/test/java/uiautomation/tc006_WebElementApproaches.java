package uiautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class tc006_WebElementApproaches {

    static WebDriver driver;

    @Test
    public void webElementApproach() throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        Thread.sleep(5000);

        //We can use WebElements in 5 Approaches
        //What to we do with WebElement > Create WebElement + Perform action(click,sendkeys,isDisplayed ...)

        //1. Not Reusable, need to be written everytime we need to call the element
//        driver.findElement(By.id("input-email")).sendKeys("tom@gmail.com");
//        driver.findElement(By.id("input-password")).sendKeys("pass@12345");

        //2. Store WebElement - Reusability, using driver to get elements here we are sending session id again and again
//        WebElement email = driver.findElement(By.id("input-email"));
//        WebElement pass = driver.findElement(By.id("input-password"));
//        email.sendKeys("tom@gmail.com");
//        pass.sendKeys("pass@12345");

        //3.By locator - Reusability, here we first maintain By locator[Object Repository] to store it will never hit the server then when we need it only then we will hit the server using driver
//        By emailField = By.id("input-email");
//        By passField = By.id("input-password");
//
//        WebElement email = driver.findElement(emailField);
//        WebElement pass = driver.findElement(passField);
//
//        email.sendKeys("tom@gmail.com");
//        pass.sendKeys("pass@12345");

//        4. By locator + generic function to get the element
//           By emailField = By.id("input-email");
//           By passField = By.id("input-password");
//
//            getElement(emailField).sendKeys("tom@gmail.com");
//            getElement(passField).sendKeys("pass@12345");

//        5. By locator + generic function to get the element + perform action
//            By emailField = By.id("input-email");
//            By passField = By.id("input-password");
//
//            enterData(emailField, "tom@gmail.com");
//            enterData(passField, "pass@12345");

//        6. By locator + generic function to get the element + perform action + ElementUtil
        By emailField = By.id("input-email");
        By passField = By.id("input-password");

        ElementUtil elUtil = new ElementUtil(driver);
        elUtil.sendKeysData(emailField, "tom@gmail.com");
        elUtil.sendKeysData(passField, "pass@12345");




        driver.quit();

    }

    public static void enterData(By locator,String value){
        getElement(locator).sendKeys(value);
    }

    public static WebElement getElement(By locator){
        return driver.findElement(locator);
    }




}
