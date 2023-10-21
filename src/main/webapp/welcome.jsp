<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 10/20/2023
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("user") == null) {
        response.sendRedirect("login.jsp");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome Page</title>
    <!-- Add any necessary CSS styles here -->
    <style>
        .card {
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 20px;
            text-align: center;
            margin: 10px;
            display: inline-block;
            cursor: pointer;
        }
        .card:hover {
            background-color: #f0f0f0;
        }
    </style>
    <jsp:include page="navbar.jsp" />
</head>
<body>

<div class="container mx-auto mt-8">
    <div class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-4 gap-4">
        <!-- Card 1 -->
        <div class="bg-white shadow-md p-4 rounded-lg text-center">
            <img src="user-management-image.jpg" alt="User Management" class="mx-auto mb-4" width="150" height="150">
            <h2 class="text-xl font-semibold mb-2">Gestion des Utilisateurs</h2>
        </div>

        <!-- Card 2 -->
        <div class="bg-white shadow-md p-4 rounded-lg text-center">
            <img src="allocation-management-image.jpg" alt="Allocation Management" class="mx-auto mb-4" width="150" height="150">
            <h2 class="text-xl font-semibold mb-2">Gestion des Allocations</h2>
        </div>

        <!-- Card 3 -->
        <div class="bg-white shadow-md p-4 rounded-lg text-center">
            <img src="fault-management-image.jpg" alt="Fault Management" class="mx-auto mb-4" width="150" height="150">
            <h2 class="text-xl font-semibold mb-2">Gestion des Pannes</h2>
        </div>

        <!-- Card 4 (Additional Category) -->
        <div class="bg-white shadow-md p-4 rounded-lg text-center">
            <img src="additional-image.jpg" alt="Additional Category" class="mx-auto mb-4" width="150" height="150">
            <h2 class="text-xl font-semibold mb-2">Additional Category</h2>
        </div>
    </div>
</div>



</body>
</html>
