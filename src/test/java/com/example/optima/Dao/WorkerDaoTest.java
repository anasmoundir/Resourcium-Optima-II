package com.example.optima.Dao;

import com.example.optima.Entities.RoleEntity;
import com.example.optima.Entities.UserEntity;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class WorkerDaoTest {

    private EntityManagerFactory entityManagerFactory;
    @BeforeEach
    void setup() {
        Map<String, String> properties = new HashMap<>();
        properties.put("javax.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver");
        properties.put("javax.persistence.jdbc.url", "jdbc:mysql://localhost:3306/Resourcium_Optima");
        properties.put("javax.persistence.jdbc.user", "root");
        properties.put("javax.persistence.jdbc.password", "");

        entityManagerFactory = Persistence.createEntityManagerFactory("default");
    }
    @Test
    void save() {
        UserDao userDao = new UserDao(entityManagerFactory);

        // Create a user entity and set its properties
        UserEntity user = new UserEntity();
        user.setEmail("test@example.com");
        user.setUserName("");

        Set<RoleEntity> roles = new HashSet<>();
        RoleEntity role1 = new RoleEntity();
        role1.setNameRole("");
        RoleEntity role2 = new RoleEntity();
        role2.setNameRole("");
        roles.add(role1);
        roles.add(role2);

        userDao.save(user, roles);

        UserEntity savedUser = userDao.getUserByEmail("test@example.com");
        assertNotNull(savedUser);
        assertEquals("testuser", savedUser.getUserName());
    }

    @Test
    void getUserByEmail() {
        UserDao userDao = new UserDao(entityManagerFactory);

        // Assuming you have a user with a known email address
        UserEntity user = userDao.getUserByEmail("test@example.com");
        assertNotNull(user);
        assertEquals("test@example.com", user.getEmail());
    }

    @Test
    void getAllUsers() {
        UserDao userDao = new UserDao(entityManagerFactory);

        // Retrieve all users
        List<UserEntity> users = userDao.getAllUsers();
        assertNotNull(users);
        assertFalse(users.isEmpty());
    }

    @Test
    void updateUserRole() {
        UserDao userDao = new UserDao(entityManagerFactory);

        // Assuming you have a user with a known ID
        int userId = 1;

        // Create roles
        Set<RoleEntity> newRoles = new HashSet<>();
        RoleEntity newRole = new RoleEntity();
        newRole.setNameRole("");
        newRoles.add(newRole);

        // Update the user's roles
        userDao.updateUserRole(userId, newRoles);

        // Check if the user's roles were updated successfully
        UserEntity updatedUser = userDao.getUserByEmail("test@example.com");
        assertNotNull(updatedUser);
        assertEquals("ROLE_UPDATED", updatedUser.getRoles().iterator().next().getNameRole());
    }

    @Test
    void getRoleById() {
        UserDao userDao = new UserDao(entityManagerFactory);

        // Assuming you have a known role ID
        int roleId = 1;

        // Get the role by ID
        RoleEntity role = userDao.getRoleById(roleId);
        assertNotNull(role);
        assertEquals("ROLE_USER", role.getNameRole());
    }

    @Test
    void getAllUsersWithRoles() {
        UserDao userDao = new UserDao(entityManagerFactory);

        // Retrieve all users with their roles
        List<UserEntity> usersWithRoles = userDao.getAllUsersWithRoles();
        assertNotNull(usersWithRoles);
        assertFalse(usersWithRoles.isEmpty());
        assertNotNull(usersWithRoles.get(0).getRoles());
    }

    @Test
    void getAllRoles() {
        UserDao userDao = new UserDao(entityManagerFactory);

        // Retrieve all roles
        List<RoleEntity> roles = userDao.getAllRoles();
        assertNotNull(roles);
        assertFalse(roles.isEmpty());
    }
}