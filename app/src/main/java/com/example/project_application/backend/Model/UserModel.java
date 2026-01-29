package com.example.project_application.backend.Model;

public class UserModel extends BaseModel {

    private String name;
    private String surname;
    private String lastname;
    private String date;
    private String email;
    private String sex;
    private String password;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLastName() {
        return lastname;
    }

    public String getDate() {
        return date;
    }

    public String getEmail() {
        return email;
    }

    public String getSex() {
        return sex;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setLastName(String lastName) {
        this.lastname = lastName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
