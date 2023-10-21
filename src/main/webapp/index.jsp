<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Tailwind Script -->
    <script src="https://cdn.tailwindcss.com"></script>

    <!-- Fonts -->
 </head>

<body class="flex flex-col items-center justify-center min-h-screen bg-gray-100">
<div class="w-full max-w-md p-4 bg-white shadow-md rounded-lg">
    <h1 class="text-xl font-semibold text-center">Welcome to Optima</h1>
    <p class="text-gray-700 text-base mt-4">Optima is a powerful application that can help you to manage your business. Sign up today to get started!</p>
    <div class="flex items-center justify-between mt-4">
        <a href="Register.jsp" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline">Register</a>
        <a href="login.jsp" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline">Login</a>
    </div>
</div>
<section class="dark:bg-gray-800 dark:text-gray-100">
    <div class="container flex flex-col justify-center p-6 mx-auto sm:py-12 lg:py-24 lg:flex-row lg:justify-between">
        <div class="flex items-center justify-center p-6 mt-8 lg:mt-0 h-72 sm:h-80 lg:h-96 xl:h-112 2xl:h-128">
            <img src="assets/svg/Business_SVG.svg" alt="" class="object-contain h-72 sm:h-80 lg:h-96 xl:h-112 2xl:h-128">
        </div>
        <div class="flex flex-col justify-center p-6 text-center rounded-sm lg:max-w-md xl:max-w-lg lg:text-left">
            <h1 class="text-5xl font-bold leadi sm:text-6xl">Ac mattis
                <span class="dark:text-violet-400">senectus</span>erat pharetra
            </h1>
            <p class="mt-6 mb-8 text-lg sm:mb-12">Dictum aliquam porta in condimentum ac integer
                <br class="hidden md:inline lg:hidden">turpis pulvinar, est scelerisque ligula sem
            </p>
            <div class="flex flex-col space-y-4 sm:items-center sm:justify-center sm:flex-row sm:space-y-0 sm:space-x-4 lg:justify-start">
                <a rel="noopener noreferrer" href="#" class="px-8 py-3 text-lg font-semibold rounded dark:bg-violet-400 dark:text-gray-900">Suspendisse</a>
                <a rel="noopener noreferrer" href="#" class="px-8 py-3 text-lg font-semibold border rounded dark:border-gray-100">Malesuada</a>
            </div>
        </div>
    </div>
</section>
</body>



