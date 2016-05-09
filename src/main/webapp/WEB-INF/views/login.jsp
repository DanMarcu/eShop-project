<%-- 
    Document   : login
    Created on : Apr 26, 2016, 3:47:18 PM
    Author     : Dan
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/global.css">
        <title>Login</title>
    </head>
    <body>
              <header>
            <div id = "login">
                <form action="LoginServlet" method="post" name="loginForm">
                    <input type="text" name="username" placeholder="username" required><br>
                    <input type="password" name="password" placeholder="password" required>
                    <button type="submit">Login</button>
                    <a href="${pageContext.request.contextPath}/createAccountPage"><button type="button">Create Account</button></a>
                    <a href="${pageContext.request.contextPath}/showUsers"><button type="button">Show Users</button></a>
                    
                </form>
            </div> 
        </header>
        
    </body>
    </body>
</html>