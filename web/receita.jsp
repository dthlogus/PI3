<%-- 
    Document   : index
    Created on : 11/04/2022, 21:13:37
    Author     : diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="estilos/css/estilos.css" rel="stylesheet" />
        <script src="estilos/javascripturo/script.js"></script>
        <title>Receita</title>
    </head>
    <body>

        <header class="header">
            <h2>C'wallet Web</h2>
        </header>

        <main class="despesa">
            <div class="despesa_container_title">
            <h1 class="despesa_title">Receita</h1>
            </div>
            <form method="POST" action="Receita" class="formDespesa">
                <div class="dp">
                    <ul>
                        <li>
                            <label id="lbCodigo" name="lbCodigo">Codigo</label>
                            <input type="number" id="id" name="id" />
                        </li>

                        <li>
                            <label id="lbNome" name="lbNome">Nome</label>
                            <input type="text" id="nome" name="nome" />

                        </li>
                        
                        <li>
                            <label id="lbDataAquisicao" name="lbDataAquisicao">Data da aquisição</label>
                            <input placeholder="12/07/2017" type="text" id="data_aquisicao" name="data_aquisicao" pattern="^([0-2][0-9]|(3)[0-1])(\/)(((0)[0-9])|((1)[0-2]))(\/)\d{4}$" />
                        </li>
                        
                        <li>
                            <label id="lbDataAquisicao" name="lbDataAquisicao">Data de disponibilidade</label>
                            <input placeholder="12/07/2017" type="text" id="data_disponibilidade" name="data_disponibilidade" pattern="^([0-2][0-9]|(3)[0-1])(\/)(((0)[0-9])|((1)[0-2]))(\/)\d{4}$" />
                        </li>

                        <li>
                            <label id="lbValorDespesa" name="lbValorDespesa">Valor da receita</label>
                            <input type="number" id="valor" name="valor" />
                        </li>

                        <li>
                            <label id="lbCategoria" name="lbCategoria">Categoria</label>
                            <select name="categoria" class="categorias">
                                <option value="aplicacao">Aplicação</option>
                                <option value="trabalho">Trabalho</option>
                                <option value="outros">Outros</option>
                            </select>
                        </li>

                        <li>
                            <label id="lbDescricao" name="lbDescricao">Descricao</label>
                            <textarea name="descricao" rows="4" cols="50" maxlength="250"></textarea>
                        </li>

                        <li>
                            <input type="number" name="id_pessoa" value="1" readonly hidden/>
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

            <div class ="tabela">
                <table border="1">
                    <tr>
                        <th>Id</th>
                        <th>Nome</th>
                        <th>Data da aquisição</th>
                        <th>Data da disponibilidade</th>
                        <th>valor da receita</th>
                        <th>Categoria</th>
                        <th>Descricao</th>
                    </tr>
                    <c:forEach items="${lista}" var="receita">
                        <tr>
                            <td><c:out value="${receita.id}"/></td>
                            <td><c:out value="${receita.nome_receita}"/></td>
                            <td><c:out value="${receita.data_aquisicao}"/></td>
                            <td><c:out value="${receita.data_disponivel}"/></td>
                            <td>R$: <c:out value="${receita.valor_receita}"/></td>
                            <td class="tb_categoria"><c:out value="${receita.categoria}"/></td>
                            <td><c:out value="${receita.descricao}"/></td>
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
        </footer>
    </body>
</html>
