package com.jetbrains.firstpr;

import com.jetbrains.firstpr.Connection.StudentDao;
import com.jetbrains.firstpr.Models.Student;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentsServlet", value = "/students")
public class StudentsServlet extends HttpServlet {

    StudentDao studentDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        studentDao = new StudentDao();
        List<Student> students = studentDao.getAllStudents();
        request.setAttribute("students", students);
        request.getRequestDispatcher("StudentsView.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
