package com.test.model;


import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Transactional
public class Authorities  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    public Authorities() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Authorities{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
