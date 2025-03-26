package uiautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class tc007_WebElmentApproach_TestCase {

    @Test
    public void webElementTestCase() throws InterruptedException {
        BrowserUtil bUtil = new BrowserUtil();
        WebDriver driver = bUtil.initDriver("chrome");

        bUtil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        Thread.sleep(5000);
        System.out.println(bUtil.getPageTitle());

        By emailField = By.id("input-email");
        By passField = By.id("input-password");

        ElementUtil elUtil = new ElementUtil(driver);
        elUtil.sendKeysData(emailField, "tom@gmail.com");
        elUtil.sendKeysData(passField, "pass@12345");

        Thread.sleep(5000);
        bUtil.closeBrowser();

        WebDriver driver1 = bUtil.initDriver("chrome");

        bUtil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
        Thread.sleep(5000);
        System.out.println(bUtil.getPageTitle());

        By firstName = By.id("input-firstname");
        By lastName = By.id("input-lastname");
        By email = By.id("input-email");
        By telephone = By.id("input-telephone");
        By pass = By.id("input-password");
        By passConfirm = By.id("input-confirm");

        ElementUtil elUtil1 = new ElementUtil(driver1);
        elUtil1.sendKeysData(firstName, "Nazia");
        elUtil1.sendKeysData(lastName, "M");
        elUtil1.sendKeysData(email, "nazia232@gmail.com");
        elUtil1.sendKeysData(telephone, "+971 9743294322");
        elUtil1.sendKeysData(pass, "Hello");
        elUtil1.sendKeysData(passConfirm, "Hello");



        bUtil.closeBrowser();


    }
}
