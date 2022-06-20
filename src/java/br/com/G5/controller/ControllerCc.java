/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.G5.controller;

import br.com.G5.model.Conta;
import br.com.G5.negocio.ContaCorrenteDao;
import br.com.G5.negocio.PessoaDal;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nicholas
 */
@WebServlet(name = "ControllerCc", urlPatterns = {"/ControllerCc"})
public class ControllerCc extends HttpServlet {

    private ContaCorrenteDao contacorrentedao;
    private PessoaDal pessoaDal;

    public ControllerCc() {
        contacorrentedao = new ContaCorrenteDao();
        pessoaDal = new PessoaDal();
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
            out.println("<title>Servlet ControllerCc</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerCc at " + request.getContextPath() + "</h1>");
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

        Conta cc = new Conta();
        List<Conta> listaContaCorrente = new ArrayList<>();
        boolean consultar = false;
        String acao;
        
         acao = request.getParameter("action");

        switch (acao) {
            case "inserir":
                 if (request.getParameter("id") == null || request.getParameter("id").isEmpty()) {
                    cc = pegarDadosParam(request);
                    contacorrentedao.adicionarConta(cc);
                }
                break;
            case "alterar":
                if (!(request.getParameter("id") == null || request.getParameter("id").isEmpty())) {
                    cc = pegarDadosParam(request);
                    contacorrentedao.alterarConta(cc);
                }
                break;
            case "excluir":
                if (!(request.getParameter("id") == null || request.getParameter("id").isEmpty())) {
                    cc.setIdConta(Integer.parseInt(request.getParameter("id")));
                    contacorrentedao.excluirConta(cc.getIdConta());
                }
                break;

            case "consultar":
                if (!(request.getParameter("id") == null || request.getParameter("id").isEmpty())) {
                    cc.setIdConta(Integer.parseInt(request.getParameter("id")));
                    listaContaCorrente.add(contacorrentedao.consultarPorId(cc.getIdConta()));
                    consultar = true;
                }
                break;
                
        }
        
        if (consultar) {
            request.setAttribute("lista", listaContaCorrente);
        } else {
            cc.setId_pessoa(Integer.parseInt(request.getSession().getAttribute("id_pessoa").toString()));
            request.setAttribute("lista", contacorrentedao.listagem(cc.getId_pessoa()));
        }


        RequestDispatcher rd = request.getRequestDispatcher("/cadastrocc.jsp");
        rd.forward(request, response);
    }
    
    
    private Conta pegarDadosParam(HttpServletRequest request){
        Conta contacc = new Conta();
        if (!(request.getParameter("id") == null || request.getParameter("id").isEmpty())) {
            contacc.setIdConta(Integer.parseInt(request.getParameter("id")));
        }
        contacc.setNomeTitular(request.getParameter("nometitular"));
        contacc.setNomeBanco(request.getParameter("banco"));
        contacc.setNumeroConta(Integer.parseInt(request.getParameter("numerocc")));
        contacc.setLimiteConta(Double.parseDouble(request.getParameter("limitecc")));
        contacc.setId_pessoa(Integer.parseInt(request.getSession().getAttribute("id_pessoa").toString()));
        return contacc;
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
