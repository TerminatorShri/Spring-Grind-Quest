package org.example.Dao;

import org.example.entities.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setStudentId(rs.getInt("studentId"));
        student.setStudentName(rs.getString("studentName"));
        student.setStudentCity(rs.getString("studentCity"));
        return student;
    }
}
