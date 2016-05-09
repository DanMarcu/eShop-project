<%-- 
    Document   : showUsers
    Created on : Apr 26, 2016, 1:11:39 PM
    Author     : Dan
--%>

<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/global.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users list</title>
    </head>
    <body>
        <table border="1" cellpadding="5">
            
            <tr>
                <th> ID </th>
                <th> USERNAME </th>
                <th> EMAIL </th>
                <th> FIRST NAME </th>
                <th> LAST NAME </th>
                <th> CITY </th>
                <th> EDIT </th>
            </tr>
            
                <c:forEach items = "${usersList}" var = "useri">
                    <tr>
                        <td><c:out value = "${useri.id}" /> </td> 
                        <td><c:out value = "${useri.username}" /></td> 
                        <td><c:out value = "${useri.email}" /></td>  
                        <td><c:out value = "${useri.firstName}" /></td>  
                        <td><c:out value = "${useri.lastName}" /></td> 
                        <td><c:out value = "${useri.city}" /></td> 
                        <td><a href = "${pageContext.request.contextPath}/editUser?id=${useri.id}"><button> Edit </button></a></td>
                    </tr>
                </c:forEach>
                    
        </table>
    </body>
</html>
