package com.example.optima.Servlets.adminusers;

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

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao(entityManagerFactory);
        List<UserEntity> userList = userDao.getAllUsersWithRoles();
        List<RoleEntity> availableRoles = userDao.getAllRoles();
        request.setAttribute("availableRoles", availableRoles);
        request.setAttribute("userList", userList);

        for (UserEntity user : userList) {
            String userId = request.getParameter("userId");
            if (userId != null && userId.equals(String.valueOf(user.getIdUser()))) {
                String addRoleId = request.getParameter("addRole");
                String deleteRoleId = request.getParameter("deleteRole");

                if (addRoleId != null) {
                    int roleIdInt = Integer.parseInt(addRoleId);
                    RoleEntity role = userDao.getRoleById(roleIdInt);

                    if (role != null) {
                        Set<RoleEntity> roles = user.getRoles();
                        roles.add(role);
                        userDao.updateUserRole(user.getIdUser(), roles);
                    }
                }

                if (deleteRoleId != null) {
                    int roleIdInt = Integer.parseInt(deleteRoleId);
                    RoleEntity role = userDao.getRoleById(roleIdInt);

                    if (role != null) {
                        Set<RoleEntity> roles = user.getRoles();
                        roles.remove(role);
                        userDao.updateUserRole(user.getIdUser(), roles);
                    }
                }
            }
        }
        request.getRequestDispatcher("admin.jsp").forward(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Inside doGet method");
        UserDao userDao = new UserDao(entityManagerFactory);
        List<UserEntity> userList = userDao.getAllUsersWithRoles();
        List<RoleEntity> availableRoles = userDao.getAllRoles();
        request.setAttribute("availableRoles", availableRoles);
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("admin.jsp").forward(request,response);
    }
}