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
            <input type="text" name="uname" ><br>
            <input type="text" name="password" ><br>
            
            <input type="submit" name="login" value="Login">   
        </form>
    </body>
</html>
