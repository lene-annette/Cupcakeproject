/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import cupcakeproject.LogicFacade;
import cupcakeproject.ShoppingCart;
import entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lene_
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {

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
        try {
            response.setContentType("text/html;charset=UTF-8");

            String action = request.getParameter("action");
            
            HttpSession session = request.getSession();
            ShoppingCart sc = new ShoppingCart();
            session.setAttribute("cart", sc);

            if (action.equals("login")) {
                String name = request.getParameter("name");
                String password = request.getParameter("password");

                User user = LogicFacade.login(name, password);

                if (user.getName() != null) {
                    session.setAttribute("activeUser", user);
                    String nextURL = "ShowProductsServlet";
                    request.getRequestDispatcher(nextURL).forward(request, response);
                } else {
                    request.getRequestDispatcher("loginError.html").forward(request, response);
                }
            } else if (action.equals("register")) {
                String name = request.getParameter("name");
                String psw = request.getParameter("password");
                String email = request.getParameter("email");
                String sbalance = request.getParameter("balance");
                int balance = Integer.parseInt(sbalance);
                User user = LogicFacade.createUser(name, psw, balance, email);

                session.setAttribute("activeUser", user);
                String nextURL = "ShowProductsServlet";
                request.getRequestDispatcher(nextURL).forward(request, response);
            }

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
