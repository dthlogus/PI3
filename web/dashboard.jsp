<%-- 
    Document   : dashboard
    Created on : 18/06/2022, 17:00:04
    Author     : Nicholas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="estilos/css/estilos.css" rel="stylesheet" />
        <script src="estilos/javascripturo/script.js"></script>
        <title>C'Wallet Home Page</title>
        <title>C'Wallet Dashboard</title>
    </head>
    <body>
        <header class="header">
            <h2>C'wallet Web</h2>
        </header>

        <main class="main">

            <form action="action" class="formDashboard">
                <nav class="nav">
                    <a href="index.jsp">Sair</a>
                    <a href="cadastrocc.jsp">Conta Corrente</a>
                    <a href="cadastrocp.jsp">Conta Poupança</a>
                    <a href="despesa.jsp">Despesas</a>
                    <a href="receita.jsp">Receita</a>
                    <a href="cartoes.jsp">Cartões</a>
                    
                </nav>
            </form>
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
