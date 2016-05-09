<%-- 
    Document   : listaProduse
    Created on : Apr 26, 2016, 1:08:55 PM
    Author     : Dan
--%>

<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Quicksand" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/global.css">
        <title>Lista Produse</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
         <p align="right"><font face="Verdana, Arial, Helvetica, sans-serif"><strong>LISTA PRODUSE</strong></font></p>
        <%@ include file="header.jsp" %> 
         <br>
        <%@ include file="menuCategorie.jsp" %> 
         <br>
       <table border="1" cellpadding="5">    
            <tr>
                <th> ID </th>
                <th> DENUMIRE </th>
                <th> DESCRIERE </th>
                <th> PRET </th>
                <th> CANTITATE </th>
            </tr>
            
                <c:forEach items = "${listaProduse}" var = "product">
                    <tr><form name="articol" method="POST" action="CartControl">
                        <td><c:out value = "${product.id}" /><input type="hidden" name="idProduct" value="${product.id}"></td> 
                        <td><c:out value = "${product.name}" /><input type="hidden" name="name" value="${product.name}"></td> 
                        <td><c:out value = "${product.description}" /><input type="hidden" name="description" value="${product.description}"></td>  
                        <td><c:out value = "${product.price}" /><input type="hidden" name="price" value="${product.price}"></td>
                        <td><input type="text" name="quantity" value="1" required></td>
                        <td><input type="hidden" name="action" value="add"><button type="submit" id="but_addToCart">Add To Cart</button></a></td>
                     </form>
                    </tr>
                </c:forEach>
                    
        </table>
    </body>
</html>
