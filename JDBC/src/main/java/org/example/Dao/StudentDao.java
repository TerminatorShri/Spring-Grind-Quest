package org.example.Dao;

import org.example.entities.Student;

public interface StudentDao {
    public int insertStudent(Student student);
    public int updateStudent(Student student);
    public int deleteStudent(int studentId);
}
