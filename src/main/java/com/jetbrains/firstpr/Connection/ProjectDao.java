package com.jetbrains.firstpr.Connection;

import com.jetbrains.firstpr.Models.Project;

import javax.persistence.*;

public class ProjectDao {
    @PersistenceContext(name = "persistence")
    public void createProject(Project project) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        EntityManager em = emf.createEntityManager();

        Query query = em.createNativeQuery("INSERT INTO project (title, startDate, duration) VALUES (?, ?, ?)");
        query.setParameter(1, project.getTitle());
        query.setParameter(2, project.getStartDate());
        query.setParameter(3, project.getDuration());

        try {
            em.getTransaction().begin();
            query.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
}
