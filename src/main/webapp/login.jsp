<%-- 
    Document   : login
    Created on : 22-09-2017, 08:56:11
    Author     : lene_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login page</title>
    </head>
    <body>
        <h2>Please enter data:</h2>
        <form action="LoginServlet">
            user name <br>
            <input type="text" name="uname" id="uname"><br>
            password <br>
            <input type="password" name="password" id="password"><br>
            
            <input type="submit" value="Login">   
        </form>
    </body>
</html>
