package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

@Component
public class DatabaseFortuneService implements FortuneService {

    private String fileName = "E:\\Study\\Spring-Projects\\Udemy\\Projects\\spring-demo-annotations\\src\\fortune-data.txt";

    // create an array of strings
    private static ArrayList<String> fortunes;

    // create a random number generator
    private Random random = new Random();

    public DatabaseFortuneService() throws FileNotFoundException {
        File file = new File(fileName);

        System.out.println("Reading fortunes from file: " + file);
        System.out.println("File exists: " + file.exists());

        // initialize array list
        fortunes = new ArrayList<String>(3);

        // read fortuens from the file
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
           String tempLine;
           while ((tempLine = bufferedReader.readLine()) != null) {
               fortunes.add(tempLine);
           }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getFortune() {

        // pick a random string from the array
        int index = random.nextInt(fortunes.size());

        return fortunes.get(index) + " From:";
    }

}
