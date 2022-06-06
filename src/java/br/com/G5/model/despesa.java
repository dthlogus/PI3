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
public class despesa {
    int id_despesa = 0;
    double valor ;
    Date data_aquisicao;
    int parcela_total;
    int parcela_atual;
    boolean repetitivo;
    double valor_despesa;

    public despesa() {
    }

    public despesa(double valor, Date data_aquisicao, int parcela_total, int parcela_atual, boolean repetitivo, double valor_despesa) {
        this.valor = valor;
        this.data_aquisicao = data_aquisicao;
        this.parcela_total = parcela_total;
        this.parcela_atual = parcela_atual;
        this.repetitivo = repetitivo;
        this.valor_despesa = valor_despesa;
    }

    public int getId_despesa() {
        return id_despesa;
    }

    public void setId_despesa(int id_despesa) {
        this.id_despesa = id_despesa;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData_aquisicao() {
        return data_aquisicao;
    }

    public void setData_aquisicao(Date data_aquisicao) {
        this.data_aquisicao = data_aquisicao;
    }

    public int getParcela_total() {
        return parcela_total;
    }

    public void setParcela_total(int parcela_total) {
        this.parcela_total = parcela_total;
    }

    public int getParcela_atual() {
        return parcela_atual;
    }

    public void setParcela_atual(int parcela_atual) {
        this.parcela_atual = parcela_atual;
    }

    public boolean isRepetitivo() {
        return repetitivo;
    }

    public void setRepetitivo(boolean repetitivo) {
        this.repetitivo = repetitivo;
    }

    public double getValor_despesa() {
        return valor_despesa;
    }

    public void setValor_despesa(double valor_despesa) {
        this.valor_despesa = valor_despesa;
    }
    
    
    
}
