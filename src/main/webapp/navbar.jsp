
<!DOCTYPE html>
<html>
<head>
  <title>Management App</title>
  <link href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.19/tailwind.min.css" rel="stylesheet">
</head>
<body>
<% if (session.getAttribute("user") != null) { %>
<p>Welcome, <%= ((com.example.optima.Entities.UserEntity) session.getAttribute("user")).getUserName() %>!</p>
<% } else { %>
<p>You are not logged in. Please <a href="login.jsp">log in</a> to access the application.</p>
<% } %>

<nav class="bg-blue-500 p-4">
  <div class="container mx-auto flex justify-between items-center">
    <h1 class="text-3xl text-white font-bold">Management App</h1>
    <% if (session.getAttribute("user") != null) { %>
    <a href="login.jsp" class="text-white hover:underline">Logout</a>
    <% } %>
  </div>
</nav>

<div class="container mx-auto mt-8 p-4">
  <ul class="flex justify-center space-x-4">

    <li><a href="dashboard.jsp" class="text-blue-500 hover:underline">Welcome</a></li>
    <li><a href="UpdateProfile.jsp" class="text-blue-500 hover:underline">Upadtig profile</a></li>
    <li><a href="products.jsp" class="text-blue-500 hover:underline">equipement</a></li>
    <li><a href="orders.jsp" class="text-blue-500 hover:underline">human ressources</a></li>
    <li><a href="settings.jsp" class="text-blue-500 hover:underline">Settings</a></li>
  </ul>
</div>

</body>
</html>