package org.example.Dao;

import org.example.entities.Student;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDaoImpl implements StudentDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertStudent(Student student) {
        String query = "INSERT INTO student (studentId, studentName, studentCity) VALUES (?, ?, ?)";
        return jdbcTemplate.update(query, student.getStudentId(), student.getStudentName(), student.getStudentCity());
    }
}
