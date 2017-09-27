<%-- 
    Document   : products
    Created on : 22-09-2017, 11:06:46
    Author     : lene_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List, entities.Bottom, cupcakeproject.RenderUtil" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product page</title>
    </head>
    <body>
        <h2>Bottoms:</h2>
        <% List<Bottom> bottoms = (List<Bottom>)session.getAttribute("bottomList");%>
        
        <table><thead><tr><th>Type</th><th>Price</th></tr></thead>
            <tbody>
                <% for(Bottom bottom : bottoms){ %>
                <tr><td><%=bottom.getType()%></td><td><%=bottom.getPrice()%></td></tr>
                <% } %>
                
            </tbody></table>
            
            
        
    </body>
</html>
