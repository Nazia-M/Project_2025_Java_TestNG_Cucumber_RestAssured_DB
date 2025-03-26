package uiautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class tc011_sendKeysConcept {

    @Test
    public void sendKeysConcept() throws InterruptedException {

        BrowserUtil bUtil = new BrowserUtil();

        WebDriver driver = bUtil.initDriver("chrome");

        bUtil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        Thread.sleep(3000);
        System.out.println(bUtil.getPageTitle());

        ElementUtil eUtil = new ElementUtil(driver);

        String Street = "Happy Street, Beautiful Lane";
        StringBuilder landmark = new StringBuilder("Internet City Dubai");
        StringBuffer country = new StringBuffer( "UAE");
        String zipcode = "LUXURY RICH";

        By labelEmailid = By.xpath("//label[text()='E-Mail Address']");
        eUtil.highlight(labelEmailid);


        By emailId = By.id("input-email");
        eUtil.sendKeysData(emailId, Street, " , ", landmark, " , " , country , " , ", zipcode);

    }


}
