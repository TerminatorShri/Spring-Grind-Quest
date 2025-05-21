package org.example.dao;

import org.example.entities.Student;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("studentDao")
public class StudentDaoImpl {

    private final SessionFactory sessionFactory;

    public StudentDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public Student getStudentById(int studentId) {
        return sessionFactory.getCurrentSession().get(Student.class, studentId);
    }

    @Transactional
    public List<Student> getAllStudents() {
        return sessionFactory.getCurrentSession().createQuery("from Student", Student.class).list();
    }

    @Transactional
    public int insertStudent(Student student) {
        sessionFactory.getCurrentSession().persist(student);
        return (int) student.getStudentId();
    }

    @Transactional
    public Student updateStudent(Student student) {
        return sessionFactory.getCurrentSession().merge(student);
    }

    @Transactional
    public boolean deleteStudent(int studentId) {
        try {
            Student student = sessionFactory.getCurrentSession().get(Student.class, studentId);
            if (student != null) {
                sessionFactory.getCurrentSession().remove(student);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
