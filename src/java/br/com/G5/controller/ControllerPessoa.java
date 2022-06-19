package br.com.G5.controller;

import br.com.G5.model.Pessoa;
import br.com.G5.negocio.PessoaDal;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.jsp.PageContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "ControllerPessoa", urlPatterns = {"/Pessoa"})
public class ControllerPessoa extends HttpServlet {

    private PessoaDal pessoaDal;

    public ControllerPessoa() {
        pessoaDal = new PessoaDal();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Pessoa pessoa = new Pessoa();
        String acao;

        acao = request.getParameter("action");

        switch (acao) {
            case "cadastrar":
                pessoa = pegarDadosParamCadastro(request);
                try {
                    pessoaDal.IAdcionar(pessoa);
                    request.setAttribute("sucessoCadastro", true);
                } catch (SQLException e) {
                    request.setAttribute("erroCadastro", true);
                } finally {
                    RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                    rd.forward(request, response);
                }
                break;
            case "acessar":
                if (!(request.getParameter("cpf") == null || request.getParameter("cpf").isEmpty())) {
                    try {
                        pessoa = pegarDadosParamLogar(request);
                        pessoa = pessoaDal.consultarPorCpf(pessoa);
                        request.getSession().setAttribute("id_pessoa", pessoa.getId_pessoa());
                        RequestDispatcher rd = request.getRequestDispatcher("/dashboard.jsp");
                        rd.forward(request, response);
                    } catch (SQLException e) {
                        request.setAttribute("erroLogar", true);
                        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                        rd.forward(request, response);
                    }
                }
                break;
        }
    }

    private Pessoa pegarDadosParamLogar(HttpServletRequest request) {
        Pessoa pessoa = new Pessoa();
        pessoa.setCpf(request.getParameter("cpf"));
        pessoa.setSenha(request.getParameter("senha"));
        return pessoa;
    }
    
    private Pessoa pegarDadosParamCadastro(HttpServletRequest request){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome_completo(request.getParameter("nomeUsuario"));
        pessoa.setEmail(request.getParameter("email"));
        pessoa.setCpf(request.getParameter("cpf"));
        pessoa.setSenha(request.getParameter("senha"));
        return pessoa;
    }
}
