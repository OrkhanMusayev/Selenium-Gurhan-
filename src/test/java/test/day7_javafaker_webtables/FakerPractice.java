package test.day7_javafaker_webtables;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class FakerPractice {
    @Test
    public void faker_test(){
        Faker faker = new Faker();

        String name = faker.name().fullName(); // Miss Samanta Schmidt
        String firstName = faker.name().firstName(); // Emory

        String lastName = faker.name().lastName(); // Barton

        String streetAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449

        System.out.println("Name:"+name);
        System.out.println("streetAddress = " + streetAddress);
        System.out.println("lastName = " + lastName);
        String gameOfThrones = faker.gameOfThrones().character();
        System.out.println("gameOfThrones = " + gameOfThrones);
        String chuckNorris =faker.chuckNorris().fact();
        System.out.println("chuckNorris = " + chuckNorris);
    }
}