package com.muchachos.servelet;

import com.muchachos.dao.VendaDao;
import com.muchachos.model.Venda;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 21/05/2020
 * @author Ramses
 */
@WebServlet(name = "CadastroVendaServlet", urlPatterns = {"/CadastroVendaServlet"})
public class CadastroVendaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //não se usa
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer ultimaVenda = 0;
        //campos opcionais
        String idFunc = request.getParameter("funcId");
        String idCliente = request.getParameter("cliId");
        String pagDin = request.getParameter("pagDin").replace("R$ ", "");
        String pagDeb = request.getParameter("pagDeb").replace("R$ ", "");
        String pagCred = request.getParameter("pagCred").replace("R$ ", "");
        String parcelas = request.getParameter("parcelas");
        String desconto = request.getParameter("valDesc").replace("R$ ", "");
        
        Venda venda = new Venda();
        
        if(!"".equals(idCliente)){
            venda.getCliente().setId(Integer.parseInt(request.getParameter("cliId")));
        }else{venda.getCliente().setId(0);}
        if(!"".equals(idFunc)){
            venda.getFuncionario().setId(Integer.parseInt(request.getParameter("funcId")));
        }else{venda.getFuncionario().setId(0);}
        java.util.Date data = new Date();
        venda.setData(data);
        venda.setQtdItens(Integer.parseInt(request.getParameter("qtdItens")));
        venda.setSubtotal(Float.parseFloat(request.getParameter("valTotal").replace("R$ ", "")));
        if(!"".equals(pagDin)){
            venda.setPagDinheiro(Float.parseFloat(request.getParameter("pagDin").replace("R$ ", "")));
        }else{venda.setPagDinheiro(0f);}
        if(!"".equals(pagDeb)){
            venda.setPagDebito(Float.parseFloat(request.getParameter("pagDeb").replace("R$ ", "")));
        }else{venda.setPagDebito(0f);}
        if(!"".equals(pagCred)){
            venda.setPagCredito(Float.parseFloat(request.getParameter("pagCred").replace("R$ ", "")));
        }else{venda.setPagCredito(0f);}
        if(!"".equals(parcelas)){
            venda.setParcelamento(Integer.parseInt(request.getParameter("parcelas")));
        }else{venda.setParcelamento(0);}
        if(!"".equals(desconto)){
            venda.setDesconto(Float.parseFloat(request.getParameter("valDesc").replace("R$ ", "")));
        }else{venda.setDesconto(0f);}
        venda.setTroco(Float.parseFloat(request.getParameter("valTroc").replace("R$ ", "")));
        try{
            VendaDao vendaDao = new VendaDao();
            vendaDao.salvar(venda);
            ultimaVenda = vendaDao.obterUltima();
            String ultimaV = ultimaVenda.toString();
            response.getWriter().write(ultimaV);
        }catch (SQLException e){
           response.getWriter().write("Erro de banco de dados: " + e.getMessage());
        }catch (ClassNotFoundException e) {
            response.getWriter().write("Erro de Driver: " + e.getMessage());
        }catch (Exception e){
            response.getWriter().write("Erro de Código: " + e.getMessage());
        }
    }
}
