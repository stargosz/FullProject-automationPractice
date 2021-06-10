package Configuration;

import Pages.Pages.WebListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrowserEnvironment {

    private String browserName = "chrome";
    private boolean headlessBrowser;
    private int webElementTimeOut;
    private int webBrowserImplicitWait;
    private boolean attachScreenShot;
    private Logger logger;
    private WebDriver webDriver;
    WebListener webListener;
    private EventFiringWebDriver driver;

    public BrowserEnvironment() {
        this.headlessBrowser = false;
        this.webElementTimeOut = 10;
        this.webBrowserImplicitWait = 5;
        this.attachScreenShot = true;
        logger = LoggerFactory.getLogger(BrowserEnvironment.class);
        this.browserName = PropertiesStore.BROWSER.isSpecified() ? PropertiesStore.BROWSER.getValue() : this.browserName;
        this.initBrowserSettings();
    }

    private void initBrowserSettings() {
        this.webElementTimeOut = PropertiesStore.BROWSER_FLUENT_TIMEOUT.isSpecified() ? PropertiesStore.BROWSER_FLUENT_TIMEOUT.getIntValue() : this.webElementTimeOut;
        this.webBrowserImplicitWait = PropertiesStore.BROWSER_IMPLICIT_TIMEOUT.isSpecified() ? PropertiesStore.BROWSER_IMPLICIT_TIMEOUT.getIntValue() : this.webBrowserImplicitWait;
        this.attachScreenShot = PropertiesStore.BROWSER_ATTACH_SCREENSHOT.isSpecified() ? PropertiesStore.BROWSER_ATTACH_SCREENSHOT.getBoolean() : this.attachScreenShot;
        this.headlessBrowser = PropertiesStore.BROWSER_HEADLESS.isSpecified() ? PropertiesStore.BROWSER_HEADLESS.getBoolean() : this.headlessBrowser;


    }

    public WebDriver getDriver() {
        EventFiringWebDriver driver;
        switch (this.browserName) {
            case "chrome":
                ChromeOptions optionsChrome = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                optionsChrome.addArguments("start-maximized");
                webDriver = new ChromeDriver(optionsChrome);
                webListener = new WebListener();
                driver = new EventFiringWebDriver(webDriver);
                driver.register(webListener);
                driver.get(System.getProperty("appUrl"));
                break;
            case "firefox":
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                WebDriverManager.chromedriver().setup();
                optionsFirefox.addArguments("start-maximized");
                webDriver = new FirefoxDriver(optionsFirefox);
                webListener = new WebListener();
                driver = new EventFiringWebDriver(webDriver);
                driver.register(webListener);
                driver.get(System.getProperty("appUrl"));
                break;
            default:

                InternetExplorerOptions optionsDefault = new InternetExplorerOptions();
                WebDriverManager.chromedriver().setup();
                webDriver = new InternetExplorerDriver(optionsDefault);
                webListener = new WebListener();
                driver = new EventFiringWebDriver(webDriver);
                driver.register(webListener);
                driver.get(System.getProperty("appUrl"));

        }
        this.driver = driver;
        return this.driver;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public void setHeadlessBrowser(boolean headlessBrowser) {
        this.headlessBrowser = headlessBrowser;
    }

    public void setWebElementTimeOut(int webElementTimeOut) {
        this.webElementTimeOut = webElementTimeOut;
    }

    public void setWebBrowserImplicitWait(int webBrowserImplicitWait) {
        this.webBrowserImplicitWait = webBrowserImplicitWait;
    }

    public void setAttachScreenShot(boolean attachScreenShot) {
        this.attachScreenShot = attachScreenShot;
    }
}
