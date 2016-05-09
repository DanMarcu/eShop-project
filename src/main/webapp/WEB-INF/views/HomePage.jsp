<%-- 
    Document   : HomePage
    Created on : Apr 26, 2016, 1:04:31 PM
    Author     : Dan
--%>

<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/global.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp" flush="true" />

        <table width=100%> 
            <tr> 
                <td valign="top">
                    <table width="350px" border="1" cellpadding="5">
                        <br><br><br><br>
                        <tr>

                            <th> CATEGORIE PRODUSE </th>

                        </tr>
                        <tr>
                            <td><a href="${pageContext.request.contextPath}/ListaProduseServ?select=pc">PC</a></td> 
                        </tr> 
                        <tr>
                            <td><a href="${pageContext.request.contextPath}/ListaProduseServ?select=notebook">Notebook</a></td> 
                        </tr> 
                        <td><a href="${pageContext.request.contextPath}/ListaProduseServ?select=smartphone">Smartphone</a></td>  
            </tr>  
        </tr> 
        <td><a href="${pageContext.request.contextPath}/ListaProduseServ?select=tv">TV</a></td>  
    </tr> 
</table>
</td>
<td valign="top"><br><br><br>
    <table width="798px" border="1" cellpadding="5">    
        <tr>
            <th> ID </th>
            <th> DENUMIRE </th>
            <th> DESCRIERE </th>
            <th> PRET </th>
        </tr>
        <tr><h2>${userRecognized}</h2></tr>
    <tr><h2>Mari discount-uri la ${categorieRandom}-uri</h2></tr>
    <c:forEach items = "${listaProdusePromotionale}" var = "product">
    <tr>
    <form name="promotii"  >
        <td><c:out value = "${product.id}" /></td> 
        <td><c:out value = "${product.name}" /></td> 
        <td><c:out value = "${product.description}" /></td>  
        <td><c:out value = "${product.price}" /></td>
    </form>
</tr>
</c:forEach>

</table>
</td>
</tr>
</table>
</body>
</html>
