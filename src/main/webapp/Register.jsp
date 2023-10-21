<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 10/17/2023
  Time: 9:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register Page</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.19/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-100 min-h-screen flex items-center justify-center">
<div class="w-full max-w-screen-xl mx-auto flex items-center justify-center">
    <div class="w-1/2 hidden md:block">
        <img src="https://images.unsplash.com/photo-1614741118887-7a4ee193a5fa?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1887&q=80" class="rounded-2xl h-auto max-h-full" alt="page img">
    </div>
    <section class="w-1/2 bg-gray-200 min-h-screen flex items-center justify-center">
        <div class="max-w-md bg-white rounded-lg shadow-md p-8 space-y-4 w-full">
            <h1 class="text-2xl font-semibold text-center">User Registration</h1>
    <form action="register" method="post">
        <div class="mb-4">
            <label for="email" class="block text-gray-700 text-sm font-bold mb-2">Email</label>
            <input type="email" name="email" id="email" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" required>
        </div>
        <div class="mb-4">
            <label for="password" class="block text-gray-700 text-sm font-bold mb-2">Password</label>
            <input type="password" name="password" id="password" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" required>
        </div>
        <div class="mb-4">
            <label for="repeat_password" class="block text-gray-700 text-sm font-bold mb-2">Repeat Password</label>
            <input type="password" name="repeat_password" id="repeat_password" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" required>
        </div>
        <div class="mb-4">
            <label for="phone_number" class="block text-gray-700 text-sm font-bold mb-2">Phone Number</label>
            <input type="text" name="phoneNumber" id="phone_number" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" required>
        </div>
        <div class="mb-4">
            <label for="gender" class="block text-gray-700 text-sm font-bold mb-2">Gender</label>
            <select name="gender" id="gender" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" required>
                <option value="1">Male</option>
                <option value="2">Female</option>
            </select>
        </div>
        <div class="flex items-center justify-between mt-4">
            <button  type="submit"  class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline">Register</button>
            <a  href="login.jsp" class="text-blue-500 hover:text-blue-700">Login</a>
        </div>
    </form>
        </div>
    </section>
</div>
</body>
</html>
