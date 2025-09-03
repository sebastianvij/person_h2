package com.example.person_h2.model;

public class Person {
    private int id;
    private String name;
    private String email; // valgfri

    public Person() { }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person(int id, String name, String email) {
        this(id, name);
        this.email = email;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
