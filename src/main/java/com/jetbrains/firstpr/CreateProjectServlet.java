package com.jetbrains.firstpr;

import com.jetbrains.firstpr.Connection.ProjectDao;
import com.jetbrains.firstpr.Connection.TaskDao;
import com.jetbrains.firstpr.Models.Project;
import com.jetbrains.firstpr.Models.Task;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "CreateProjectServlet", value = "/create-project-servlet")
public class CreateProjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String startDate = request.getParameter("startDate");
        int developerId = Integer.parseInt(request.getParameter("developerId"));
        int taskId = Integer.parseInt(request.getParameter("taskId"));
        int duration = Integer.parseInt(request.getParameter("duration"));

        Project project = new Project();
        project.setTitle(title);
        project.setStartDate(startDate);
        project.setDuration(duration);

        Task task = new Task();
        task.setId(taskId);
        task.setTitle("Task Title");
        task.setProjectId(project.getId());
        task.setDeveloperId(developerId);
        task.setDuration(duration);
        task.setStartDate(startDate);


        //create new project
        ProjectDao projectDao = new ProjectDao();
        projectDao.createProject(project);

        //create new task
        TaskDao taskDao = new TaskDao();
        taskDao.createTask(task);

        //session to send
        HttpSession session = request.getSession();
        session.setAttribute("projectTitle", project.getTitle());
        session.setAttribute("developerId", developerId);
        session.setAttribute("taskId", taskId);

        //send to home page
        response.sendRedirect("home.jsp");
    }
}
