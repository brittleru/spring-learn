package com.example.jackson.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Arrays;

public class Driver {

    public static void main(String[] args) {

        String sampleLitePath = "data/sample-lite.json";
        String sampleFullPath = "data/sample-full.json";

        try {

            // create object mapper
            ObjectMapper mapper = new ObjectMapper();


            // read JSON file and map/convert to Java POJO:
            // data/sample-lite.json
            Student student = mapper.readValue(new File(sampleLitePath), Student.class);

            // print first and last name
            System.out.println("First name = " + student.getFirstName());
            System.out.println("Last name = " + student.getLastName());

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\n\n\n");

        try {

            // create object mapper
            ObjectMapper mapper = new ObjectMapper();

            // read JSON file and map/convert to Java POJO:
            // data/sample-full.json
            Student student = mapper.readValue(new File(sampleFullPath), Student.class);

            // print first and last name
            System.out.println("First name = " + student.getFirstName());
            System.out.println("Last name = " + student.getLastName());
            System.out.println("Address = " + student.getAddress());
            System.out.println("Languages = " + Arrays.toString(student.getLanguages()));

            // print out address: street and city
            Address address = student.getAddress();
            System.out.println("Street = " + address.getStreet());
            System.out.println("Street = " + address.getCity());

            // loop the languages
            for (String language : student.getLanguages()) {
                System.out.println("Programming Language: " + language);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}
