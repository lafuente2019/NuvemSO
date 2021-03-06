package com.muchachos.dao;

import com.muchachos.db.ConexaoDatabase;
import com.muchachos.interfaces.RelatorioInterface;
import com.muchachos.model.Detalhes;
import com.muchachos.model.Ranking;
import com.muchachos.model.Relatorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * 11/05/2020 15:58
 *
 * @author Fabio Vieira
 */
public class RelatorioDao implements RelatorioInterface {

    @Override
    public List<Relatorio> ObterTodosComFiltro(Timestamp dataDe, Timestamp dataPara, String filial, String cliente, String categoria) throws ClassNotFoundException, SQLException {
        List<Relatorio> relatorio = null;
        try {
            Connection conexao = ConexaoDatabase.getConexao();

            PreparedStatement ps = conexao.prepareStatement("select distinct v.id,c.nome as nome,v.data,v.qtd_itens,v.val_total,f.nome as colaborador,f.filial as filial from TB_VENDA as v "
                    + " inner join TB_CLIENTE as c on v.id_cliente = c.id "
                    + " inner join TB_COLABORADOR as f on v.id_funcionario = f.id "
                    + " inner join TB_ITENSVENDA as iv on v.id = iv.id_venda "
                    + " inner join TB_PRODUTO as p on iv.id_produto = p.id "
                    + " where (c.nome like ?) and (f.filial like ?) and (p.categoria like ?) and (v.data >= ? and v.data<= ?)");

            ps.setString(1, cliente);
            ps.setString(2, filial);
            ps.setString(3, categoria);
            ps.setTimestamp(4, dataDe);
            ps.setTimestamp(5, dataPara);

            ResultSet rs = ps.executeQuery();
            relatorio = new ArrayList<>();

            while (rs.next()) {
                Relatorio r = new Relatorio(rs.getInt("id"), rs.getString("nome"), rs.getDate("data"), rs.getInt("qtd_itens"),
                        rs.getFloat("val_total"), rs.getString("colaborador"), rs.getString("filial"));
                relatorio.add(r);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.toString());
        } catch (Exception sQLException) {
            System.out.println(sQLException.toString());

        }
        return relatorio;
    }

    //DETALHE DE CADA VENDA
    @Override
    public List<Detalhes> ObterDetalhes(int id, String categoria) throws ClassNotFoundException, SQLException {
        List<Detalhes> iv = new ArrayList<>();

        try {
            Connection conexao = ConexaoDatabase.getConexao();

            PreparedStatement ps = conexao.prepareStatement("select iv.Id_Produto, p.Nome, iv.qtd_itens, p.Categoria, p.preco, iv.val_total from TB_ITENSVENDA as iv"
                    + " inner join TB_PRODUTO as p on iv.ID_PRODUTO = p.ID"
                    + " where iv.id_venda = ? and p.categoria like ?");

            ps.setInt(1, id);
            ps.setString(2, categoria);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                iv.add(new Detalhes(rs.getInt("id_produto"), rs.getString("nome"), rs.getInt("qtd_itens"), rs.getString("categoria"), rs.getFloat("preco"), rs.getFloat("val_total")));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.toString());
        } catch (Exception sQLException) {
            System.out.println(sQLException.toString());
        }
        return iv;
    }

    @Override
    public List<Ranking> ObterRank() throws ClassNotFoundException, SQLException {
        List<Ranking> ranking = new ArrayList<>();

        try {
            Connection conexao = ConexaoDatabase.getConexao();

            PreparedStatement ps = conexao.prepareStatement("SELECT COUNT(*)as qtd, v.ID_FUNCIONARIO, f.NOME as nome,f.FILIAL as filial FROM TB_VENDA as v "
                    + " INNER JOIN TB_COLABORADOR as f on v.ID_FUNCIONARIO = f.ID "
                    + " GROUP BY v.ID_FUNCIONARIO, f.nome, f.filial  ORDER BY v.ID_FUNCIONARIO DESC LIMIT 10");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ranking.add(new Ranking(rs.getInt(1), rs.getString(3), rs.getString(4)));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.toString());
        } catch (Exception sQLException) {
            System.out.println(sQLException.toString());
        }

        return ranking;
    }

    //RELATORIO DE VENDAS
}
