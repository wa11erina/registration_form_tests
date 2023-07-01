package demoqa.utils;

import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

     public static void main(String[] args) {
        System.out.println(getRandomString(10));
        System.out.println(getRandomFakerFirstName());
        System.out.println(getRandomFakerLastName());
        System.out.println(getRandomEmail());
        System.out.println(getRandomFakerEmail());
        System.out.println(getRandomGender());
        System.out.println(getRandomFakerGender());
        System.out.println(getRandomSimplePhone());
        System.out.println(getRandomFakerPhone());
        System.out.println(getRandomMonth());
        System.out.println(getRandomFakerMonth());
        System.out.println(getRandomFakerDay());
        System.out.println(getRandomInt(1900, 2023));
        System.out.println(getRandomSubject());
        System.out.println(getRandomFakerSubject());
        System.out.println(getRandomHobby());
        System.out.println(getRandomFakerHobby());
        System.out.println(getRandomStringWithNumbersAndSpaces(20));
        System.out.println(getRandomFakerAddress());
        System.out.println(getRandomUserState());
        System.out.println(getRandomFakerUserState());
        System.out.println(getRandomUserCity("NCR"));
        System.out.println(getRandomFakerUserCity("Haryana"));
        System.out.println(getRandomUuid());

    }

    public static String getRandomString(int len) {
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static String getRandomStringWithNumbersAndSpaces(int len) {
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz ";
        SecureRandom rnd = new SecureRandom();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static String getRandomFakerFirstName() {

        return new Faker().name().firstName();
    }

    public static String getRandomFakerLastName() {

        return new Faker().name().lastName();
    }

    public static String getRandomEmail() {

         return getRandomString(10) + "@gmail.com";
    }

    public static String getRandomFakerEmail() {

        return new Faker().internet().emailAddress();
    }

    private static String getRandomValueFromDataset(String[] values) {
        int index = getRandomInt(0, values.length-1);
        return values[index];
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return getRandomValueFromDataset(genders);
    }

    public static String getRandomFakerGender() {
        String[] genders = {"Male", "Female", "Other"};
        return new Faker().options().option(genders);
    }

    public static int getRandomInt(int min, int max) {

        return ThreadLocalRandom.current().nextInt(min, max +1);
    }

    // +3 (263) 253 - 66 - 12
    public static String getRandomPhone() {
        return String.format("+%s (%s) %s - %s - %s", getRandomInt(1, 9), getRandomInt(100, 999),
                getRandomInt(100, 999), getRandomInt(10, 99), getRandomInt(10, 99));
     }

    public static String getRandomSimplePhone() {
    return String.format("%s%s%s%s%s%s%s%s%s%s", getRandomInt(0, 9), getRandomInt(0, 9),
                    getRandomInt(0, 9), getRandomInt(0, 9), getRandomInt(0, 9),
                    getRandomInt(0, 9), getRandomInt(0, 9), getRandomInt(0, 9),
                    getRandomInt(0, 9), getRandomInt(0, 9));
    }

    public static String getRandomFakerPhone() {

         return new Faker().phoneNumber().subscriberNumber(10);
    }

    public static String getRandomMonth() {
        String[] months = {"January", "February", "March", "April",
                "May", "June", "July", "August",
                "September", "October", "November", "December"};
        return getRandomValueFromDataset(months);
     }

    public static String getRandomFakerMonth() {
        String[] months = {"January", "February", "March", "April",
                "May", "June", "July", "August",
                "September", "October", "November", "December"};
        return new Faker().options().option(months);
    }

    public static String getRandomFakerDay() {

        return String.format("%02d", new Faker().number().numberBetween(1, 28));
    }

    public static String getRandomSubject() {
        String[] subjects = {"Accounting", "Arts", "Biology", "Chemistry", "Civics",
                "Commerce", "Computer Science", "Economics", "English", "Hindi",
                "History", "Maths", "Physics", "Social Studies"};
        return getRandomValueFromDataset(subjects);
    }

    public static String getRandomFakerSubject() {
        String[] subjects = {"Accounting", "Arts", "Biology", "Chemistry", "Civics",
                "Commerce", "Computer Science", "Economics", "English", "Hindi",
                "History", "Maths", "Physics", "Social Studies"};
        return new Faker().options().option(subjects);
    }

    public static String getRandomHobby() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return getRandomValueFromDataset(hobbies);
    }

    public static String getRandomFakerHobby() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return new Faker().options().option(hobbies);
    }

    public static String getRandomFakerAddress() {

         return new Faker().address().fullAddress();
    }

    public static String getRandomUserState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return getRandomValueFromDataset(states);
     }

    public static String getRandomFakerUserState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return new Faker().options().option(states);
    }

    public static String getRandomUserCity(String userState) {
        if (userState.equals("NCR")) {
            String[] ncrCities = {"Delhi", "Gurgaon", "Noida"};
            return getRandomValueFromDataset(ncrCities);
        }
        else if (userState.equals("Uttar Pradesh")) {
            String[] uttarpradeshCities = {"Agra", "Lucknow", "Merrut"};
            return getRandomValueFromDataset(uttarpradeshCities);
        }
        else if (userState.equals("Haryana")) {
            String[] haryanaCities = {"Karnal", "Panipat"};
            return getRandomValueFromDataset(haryanaCities);

        }
        else if (userState.equals("Rajasthan")) {
            String[] rajasthancities = {"Jaipur", "Jaiselmer"};
            return getRandomValueFromDataset(rajasthancities);
        }
        return null;
    }


    public static String getRandomFakerUserCity(String state) {
        if (state.equals("NCR")) {
            String[] ncrCities = {"Delhi", "Gurgaon", "Noida"};
            return new Faker().options().option(ncrCities);
        }
        else if (state.equals("Uttar Pradesh")) {
            String[] uttarpradeshCities = {"Agra", "Lucknow", "Merrut"};
            return new Faker().options().option(uttarpradeshCities);
        }
        else if (state.equals("Haryana")) {
            String[] haryanaCities = {"Karnal", "Panipat"};
            return new Faker().options().option(haryanaCities);
        }
        else if (state.equals("Rajasthan")) {
            String[] rajasthancities = {"Jaipur", "Jaiselmer"};
            return new Faker().options().option(rajasthancities);
        }
        return null;
    }



    public static String getRandomUuid() {

         return UUID.randomUUID().toString();
    }



}

