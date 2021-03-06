package com.muchachos.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * 30/04/2020 22:03
 * @author Ramses
 * Atualizado 18/05/2020 19:44
 * @author Ramses
 */
public class Venda{
    private Integer id;
    private Date data;
    private Integer qtdItens;
    private ArrayList<ItemVenda> itensVenda = new ArrayList<ItemVenda>();
    private Float pagDinheiro;
    private Float pagDebito;
    private Float pagCredito;
    private Integer parcelamento;
    private Float desconto;
    private Float subtotal;
    private Float troco;
    private Cliente cliente;
    private Funcionario funcionario;
    
    public Venda(){
        funcionario = new Funcionario();
        cliente = new Cliente();
        itensVenda = new ArrayList<ItemVenda>();
    };
    
    public Venda(Integer id, Date data, Integer qtdItens, Float pagDinheiro, Float pagDebito, Float pagCredito, Integer parcelamento, Float desconto, Float troco, Float subtotal, Cliente cliente, Funcionario funcionario) {
        this.id = id;
        this.data = data;
        this.qtdItens = qtdItens;
        this.pagDinheiro = pagDinheiro;
        this.pagDebito = pagDebito;
        this.pagCredito = pagCredito;
        this.parcelamento = parcelamento;
        this.desconto = desconto;
        this.troco = troco;
        this.subtotal = subtotal;
        this.cliente = cliente;
        this.funcionario = funcionario;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getQtdItens() {
        return qtdItens;
    }

    public void setQtdItens(Integer qtdItens) {
        this.qtdItens = qtdItens;
    }
    
    public ArrayList<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(ArrayList<ItemVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }

    public Float getPagDinheiro() {
        return pagDinheiro;
    }

    public void setPagDinheiro(Float pagDinheiro) {
        this.pagDinheiro = pagDinheiro;
    }

    public Float getPagDebito() {
        return pagDebito;
    }

    public void setPagDebito(Float pagDebito) {
        this.pagDebito = pagDebito;
    }

    public Float getPagCredito() {
        return pagCredito;
    }

    public void setPagCredito(Float pagCredito) {
        this.pagCredito = pagCredito;
    }

    public Integer getParcelamento() {
        return parcelamento;
    }

    public void setParcelamento(Integer parcelamento) {
        this.parcelamento = parcelamento;
    }

    public Float getDesconto() {
        return desconto;
    }

    public void setDesconto(Float desconto) {
        this.desconto = desconto;
    }

    public Float getTroco() {
        return troco;
    }

    public void setTroco(Float troco) {
        this.troco = troco;
    }
    
    public Float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Float subtotal) {
        this.subtotal = subtotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    
}
