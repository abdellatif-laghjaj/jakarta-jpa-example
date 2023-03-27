package com.jetbrains.firstpr;

import com.jetbrains.firstpr.Connection.StudentDao;
import com.jetbrains.firstpr.Models.Student;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddStudentServlet", value = "/add-student")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");

        Student student = new Student(firstname,lastname);
        StudentDao stdDao = new StudentDao();
        stdDao.addStudent(student);

        String message = "Student Added Successfully";
        request.setAttribute("message",message);
        request.getRequestDispatcher("addStudent.jsp").forward(request,response);
    }
}
