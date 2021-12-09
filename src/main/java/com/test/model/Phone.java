package com.test.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String model;

    private int number;

    @JsonBackReference
    @OneToOne(mappedBy = "phone")
    private User user;

    public Phone(String model, int number, User user) {
        this.model = model;
        this.number = number;
        this.user = user;
    }

    public Phone(String model, int number) {
        this.model = model;
        this.number = number;
    }

    public Phone() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
