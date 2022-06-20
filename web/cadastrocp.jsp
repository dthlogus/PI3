<%-- 
    Document   : CadastroCp
    Created on : 18/06/2022, 20:32:45
    Author     : Nicholas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Conta Poupança | C'Wallet</title>
        <link href="estilos/css/estilos.css" rel="stylesheet" />
        <script src="estilos/javascripturo/script.js"></script>
    </head>
    <body>
        <header class="header">
            <h2>C'wallet Web</h2>

            <nav class="menu">
                <a href="dashboard.jsp">Inicio</a>
                <a href="cadastrocc.jsp">Conta Corrente</a>
                <a href="cadastrocp.jsp">Conta Poupança</a>
                <a href="despesa.jsp">Despesas</a>
                <a href="cartoes.jsp">Cartões</a>
            </nav>

        </header>


        <main class="mainContaPoupanca">
            <section class="contaPoupanca">
                <div class="cadastroContaPoupanca">
                    <form method="POST" action="ControllerCp" >
                        <h1>Cadastro de Conta Poupança</h1>
                        <ul>

                            <li>
                                <label>ID</label>
                                <input type="number" id="id" name="id" />
                            </li>

                            <li>
                                <label>Nome Titular</label>
                                <input id="nometitular" type="text"  name="nometitular" placeholder="Nome do Títular" />
                            </li>

                            <li>
                                <label>Banco</label>
                                <select name="banco" id="banco" class="banco" />
                            <option value="bancodobrasil">Brando do Brasil</option>
                            <option value="bradesco">Bradesco</option>
                            <option value="caixa">Caixa Econômica</option>
                            <option value="inter">Banco Inter</option>
                            <option value="itau">Itaú</option>
                            <option value="nubank">NU Bank</option>
                            <option value="bradesco">Bradesco</option>
                            <option value="santander">Santander</option>
                            <option value="sicoob">Sicoob</option>
                            </select>
                            </li>

                            <li>
                                <label>Número da Conta Poupança</label>
                                <input id="numerocp" type="text"  name="numerocp"  placeholder="12345" />
                            </li>

                            <li>
                                <label>Limite da conta</label>
                                <input id="limitecp" type="text"  name="limitecp" placeholder="100.00"  />
                            </li>

                            <li style="display: inline-flex;">
                                <button name="action" value="inserir">Inserir</button>
                                <button name="action" value="alterar">Alterar</button>
                                <button name="action" value="excluir">Remover</button>
                                <button name="action" value="consultar">Consultar</button>
                                <button name="action" value="listar">Listar todos</button>
                            </li>
                        </ul>
                    </form>
                </div>


                <div class="listagemDeContasPoupanca">
                    <table border="1">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Titular</th>
                                <th>Banco</th>
                                <th>Numero da Conta Poupança</th>
                                <th>Limite da conta</th>
                            </tr>
                        </thead>

                        <c:forEach items="${lista}" var="contapoupanca">
                            <tbody>
                                <tr>
                                    <td><c:out value="${contapoupanca.idConta}"/></td>
                                    <td><c:out value="${contapoupanca.nomeTitular}"/></td>
                                    <td><c:out value="${contapoupanca.nomeBanco}"/></td>
                                    <td><c:out value="${contapoupanca.numeroConta}"/></td>
                                    <td><c:out value="${contapoupanca.limiteConta}"/></td>
                                </tr>
                            </tbody>

                        </c:forEach>
                    </table>
                </div>
            </section>
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
        </footer>
    </body>
</html>
