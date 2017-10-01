<%-- 
    Document   : loginOrRegister
    Created on : 01-10-2017, 08:12:42
    Author     : lene_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h3>Register:</h3>
            <form action="UserServlet">
                <input type="hidden" name="action" value="register">
                Navn: <input type="text" name="name"><br>
                Password: <input type="password" name="password"><br>
                Email: <input type="email" name="email"><br>
                Balance: <input type="text" name="balance"><br>
                <input type="submit" value="Register">
            </form>
        </div>
        <div>
            <h3>Login:</h3>
            <form action="UserServlet">
                <input type="hidden" name="action" value="login">
                user name <input type="text" name="name" id="uname"><br>
                password <input type="password" name="password" id="password"><br>
                <input type="submit" value="Login">   
            </form>
        </div>
    </body>
</html>
