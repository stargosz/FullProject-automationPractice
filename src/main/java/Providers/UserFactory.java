package Providers;

import Models.Gender;
import Models.User;

import static Models.Gender.getRandomGender;
import static Providers.RandomValuesGenerator.*;

public class UserFactory{


    public User getRandomUser(){
        return new User.Builder()
                .gender(getRandomGender())
                .firstName(getRandomString(5))
                .lastName(getRandomString(5))
                .email(getRandomEmail(7))
                .password(getRandomString(7))
                .address(getRandomString(10))
                .city(getRandomString(7))
                .zipCode(getRandomInt())
                .mobilePhone(getRandomInt())
                .build();
    }

    public User getAlreadyRegisteredUser(){
        return new User.Builder()
                .gender(Gender.Female)
                .firstName("izyUJ")
                .lastName("hgfym")
                .email("DtHuokB@gmail.com")
                .password("KlEwEQM")
                .build();
    }
}
