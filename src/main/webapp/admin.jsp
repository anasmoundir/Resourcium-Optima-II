<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.example.optima.Entities.UserEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.optima.Entities.RoleEntity" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Page</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.19/tailwind.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="NavAdmin.jsp" />
<div class="max-w-screen-xl">
    <div class="mx-auto max-w-lg text-center">
        <h1 class="text-3xl font-bold text-gray-900">User Roles</h1>
        <table class="min-w-full overflow-x-scroll divide-y divide-gray-200">
            <thead class="bg-gray-50">
            <tr>
                <th scope="col" class="px-6 py-3 text-xs font-medium tracking-wider text-left text-gray-500 uppercase">
                    ID
                </th>
                <th scope="col" class="px-6 py-3 text-xs font-medium tracking-wider text-left text-gray-500 uppercase">
                    Phone
                </th>
                <th scope="col" class="px-6 py-3 text-xs font-medium tracking-wider text-left text-gray-500 uppercase">
                    Email
                </th>
                <th scope="col" class="px-6 py-3 text-xs font-medium tracking-wider text-left text-gray-500 uppercase">
                    Name
                </th>
                <th scope="col" class="px-6 py-3 text-xs font-medium tracking-wider text-left text-gray-500 uppercase">
                    Gender
                </th>
                <th scope="col" class="px-6 py-3 text-xs font-medium tracking-wider text-left text-gray-500 uppercase">
                    Role ID
                </th>
                <th scope="col" class="px-6 py-3 text-xs font-medium tracking-wider text-left text-gray-500 uppercase">
                    Update Role
                </th>
            </tr>
            </thead>
            <tbody class="bg-white divide-y divide-gray-200">
            <% List<UserEntity> userEntities = (List<UserEntity>) request.getAttribute("userList");
                List<RoleEntity> availableRoles = (List<RoleEntity>) request.getAttribute("availableRoles");
                for (UserEntity user1 : userEntities) { %>
            <tr class="transition-all hover:bg-gray-100 hover:shadow-lg">
                <td class="px-6 py-4 whitespace-nowrap">
                    <%= user1.getIdUser() %>
                </td>
                <td class="px-6 py-4 whitespace-nowrap">
                    <%= user1.getPhoneNumber() %>
                </td>
                <td class="px-6 py-4 whitespace-nowrap">
                    <%= user1.getEmail() %>
                </td>
                <td class="px-6 py-4 whitespace-nowrap">
                    <%= user1.getUserName() %>
                </td>
                <td class="px-6 py-4 whitespace-nowrap">
                    <%= user1.getGender() %>
                </td>
                <td class="px-6 py-4 whitespace-nowrap">
                    <%= user1.getIdRole() %>
                </td>
                <td class="px-6 py-4 whitespace-nowrap">
                    <input type="hidden" name="userId" value="<%= user1.getIdUser() %>">
                    <select name="roles" class="px-2 py-1 text-sm">
                        <% for (RoleEntity role : user1.getRoles()) { %>
                        <option value="<%= role.getIdRole() %>"><%= role.getNameRole() %></option>
                        <% } %>
                    </select>
                </td>
                <td class="px-6 py-4 whitespace-nowrap">
                    <form action="admin" method="post">
                        <input type="hidden" name="userId" value="<%= user1.getIdUser() %>">
                        <select name="addRole" class="px-2 py-1 text-sm">
                            <option value="" disabled selected>Add Role</option>
                            <% for (RoleEntity role : availableRoles) { %>
                            <option value="<%= role.getIdRole() %>"><%= role.getNameRole() %></option>
                            <% } %>
                        </select>
                        <select name="deleteRole" class="px-2 py-1 text-sm">
                            <option value="" disabled selected>Delete Role</option>
                            <% for (RoleEntity role : user1.getRoles()) { %>
                            <option value="<%= role.getIdRole() %>"><%= role.getNameRole() %></option>
                            <% } %>
                        </select>
                        <button type="submit" name="add" value="true" class="px-2 py-1 bg-blue-500 text-white rounded-md">Add</button>
                        <button type="submit" name="delete" value="true" class="px-2 py-1 bg-red-500 text-white rounded-md">Delete</button>
                    </form>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>