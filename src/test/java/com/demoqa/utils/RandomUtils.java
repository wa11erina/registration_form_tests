package com.demoqa.utils;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

     public static void main(String[] args) {
        System.out.println(getRandomString(10));
        System.out.println(getRandomEmail());
        System.out.println(getRandomGender());
        System.out.println(getRandomSimplePhone());
        System.out.println(getRandomMonth());
        System.out.println(getRandomInt(1900, 2023));
        System.out.println(getRandomSubject());
        System.out.println(getRandomHobby());
        System.out.println(getRandomStringWithNumbersAndSpaces(20));
        System.out.println(getRandomUserState());
        System.out.println(getRandomNCRCities());
        System.out.println(getRandomUttarPradeshCities());
        System.out.println(getRandomHaryanaCities());
        System.out.println(getRandomRajasthanCities());
         System.out.println(getRandomUserCity());
        System.out.println(getRandomUuid());
        System.out.println(getRandomFirstName());

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

    public static String getRandomEmail() {

         return getRandomString(10) + "@gmail.com";
    }

    private static String getRandomValueFromDataset(String[] values) {
        int index = getRandomInt(0, values.length-1);
        return values[index];
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return getRandomValueFromDataset(genders);
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

    public static String getRandomMonth() {
        String[] months = {"January", "February", "March", "April",
                "May", "June", "July", "August",
                "September", "October", "November", "December"};
        return getRandomValueFromDataset(months);
     }

    public static String getRandomSubject() {
        String[] subjects = {"Accounting", "Arts", "Biology", "Chemistry", "Civics",
                "Commerce", "Computer Science", "Economics", "English", "Hindi",
                "History", "Maths", "Physics", "Social Studies"};
        return getRandomValueFromDataset(subjects);
    }

    public static String getRandomHobby() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return getRandomValueFromDataset(hobbies);
    }

    public static String getRandomUserState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return getRandomValueFromDataset(states);
    }

    public static String getRandomNCRCities() {
        String[] ncrCities = {"Delhi", "Gurgaon", "Noida"};
        return getRandomValueFromDataset(ncrCities);
    }

    public static String getRandomUttarPradeshCities() {
        String[] uttarpradeshCities = {"Agra", "Lucknow", "Merrut"};
        return getRandomValueFromDataset(uttarpradeshCities);
    }

    public static String getRandomHaryanaCities() {
        String[] haryanaCities = {"Karnal", "Panipat"};
        return getRandomValueFromDataset(haryanaCities);
    }

    public static String getRandomRajasthanCities() {
        String[] rajasthancities = {"Jaipur", "Jaiselmer"};
        return getRandomValueFromDataset(rajasthancities);
    }

    public static String getRandomUserCity() {
        if (getRandomUserState().equals("NCR")) {
            return getRandomNCRCities();
        }
        else if (getRandomUserState().equals("Uttar Pradesh")) {
            return getRandomUttarPradeshCities();
        }
        else if (getRandomUserState().equals("Haryana")) {
            return getRandomHaryanaCities();
        }
        else {
            return getRandomRajasthanCities();
        }
    }


    public static String getRandomUuid() {

         return UUID.randomUUID().toString();
    }

    public static String getRandomFirstName() {

         return new Faker().name().firstName();
    }

}

