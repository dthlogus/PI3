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
        
        <script src="estilos/javascripturo/script.js"></script>
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
            <div class="cartao_container_titulo">
                <h1 class="cartao_titulo">Cartões</h1>
            </div>
            <form method="POST" action="Cartao" class="formCartao">
                <div class="ct">
                  <ul>  
                    <li>
                        <label id="lbIdCartao" name="lbIdCartao">ID</label>
                        <input type="number" id="id_cartao" name="id_cartao"/>
                    </li>
                    <li>
                        <label id="lbNomeCartao" name="lbNomeCartao">Titular</label>
                        <input type="text" id="nome_cartao" name="nome_cartao"/>
                    </li>
                    <li>
                        <label id="lbBandeiraCartao" name="lbBandeiraCartao">Bandeira</label>
                        <input type="text" id="bandeira_cartao" name="bandeira_cartao"/>
                    </li>
                    <li>
                        <label id="lbNumeroCartao" name="lbNumeroCartao">Número</label>
                        <input type="text" id="numero_cartao" name="numero_cartao"/>
                    </li>
                    <li>
                        <label id="lbValidadeCartao" name="lbValidadeCartao">Validade</label>
                        <input placeholder="05/2023" type="text" id="validade_cartao" name="validade_cartao" pattern="(0[1-9]|10|11|12)/20[0-9]{2}$"/>
                    </li>
                    <li>
                        <label id="lbLimiteCartao" name="lbLimiteCartao">Limite</label>
                        <input type="number" id="limite_Cartao" name="limite"/>
                    </li>
                    <li>
                        <label id="lbDataFechamento" name="lbDataFechamento">Data de fechamento</label>
                        <input placeholder="12/07/2017" type="text" id="data_fechamento" name="data_fechamento" pattern="^([0-2][0-9]|(3)[0-1])(\/)(((0)[0-9])|((1)[0-2]))(\/)\d{4}$"/>
                    </li>
                     <li>
                        <label id="lbDataVencimento" name="lbDataVencimento">Data de vencimento</label>
                        <input placeholder="12/07/2017" type="text" id="data_vencimento" name="data_vencimento" pattern="^([0-2][0-9]|(3)[0-1])(\/)(((0)[0-9])|((1)[0-2]))(\/)\d{4}$"/>
                    </li>
                    <li>
                        <label id="lbDataPagamento" name="lbDataPagamento">Data de pagamento</label>
                        <input placeholder="12/07/2017" type="text" id="data_pagamento" name="data_pagamento" pattern="^([0-2][0-9]|(3)[0-1])(\/)(((0)[0-9])|((1)[0-2]))(\/)\d{4}$"/>
                    </li>
                    <li>
                        <label id="lbCCV" name="lbCCV">CCV</label>
                        <input type="text" id="ccv" name="ccv"/>
                    </li>
                    <li style="display: inline-flex;">
                            <button name="action" value="inserir">Inserir</button>
                            <button name="action" value="alterar">Alterar</button>
                            <button name="action" value="excluir">Remover</button>
                            <button name="action" value="consultar">Consultar</button>
                            <button name="action" value="listar">Listar todos</button>

                    </li>
                  </ul> 
                </div>
            </form>
            <div class="tabela">
                <table border="1">
                   <tr> 
                        <th>ID</th>
                        <th>Titular</th>
                        <th>Bandeira</th>
                        <th>Número</th>
                        <th>Validade</th>
                        <th>Limite</th>
                        <th>Data de fechamento</th>
                        <th>Data de vencimento</th>
                        <th>Data de pagamento</th>
                        <th>CCV</th>
                   </tr>
                   <c:forEach items="${lista}" var="cartao">
                       <tr>
                           <td><c:out value="${cartao.id_cartao}"/></td>
                           <td><c:out value="${cartao.nome_cartao}"/></td>
                           <td><c:out value="${cartao.bandeira_cartao}"/></td>
                           <td><c:out value="${cartao.numero_cartao}"/></td>
                           <td><c:out value="${cartao.validade}"/></td>
                           <td>R$<c:out value="${cartao.limite}"/></td>
                           <td><c:out value="${cartao.data_fechamento}"/></td>
                           <td><c:out value="${cartao.data_vencimento}"/></td>
                           <td><c:out value="${cartao.data_pagamento}"/></td>
                           <td><c:out value="${cartao.ccv}"/></td>
                       </tr>
                   </c:forEach>   
                </table>
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
