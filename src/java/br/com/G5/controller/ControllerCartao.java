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
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author luisg
 */
@WebServlet(name = "ControllerCartao", urlPatterns = {"/Cartao"})
public class ControllerCartao extends HttpServlet {
    
    private CartaoDal cartaodal;
    DateTimeFormatter formatoVencimento = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    DateTimeFormatter formatoFaturas = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ControllerCartao() {
       cartaodal = new CartaoDal();
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
            out.println("<title>Servlet Controller</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controller at " + request.getContextPath() + "</h1>");
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
       Cartao cartao = new Cartao();
       ArrayList<Cartao> cartoes = new ArrayList<>();
       boolean consultar = false;
       String acao = request.getParameter("action");
     
       
       switch(acao){
           case "inserir":
               if(request.getParameter("id_cartao")==null || request.getParameter("id_cartao").isEmpty()){
                   cartao = pegarDados(request);
                   cartaodal.IAdcionar(cartao);
               }
               break;
           case "alterar":
               if(!(request.getParameter("id_cartao")==null || request.getParameter("id_cartao").isEmpty())){
                   cartao = pegarDados(request);
                   cartaodal.IAlterarCartao(cartao);
               }
               break;
           case "excluir":
               if(!(request.getParameter("id_cartao")==null || request.getParameter("id_cartao").isEmpty())){
                   cartao.setId_cartao(Integer.parseInt(request.getParameter("id_cartao")));
                   cartaodal.IExcluirPorId(cartao.getId_cartao());
               }
               break;
           case "consultar":
               if(!(request.getParameter("id_cartao")==null || request.getParameter("id_cartao").isEmpty())){
                   cartao.setId_cartao(Integer.parseInt(request.getParameter("id_cartao")));
                   cartoes.add(cartaodal.consultarPorId(cartao.getId_cartao()));
                   consultar = true;
               }
               break;
               
       }
          if (consultar) {
            request.setAttribute("lista", cartoes);
        } else {
            cartao.setId_pessoa(Integer.parseInt(request.getSession().getAttribute("id_pessoa").toString()));
            request.setAttribute("lista", cartaodal.listagem(cartao.getId_pessoa()));
        }
      
       RequestDispatcher rd = request.getRequestDispatcher("/cartoes.jsp");
       rd.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    private Cartao pegarDados(HttpServletRequest request){
        Cartao cartao = new Cartao();
        String gambs;
        gambs =request.getParameter("validade_cartao");
        gambs ="01/"+ gambs;
        if (!(request.getParameter("id_cartao") == null || request.getParameter("id_cartao").isEmpty())) {
            cartao.setId_cartao(Integer.parseInt(request.getParameter("id_cartao")));
        }
        cartao.setNome_cartao(request.getParameter("nome_cartao"));
        cartao.setBandeira_cartao(request.getParameter("bandeira_cartao"));
        cartao.setNumero_cartao(request.getParameter("numero_cartao"));
        cartao.setValidade(LocalDate.parse(gambs,formatoVencimento));
        cartao.setLimite(Double.parseDouble(request.getParameter("limite")));
        cartao.setData_fechamento(LocalDate.parse(request.getParameter("data_fechamento"),formatoFaturas));
        cartao.setData_vencimento(LocalDate.parse(request.getParameter("data_vencimento"),formatoFaturas));
        cartao.setData_pagamento(LocalDate.parse(request.getParameter("data_pagamento"),formatoFaturas));
        cartao.setCcv(request.getParameter("ccv"));
        cartao.setId_pessoa(Integer.parseInt(request.getSession().getAttribute("id_pessoa").toString()));
        
        return cartao;
        
    }
 
}
