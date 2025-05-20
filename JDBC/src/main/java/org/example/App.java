package org.example;

import org.example.Dao.StudentDao;
import org.example.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbcConfig.xml");

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
        int studentId = 5;
        int result = studentDao.deleteStudent(studentId);

        if (result > 0) {
            System.out.println("Student deleted successfully");
        } else {
            System.out.println("Failed to delete student");
        }
    }
}
