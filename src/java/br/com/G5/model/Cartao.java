/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.G5.model;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author luisg
 */
public class Cartao {
    int id_cartao = 0;
    String numeroDoCartao;
    String bandeira_Cartao;
    LocalDate validade;
    String titular;
    LocalDate data_vencimento;
    LocalDate data_pagamento;
    LocalDate data_fechamento;
    String ccv;
    Double limite;
  
    
  

    public Cartao() {
    }

    public Cartao(String numeroDoCartao, String bandeira_Cartao, LocalDate validade, String titular, LocalDate data_vencimento, LocalDate data_pagamento, LocalDate data_fechamento, String ccv, Double limite) {
        this.numeroDoCartao = numeroDoCartao;
        this.bandeira_Cartao = bandeira_Cartao;
        this.validade = validade;
        this.titular = titular;
        this.data_vencimento = data_vencimento;
        this.data_pagamento = data_pagamento;
        this.data_fechamento = data_fechamento;
        this.ccv = ccv;
        this.limite = limite;
    }
   

    public int getId_cartao() {
        return id_cartao;
    }

    public void setId_cartao(int id_cartao) {
        this.id_cartao = id_cartao;
    }

    public String getNumeroDoCartao() {
        return numeroDoCartao;
    }

    public void setNumeroDoCartao(String numeroDoCartao) {
        this.numeroDoCartao = numeroDoCartao;
    }

    public String getBandeira_Cartao() {
        return bandeira_Cartao;
    }

    public void setBandeira_Cartao(String bandeira_Cartao) {
        this.bandeira_Cartao = bandeira_Cartao;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public LocalDate getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(LocalDate data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public LocalDate getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(LocalDate data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    public LocalDate getData_fechamento() {
        return data_fechamento;
    }

    public void setData_fechamento(LocalDate data_fechamento) {
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

    @Override
    public String toString() {
        return "Cartao{" + "id_cartao=" + id_cartao + ", numeroDoCartao=" + numeroDoCartao + ", bandeira_Cartao=" + bandeira_Cartao + ", validade=" + validade + ", titular=" + titular + ", data_vencimento=" + data_vencimento + ", data_pagamento=" + data_pagamento + ", data_fechamento=" + data_fechamento + ", ccv=" + ccv + ", limite=" + limite + '}';
    }

}
