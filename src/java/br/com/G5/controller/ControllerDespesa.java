/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.G5.controller;

import br.com.G5.model.Despesa;
import br.com.G5.model.Enum.CategoriaDespesaEnum;
import br.com.G5.negocio.DespesaDal;
import br.com.G5.negocio.PessoaDal;
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

/**
 *
 * @author mathe
 */
@WebServlet(name = "ControllerDespesa", urlPatterns = {"/Despesa"})
public class ControllerDespesa extends HttpServlet {

    private DespesaDal despesaDal;
    private PessoaDal pessoaDal;
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ControllerDespesa() {
        despesaDal = new DespesaDal();
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
        Despesa despesa = new Despesa();
        List<Despesa> despesas = new ArrayList<>();
        boolean consultar = false;
        String acao;

        if (!(request.getParameter("name") == null || request.getParameter("name").isEmpty())) {

            if (request.getParameter("id") == null || request.getParameter("id").isEmpty()) {
            } else {
                despesa.setId(Integer.parseInt(request.getParameter("codigo")));
            }
            despesa.setNome(request.getParameter("nome"));
            if (request.getParameter("data_aquisicao") == null || request.getParameter("data_aquisicao").isEmpty()) {
            } else {
                despesa.setData_aquisicao(LocalDate.parse(request.getParameter("data_aquisicao"), format));
            }
            if ((request.getParameter("parcela_total") == null || request.getParameter("parcela_atual") == null) || (request.getParameter("parcela_total").isEmpty() || request.getParameter("parcela_atual").isEmpty())) {
                despesa.setParcela_total(0);
                despesa.setParcela_atual(0);
            } else {
                despesa.setParcela_total(Integer.parseInt(request.getParameter("parcela_total")));
                despesa.setParcela_atual(Integer.parseInt(request.getParameter("parcela_atual")));
            }
            despesa.setRepetitivo(Boolean.parseBoolean(request.getParameter("repetitivo")));
            despesa.setValor_despesa(Double.parseDouble(request.getParameter("valor_despesa")));
            despesa.setCategoria(CategoriaDespesaEnum.valueOf(request.getParameter("categoria").toUpperCase()));
            despesa.setDescricao(request.getParameter("descricao"));
        }
        despesa.setId_pessoa(Integer.parseInt(request.getParameter("id_pessoa")));

        acao = request.getParameter("action");

        switch (acao) {
            case "inserir":
                despesaDal.IAdicionar(despesa);
                break;
            case "alterar":
                despesaDal.IAlternarDespesa(despesa);
                break;
            case "excluir":
                despesaDal.IExcluirPorId(despesa.getId());
                break;
            case "consultar":
                despesas.add(despesaDal.consultaPorId(despesa.getId()));
                consultar = true;
                break;
            case "listar":
                despesas = despesaDal.listagem(despesa.getId_pessoa());
                consultar = true;
                break;
        }

        if (consultar) {
            request.setAttribute("lista", despesas);
        } else {
            request.setAttribute("lista", despesaDal.listagem(despesa.getId_pessoa()));
        }

        RequestDispatcher rd = request.getRequestDispatcher("/despesa.jsp");
        rd.forward(request, response);
    }

}
