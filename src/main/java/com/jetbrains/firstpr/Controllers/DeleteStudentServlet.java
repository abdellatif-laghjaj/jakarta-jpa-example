package com.jetbrains.firstpr.Controllers;

import com.jetbrains.firstpr.Connection.StudentDao;
import com.jetbrains.firstpr.Models.Student;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteStudentServlet", value = "/delete-student-servlet")
public class DeleteStudentServlet extends HttpServlet {
    private StudentDao studentDao;

    @Override
    public void init() throws ServletException {
        studentDao = new StudentDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int studentId = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : 0;
        Student student = studentDao.findStudent(studentId);

        studentDao.deleteStudent(student);
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath + "/students");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
