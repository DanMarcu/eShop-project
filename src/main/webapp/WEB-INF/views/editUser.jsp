<%-- 
    Document   : editUser
    Created on : Apr 26, 2016, 1:07:40 PM
    Author     : Dan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/global.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit user</title>
    </head>
    <body>
        
        <form action="UpdateUserServlet" method="POST" name="editUser">
            <input type="hidden" name="id" value="${user.id}" />
            <input type="text" name="newUsername" placeholder="Username" size="50" value="${user.username}"><br>
            <input type="text" name="newEmail" placeholder="you@example.com" value="${user.email}"><br>
            <input type="text" name="newFirstName" placeholder="First Name" value="${user.firstName}"><br>
            <input type="text" name="newLastName" placeholder="Last Name" value="${user.lastName}"><br>
            <input type="text" name="newCity" placeholder="City" value="${user.city}"><br> 
            <button type="submit" name="action" value="Update">Update</button><br><br>
            <button type="submit" name="action" value="Delete">Delete</button>
        </form>
        
    </body>
</html>
