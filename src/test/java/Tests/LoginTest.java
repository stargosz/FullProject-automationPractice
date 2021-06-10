package Tests;

import Models.User;
import Pages.Pages.MenuPage;
import Providers.UserFactory;
import TestBase.TestBase;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LoginTest extends TestBase {
    MenuPage menuPage = new MenuPage(driver);
    User user = new UserFactory().getAlreadyRegisteredUser();
    @Test
    public void shouldRegisterNewUser() {

        menuPage.openLoginPage()
                .loginUser(user);
        assertThat(menuPage.getUserName(), is(user.getFirstName() + " " + user.getLastName()));
    }
}
