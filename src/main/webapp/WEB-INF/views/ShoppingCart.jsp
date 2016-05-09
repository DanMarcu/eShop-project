<%-- 
    Document   : ShoppingCart
    Created on : Apr 26, 2016, 1:05:34 PM
    Author     : Dan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/global.css">
        <title>Shopping Cart</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    </head>

    <body>
        <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
        <p align="right"><font face="Verdana, Arial, Helvetica, sans-serif"><strong>COS CUMPARATURI</strong></font></p>
       
         <br>
         <%@ include file="menuCategorie.jsp" %>
         <br>
        <table width="75%">
            <tr>
                <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">ID Product</font></strong></td>
                <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Name</font></strong></td>
                <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Description</font></strong></td>
                <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Quantity</font></strong></td>
                <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Unit Price</font></strong></td>
                <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Total</font></strong></td>
            </tr>
            <jsp:useBean id="cart" scope="session" class="com.mycompany.eshop.entities.CartBean" />
            <c:if test="${cart.lineItemCount==0}">
                <tr>
                    <td colspan="4"><font size="2" face="Verdana, Arial, Helvetica, sans-serif">- Your shopping cart is empty ! -<br/>
                </tr>
            </c:if>
            <c:forEach var="cartItem" items="${cart.cartItems}" varStatus="counter">
                <form name="item" method="POST" action="CartControl">
                    <tr>
                       <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><b><c:out value="${cartItem.idProduct}"/></b></td>
                       <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><b><c:out value="${cartItem.name}"/></b><br/></td>
                          <td>  <c:out value="${cartItem.description}"/></font></td>
                        <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">
                            <input type='hidden' name='itemIndex' value='<c:out value="${counter.count}"/>'>
                            <input type='text' name="quantity" value='<c:out value="${cartItem.quantity}"/>' size='2'>
                            <input type="submit" name="action" value="Update">
                            </br><input type="submit" name="action" value="Delete">
                            </font></td>
                        <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">$<c:out value="${cartItem.unitCost}"/></font></td>
                        <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">$<c:out value="${cartItem.totalCost}"/></font></td>
                    </tr>
                </form>
            </c:forEach>
            <tr>
                <td colspan="2"> </td>
                <td> </td><td> </td><td> </td>
                <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Subtotal: $<c:out value="${cart.orderTotal}"/></font></td>
            </tr>
        </table>
    </body>
</html>
