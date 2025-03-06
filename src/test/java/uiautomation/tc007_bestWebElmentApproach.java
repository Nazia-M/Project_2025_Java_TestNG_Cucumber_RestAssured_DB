package uiautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class tc007_bestWebElmentApproach {

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
        elUtil.enterData(emailField, "tom@gmail.com");
        elUtil.enterData(passField, "pass@12345");

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

        ElementUtil elUtil1 = new ElementUtil(driver);
        elUtil1.enterData(firstName, "Nazia");
        elUtil1.enterData(lastName, "M");
        elUtil.enterData(email, "nazia232@gmail.com");
        elUtil.enterData(telephone, "+971 9743294322");
        elUtil.enterData(pass, "Hello");
        elUtil.enterData(passConfirm, "Hello");



//        bUtil.closeBrowser();


    }
}
