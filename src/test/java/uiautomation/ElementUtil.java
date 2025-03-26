package uiautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtil {

    private WebDriver driver;

    public ElementUtil(WebDriver driver){
        this.driver = driver;
    }

    private void nullCheck(CharSequence... value){
        if(value == null)
            throw new RuntimeException("----------Value can not be null");
    }

    //SendKeys for String
    public void sendKeysData(By locator, String value) throws InterruptedException {
        nullCheck(value);
        highlight(locator);
        getElement(locator).sendKeys(value);
    }

    //SendKeys for StringBuffer and String Builder - Method overloading above
    public void sendKeysData(By locator, CharSequence... value) throws InterruptedException {
        nullCheck(value);
        highlight(locator);
        getElement(locator).sendKeys(value);
    }

    public WebElement getElement(By locator) throws InterruptedException {
        highlight(locator);
        return driver.findElement(locator);
    }

    public void clickElement(By locator) throws InterruptedException {
        highlight(locator);
        getElement(locator).click();
    }

    public String getTextElement(By locator) throws InterruptedException {
        highlight(locator);
        return getElement(locator).getText();
    }

    public String getElementDomAttribute(By locator, String attName) throws InterruptedException {
        nullCheck(attName);
        highlight(locator);
        return getElement(locator).getDomAttribute(attName);
    }

    public String getElementDomProperty(By locator, String propertyName) throws InterruptedException {
        nullCheck(propertyName);
        highlight(locator);
        return getElement(locator).getDomProperty(propertyName);
    }

    //Yellow background color with solid red color border.
    public void highlight(By locator) throws InterruptedException {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        Thread.sleep(3000);
        js.executeScript("arguments[0].setAttribute('style','')", element);
    }

}
