package com.example.optima.Servlets;

import com.example.optima.Dao.UserDao;
import com.example.optima.Entities.UserEntity;
import com.example.optima.Services.HashPassword;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private String message;
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

    public void init() {
        message = "Hello World!";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            UserDao userDao = new UserDao(entityManagerFactory);
            UserEntity user = userDao.getUserByEmail(email);
            if (user != null && HashPassword.hashPassword(password).equals(user.getUserPassword())) {
                HttpSession session = req.getSession(true);
                session.setAttribute("user", user);

                if(user.getIdRole() == 2)
                {
                    resp.sendRedirect(req.getContextPath() +"/welcome.jsp");
                }
                else if(user.getIdRole() == 1)
                {
                    resp.sendRedirect(req.getContextPath() + "/admin");
                }

            } else {
                resp.sendRedirect(req.getContextPath() + "/error.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath() + "/error.jsp");
        }
    }
}
