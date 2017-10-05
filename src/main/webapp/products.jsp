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
        <meta charset="utf-8">

        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Product page</title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

        <!-- Custom styles for this template -->
        <link href="css/business-casual.css" rel="stylesheet">
    </head>
    <body>
        <div class="tagline-upper text-center text-heading text-shadow text-white mt-5 d-none d-lg-block">Cupcake Project</div>
        <div class="tagline-lower text-center text-expanded text-shadow text-uppercase text-white mb-5 d-none d-lg-block">Nørgaardsvej 30 | Lyngby, 2800</div>
        <div class="container">
            <% User user1 = (User) session.getAttribute("activeUser");%>
            <h4 class="text-shadow text-white text-center">User:</h4> <h5 class="text-shadow text-white text-center"><%=user1.getName()%></h5>
            <h4 class="text-shadow text-white text-center">Balance:</h4> <h5 class="text-shadow text-white text-center"><%=user1.getBalance()%></h5>

            <div class="bg-faded p-4 my-4">
                <div class="card card-inverse">
                    <img class="card-img img-fluid w-100" src="img/slide-1.jpg" alt="">
                    <div class="card-img-overlay bg-overlay">
                        <h2 class="card-title text-shadow text-white text-uppercase mb-0">Choose bottom and topping</h2>
                        <br>
                        <form action="CartServlet">
                            <% List<Bottom> bottoms = (List<Bottom>) session.getAttribute("bottomList");%>
                            <h4 class="text-shadow text-white">Bottoms:</h4>
                            <select name="bChooser">
                                <%for (Bottom bottom : bottoms) {%>
                                <% String type = bottom.getType();%>
                                <% int price = bottom.getPrice();%>
                                <option><%out.print(type + " " + price);%></option>
                                <% } %>
                            </select><br>
                            <br>

                            <% List<Top> tops = (List<Top>) session.getAttribute("topList");%>
                            <h4 class="text-shadow text-white">Toppings:</h4>
                            <select name="tChooser">
                                <%for (Top top : tops) {%>
                                <% String type = top.getType();%>
                                <% int price = top.getPrice();%>
                                <option><%out.print(type + " " + price);%></option>
                                <% }%>
                            </select><br><br>

                            <h4 class="text-shadow text-white">Quantity:</h4>
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
                            <input class="btn btn-secondary" type="submit" value="Add to cart">
                        </form>
                        <% ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("cart");%>
                        <% List<LineItem> lineItem = shoppingCart.getListOfItems();%>
                        <%if (!lineItem.isEmpty()) {%>
                        <table>
                            <tr>
                                <th><h4 class="text-shadow text-white">Bottom</h4></th>
                                <th><h4 class="text-shadow text-white">Topping</h4></th> 
                                <th><h4 class="text-shadow text-white">Quantity</h4></th>
                                <th><h4 class="text-shadow text-white">Total price</h4></th>
                            </tr>
                            <br>
                            <%for (LineItem item : lineItem) {%>
                            <tr><td>
                                    <% String bottom = item.getBot().getType();%>
                                    <h6 class="text-shadow text-white"><%=bottom%></h6>
                                </td><td>
                                    <% String top = item.getTop().getType();%> 
                                    <h6 class="text-shadow text-white"><%=top%></h6>
                                </td><td>
                                    <% int quantity = item.getQuantity();%>
                                    <h6 class="text-shadow text-white"><%=quantity%></h6>
                                </td><td>
                                    <% int totalPrice = item.getTotalPrice();%>      
                                    <h6 class="text-shadow text-white"><%=totalPrice%></h6>
                                </td></tr>
                                <% } %>
                            <tr>
                                <td><h5 class="text-shadow text-white">Total price:</h5></td>
                                <td> </td>
                                <td> </td>
                                <td>
                                    <% int cartTotal = 0;%>
                                    <% for (LineItem item1 : lineItem) {%>
                                    <%cartTotal += item1.getTotalPrice();%>
                                    <% }%>
                                    <h5 class="text-shadow text-white"><%=cartTotal%></h5>
                                </td>

                            </tr>
                        </table>
                        <br>
                        <form action="confirmation.jsp">
                            <input class="btn btn-secondary" type="submit" value="Order Cupcakes">
                        </form>
                    </div>
                </div>
            </div>
            <% }%>
        </div>
    </body>
</html>
