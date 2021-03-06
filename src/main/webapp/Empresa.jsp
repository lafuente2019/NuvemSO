<%-- 
    Document   : start
    Created on : 30/04/2020, 21:49:56
    Author     : Valter Lafuente Junior
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
        <!--Titulo e icone-->
        <title>Perfumaria Muchachos: Início do sistema</title>
        <style>
            .empresa{
                position: absolute;
                top:50%;
                left: 50%;
                margin-right: -50%;
                transform: translate(-50%, -50%);
            }
            .empresa > p{
                font-size: 25px;
            }

        </style>
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

        <div class="container-fluid col-md-3 col-sm-5" style="top: 15px; width: 800px;">
            <div class="tabela">
                <table id="tableVendas" class="table table-sm table-secondary table-hover table-striped">   
                    <thead class="thead-dark">
                        <tr>
                            <th>Nº de vendas</th>
                            <th>Colaborador</th>
                            <th>Filial</th>
                        </tr>
                    </thead>        
                    <c:forEach var="v" items="${vendas}">

                        <tr class="linha">
                            <td >${v.numVendas}</td>
                            <td>${v.nome}</td>
                            <td>${v.filial}</td>
                        </tr>

                    </c:forEach>

                </table>

            </div>
        </div>
        <div class="empresa">
            <p>A Perfumaria Muchachos está a mais de 15 anos no mercado, levando a todos os cantos do país nossos aromas e artigos decorativos.</p>
            <p>Possuimos diversas linhas de produtos, desde produtos para aromaterapia, passando pela area decorativa e alcançando até mesmo o fornecimento</p>
            <p>de produtos personalizados para grandes redes.Por sermos fábrica, possuímos uma grande flexibilidade de aromas e tipos de produtos.</p>
            <p>Nossos clientes contam com uma gama de produtos muito variada,sempre lancando novidades para suprir as demandas do mercado.</p> 
            <p>Convidamos você a conhecer nosso site e nossos produtos! Temos certeza de que não irá se arrepender!!</p>

            <div class="desen" >
                <h4>Desenvolvido por:</h4>
                <p>Diego Souza de Queiroz</p>
                <p>Fabio Luiz Gabriel Vieira</p>
                <p>Valter Lafuente Junior</p>
            </div>
        </div>  

        <!--1-jQuery.js-->
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <!--2-Popper.js-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <!--3-Bootstrap.js-->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <!--4-Específica da página-->
        <script type="text/javascript" src="js/start.js"></script>
    </body>
</html>