package uiautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class tc010_AttributeConcept {
    static WebDriver driver;

    @Test
    public void attributeConcept() throws InterruptedException {

        BrowserUtil bUtil = new BrowserUtil();
        driver = bUtil.initDriver("chrome");
        bUtil.launchURL("https://www.google.com/");
        Thread.sleep(5000);

        ElementUtil eUtil = new ElementUtil(driver);

        //getAttribute is deprecated from Jan 2025 onwards instead 2 new methods have come
//        WebElement firstname = driver.findElement(By.id("input-firstname"));
//        String value = firstname.getAttribute("placeholder");
//        System.out.println("Valeu "+value);
//        String value1 = firstname.getAttribute("contentEditable");
//        System.out.println("Value 1 "+value1);


//        WebElement firstname = driver.findElement(By.id("input-firstname"));

//        String value = firstname.getDomAttribute("placeholder");
//        System.out.println("getDomAttribute placeholder : "+value);
//
//        String value1 = firstname.getDomProperty("contentEditable");
//        System.out.println("getDomProperty contentEditable : "+value1);


        /*
        Creating Utils
         */
        By search = By.id("APjFqb");
        eUtil.sendKeysData(search, "Selenium");
        System.out.println(eUtil.getElementDomAttribute(search, "title"));
        System.out.println(eUtil.getElementDomProperty(search, "value"));

        Thread.sleep(5000);
        bUtil.closeBrowser();

    }

}
