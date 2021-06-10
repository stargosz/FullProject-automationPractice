package Pages.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class  MenuPage  extends BasePage{
    Logger logger = LoggerFactory.getLogger(MenuPage.class);
    public MenuPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = ".user-info a.hidden-sm-down")
    private WebElement signOutBtn;

    @FindBy(css = ".login")
    private WebElement signInBtn;

    @FindBy(css = ".account")
    private WebElement userName;

    @FindBy(css = "#block_top_menu > ul > li:nth-child(1) > a")
    private WebElement woman;

    @FindBy(css = "#block_top_menu > ul > li:nth-child(2) > a")
    private WebElement dress;

    @FindBy(css = "#block_top_menu > ul > li:nth-child(3) > a")
    private WebElement tshirt;


    public LoginPage openLoginPage() {
        webClient.click(signInBtn);
        return new LoginPage(getDriver());
    }

    public String getUserName() {
        return userName.getText();
    }

    public MenuPage mouseHoverWoman() {
        logger.info("Mouse hover on Woman link");
        mouseHover(woman);
        return this;
    }
    public MenuPage mouseHoverDress() {
        logger.info("Mouse hover on Woman link");
        mouseHover(dress);
        return this;
    }
    public MenuPage mouseHoverTshirt() {
        logger.info("Mouse hover on Woman link");
        mouseHover(tshirt);
        return  this;
    }
}
