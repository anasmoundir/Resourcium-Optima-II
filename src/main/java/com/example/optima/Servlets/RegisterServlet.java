package com.example.optima.Servlets;

import com.example.optima.Dao.UserDao;
import com.example.optima.Dao.RoleDao;
import com.example.optima.Entities.RoleEntity;
import com.example.optima.Entities.UserEntity;
import com.example.optima.Services.HashPassword;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {


    UserEntity user = new UserEntity();
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("Register.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        boolean isError = false;
        try {

            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String repeatedPassword = request.getParameter("repeat_password");

            if (password.equals(repeatedPassword)) {
               password = HashPassword.hashPassword(password);
                user.setUserPassword(password);
                String username = HashPassword.extractUsernameFromEmail(email);
                user.setUserName(username);
                String phoneNumber = request.getParameter("phoneNumber");
                Byte gender;
                try {
                    gender = Byte.valueOf(request.getParameter("gender"));
                } catch (NumberFormatException e) {
                    throw new Exception("Invalid gender value");
                }
                user.setEmail(email);
                user.setUserPassword(password);
                user.setPhoneNumber(phoneNumber);
                user.setGender(gender);
                user.setIdRole(2);
                Set<RoleEntity> roles = new HashSet<>();
                RoleDao roleDao = new RoleDao(entityManagerFactory);
                RoleEntity role = roleDao.findRoleByName("user");
                roles.add(role);
                UserDao userDao = new UserDao(entityManagerFactory);
                userDao.save(user,roles);
                response.sendRedirect(request.getContextPath() + "/welcome.jsp");
            } else {
                isError = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            isError = true;
        }

        if (isError) {
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }


}

