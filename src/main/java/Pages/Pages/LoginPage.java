package Pages.Pages;

import Models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#create-account_form button  ")
    private WebElement registerNewUserBtn;

    @FindBy(css = "[name='email_create']")
    private WebElement emailInput;

    @FindBy(css = "#email")
    private WebElement emailLoginInput;

    @FindBy(css = "#passwd")
    private WebElement passwdInput;

    @FindBy(css = "button#SubmitLogin")
    private WebElement loginButton;



//    public RegistrationPage

    public RegistrationPage openRegistrationPage(User user){
        webClient.sendKeys(emailInput, user.getEmail());
        webClient.click(registerNewUserBtn);
        return new RegistrationPage(getDriver());
    }

    public void loginUser(User user){
        webClient.sendKeys(emailLoginInput, user.getEmail());
        webClient.sendKeys(passwdInput, user.getPassword());
        webClient.click(loginButton);
    }
}
