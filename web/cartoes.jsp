<%-- 
    Document   : cartoes
    Created on : 19/06/2022, 10:32:15
    Author     : Nicholas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="estilos/css/estilos.css" rel="stylesheet" />
        <title>Cartões | C'Wallet</title>
    </head>
    <body>

        <header class="header">
            <h2>C'wallet Web</h2>

            <nav class="menu">
                <a href="index.jsp">Inicio</a>
                <a href="cadastrocc.jsp">Conta Corrente</a>
                <a href="despesa.jsp">Despesas</a>
                <a href="cartoes.jsp">Cartões</a>
            </nav>

        </header>
        <main class="cartao">

            <div class="cadastroCartao">
                <form method="POST" action='ControllerCartao' name="frmDadosCartao" class="formCartao">
                    <h1>Cadastrar Cartão</h1>
                    <table class="tabelaCadastroCartao">
                        <tbody>
                            <tr>
                                <td>Id:</td>
                                <td><input type="text" readonly="readonly" name="id" value="<c:out value="${cartao.id}"/>"/> </td>
                            </tr>

                            <tr>
                                <td>Nome no cartão: </td>
                                <td> <input type="text" name="nome" value="<c:out value="${cartao.titular}" />" /> </td>
                            </tr>
                            <tr>
                                <td>Bandeira cartão: </td>
                                <td> <input type="text" name="bandeira" value="<c:out value="${cartao.bandeira_Cartao}"/>"/></td>
                            </tr>
                            <tr>
                                <td>Número cartão: </td>
                                <td><input type="text" name="numero" value="<c:out value="${cartao.numeroDoCartao}"/>"/></td>
                            </tr>
                            <tr>
                                <td>Validade cartão: </td>
                                <td><input type="text" name="validade" value="<fmt:formatDate pattern="MM/YYYY" value="${cartao.validade}"/>"/></td>
                            </tr>
                            <tr>
                                <td>CCV: </td>
                                <td><input type="text" name="ccv" value="<c:out value="${cartao.ccv}"/>"/></td>
                            </tr>
                            <tr>
                                <td>Limite: </td>
                                <td><input type="text" name="limite" value="<c:out value="${cartao.limite}"/>"></td>
                            </tr>
                            <tr>
                                <td>Data de vencimento: </td>
                                <td><input type="text" name="data_vencimento" value="<fmt:formatDate pattern="MM/dd/yyyy" value="${cartao.data_vencimento}"/>"/></td>
                            </tr>
                            <tr>
                                <td>Data de pagamento: </td>
                                <td><input type="text" name="data_pagamento" value="<fmt:formatDate pattern="MM/dd/yyyy" value="${cartao.data_pagamento}"/>"/></td> 
                            </tr>
                            <tr>
                                <td>Data de fechamento: </td>
                                <td><input type="text" name="data_fechamento" value="<fmt:formatDate pattern="MM/dd/yyyy" value="${cartao.data_fechamento}"/>"/></td>
                            </tr>
                        </tbody>

                    </table>
                    <br>
                    <input type = "submit" value="Gravar" class="botao">
                    <input type = "submit" value="Excluir" class="botao">
                    <input type = "submit" value="Alterar" class="botao">
                    <input type = "submit" value="Consultar" class="botao">
                </form>
            </div>

            <div class="tabelaCartao">
                <form method="GET" action='ControllerCartao' name="frmTabelaCartao" class="formTabelaCartoes">
                    <table border=1 class="tabelaDeCartoes">
                        <thead>
                        <br>
                        <tr>

                            <th>ID</th>
                            <th>Nome no Cartão</th>
                            <th>Bandeira do Cartão</th>
                            <th>Número Cartão</th>
                            <th>Validade Cartão</th>
                            <th>CCV</th>
                            <th>Limite do Cartão</th>
                            <th>Data de Fechamento</th>
                            <th>Data de Vencimento</th>
                            <th>Data de Pagamento</th>
                            <th colspan=2>Ação</th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${cartoes}" var="cartao">
                                <tr>

                                    <td><c:out value="${cartao.titular}"/></td>
                                    <td><c:out value="${cartao.bandeira_Cartao}"/></td>
                                    <td><c:out value="${cartao.numeroDoCartao}"/></td>
                                    <td><c:out value="${cartao.validade}"/></td>
                                    <td><c:out value="${cartao.ccv}"/></td>
                                    <td><c:out value="${cartao.limite}"/></td>
                                    <td><c:out value="${cartao.data_vencimento}"/></td>
                                    <td><c:out value="${cartao.data_pagamento}"/></td>
                                    <td><c:out value="${cartao.data_fechamento}"/></td>
                                    <td><a href="ControllerCartao?action=alterar&ccv=<c:out value="${cartao.ccv}"/>">Remover</a></td>
                                    <td><a href="ControllerCartao?action=remover&ccv=<c:out value="${cartao.ccv}"/>">Alterar</a></td>

                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </form>
            </div>
        </main>


        <footer class="footer">
            <ul>
                <li>
                    <p>SENAI FATESG</p>
                </li>
                <li>
                    <p>Analise e Desenvolvimento de Sistemas</p>
                </li>
                <li>
                    <p>3º Período</p>
                </li>
                <li>
                    <p>Grupo 5</p>
                </li>
            </ul>

    </body>
</html>
