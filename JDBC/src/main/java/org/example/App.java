package org.example;

import org.example.Dao.StudentDao;
import org.example.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // Option 1: XML-Based Configuration (Uncomment if using XML)
        // ApplicationContext context = new ClassPathXmlApplicationContext("jdbcConfig.xml");

        // Option 2: Java-Based Configuration (Recommended and used here)
        // This loads the Spring context using annotations defined in the JDBCConfig class.
        ApplicationContext context = new AnnotationConfigApplicationContext(JDBCConfig.class);

        StudentDao studentDao = (StudentDao) context.getBean("studentDao");

        // Inserting a Student
        // Student student = new Student(10, "Shriyash", "Bangalore");
        // int result = studentDao.insertStudent(student);

        // if (result > 0) {
        //    System.out.println("Student inserted successfully");
        // } else {
        //    System.out.println("Failed to insert student");
        // }

        // Updating a Student
        // Student student = new Student(10, "Shriyash Dongarkar", "Pune");
        // int result = studentDao.updateStudent(student);

        // if (result > 0) {
        //     System.out.println("Student updated successfully");
        // } else {
        //     System.out.println("Failed to update student");
        // }

        // Deleting a Student
        // int studentId = 5;
        // int result = studentDao.deleteStudent(studentId);

        // if (result > 0) {
        //     System.out.println("Student deleted successfully");
        // } else {
        //     System.out.println("Failed to delete student");
        // }

        // Fetching a Student
        int studentId = 10;
        Student student = studentDao.getStudent(studentId);

        if (student != null) {
            System.out.println("Student details: " + student);
        } else {
            System.out.println("Student not found");
        }

        // Fetching all Students
        List<Student> students = studentDao.getStudents();
        if (students != null && !students.isEmpty()) {
            System.out.println("All students: ");
            for (Student s : students) {
                System.out.println(s);
            }
        } else {
            System.out.println("No students found");
        }
    }
}
