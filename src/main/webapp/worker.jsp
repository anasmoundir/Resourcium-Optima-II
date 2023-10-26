<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Include CSS or Tailwind CSS -->
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.15/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-100">
<h1 class="text-2xl font-semibold text-center mt-4">Worker Management</h1>

<!-- Add Worker Form -->
<form action="createWorker" method="post" class="container mx-auto p-4 mt-4">
    <%--@declare id="availability"--%>
        <%--@declare id="maxhours"--%>
        <h2 class="text-xl font-semibold">Add Worker</h2>
    <label for="availability">Availability:</label>
    <input type="text" name="availability" required>
    <label for="maxHours">Max Hours:</label>
    <input type="text" name="maxHours" required>
    <!-- Other input fields for worker properties -->

    <input type="submit" value="Add" class="bg-blue-500 text-white p-2 rounded mt-2">
</form>

<!-- Worker List Table -->
<table class="table-auto w-full container mx-auto p-4 mt-4">
    <thead>
    <tr>
        <th class="px-4 py-2">ID</th>
        <th class="px-4 py-2">Availability</th>
        <th class="px-4 py-2">Max Hours</th>
        <!-- Other table headers for worker properties -->
        <th class="px-4 py-2">Actions</th>
    </tr>
    </thead>
    <tbody>
    <!-- Loop through workers and display them in rows -->
    <c:forEach items="${workers}" var="worker">
        <tr>
            <td class="px-4 py-2">${worker.idWorker}</td>
            <td class="px-4 py-2">${worker.availability}</td>
            <td class="px-4 py-2">${worker.maxHours}</td>
            <!-- Other table data cells for worker properties -->
            <td class="px-4 py-2">
                <!-- Edit Worker Form -->
                <form action="updateWorker" method="post">
                    <input type="hidden" name="idWorker" value="${worker.idWorker}">
                    <!-- Input fields for updating worker properties -->
                    <input type="submit" value="Edit" class="bg-blue-500 text-white p-2 rounded">
                </form>

                <!-- Delete Worker Form -->
                <form action="deleteWorker" method="post">
                    <input type="hidden" name="idWorker" value="${worker.idWorker}">
                    <p>Are you sure you want to delete this worker?</p>
                    <input type="submit" value="Delete" class="bg-red-500 text-white p-2 rounded mt-2">
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>