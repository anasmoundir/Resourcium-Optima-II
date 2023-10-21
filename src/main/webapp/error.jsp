<%@ page isErrorPage="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html >
<html>
<head>
    <meta charset="UTF-8">
    <title>Error Page</title>
</head>
<body>
<% if(response.getStatus() == 500){ %>
<h2 color="red">Error: <%=exception.getMessage() %></h2><br>

<%@ include file="index.jsp"%>
<%}else {%>
Hi There, error code is <%=response.getStatus() %><br>
Please go to <a href="index.jsp">home page</a>
<%} %>
</body>
</html>