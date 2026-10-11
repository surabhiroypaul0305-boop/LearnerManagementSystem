package com.learnerManagement.entity;

public class Student extends Person{

    private String batch;
    private boolean active;

    public Student(String fName,String lName,String email,String batch, boolean active) {
        super(fName,lName,email);
        this.batch = batch;
        this.active = active;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    public String getBatch() {
        return batch;
    }

    public boolean getActive() {
        return active;
    }
    @Override
    public void getDisplayName(){
        System.out.println("Name of Student from Student Class" + getFirstName() + " " + getLastName());
    }
}
