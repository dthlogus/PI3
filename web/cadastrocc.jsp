<%-- 
    Document   : CadastroCc
    Created on : 18/06/2022, 12:58:31
    Author     : Nicholas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de conta Corrente</title>
        <link href="estilos/css/estilos.css" rel="stylesheet" />
        <script src="estilos/javascripturo/script.js"></script>
    </head>
    <body>
        <header class="header">
            <h2>C'wallet Web</h2>
            
            <nav class="menu">
                <a href="index.jsp">Inicio</a>
                <a href="cadastrocc.jsp">Conta Corrente</a>
            </nav>

        </header>


        <main class="main">
            <section class="index">
                <div class="cadastroContaCorrente">
                    <form action="" method="POST">
                        <h1>Cadastro de Conta Corrente</h1>
                        <ul>
                            
                            <li>
                                <label>ID</label>
                                <input type="number" id="id" name="id" value="<c:out value="${id}" />" />
                            </li>
                            
                            <li>
                                <label>Nome Titular</label>
                                <input id="nometitular" type="text" required="true" name="nometitular" placeholder="Nome do Títular" value="<c:out value="${id}" />"/>
                            </li>

                            <li>
                                <label>Banco</label>
                                <select name="banco" id="banco" class="banco">
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
                                <label>Número da Conta Corrente</label>
                                <input id="numerocc" type="text" required="true" name="numerocc"  value="" placeholder="12345" />
                            </li>

                            <li>
                                <label>Limite da conta</label>
                                <input id="limitecc" type="text" required="true" name="limitecc"  value="" placeholder="100,00" />
                            </li>
                        </ul>
                        <input type="submit" class="cadastarConta" value="confirmar"/>
                    </form>
                </div>
                
                
                <div class="listagemDeContasCorrente">
                    <table border="1">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Titular</th>
                                <th>Numero da Conta Corrente</th>
                                <th>Banco</th>
                                <th>Limite da conta</th>
                            </tr>
                        </thead>
                        <c:forEach items="${lista}" var="cc">
                        <tbody>
                            <tr>
                                <td><c:out value="${cc.id}"</td>
                            </tr>
                        </tbody>
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
