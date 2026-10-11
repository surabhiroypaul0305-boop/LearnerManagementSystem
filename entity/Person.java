package com.learnerManagement.entity;

import com.learnerManagement.util.IDGenerator;

public class Person {
    private int id=10;
    private String firstName;
    private String lastName;
    private String email;


    public Person(String firstName, String lastName, String email) {
        IDGenerator IG = new IDGenerator();
        int Sid = IG.generateStudentId();
        this.id = Sid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public  int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
    public void getDisplayName(){
        System.out.println("Name of Student from Person Class" + this.firstName + " " + this.lastName);
    }
}
