package com.model;

import com.github.javafaker.Faker;

public class User {

    private String email;
    private String password;
    private String name;

    //Конструкторы
    public User() {
    }

    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    //методы

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }
    //Сгенерировать случайные данные юзера для регистрации
    public static User getRandomUser(){
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        String password = faker.lorem().characters(6, true);
        String name = faker.name().firstName();
        return new User (email, password, name);
    }
    //Сгенерируем случайные данные юзера c некоррекным паролем (<6 символов)
    public static User getRandomUserIncorrectPassword(){
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        String password = faker.lorem().characters(5, true);
        String name = faker.name().firstName();
        return new User (email, password, name);
    }

}
