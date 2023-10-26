

</head>
<body>
<nav class="bg-blue-600 p-4 text-white">
  <div class="container mx-auto flex justify-between items-center">
    <a href="welcome.jsp" class="text-2xl font-bold">Your Logo</a>
    <div>
      <ul class="flex space-x-6">
        <li>
          <a href="welcome.jsp" class="hover:text-yellow-300">Home</a>
        </li>
        <li>
          <%
            if (session.getAttribute("user") != null && "2".equals(session.getAttribute("role_id")) && session.getAttribute("user") != null) {
          %>
          <a href="adminpage.jsp" class="hover:text-yellow-300">Admin</a>
          <%
            }
          %>
        </li>
        <li>
          <%
            if (session.getAttribute("user") != null && "2".equals(session.getAttribute("role_id")) && session.getAttribute("user") != null) {
          %>
          <a href="admin.jsp" class="hover:text-yellow-300">Admin</a>
          <%
            }
          %>
        </li>
        <li>
          <a href="equipements.jsp" class="hover:text-yellow-300">Equipements</a>
        </li>
        <li>
          <!-- Add more navigation links as needed -->
        </li>
      </ul>
    </div>
  </div>
</nav>

</body>
</html>
