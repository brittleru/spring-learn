package com.example.models;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Student {

    private String firstName;
    private String lastName;
    private String country;

    private LinkedHashMap<String, String> favoriteLanguageOptions;
    private String favoriteLanguage;

    private ArrayList<String> operatingSystems;

//    private LinkedHashMap<String, String> countryOptions;

    public Student() {
        // populate favorite language options, parameter order: value, display label
        favoriteLanguageOptions = new LinkedHashMap<String, String>();

        favoriteLanguageOptions.put("Java", "Java");
        favoriteLanguageOptions.put("Python", "Python");
        favoriteLanguageOptions.put("C++", "C++");
        favoriteLanguageOptions.put("Lisp", "Lisp");
        favoriteLanguageOptions.put("PDF", "PDF");  // =))))))))))))))

        // populate country options: used ISO country code
//        countryOptions = new LinkedHashMap<String, String>();
//
//        countryOptions.put("BR", "Brazil");
//        countryOptions.put("DE", "Germany");
//        countryOptions.put("JP", "Japan");
//        countryOptions.put("KR", "Korea");
//        countryOptions.put("RU", "Russia");
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

//    public LinkedHashMap<String, String> getCountryOptions() {
//        return countryOptions;
//    }

//
    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }


    public LinkedHashMap<String, String> getFavoriteLanguageOptions() {
        return favoriteLanguageOptions;
    }

    public ArrayList<String> getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(ArrayList<String> operatingSystems) {
        this.operatingSystems = operatingSystems;
    }
}
