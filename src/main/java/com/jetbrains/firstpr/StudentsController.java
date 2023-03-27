package com.jetbrains.firstpr;

import com.jetbrains.firstpr.Connection.StudentDao;
import com.jetbrains.firstpr.Models.Student;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "StudentsController", value = "/students/*")
public class StudentsController extends HttpServlet {
    private StudentDao studentDao;

    @Override
    public void init() throws ServletException {
        studentDao = new StudentDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getPathInfo();
        System.out.println("action = " + action);
        int studentId = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : 0;
        Student student = studentDao.findStudent(studentId);
        if (action == null) {
            action = "/students";
        }

        switch (action) {
            case "/students":
                request.getRequestDispatcher("StudentsView.jsp").forward(request, response);
                break;
            case "/delete":
                StudentDao.deleteStudent(student);
                request.getRequestDispatcher("StudentsView.jsp").forward(request, response);
                break;

            case "/edit":
                    int id = Integer.parseInt(request.getParameter("id"));
                    Student st = StudentDao.findStudent(id);
                    request.setAttribute("student", st);
                    request.getRequestDispatcher("updateStudent.jsp").forward(request, response);
                    break;

            case "/update":
                StudentDao.updateStudent(student);
                response.sendRedirect(request.getContextPath() + "/students");
                break;
            default:
                //redirect to index
                response.sendRedirect(request.getContextPath() + "/students");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
