package com.jetbrains.firstpr.Connection;

import com.jetbrains.firstpr.Models.Task;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDao {
    @PersistenceContext(name = "persistence")
    public List<Task> getAllTasks() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        EntityManager em = emf.createEntityManager();

        Query query = em.createNativeQuery("SELECT * FROM task", Task.class);

        ArrayList<Task> tasks = new ArrayList<Task>();
        while (query.getResultList().iterator().hasNext()) {
            tasks.add((Task) query.getResultList().iterator().next());
        }

        return tasks;
    }

    public void createTask(Task task) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        EntityManager em = emf.createEntityManager();

        Query query = em.createNativeQuery("INSERT INTO task (title, startDate, duration, developerId, projectId) VALUES (?, ?, ?, ?, ?)");
        query.setParameter(1, task.getTitle());
        query.setParameter(2, task.getStartDate());
        query.setParameter(3, task.getDuration());
        query.setParameter(4, task.getDeveloperId());
        query.setParameter(5, task.getProjectId());

        try {
            em.getTransaction().begin();
            query.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
}
