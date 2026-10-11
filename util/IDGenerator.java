package com.learnerManagement.util;

public class IDGenerator {
    private static int id = 100;
    private static int courseId = 100;

    public int generateStudentId(){
        return ++id;
    }
}
