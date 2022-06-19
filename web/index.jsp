<%-- 
    Document   : index
    Created on : 17/06/2022, 17:33:50
    Author     : Joao Nicholas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="estilos/css/estilos.css" rel="stylesheet" />
        <script src="estilos/javascripturo/script.js"></script>
        <title>C'Wallet Home Page</title>
    </head>
    <body>

        <header class="header">
            <h2>C'wallet Web</h2>
        </header>

        <main class="main">
            <section class="index">
                <div class="cadastro">
                    <form action="Pessoa" method="POST" >

                        <h1>Cadastro</h1>
                        <ul>
                            <li>
                                <label>Nome Completo</label>
                                <input id="nomeUsuario" type="text" required="true" name="nomeUsuario"  value="" placeholder="Nome" />
                            </li>

                            <li>
                                <label>E-mail</label>
                                <input type="email" name="email" id="email" value="" required="true" placeholder="exemplo@mail.com"/>
                            </li>

                            <li>
                                <label>CPF</label>
                                <input type="text" name="cpf" id="CPFl" value="" required="true" placeholder="12345678901"/>
                            </li>
                            <li>
                                <label>Senha</label>
                                <input type="password" name="senha" value="" required="true" placeholder="senha"  minlength="6"/>
                            </li>   
                        </ul>
                        <input type="submit" name="action" class="cadastrar" value="cadastrar"/>
                    </form>
                    <c:if test="${erroCadastro}">
                        <p style="color: white;">Dados inválidos para cadastro, por favor, confira os valores</p>
                    </c:if>
                        <c:if test="${sucessoCadastro}">
                        <p style="color: greenyellow;">Cadastrado com sucesso</p>
                    </c:if>
                </div>
                


                <div class="login">
                    <form action="Pessoa" method="POST">

                        <h1>Login</h1>

                        <ul>
                            <li>
                                <label>CPF</label>
                                <input type="text" name="cpf" id="CPFl" value="" maxlength="11" required="true" placeholder="12345678901"/>
                            </li>
                            <li>
                                <label>Senha</label>
                                <input type="password" name="senha" value="" required="true" placeholder="senha"  minlength="6"/>
                            </li>
                        </ul>
                        <input type="submit" name="action" class="acessar" value="acessar"/>
                    </form>
                    <c:if test="${erroLogar}">
                        <p style="color: white;">Usuarios ou senhas invalidos</p>
                    </c:if>
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
