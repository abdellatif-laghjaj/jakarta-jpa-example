package com.jetbrains.firstpr;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    String email;

    public void init() {
        message = "WELCOME!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        email = (String) session.getAttribute("email");

        // Hello
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1>Welcome</h1>");
        out.println("<h3>" + email + "</h3>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}