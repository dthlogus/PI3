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
    int id_cartao = 0;
    Date validade;
    String titular;
    Date data_vencimento;
    Date data_pagamento;
    Date data_fechamento;
    String ccv;
    Double limite;
    int parcela;

    public Cartao() {
    }

    public Cartao(Date validade, String titular, Date data_vencimento, Date data_pagamento, Date data_fechamento, String ccv, Double limite, int parcela) {
        this.validade = validade;
        this.titular = titular;
        this.data_vencimento = data_vencimento;
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

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Date getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(Date data_vencimento) {
        this.data_vencimento = data_vencimento;
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

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    public int getParcela() {
        return parcela;
    }

    public void setParcela(int parcela) {
        this.parcela = parcela;
    }

    @Override
    public String toString() {
        return "Cartao{" + "id_cartao=" + id_cartao + ", validade=" + validade + ", titular=" + titular + ", data_vencimento=" + data_vencimento + ", data_pagamento=" + data_pagamento + ", data_fechamento=" + data_fechamento + ", ccv=" + ccv + ", limite=" + limite + ", parcela=" + parcela + '}';
    }
    
    
    
    
}
