<%-- 
    Document   : registration
    Created on : 22-09-2017, 08:44:57
    Author     : lene_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
    </head>
    <body>
        <form name="registerForm" method="post" action="UserServlet">
            Navn: <input type="text" name="name"><br>
            Password: <input type="password" name="password"><br>
            Email: <input type="text" name="email"><br>
            Balance: <input type="text" name="balance"><br>
            <input type="submit" name="register" value="register">
            
        </form>
        
        <%--
        <h2>Please enter data:</h2>
        <form action="RegisterServlet">
            <input type="text" name="uname" value="username"><br>
            <input type="text" name="psw" value="password"><br>
            <input type="text" name="email" value="email"><br>
            account balance <br>
            <input type="text" name="balance" value="0"><br>
            <input type="submit" name="register" value="Register">   
        </form>
        --%>
    </body>
</html>
