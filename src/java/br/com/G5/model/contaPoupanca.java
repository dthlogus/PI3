/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.G5.model;

/**
 *
 * @author luisg
 */
public class contaPoupanca {
    int id_conta_poupanca = 0;
    String numero_conta_poupanca;
    double saldo_conta_poupanca;

    public contaPoupanca() {
    }
    
    public contaPoupanca(String numero_conta_poupanca, double saldo_conta_poupanca) {
        this.numero_conta_poupanca = numero_conta_poupanca;
        this.saldo_conta_poupanca = saldo_conta_poupanca;
    }

    public int getId_conta_poupanca() {
        return id_conta_poupanca;
    }

    public void setId_conta_poupanca(int id_conta_poupanca) {
        this.id_conta_poupanca = id_conta_poupanca;
    }

    public String getNumero_conta_poupanca() {
        return numero_conta_poupanca;
    }

    public void setNumero_conta_poupanca(String numero_conta_poupanca) {
        this.numero_conta_poupanca = numero_conta_poupanca;
    }

    public double getSaldo_conta_poupanca() {
        return saldo_conta_poupanca;
    }

    public void setSaldo_conta_poupanca(double saldo_conta_poupanca) {
        this.saldo_conta_poupanca = saldo_conta_poupanca;
    }
    
    
    
}
