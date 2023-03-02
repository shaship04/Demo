package klarna.helpers;

import com.github.javafaker.Faker;

public class DataGenerator {

    public static String getRandomreference() {

        Faker faker = new Faker();
        String reference = faker.regexify("([A-Z0-9a-z]){12,15}");
        return reference;


    }
}
