package com.example.optima.Servlets;

import com.example.optima.Dao.UserDao;
import com.example.optima.Entities.RoleEntity;
import com.example.optima.Entities.UserEntity;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao(entityManagerFactory);
        List<UserEntity> userList = userDao.getAllUsers();

        for (UserEntity user : userList) {
            String roleId = request.getParameter("promoteRole_" + user.getIdUser());
            if (roleId != null) {
                int userId = user.getIdUser();
                Set<RoleEntity> roles = new HashSet<>();
                int roleIdInt = Integer.parseInt(roleId);
                RoleEntity role = userDao.getRoleById(roleIdInt);
                if (role != null) {
                    roles.add(role);
                    userDao.updateUserRole(userId, roles);
                }
            }
        }

        response.sendRedirect("admin.jsp");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao(entityManagerFactory);
        List<UserEntity> userList = userDao.getAllUsersWithRoles();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("/admin.jsp").forward(request, response);
    }
}