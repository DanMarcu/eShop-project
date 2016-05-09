<%-- 
    Document   : createAccountPage
    Created on : Apr 26, 2016, 1:06:52 PM
    Author     : Dan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/global.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Account</title>
    </head>
    <body>
        
            <div id = "createAccount">
                <form action="CreateUserServlet" method="POST" name="createForm">
                    <input type="text" name="username" placeholder="Username" required><br>
                    <input type="password" name="password" placeholder="Password" required><br>
                    <input type="password" name="passConfirm" placeholder="Confirm password" required><br>
                    <input type="text" name="email" placeholder="you@example.com" required><br>
                    <input type="text" name="firstName" placeholder="First Name" required><br>
                    <input type="text" name="lastName" placeholder="Last Name" required><br>
                    <input type="text" name="city" placeholder="City">
                    
                    <button type="submit">Create Account</button>
                </form>
            </div>
            
    </body>
</html>
