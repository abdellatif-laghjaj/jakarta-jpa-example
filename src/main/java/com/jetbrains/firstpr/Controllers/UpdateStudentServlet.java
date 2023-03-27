package com.jetbrains.firstpr.Controllers;

import com.jetbrains.firstpr.Connection.StudentDao;
import com.jetbrains.firstpr.Models.Student;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "UpdateStudentServlet", value = "/update-student-servlet")
public class UpdateStudentServlet extends HttpServlet {
    private StudentDao studentDao;

    @Override
    public void init() throws ServletException {
        studentDao = new StudentDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int studentId = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : 0;
        Student student = studentDao.findStudent(studentId);
        request.setAttribute("student", student);
        request.getRequestDispatcher("updateStudent.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int studentId = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : 0;
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        Student student = studentDao.findStudent(studentId);
        student.setFirstname(firstName);
        student.setLastname(lastName);
        studentDao.updateStudent(student, studentId);
        response.sendRedirect(request.getContextPath() + "/students");
    }
}
