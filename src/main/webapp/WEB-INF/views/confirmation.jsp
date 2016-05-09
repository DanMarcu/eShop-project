<%-- 
    Document   : confirmation
    Created on : Apr 26, 2016, 1:06:18 PM
    Author     : Dan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/global.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmation</title>
    </head>
    <body>
         <p align="right"><font face="Verdana, Arial, Helvetica, sans-serif"><strong>PAGINA DE CONFIRMARE A INREGISTRARII</strong></font></p> 
         <%@ include file="header.jsp" %> 
         <br> 
         <%@ include file="menuCategorie.jsp" %>  
        <h1>${result}</h1>
    </body>
</html>