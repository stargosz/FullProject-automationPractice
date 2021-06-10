package Pages.Pages;

import Models.Gender;
import Models.User;
import Providers.RandomValuesGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "[for='id_gender1']")
    private WebElement maleRbt;

    @FindBy(css = "[for='id_gender2']")
    private WebElement femaleRbt;

    @FindBy(css = "#customer_firstname")
    private WebElement firstNameInput;

    @FindBy(css = "#customer_lastname")
    private WebElement lastNameInput;

    @FindBy(css = "#passwd")
    private WebElement passwordInput;

    @FindBy(css = "#days")
    WebElement daysSelect;

    @FindBy(css = "#months")
    private WebElement monthsSelect;

    @FindBy(css = "#years")
    private WebElement yearsSelect;

    @FindBy(css = "[name='address1']")
    private WebElement addressInput;

    @FindBy(css = "#city")
    private WebElement cityInput;

    @FindBy(css = "#id_state")
    private WebElement stateSelect;

    @FindBy(css = "#postcode")
    private WebElement zipCodeInput;

    @FindBy(css = "#id_country")
    private WebElement countrySelect;

    @FindBy(css = "#phone_mobile")
    private WebElement mobilePhoneInput;

    @FindBy(css = "#submitAccount")
    private WebElement registerBtn;

    public void registerUser(User user) {
        webClient.click(user.getGender() == Gender.Male ? maleRbt : femaleRbt);
        webClient.sendKeys(firstNameInput, user.getFirstName());
        webClient.sendKeys(lastNameInput, user.getLastName());
        webClient.sendKeys(passwordInput, user.getPassword());
        webClient.selectByIndex(daysSelect, RandomValuesGenerator.getRandomIntFromSelect(daysSelect));
        webClient.selectByIndex(monthsSelect, RandomValuesGenerator.getRandomIntFromSelect(monthsSelect));
        webClient.selectByIndex(yearsSelect, RandomValuesGenerator.getRandomIntFromSelect(yearsSelect));
        webClient.sendKeys(addressInput, user.getAddress());
        webClient.sendKeys(cityInput, user.getCity());
        webClient.selectByIndex(stateSelect, RandomValuesGenerator.getRandomIntFromSelect(stateSelect));
        webClient.sendKeys(zipCodeInput, String.valueOf(user.getZipCode()));
        webClient.selectByIndex(countrySelect, RandomValuesGenerator.getRandomIntFromSelect(countrySelect));
        webClient.sendKeys(mobilePhoneInput, String.valueOf(user.getMobilePhone()));
        webClient.click(registerBtn);
    }
}
