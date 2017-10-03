/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import cupcakeproject.ShoppingCart;
import entities.Bottom;
import entities.LineItem;
import entities.Top;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PC
 */
@WebServlet(name = "CartServlet", urlPatterns = {"/CartServlet"})
public class CartServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {

            HttpSession session = request.getSession();
            ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("cart");

            String bottom = request.getParameter("bChooser");
            String topping = request.getParameter("tChooser");
            String squantity = request.getParameter("quantity");
            int quantity = Integer.parseInt(squantity);
            int bprice = 0;
            int tprice = 0;
            String[] bottomCake = bottom.split(" ");
            bprice = Integer.parseInt(bottomCake[bottomCake.length-1]);
            
            String bStr = "";
            for(int i = 0; i < bottomCake.length-1; i++){
                bStr += bottomCake[i] + " ";
            }
                    
            Bottom bot = new Bottom(bStr,bprice);
            
            String[] topCake = topping.split(" ");
            tprice = Integer.parseInt(topCake[topCake.length-1]);
            
            String tStr = "";
            for(int i = 0; i < topCake.length-1; i++){
                tStr += topCake[i] + " ";
            }
            
            Top top = new Top(tStr,tprice);
            
            LineItem lineItem = new LineItem(bot, top, quantity);
            shoppingCart.addItem(lineItem);
            

            String nextURL = "ShowProductsServlet";
            request.getRequestDispatcher(nextURL).forward(request, response);

        } catch (Exception e) {
            response.sendRedirect("errorjsp.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
