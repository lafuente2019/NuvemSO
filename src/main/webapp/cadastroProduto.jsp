<%-- 
    Document   : cadastroProduto
    Created on : 01/05/2020, 19:29:31
    Author     :  Diego Souza de Queiroz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <!-- Meta tags Obrigatórias -->
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name=viewport content="width=device-width, initial-scale=1">
        <!--CSS -->
        <!--Fonts Awesome-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
        <!--Bootstrap-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <!--Específica da Página-->
        <link href="css/start.css" rel="stylesheet">
        <link href="css/cadastros.css" rel="stylesheet">
        <!--Titulo e icone-->
        <link rel="shortcut icon" href="img/logo-branco.png"/>
        <title>Perfumaria Muchachos: Cadastro Produto</title>
    </head>
    <body>
        <!--CABEÇALHO-->
        <div class="container-fluid">
            <div class="row cabecalho">
                <div class="col-lg-2 col-sm-2"><!--BUTTON HUMBURGER-->
                    <button id="hamburger" type="button" class="btn btn-outline-dark"><span class="fas fa-bars"></span></button>
                </div>
                <div class="col-lg-3 col-sm-3"><!--LOGO CABEÇALHO-->
                    <!--Colorir logo efeito em jquery - usa-se o id #logocab-->
                    <a  href="start.jsp">
                        <img id="logocab" src="img/grupo-2.png" alt="Logo Muchachos Perfumaria">
                    </a>
                </div>
                <div class="col-lg-3 col-sm-3"><!--HORA E DATA-->
                    <h1 id="calendario"></h><!--Data e calendario feito em jquery - usa-se o id #calendario-->
                </div>
                <div class="col-lg-2 col-sm-2"><!--USUÁRIO-->
                    <h1><span class="fas fa-user"></span> Ramses Souza</h>
                </div>
                <div class="col-lg-1 col-sm-1"><!--SAIR DO SISTEMA-->
                    <a class="btn btn-outline-dark" href="LogoutServlet" role="button">Sair <span class="fas fa-sign-out-alt"></span></a>
                </div>
            </div>
        </div>
        <!--BARRA NAVEGACAO LATERAL-->
        <div id="barra-lateral" class="barra-lateral"><!--expandir/recolher, feito em jquery - usa o id #barra-lateral-->
            <ul><!--Colorir botões ao apertar, feito em jquery - usa a classe .item-linha-->
                <p>Vendas</p>
                <li><a class="item-linha" href="venda.jsp"><span class="fas fa-shopping-cart mr-4"></span> Venda</a></li>
                <li><a class="item-linha" href="cadastroCliente.jsp"><span class="fas fa-user-plus mr-4"></span>Cadastro de Cliente</a></li>
                <li><a class="item-linha" href="ConsultarClienteServlet"><span class="fas fa-users mr-4"></span>Consulta de Cliente</a></li>
                <p>Marketing</p>
                <li><a class="item-linha" href="cadastroProduto.jsp"><span class="fas fa-pump-soap mr-4"></span> Cadastro de Produto</a></li>
                <li><a class="item-linha" href="consultaProdutoServlet"><span class="fas fa-search mr-4"></span>Consulta de Produto</a></li>
                <li><a class="item-linha" href="ConsultarClienteServlet"><span class="fas fa-users mr-3"></span> Consulta de Cliente</a></li>
                <p>Tecnologia da Informação</p>
                <li><a class="item-linha" href="cadastroFuncionario.jsp"><span class="fas fa-user-tie mr-4"></span> Cadastro de Colaborador</a></li>
                <li><a class="item-linha" href="consultaFuncionarioServlet"><span class="fas fa-user-edit mr-3"></span> Consulta de Colaborador</a></li>
                <p>Recursos Humanos</p>
                <li><a class="item-linha" href="consultaFuncionarioServlet"><span class="fas fa-user-edit mr-3"></span> Consulta de Colaborador</a></li>
                <p>Relatório</p>
                <li><a class="item-linha" href="RelatoriosServlet"><span class="fas fa-chart-line mr-3"></span> Relatório</a></li>
                <p>Sobre a Empresa</p>
                <li><a class="item-linha" href="Empresa.jsp"><span class="fas fa-chart-bar mr-3"></span> Sobre a empresa</a></li>
            </ul>
        </div>
        <!--CONTEUDO DA PAGINA-->
        <!--expandir/recolher, feito em jquery - usa o id #conteudo-pagina-->
        <div id="conteudo-pagina" class="container-fluid conteudo-pagina">
            <h1>Cadastro de Produto</h1> 
            <!--Formulário Geral-->
            <form id="formulario" class="formulario">
                <!--Linha 1-->
                <div class="row linha-do-nome">
                    <!--Nome do Produto-->
                    <div class="col-sm-10 col-md-10">
                        <div class="form-group">
                            <label for="nome">Nome do Produto</label>
                            <input id="nome" name="nome" type="text" class="form-control" maxlength="40" placeholder="Exemplo.: Ferrari black" required="">
                        </div>
                    </div><!--Fim do Nome do Produto-->
                    <!--Ativo-->
                    <div class="col-md-2 col-sm-2">
                        <div class="form-group">
                            <label>Status</label>
                            <select id="status" name="status" class="form-control">
                                <option value="ativo">Ativo</option>
                                <option value="inativo">Inativo</option>
                            </select>
                        </div>
                    </div><!--Fim Ativo-->
                </div><!--Fim da linha 1-->
                <!--Linha 2-->	
                <div class="row">
                    <!--Categoria-->
                    <div class="dropdown col-sm-6">
                        <div class="form-group">
                            <label for="categoria">Categoria</label>
                            <select id="categoria" name="categoria" class="form-control" required>
                                <option value="beleza">Beleza</option>
                                <option value="cosmeticos">Cosmeticos</option>
                                <option value="perfumes">Perfumes</option>
                                <option value="utensilios">Utensilios</option>
                            </select>
                        </div>
                    </div><!--Fim da Categoria-->
                    <!--Preco-->
                    <div class="col-sm-4">
                        <div class="form-group">
                            <label for="preco">Preço</label>
                            <input id="preco" name="preco"  class="form-control mascara-decimais" maxlength="6" placeholder="Exemplo.: 250.00" required >
                        </div>
                    </div><!--Fim do preco-->
                    <!--Quantidade-->
                    <div class="col-sm-2">
                        <div class="form-group">
                            <label for="quantidade">Quantidade</label>
                            <input id="quantidade" name="quantidade" type="number" class="form-control mascara-numero" maxlength="6" placeholder="Exemplo.: 1359" required>
                        </div>
                    </div><!--Fim Quantidade-->
                </div><!--Fim da linha 2-->
                <!--Linha 3-->
                <div class="row">
                    <!--Descricao-->
                    <div class="col-sm-12" >
                        <div class="form-group">
                            <label for="descricao">Descrição</label> 
                            <input id="descricao" name="descricao" type="text" class="form-control" maxlength="200" placeholder="Exemplo.: Produto para tratamento capilar" required>
                        </div>
                    </div><!--Fim Desricao-->
                </div><!--Fim da linha 3-->
                <!--Linha 4-->
                <div class="botoes">
                    <div class="row">
                        <!--Botão Limpar-->
                        <div class=" offset-md-8 col-sm-2">
                            <input type="reset" value="Limpar" class="btn btn btn-danger btn-block">						
                        </div><!--Fim Botão Limpar-->
                        <!--Botão Salvar-->
                        <div class="col-sm-2">
                            <input type="submit" value="Salvar" class="btn btn-success btn-block">
                        </div><!--Fim Botão Salvar-->
                    </div><!--Fim da linha 4-->
                </div><!--Fim classe botoes-->
            </form><!--Fim do formulário-->
        </div><!--Fim do conteudo da pagina-->

        <!--MODAL-->
        <div class="modal fade modal" id="modalMensagem" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Mensagem</h5>
                        <button type="button" class="close fechar-modal"><!--data-dismiss="modal"-->
                            <span class="fas fa-times"></span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <p id="mensagem"></p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger btn-sm fechar-modal"><!--data-dismiss="modal"-->
                            <span class="fas fa-times mr-2"></span>Fechar
                        </button>
                    </div>
                </div>
            </div>
        </div>

        <!--1-jQuery.js-->
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <!--2-Popper.js-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <!--3-Bootstrap.js -->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <!--4-Mask Money Plugin-->
        <script src="https://cdn.rawgit.com/plentz/jquery-maskmoney/master/dist/jquery.maskMoney.min.js"></script>
        <!--5-Mask CPF Plugin-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.12/jquery.mask.min.js"></script>
        <!--6-Específica da página-->
        <script type="text/javascript" src="js/start.js"></script>
        <script type="text/javascript" src="js/cadastroProduto.js"></script>
        <script type="text/javascript" src="js/validacao.js"></script>
    </body>
</html>
