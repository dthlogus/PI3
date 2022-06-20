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
    int id_pessoa;
    int id_cartao ;
    String numero_cartao;
    String bandeira_cartao;
    LocalDate validade;
    String nome_cartao;
    LocalDate data_vencimento;
    LocalDate data_pagamento;
    LocalDate data_fechamento;
    String ccv;
    double limite;


    public Cartao() {
    }


    public int getId_cartao() {
        return id_cartao;
    }

    public void setId_cartao(int id_cartao) {
        this.id_cartao = id_cartao;
    }

    public String getNumero_cartao() {
        return numero_cartao;
    }

    public void setNumero_cartao(String numero_cartao) {
        this.numero_cartao = numero_cartao;
    }

    public String getBandeira_cartao() {
        return bandeira_cartao;
    }

    public void setBandeira_cartao(String bandeira_cartao) {
        this.bandeira_cartao = bandeira_cartao;
    }

    public String getValidade() {
        String val;
        val = validade.getMonthValue() + "/" + validade.getYear();
        return val;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public String getNome_cartao() {
        return nome_cartao;
    }

    public void setNome_cartao(String nome_cartao) {
        this.nome_cartao = nome_cartao;
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

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public LocalDate getValidadeLocalDate(){
        return validade;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }
    


}
