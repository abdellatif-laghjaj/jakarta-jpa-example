package com.jetbrains.firstpr.Connection;

import com.jetbrains.firstpr.Models.Student;

import javax.persistence.*;
import java.util.List;

public class StudentDao {

    @PersistenceContext(unitName = "bdd_tpapp_UP")
    private static EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public StudentDao() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("bdd_tpapp_UP");
        this.entityManager = this.entityManagerFactory.createEntityManager();
    }

    public List<Student> getAllStudents() {
        List<Student> students = null;
        students = entityManager.createNativeQuery("SELECT * FROM student ", Student.class).getResultList();
        return students;
    }

    public Student addStudent(Student student) {
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        return student;
    }

    public Student findStudent(int id) {
        return entityManager.find(Student.class, id);
    }

    public void updateStudent(Student student, int id) {
        Student s = entityManager.find(Student.class, id);
        entityManager.getTransaction().begin();
        s.setFirstname(student.getFirstname());
        s.setLastname(student.getLastname());
        entityManager.getTransaction().commit();
    }

    public void deleteStudent(Student student) {
        entityManager.getTransaction().begin();
        entityManager.remove(student);
        entityManager.getTransaction().commit();
    }


    public void close() {
        this.entityManager.close();
        this.entityManagerFactory.close();
    }
}
