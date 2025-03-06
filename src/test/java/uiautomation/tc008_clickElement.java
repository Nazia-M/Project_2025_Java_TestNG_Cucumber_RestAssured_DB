package uiautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class tc008_clickElement {

    @Test
    public void clickElement() throws InterruptedException {
        BrowserUtil bUtil = new BrowserUtil();

        WebDriver driver = bUtil.initDriver("chrome");

        bUtil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        Thread.sleep(5000);
        System.out.println(bUtil.getPageTitle());

        //We can click on button, link, checkbox, radiobutton, image

        By regLink = By.linkText("Register");
        By agreeCheckbox = By.name("agree");

        ElementUtil eUtil = new ElementUtil(driver);
        eUtil.clickElement(regLink);
        eUtil.clickElement(agreeCheckbox);







    }
}
