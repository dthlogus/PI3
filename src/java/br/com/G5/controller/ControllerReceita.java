package br.com.G5.controller;

import br.com.G5.model.Enum.CategoriaReceitaEnum;
import br.com.G5.model.Receita;
import br.com.G5.negocio.PessoaDal;
import br.com.G5.negocio.ReceitaDal;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ControllerReceita", urlPatterns = {"/Receita"})
public class ControllerReceita extends HttpServlet {

    private ReceitaDal receitaDal;
    private PessoaDal pessoaDal;
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ControllerReceita() {
        receitaDal = new ReceitaDal();
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
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Receita receita = new Receita();
        List<Receita> receitas = new ArrayList<>();
        boolean consultar = false;
        String acao;
        
        acao = request.getParameter("action");

        switch (acao) {
            case "inserir":
                if (request.getParameter("id") == null || request.getParameter("id").isEmpty()) {
                    receita = pegarDadosParam(request);
                    receitaDal.IAdicionar(receita);
                }
                break;
            case "alterar":
                if (!(request.getParameter("id") == null || request.getParameter("id").isEmpty())) {
                    receita = pegarDadosParam(request);
                    receitaDal.IAlternarReceita(receita);
                }
                break;
            case "excluir":
                if (!(request.getParameter("id") == null || request.getParameter("id").isEmpty())) {
                    receita.setId(Integer.parseInt(request.getParameter("id")));
                    receitaDal.IExcluirPorId(receita.getId());
                }
                break;
            case "consultar":
                if (!(request.getParameter("id") == null || request.getParameter("id").isEmpty())) {
                    receita.setId(Integer.parseInt(request.getParameter("id")));
                    receitas.add(receitaDal.consultaPorId(receita.getId()));
                    consultar = true;
                }
                break;
        }

        if (consultar) {
            request.setAttribute("lista", receitas);
        } else {
            receita.setId_pessoa(Integer.parseInt(request.getSession().getAttribute("id_pessoa").toString()));
            request.setAttribute("lista", receitaDal.listagem(receita.getId_pessoa()));
        }

        RequestDispatcher rd = request.getRequestDispatcher("/receita.jsp");
        rd.forward(request, response);
    }

    private Receita pegarDadosParam(HttpServletRequest request) {
        Receita receita = new Receita();
        if (!(request.getParameter("id") == null || request.getParameter("id").isEmpty())) {
            receita.setId(Integer.parseInt(request.getParameter("id")));
        }
        if (!(request.getParameter("data_aquisicao") == null || request.getParameter("data_aquisicao").isEmpty())) {
            receita.setData_aquisicao(LocalDate.parse(request.getParameter("data_aquisicao"), format));
        }
        if (!(request.getParameter("data_disponivel") == null || request.getParameter("data_disponivel").isEmpty())) {
            receita.setData_disponivel(LocalDate.parse(request.getParameter("data_disponivel"), format));
        }
        receita.setNome_receita(request.getParameter("nome"));
        receita.setDescricao(request.getParameter("descricao"));
        receita.setValor_receita(Double.parseDouble(request.getParameter("valor")));
        receita.setCategoria(CategoriaReceitaEnum.valueOf(request.getParameter("categoria").toUpperCase()));
        receita.setId_pessoa(Integer.parseInt(request.getSession().getAttribute("id_pessoa").toString()));
        return receita;
    }

}
