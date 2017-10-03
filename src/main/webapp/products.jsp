<%-- 
    Document   : products
    Created on : 22-09-2017, 11:06:46
    Author     : lene_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List, entities.Bottom, entities.Top, entities.User, entities.LineItem, cupcakeproject.ShoppingCart" %>
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
            <form action="CartServlet">
                <br>Bottoms:<br>
                <select name="bChooser">
                    <%for (Bottom bottom : bottoms) {%>
                    <% String type = bottom.getType();%>
                    <% int price = bottom.getPrice();%>
                    <option><%out.print(type + " " + price);%></option>
                    <% } %>
                </select><br>
                <br>

                <% List<Top> tops = (List<Top>) session.getAttribute("topList");%>
                Toppings:<br>
                <select name="tChooser">
                    <%for (Top top : tops) {%>
                    <% String type = top.getType();%>
                    <% int price = top.getPrice();%>
                    <option><%out.print(type + " " + price);%></option>
                    <% }%>
                </select><br><br>

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
                </select><br>
                <br>
                <input type="submit" value="Add to cart">
            </form>
        </div>


        <div>
            <% ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("cart");%>
            <% List<LineItem> lineItem = shoppingCart.getListOfItems();%>
            <%if (!lineItem.isEmpty()) {%>
            <table>
                <tr>
                    <th>Bottom</th>
                    <th>Topping</th> 
                    <th>Quantity</th>
                    <th>Total price</th>
                </tr>

                <%for (LineItem item : lineItem) {%>
                <tr><td>
                        <% String bottom = item.getBot().getType();%>
                        <%=bottom%>
                    </td><td>
                        <% String top = item.getTop().getType();%> 
                        <%=top%>
                    </td><td>
                        <% int quantity = item.getQuantity();%>
                        <%=quantity%>
                    </td><td>
                        <% int totalPrice = item.getTotalPrice();%>      
                        <%=totalPrice%>
                    </td></tr>
                    <% } %>
                <tr>
                    <td>Shoppingcart total:</td>
                    <td> </td>
                    <td> </td>
                    <td>
                        <% int cartTotal = 0;%>
                        <% for (LineItem item1 : lineItem) {%>
                            <%cartTotal += item1.getTotalPrice();%>
                        <% } %>
                        <%=cartTotal%>
                    </td>
                    
                </tr>
            </table>
            <% } %>
        </div>
        <div>
            <form action="#">
                <input type="submit" value="Check out">
            </form>
        </div>


    </body>
</html>
