<%-- 
    Document   : products
    Created on : 22-09-2017, 11:06:46
    Author     : lene_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List, entities.Bottom, entities.Top, entities.User" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product page</title>
    </head>
    <body>
        <div>
            <% User user1 = (User) session.getAttribute("activeUser");%>
            User: <%=user1.getName()%>
            Balance: <%=user1.getBalance()%>
        </div>
        <div>
            <% List<Bottom> bottoms = (List<Bottom>) session.getAttribute("bottomList");%>
            <form>
                Bottoms:<br>
                <select name="bChooser">
                    <%for (Bottom bottom : bottoms) {%>
                    <% String type = bottom.getType();%>
                    <% int price = bottom.getPrice();%>
                    <option><%out.print(type + "\t" + price);%></option>
                    <% } %>
                </select><br>
                <br>

                <% List<Top> tops = (List<Top>) session.getAttribute("topList");%>
                Toppings:<br>
                <select name="tChooser">
                    <%for (Top top : tops) {%>
                    <% String type = top.getType();%>
                    <% int price = top.getPrice();%>
                    <option><%out.print(type + "\t" + price);%></option>
                    <% }%>
                </select><br>

                Quantity: <br>
                <select name="quantity">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                    <option value="9">9</option>
                    <option value="10">10</option>
                </select>
                <br>
                <input type="submit" value="Add to cart">
            </form>
        </div>

    </body>
</html>
