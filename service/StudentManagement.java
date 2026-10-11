package com.learnerManagement.service;

import com.learnerManagement.entity.Student;

import java.util.ArrayList;
import java.util.List;

interface Deactivation{
    public void deactivate();
}
public class StudentManagement {
    private List<Student> student = new ArrayList<>();
    public void addStudent(Student data){
        student.add(data);

    }
    public void removeStudent(int id){
        for(int i = 0;i< student.size();i++){
            if(student.get(i).getId() == id){
                student.remove(i);
            }
        }
        System.out.println("student removed with id !!" + id  );

    }
    public List<Student> listStudents(){
        System.out.println("=========== Student List ======");
        for(Student s : student){
            System.out.println(" student Id : " + s.getId() + "\n student name : " + s.getFirstName() +" " + s.getLastName()
                    + "\n Email : "+ s.getEmail() + "\n batch : "+
                    s.getBatch() + " " + "\n student status : " + s.getActive());
            System.out.println("##############");

        }

        System.out.println("=================");
        return student;
    }
    public void deactivate(int id){
        for(int i = 0;i< student.size();i++){
            if(student.get(i).getId() == id){
                student.get(i).setActive(false);
            }
        }
        System.out.println("student updated with id !!" + id  );
    }

    public void updateStudent(int id,String batch){
        for(int i = 0;i< student.size();i++){
            if(student.get(i).getId() == id){
                student.get(i).setBatch(batch);
            }
        }
        System.out.println("student updated with id !!" + id  );
    }

    public void searchStudentDetailsByID(int id){
        for(int i = 0;i< student.size();i++){
            if(student.get(i).getId() == id){

                System.out.println(" Searched student Id : " + student.get(i).getId() + "\n student name : " + student.get(i).getFirstName() + " " + student.get(i).getLastName()
                        + "\n Email : " + student.get(i).getEmail() + "\n batch : "+
                        student.get(i).getBatch() + " ");
            }
        }
    }
}
