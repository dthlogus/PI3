/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.G5.model;

/**
 *
 * @author luisg
 */
public class carteira {
    int id_carteira = 0;
    Double saldo_total_receita;
    Double balanco_atual;

    public carteira() {
    }
    
    public carteira(int id_carteira,Double saldo_total_receita, Double balanco_atual) {
        this.saldo_total_receita = saldo_total_receita;
        this.balanco_atual = balanco_atual;
        this.id_carteira = id_carteira;
    }

    public int getId_carteira() {
        return id_carteira;
    }

    public void setId_carteira(int id_carteira) {
        this.id_carteira = id_carteira;
    }

    public Double getSaldo_total_receita() {
        return saldo_total_receita;
    }

    public void setSaldo_total_receita(Double saldo_total_receita) {
        this.saldo_total_receita = saldo_total_receita;
    }

    public Double getBalanco_atual() {
        return balanco_atual;
    }

    public void setBalanco_atual(Double balanco_atual) {
        this.balanco_atual = balanco_atual;
    }

    
}