/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.G5.model;

import java.util.Date;

/**
 *
 * @author luisg
 */
public class Cartao {
    private int id_cartao = 0;
    private Date validade;
    private String nome_titular = "";
    private Date data_Vencimento;
    private Date data_pagamento;
    private Date data_fechamento;
    private String ccv;
    private double limite ;
    private int parcela;

    public Cartao() {
    }

    public Cartao(Date validade, Date data_Vencimento, Date data_pagamento, Date data_fechamento, String ccv, double limite, int parcela) {
        this.validade = validade;
        this.data_Vencimento = data_Vencimento;
        this.data_pagamento = data_pagamento;
        this.data_fechamento = data_fechamento;
        this.ccv = ccv;
        this.limite = limite;
        this.parcela = parcela;
    }

    public int getId_cartao() {
        return id_cartao;
    }

    public void setId_cartao(int id_cartao) {
        this.id_cartao = id_cartao;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public String getNome_titular() {
        return nome_titular;
    }

    public void setNome_titular(String nome_titular) {
        this.nome_titular = nome_titular;
    }

    public Date getData_Vencimento() {
        return data_Vencimento;
    }

    public void setData_Vencimento(Date data_Vencimento) {
        this.data_Vencimento = data_Vencimento;
    }

    public Date getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(Date data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    public Date getData_fechamento() {
        return data_fechamento;
    }

    public void setData_fechamento(Date data_fechamento) {
        this.data_fechamento = data_fechamento;
    }

    public String getCcv() {
        return ccv;
    }

    public void setCcv(String ccv) {
        this.ccv = ccv;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public int getParcela() {
        return parcela;
    }

    public void setParcela(int parcela) {
        this.parcela = parcela;
    }
    
    

    
    
    
    
    
}
