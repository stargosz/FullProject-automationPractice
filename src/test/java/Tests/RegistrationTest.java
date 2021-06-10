package Tests;

import Models.User;
import Pages.Pages.MenuPage;
import Providers.UserFactory;
import TestBase.TestBase;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RegistrationTest extends TestBase {
    MenuPage menuPage = new MenuPage(driver);
    User user = new UserFactory().getRandomUser();
    @Test
    public void shouldRegisterNewUser() {

        menuPage.openLoginPage()
                .openRegistrationPage(user)
                .registerUser(user);
        assertThat(menuPage.getUserName(), is(user.getFirstName() + " " + user.getLastName()));
    }
    @Test
    public void shouldHoverMouseOnElement(){
        menuPage.mouseHoverWoman()
                .mouseHoverDress()
                .mouseHoverTshirt();
    }
}
