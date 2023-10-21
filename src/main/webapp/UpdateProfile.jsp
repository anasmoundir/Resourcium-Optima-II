<%@ page import="static jakarta.faces.component.UIWebsocket.PropertyKeys.user" %><%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 10/20/2023
  Time: 11:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modifier le Profil</title>
</head>
<body>
<h1>Modifier le Profil</h1>
<form action="updateProfile" method="post">
    <label for="username">Nom d'Utilisateur:</label>
    <input type="text" id="username" name="username" value="" required><br>

    <label for="email">Adresse E-mail:</label>
    <input type="email" id="email" name="email" value="" required><br>

    <label for="phoneNumber">Numéro de Téléphone:</label>
    <input type="tel" id="phoneNumber" name="phoneNumber" value="" required><br>

    <label for="gender">Genre:</label>
    <select id="gender" name="gender">
        <option value="1" >Homme</option>
        <option value="2" >Femme</option>
        <option value="3" >Non spécifié</option>
    </select><br>

    <input type="submit" value="Mettre à jour">
</form>
</body>
</html>
