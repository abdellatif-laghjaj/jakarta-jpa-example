package com.jetbrains.firstpr;

import com.jetbrains.firstpr.Connection.LoginDao;
import com.jetbrains.firstpr.Models.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        LoginDao loginDao = new LoginDao();

        User user = loginDao.check(email, password);
        String destPage = "index.jsp";

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("fullname", user.getFullName());
            PrintWriter out = response.getWriter();
            destPage = "home.jsp";
        } else {
            String message = "Invalid email/password";
            request.setAttribute("message", message);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
        dispatcher.forward(request, response);
    }
}
