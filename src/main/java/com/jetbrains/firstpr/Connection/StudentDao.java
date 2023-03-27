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

    ;

    public static Student findStudent(int id) {
        return entityManager.find(Student.class, id);
    }

    public static Student updateStudent(Student student) {
        Student stUpdated = findStudent(student.getId());
        stUpdated.setLastname(student.getLastname());
        stUpdated.setFirstname(student.getFirstname());
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();
        return stUpdated;
    }

    ;

    public static void deleteStudent(Student student) {
        entityManager.getTransaction().begin();
        entityManager.remove(student);
        entityManager.getTransaction().commit();
    }


    public void close() {
        this.entityManager.close();
        this.entityManagerFactory.close();
    }
}
