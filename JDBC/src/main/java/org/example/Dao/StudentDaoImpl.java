package org.example.Dao;

import org.example.entities.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Student getStudent(int studentId) {
        String query = "SELECT * FROM student WHERE studentId = ?";
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);

        return this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
    }

    @Override
    public List<Student> getStudents() {
        String query = "SELECT * FROM student";
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
        return this.jdbcTemplate.query(query, rowMapper);
    }

    @Override
    public int insertStudent(Student student) {
        String query = "INSERT INTO student (studentId, studentName, studentCity) VALUES (?, ?, ?)";
        return jdbcTemplate.update(query, student.getStudentId(), student.getStudentName(), student.getStudentCity());
    }

    @Override
    public int updateStudent(Student student) {
        String query = "UPDATE student SET studentName = ?, studentCity = ? WHERE studentId = ?";
        return jdbcTemplate.update(query, student.getStudentName(), student.getStudentCity(), student.getStudentId());
    }

    @Override
    public int deleteStudent(int studentId) {
        String query = "DELETE FROM student WHERE studentId = ?";
        return jdbcTemplate.update(query, studentId);
    }
}
