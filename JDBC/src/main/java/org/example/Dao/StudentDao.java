package org.example.Dao;

import org.example.entities.Student;

import java.util.List;

public interface StudentDao {
    public Student getStudent(int studentId);

    public List<Student> getStudents();

    public int insertStudent(Student student);

    public int updateStudent(Student student);

    public int deleteStudent(int studentId);
}
