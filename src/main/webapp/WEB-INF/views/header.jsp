<%-- 
    Document   : header
    Created on : Apr 26, 2016, 1:08:15 PM
    Author     : Dan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id = "header">

    <a href="HomePage.jsp"><p id = "logo"> &lt; eShop &gt; </p></a>

    <div id = "login_and_basket">

        <c:set var='username' value='${sessionScope.username}'></c:set>

        <c:choose>
            <c:when test="${username == false}">
                Welcome, <a href = "${pageContext.request.contextPath}listaProduse" id="welcome_name">${username}</a>!
                <button onclick="window.location.href = '${pageContext.request.contextPath}/logout'" id="but_logout"> Logout </button>
            </c:when>

            <c:when test="${username != false}">
                <button onclick="window.location.href = '${pageContext.request.contextPath}/login'" id="but_login"> Login </button>
            </c:when>   
                
                
        </c:choose>      



        <button onclick="window.location.href = '${pageContext.request.contextPath}/ShoppingCart'" id="but_basket"> ShoppingCart </button>
    </div>

</div>
