<%-- 
    Document   : index
    Created on : 11/04/2022, 21:13:37
    Author     : diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Despesas</title>
    </head>
    <body>
        <h1>Despesa</h1>
        <form method="POST" action="Despesa">
            <div>
                <label id="lbCodigo" name="lbCodigo">Codigo</label>
                <input type="number" id="id" name="id" value="<c:out value="${id}" />" />
                <label id="lbNome" name="lbNome">Nome</label>
                <input type="text" id="nome" name="nome" value="<c:out value="${nome}" />"/>
                <label id="lbDataAquisicao" name="lbDataAquisicao">Data da aquisição</label>
                <input placeholder="12/07/2017" type="text" id="data_aquisicao" name="data_aquisicao" pattern="^([0-2][0-9]|(3)[0-1])(\/)(((0)[0-9])|((1)[0-2]))(\/)\d{4}$" value="<c:out value="${despesa.data_aquisicao}" />"/>
                <label id="lbParcelaTotal" name="lbParcelaTotal">Total de parcelas</label>
                <input type="number" id="parcela_total" name="parcela_total" value="<c:out value="${parcela_total}" />"/>
                <label id="lbParcelaAtual" name="lbParcelaAtual">Parcela atual</label>
                <input type="number" id="parcela_atual" name="parcela_atual" value="<c:out value="${parcela_atual}" />"/>
                <label id="lbRepetitivo" name="lbRepetitivo">Repetitivo</label>
                <input type="radio" name="repetitivo" value="true" value="<c:out value="${repetitivo}" />"> Sim
                <input type="radio" name="repetitivo" value="false" checked value="<c:out value="${repetitivo}" />"> Não
                <label id="lbValorDespesa" name="lbValorDespesa">Valor despesa</label>
                <span>R$</span><input type="number" id="valor_despesa" name="valor_despesa" value="<c:out value="${valor_despesa}" />"/>
                <label id="lbCategoria" name="lbCategoria">Categoria</label>
                <select name="categoria" value="<c:out value="${categoria}" />">
                    <option value="agua">Água</option>
                    <option value="luz">Luz</option>
                    <option value="alimentacao">Alimentação</option>
                    <option value="transporte">Transporte</option>
                    <option value="estudo">Estudo</option>
                    <option value="lazer">Lazer</option>
                    <option value="outros">Outros</option>
                </select>
                <label id="lbDescricao" name="lbDescricao">Descricao</label>
                <textarea name="descricao" rows="4" cols="50" maxlength="250" value="<c:out value="${descricao}" />"></textarea>
                <input type="number" name="id_pessoa" value="1" readonly hidden/>
                <button name="action" value="inserir">Inserir</button>
                <button name="action" value="alterar">Alterar</button>
                <button name="action" value="excluir">Remover</button>
                <button name="action" value="consultar">Consultar</button>
                <button name="action" value="listar">Listar todos</button>
            </div>
            <div>
                <table border="1">
                    <tr>
                        <th>Id</th>
                        <th>Nome</th>
                        <th>Data da aquisição</th>
                        <th>parcelas</th>
                        <th>repetitivo</th>
                        <th>valor da despesa</th>
                        <th>Categoria</th>
                        <th>Descricao</th>
                    </tr>
                    <c:forEach items="${lista}" var="despesa">
                        <tr>
                            <td><c:out value="${despesa.id}"/></td>
                            <td><c:out value="${despesa.nome}"/></td>
                            <td><c:out value="${despesa.data_aquisicao}"/></td>
                            <td><c:out value="${despesa.parcela_atual}"/> / <c:out value="${despesa.parcela_total}"/></td>
                            <c:if test="${despesa.repetitivo}">
                            <td>Habilitado</td>
                            </c:if>
                            <c:if test="${!despesa.repetitivo}">
                            <td>Não Habilitado</td>
                            </c:if>
                            <td><c:out value="${despesa.valor_despesa}"/></td>
                            <td><c:out value="${despesa.categoria}"/></td>
                            <td><c:out value="${despesa.descricao}"/></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </form>
    </body>
</html>
