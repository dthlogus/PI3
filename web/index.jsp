<%-- 
    Document   : index
    Created on : 17/06/2022, 17:33:50
    Author     : Joao Nicholas
--%>

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
                    <form action="" method="POST" >

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
                                <input type="text" name="CPF" id="CPFl" value="" required="true" placeholder="12345678901"/>
                            </li>
                            <li>
                                <label>Senha</label>
                                <input type="password" name="senha" value="" required="true" placeholder="senha"  minlength="6"/>
                            </li>   
                        </ul>
                        <input type="submit" class="cadastrar" value="cadastrar"/>
                    </form>

                </div>


                <div class="login">
                    <form action="" method="POST">

                        <h1>Login</h1>

                        <ul>
                            <li>
                                <label>CPF</label>
                                <input type="text" name="CPF" id="CPFl" value="" required="true" placeholder="12345678901"/>
                            </li>
                            <li>
                                <label>Senha</label>
                                <input type="password" name="senha" value="" required="true" placeholder="senha"  minlength="6"/>
                            </li>
                        </ul>
                        <input type="submit" class="acessar" value="acessar" onclick="redirecionar()"/>
                    </form> 
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
