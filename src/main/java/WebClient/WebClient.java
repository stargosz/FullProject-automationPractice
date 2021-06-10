package WebClient;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class WebClient {
    private static Logger logger = LoggerFactory.getLogger(WebClient.class);
    WebDriver driver;


    public WebElement getElement(WebElement element){
        try {
            Wait<WebDriver> wait = new FluentWait<>(this.driver)
                    .withTimeout(Duration.ofSeconds(30))
                    .pollingEvery(Duration.ofSeconds(1))
                    .ignoring(StaleElementReferenceException.class)
                    .ignoring(ElementNotVisibleException.class)
                    .ignoring(NoSuchElementException.class);
            element = wait.until(ExpectedConditions.visibilityOf(element));
            return element;
        } catch (Exception var4) {
            logger.error("Timeout finding element with location: {}");
            return null;
        }
    }

    public void click(WebElement element){
//        logger.debug("Clicking on element: "+element.getText());
        element.click();
    }



    public void sendKeys(WebElement element, String text){
//        getElement(element);
        element.clear();
        element.sendKeys(text);
        logger.debug("Sending text: '"+text+"' to element: "+element.getText());
    }

    public void selectByIndex(WebElement element, int index){
//        getElement(element);
        Select select = new Select(element);
        select.selectByIndex(index);
        logger.debug("Selecting option from select with index value: "+index);
    }




    public ExpectedCondition<WebElement> isClickable(WebElement element){
        return elementToBeClickable(element);
    }
}
