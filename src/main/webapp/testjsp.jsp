<%-- 
    Document   : testjsp
    Created on : 02-10-2017, 12:42:10
    Author     : lene_
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cupcakeproject.ShoppingCart"%>
<%@page import="entities.LineItem"%>
<%@page import="entities.Top"%>
<%@page import="entities.Bottom"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>testside</title>
    </head>
    <body>
        <div>
            <table>
                <tr>
                    <th>Bottom</th>
                    <th>Topping</th> 
                    <th>Quantity</th>
                    <th>Total price</th>
                </tr>
                <% ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("cart");%>
                <% List<LineItem> lineItem = shoppingCart.getListOfItems();%>

                <%for (LineItem item : lineItem) {%>
                <tr><td>
                        <% String bottom = item.getBot().getType(); %>
                        <%=bottom%>
                    </td><td>
                        <% String top = item.getTop().getType(); %> 
                        <%=top%>
                    </td><td>
                        <% int quantity = item.getQuantity(); %>
                        <%=quantity%>
                    </td><td>
                        <% int totalPrice = item.getTotalPrice();%>      
                        <%=totalPrice%>
                    </td></tr>
                    <% }%>
            </table>
            <a href="ShowProductsServlet">tilbage</a>
        </div>
            
    </body>
</html>
