package Providers;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class RandomValuesGenerator {

    public static String getRandomString(int length){
        return RandomStringUtils.randomAlphabetic(length);
    }

    public static String getRandomEmail(int length){
        System.out.println(RandomStringUtils.randomAlphabetic(length)+"@gmail.com");
        return RandomStringUtils.randomAlphabetic(length)+"@gmail.com";
    }

    public static int getRandomInt(){
        int min = 10000;
        int max = 99999;
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
       return random_int;
    }

    public static int getRandomIntFromSelect(WebElement element) {
        Select select = new Select(element);
        List<WebElement> selectOptions = select.getOptions();
        int size = selectOptions.size();
        Random rnd = new Random();
        int value = rnd.nextInt(size);
        if (value == 0) value = value + 1;
        return value;
    }
}
