<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 10/22/2023
  Time: 3:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Page</title>
</head>
<body>
<h1>Admin Page</h1>

<form action="AdminServlet" method="post">
    <table>
        <tr>
            <th>ID</th>
            <th>phone</th>
            <th>email</th>
            <th>given name</th>
            <th>genrerole</th>
            <th>Roleid</th>
            <th></th>
        </tr>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td>${user.idUser}</td>
                <td>${user.phoneNumber}</td>
                <td>${user.email}</td>
                <td>${user.userName}</td>
                <td>${user.gender}</td>
                <td>${user.idRole}</td>
                <td>
                    <select name="promoteRole_${user.idUser}">
                        <c:forEach var="role" items="${user.roles}">
                            <option value="${role.id}">${role.nameRole}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
        </c:forEach>
    </table>
    <input type="submit" value="Update Roles">
</form>

</body>
</html>