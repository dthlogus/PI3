/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.G5.controller;


import br.com.G5.model.Conta;
import br.com.G5.negocio.ContaPoupancaDao;
import br.com.G5.negocio.PessoaDal;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Nicholas
 */
@WebServlet(name = "ControllerCp", urlPatterns = {"/ControllerCp"})
public class ControllerCp extends HttpServlet {
    
    private ContaPoupancaDao contapoupancadao;
    private PessoaDal pessoaDal;

    public ControllerCp() {
        contapoupancadao = new ContaPoupancaDao();
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
            out.println("<title>Servlet ControllerCp</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerCp at " + request.getContextPath() + "</h1>");
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
        Conta cp = new Conta();
        List<Conta> listaContaPoupanca= new ArrayList<>();
        boolean consultar = false;
        String acao;
        
        acao = request.getParameter("action");
        
         switch (acao) {
            case "inserir":
                 if (request.getParameter("id") == null || request.getParameter("id").isEmpty()) {
                    cp = pegarDadosParam(request);
                    contapoupancadao.adicionarConta(cp);
                }
                break;
            case "alterar":
                if (!(request.getParameter("id") == null || request.getParameter("id").isEmpty())) {
                    cp = pegarDadosParam(request);
                    contapoupancadao.alterarConta(cp);
                }
                break;
            case "excluir":
                if (!(request.getParameter("id") == null || request.getParameter("id").isEmpty())) {
                    cp.setIdConta(Integer.parseInt(request.getParameter("id")));
                    contapoupancadao.excluirConta(cp.getIdConta());
                }
                break;

            case "consultar":
                if (!(request.getParameter("id") == null || request.getParameter("id").isEmpty())) {
                    cp.setIdConta(Integer.parseInt(request.getParameter("id")));
                    listaContaPoupanca.add(contapoupancadao.consultarPorId(cp.getIdConta()));
                    consultar = true;
                }
                break;
                
        }
        
        if (consultar) {
            request.setAttribute("lista", listaContaPoupanca);
        } else {
            cp.setId_pessoa(Integer.parseInt(request.getSession().getAttribute("id_pessoa").toString()));
            request.setAttribute("lista", contapoupancadao.listagem(cp.getId_pessoa()));
        }


        RequestDispatcher rd = request.getRequestDispatcher("/cadastrocp.jsp");
        rd.forward(request, response);
        
        
    }
    
        private Conta pegarDadosParam(jakarta.servlet.http.HttpServletRequest request){
        Conta contacp = new Conta();
        if (!(request.getParameter("id") == null || request.getParameter("id").isEmpty())) {
            contacp.setIdConta(Integer.parseInt(request.getParameter("id")));
        }
        contacp.setNomeTitular(request.getParameter("nometitular"));
        contacp.setNomeBanco(request.getParameter("banco"));
        contacp.setNumeroConta(Integer.parseInt(request.getParameter("numerocp")));
        contacp.setLimiteConta(Double.parseDouble(request.getParameter("limitecp")));
        contacp.setId_pessoa(Integer.parseInt(request.getSession().getAttribute("id_pessoa").toString()));
        return contacp;
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
