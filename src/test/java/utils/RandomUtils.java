package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomUtils {
    Faker faker = new Faker(new Locale("en-US"));

    public String firstName(){
        return faker.name().firstName();
    }
    public String lastName(){
        return faker.name().lastName();
    }
    public String email(){
        return faker.internet().emailAddress();
    }
    public String gender() {
        return faker.options().option("Male", "Female", "Other");
    }
    public String userNumber(){
        return faker.phoneNumber().subscriberNumber(10);
    }
    public String dayOfBirth (){
        return String.format("%02d", faker.number().numberBetween(1, 28));
    }
    public String monthOfBirth(){
        return faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    }
    public String yearOfBirth(){
        return faker.number().numberBetween(1900,2024)+ "";
    }
    public String subjects(){
        return faker.options().option("Chemistry", "Computer Science", "Commerce", "Social Studies", "Civics", "English", "Arts", "History", "Maths", "Phisics", "Biology", "Hindi");
    }
    public String hobbies() {
        return faker.options().option("Sports", "Reading", "Music");
    }
    public String pictureName(){
            String[] files = {"clouds.jpg", "krasiv.jpg", "park.jpg"};
            return faker.options().option(files);
        }
    public String currentAddress() {
        return faker.address().streetAddress();
    }
    public String state() {
        return faker.options().option("NCR", "Haryana", "Uttar Pradesh");
    }
    public String city(String state) {
        if ("NCR".equals(state)) {
            return faker.options().option("Delhi", "Gurgaon", "Noida");
        } else if ("Uttar Pradesh".equals(state)) {
            return faker.options().option("Agra", "Lucknow", "Merrut");
        } else if ("Haryana".equals(state)) {
            return faker.options().option("Karnal", "Panipat");
        } else {
            return "";
        }
    }
}
