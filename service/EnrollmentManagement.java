package com.learnerManagement.service;

import com.learnerManagement.entity.Course;
import com.learnerManagement.entity.Enrollment;
import com.learnerManagement.entity.Student;
import com.learnerManagement.exception.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentManagement {
        private List<Enrollment> enrollment = new ArrayList<>();

        public void enrollStudent(Enrollment enrollmentList,List<Course> courseList,List<Student> students ){

            Student foundStudent = null;
            Course foundCourse = null;

            // 1. Find the student
            for (Student student : students) {
                if (enrollmentList.getStudentId() == student.getId()) {
                    foundStudent = student;
                    break;
                }
            }

            if (foundStudent == null) {
                System.out.println("Student not found.");
                 throw new EntityNotFoundException("Student not found.");

            }

            // 2. Find the course
            for (Course course : courseList) {
                if (enrollmentList.getCourseId() == course.getId()) {
                    foundCourse = course;
                    break;
                }
            }

            if (foundCourse == null) {
                System.out.println("Course not found.");
                return;
            }

            // 3. Check whether the course is active
            if (!foundCourse.isActive()) {
                System.out.println("Course is inactive.");
                return;
            }

            enrollment.add(enrollmentList);
        }

    public void listCourseEnrollment(){
        System.out.println("=========== Student Enrollment List ======");
        for(Enrollment s : enrollment){
            System.out.println(" Student Id : " + s.getStudentId() + "\n Course Id  : " + s.getCourseId() +"\n Date : "
                    + s.getEnrollmentDate() + "\n status :" + s.getStatus());
            System.out.println("_____________");
        }
        System.out.println("=================");

    }

    // Change an enrollment's status
    public void updateEnrollmentStatus(
            int enrollmentId, Enrollment.Status newStatus) {

        for (Enrollment e : enrollment) {
            if (e.getId() == enrollmentId) {

                // A completed enrollment cannot be cancelled
                if (e.getStatus() == Enrollment.Status.COMPLETED
                        && newStatus == Enrollment.Status.CANCELLED) {

                    System.out.println(
                            "A completed enrollment cannot be cancelled."
                    );
                    return;
                }

                e.setStatus(newStatus);
                System.out.println("Enrollment status updated.");
                return;
            }
        }

        System.out.println("Enrollment not found.");
    }

}
