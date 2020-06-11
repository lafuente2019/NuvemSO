package com.muchachos.dao;

import com.muchachos.db.ConexaoDatabase;
import com.muchachos.interfaces.ProdutoInterface;
import com.muchachos.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diego Souza de Queiroz
 */
public class ProdutoDao extends ConexaoDatabase implements ProdutoInterface {

    @Override
    public List<Produto> obterTodos() throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoDatabase.getConexao();
        PreparedStatement ps = conexao.prepareStatement("SELECT id, nome, quantidade, descricao, categoria, status From TB_PRODUTO");

        ResultSet rs = ps.executeQuery();
        List<Produto> produtos = new ArrayList();

        while (rs.next()) {
            produtos.add(new Produto(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7)));
        }
        return produtos;
    }

    @Override
    public void salvar(Produto produto) throws ClassNotFoundException, SQLException {
        Connection conexao = ConexaoDatabase.getConexao();
        PreparedStatement statement = conexao.prepareStatement("insert into TB_PRODUTO (nome, preco, quantidade, descricao, categoria, status)" + "values(?,?,?,?,?,?)");

        statement.setString(1, produto.getNome());
        statement.setFloat(2, produto.getPreco());
        statement.setInt(3, produto.getQuantidade());
        statement.setString(4, produto.getDescricao());
        statement.setString(5, produto.getCategoria());
        statement.setString(6, produto.getStatus());
        statement.execute();
    }

    @Override
    public List<Produto> obterComPreco() throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoDatabase.getConexao();
        PreparedStatement ps = conexao.prepareStatement("SELECT id, nome, preco, quantidade, categoria, status from TB_PRODUTO");

        ResultSet rs = ps.executeQuery();
        List<Produto> produtos = new ArrayList();

        while (rs.next()) {
            while (rs.next()) {
                produtos.add(new Produto(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4), rs.getString(5), rs.getString(6)));
            }
            return produtos;

        }
        return produtos;
    }

    @Override
    public void excluir(int cod) throws ClassNotFoundException, SQLException {
        Connection conexao = ConexaoDatabase.getConexao();
        PreparedStatement statement = conexao.prepareStatement("DELETE FROM TB_PRODUTO WHERE id = ?");

        statement.setInt(1, cod);
        statement.execute();
    }

    @Override
    public Produto obterPorID(int cod) throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoDatabase.getConexao();
        PreparedStatement ps = conexao.prepareStatement("SELECT id, nome, preco,quantidade,descricao,categoria,status FROM TB_PRODUTO WHERE id=?");
        ps.setInt(1, cod);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new Produto(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4),
                    rs.getString(5), rs.getString(6), rs.getString(7));
        }

        throw new SQLException("Codigo não encontrado: " + cod);
    }

    @Override
    public void atualizar(Produto produto) throws ClassNotFoundException, SQLException {
        Connection conexao = ConexaoDatabase.getConexao();
        PreparedStatement statement = conexao.prepareStatement(
                " UPDATE TB_PRODUTO  SET nome=?, preco=?, quantidade=?, descricao=?, categoria=?, status=? WHERE id=?");

        statement.setString(1, produto.getNome());
        statement.setFloat(2, produto.getPreco());
        statement.setInt(3, produto.getQuantidade());
        statement.setString(4, produto.getDescricao());
        statement.setString(5, produto.getCategoria());
        statement.setString(6, produto.getStatus());
        statement.setInt(7, produto.getId());
        statement.execute();
    }
 
    @Override
    public List<Produto> buscarPorNome(String busca) throws SQLException, Exception {
        String sql = "SELECT * FROM TB_PRODUTO WHERE upper(nome) like ? or upper(categoria) like ?";
        busca = '%' + busca + '%';

        List<Produto> listaProduto = null;
        Connection conexao = null;
        PreparedStatement ps = null;

        ResultSet rs = null;
        

        try {
            conexao = ConexaoDatabase.getConexao();
            ps = conexao.prepareStatement(sql);
            ps.setString(1, busca.toUpperCase());
            ps.setString(2, busca.toUpperCase());

            rs = ps.executeQuery();

            while (rs.next()) {
                if (listaProduto == null) {
                    listaProduto = new ArrayList<>();
                }
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                float preco = rs.getFloat("preco");
                int quantidade = rs.getInt("quantidade");
                String categoria = rs.getString("categoria");
                String status = rs.getString("status");

                Produto P = new Produto(id, nome, preco, quantidade, categoria, status);
                listaProduto.add(P);
            }

        } catch (SQLException e) {
            e.getMessage();
            System.out.println(e);
        } 
        return listaProduto;
    }

}
