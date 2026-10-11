package com.learnerManagement.service;

import com.learnerManagement.entity.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseManagement {
    private List<Course> course = new ArrayList<>();
    public void addCourse(Course data){
        course.add(data);

    }

    public List<Course> listCourse(){
        System.out.println("=========== Course List ======");
        for(Course s : course){
            System.out.println(" Course Id : " + s.getId() + "\n course name : " + s.getCourseName() +"\n Description : "
                    + s.getDescription() + "\n getDuration : "+ s.getDurationInWeeks());
            System.out.println("_____________");

        }
        System.out.println("=================");
        return course;
    }
    public void deactivate(int id){
        for(int i = 0;i< course.size();i++){
            if(course.get(i).getId() == id){
                course.get(i).setActive(false);
            }
        }
        System.out.println("student updated with id !!" + id  );
    }
}
