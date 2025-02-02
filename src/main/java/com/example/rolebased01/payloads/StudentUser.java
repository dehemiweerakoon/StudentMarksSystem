package com.example.rolebased01.payloads;

public class StudentUser {
    private String firstName;
    private String lastName;
    private int year;
    private String username;
    private String password;
    private String email;

    public StudentUser(String firstName, String lastName, int year, String username, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
        this.username = username;
        this.password = password;
        this.email = email;
    }
    public StudentUser(){}

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
