package uiautomation;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class tc005_checkBrowserUtils {

    @Test
    public void cartOpen(){

        BrowserUtil util = new BrowserUtil();
        WebDriver driver = util.initDriver("chrome");
        util.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        util.getPageTitle();
        util.getPageURL();
        util.quitBrowser();
    }
}
