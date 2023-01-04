package com.example.demo.service;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


class UserServiceTest {

    @Test
    void makeRandomName() {
        Faker faker = new Faker();
        Random random = new Random();
        int i;

        // For Various Creations Of...

        // PREFIX
        String prefix = "";
        do {
            i = random.nextInt(5);
            switch (i) {
                case 0:
                    prefix = faker.color().name(); break;
                case 1:
                    prefix = faker.weather().description(); break;
                case 2:
                    prefix = faker.university().prefix(); break;
                case 3:
                    prefix = faker.space().planet(); break;
                case 4:
                    prefix = faker.music().genre(); break;
            }
        } while (prefix.length() > 11);

        // NOUN
        String noun = "";
        do{
            i = random.nextInt(7);
            switch (i) {
                case 0:
                    noun = faker.animal().name(); break;
                case 1:
                    noun = faker.food().dish(); break;
                case 2:
                    noun = faker.music().instrument(); break;
                case 3:
                    noun = faker.relationships().any(); break;
                case 4:
                    noun = faker.job().position(); break;
                case 5:
                    noun = faker.food().fruit(); break;
                case 6:
                    noun = faker.food().vegetable(); break;
            }
        }while(noun.length() > 11);


        // CONCAT!
        StringBuilder sb = new StringBuilder();
        sb.append(prefix).append(" ").append(noun);
        System.out.println("result : " + sb.toString().trim().replace(" ", "_").toLowerCase(Locale.ROOT));
    }
}