package com.example.user;


import com.example.validation.FieldMatch;
import com.example.validation.ValidEmail;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@FieldMatch.List({
        @FieldMatch(first = "password", second = "matchingPassword", message = "The passwords fields must match")
})
public class CrmUser {

    @NotNull(message = "Please enter an username.")
    @Size(min = 1, message = "Username can't have less than 1 character")
    private String userName;


    @NotNull(message = "Please enter a password.")
    @Size(min = 1, message = "Password can't be less than 1 character")
    private String password;

    @NotNull(message = "Please enter a password.")
    @Size(min = 1, message = "Password can't be less than 1 character")
    private String matchingPassword;

    @NotNull(message = "Please enter a first name.")
    @Size(min = 1, message = "First name can't have less than 1 character")
    private String firstName;


    @NotNull(message = "Please enter a last name.")
    @Size(min = 1, message = "Last name can't have less than 1 character")
    private String lastName;

    @ValidEmail
    @NotNull(message = "Please enter a valid email.")
    @Size(min = 1, message = "Email cant have less than 1 character")
    private String email;

    public CrmUser() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
