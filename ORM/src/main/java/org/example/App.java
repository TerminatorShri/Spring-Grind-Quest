package org.example;

import org.example.dao.StudentDaoImpl;
import org.example.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        StudentDaoImpl studentDao = context.getBean("studentDao", StudentDaoImpl.class);

        // Insert a new student
        // Student student = new Student(135, "Shri", "New York");

        // int result = studentDao.insertStudent(student);

        // if (result > 0) {
        //     System.out.println("Student inserted successfully with ID: " + result);
        // } else {
        //     System.out.println("Failed to insert student.");
        // }

        // Retrieve a student by ID
        // int studentId = 135;
        // Student student = studentDao.getStudentById(studentId);

        // if (student != null) {
        //     System.out.println("Student found: " + student);
        // } else {
        //     System.out.println("No student found with ID: " + studentId);
        // }

        // Retrieve all students
        List<Student> students = studentDao.getAllStudents();

        if (students != null && !students.isEmpty()) {
            System.out.println("All students:");
            for (Student s : students) {
                System.out.println(s);
            }
        } else {
            System.out.println("No students found.");
        }

        // Update a student
        Student studentToUpdate = new Student(135, "Shri", "Los Angeles");

        Student updatedStudent = studentDao.updateStudent(studentToUpdate);

        if (updatedStudent != null) {
            System.out.println("Student updated successfully: " + updatedStudent);
        } else {
            System.out.println("Failed to update student.");
        }

        // Delete a student
        boolean isDeleted = studentDao.deleteStudent(135);

        if (isDeleted) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Failed to delete student.");
        }
    }
}
