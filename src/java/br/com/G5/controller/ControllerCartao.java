/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.G5.controller;

import br.com.G5.model.Cartao;
import br.com.G5.negocio.CartaoDal;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author luisg
 */
@WebServlet(name = "ControllerCartao", urlPatterns = {"/ControllerCartao"})
public class ControllerCartao extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String FORMULARIO = "./index.jsp";
    private CartaoDal dal;
    DateTimeFormatter formatoVencimento = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    DateTimeFormatter formatoFaturas = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    public ControllerCartao() {
        super();
        dal = new CartaoDal();
    }

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerCartao</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerCartao at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String action = request.getParameter("action");
        
        if(action.equalsIgnoreCase("remover")){
            int id = Integer.parseInt(request.getParameter("ccv"));
            dal.IExcluirPorId(id);
            
        }
        if(action.equalsIgnoreCase("alterar")){
            int id = Integer.parseInt(request.getParameter("ccv"));
            Cartao cartao = dal.consultarPorId(id);
            request.setAttribute("cartao", cartao);
        }
        
        RequestDispatcher view = request.getRequestDispatcher(FORMULARIO);
        request.setAttribute("cartoes", dal.listagem());
        view.forward(request, response);
        
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
        Cartao cartao = new Cartao();
        cartao.setTitular(request.getParameter("nome"));
        cartao.setBandeira_Cartao(request.getParameter("bandeira"));
        cartao.setNumeroDoCartao(request.getParameter("numero"));
        cartao.setValidade(LocalDate.parse(request.getParameter("validade"), formatoVencimento));
        cartao.setCcv(request.getParameter("ccv"));
        cartao.setData_vencimento(LocalDate.parse(request.getParameter("data_vencimento"), formatoFaturas));
        cartao.setData_pagamento(LocalDate.parse(request.getParameter("data_pagamento"), formatoFaturas));
        cartao.setData_fechamento(LocalDate.parse(request.getParameter("data_fechamento"), formatoFaturas));
        
        String id = request.getParameter("id");
        
        if(id == null || id.isEmpty()){
            dal.IAdcionar(cartao);
        }
        else{
            cartao.setId_cartao(Integer.parseInt(id));
            dal.IAlterarCartao(cartao);
        }
        RequestDispatcher view = request.getRequestDispatcher(FORMULARIO);
        request.setAttribute("cartoes", dal.listagem());
        view.forward(request, response);
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
