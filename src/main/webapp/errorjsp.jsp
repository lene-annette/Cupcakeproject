<%-- 
    Document   : errrorjsp
    Created on : 29-09-2017, 13:05:19
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
            <div>an error ucurred please try again,  
                this is the jsp<br>
            <a href="index.html">home</a></div>
        <hr>
        <%=request.getAttribute("error")%>
        
    </body>
</html>
