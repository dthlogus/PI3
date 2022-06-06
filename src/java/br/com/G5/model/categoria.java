/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.G5.model;

/**
 *
 * @author luisg
 */
public class categoria {
    String categoria_despesa ="";
    String categoria_receita = "";

    public categoria() {
    }
    public categoria(String categoria_despesa,String categroia_receita){
        this.categoria_despesa =  categoria_despesa;
        this.categoria_receita = categroia_receita;
    }

    public String getCategoria_despesa() {
        return categoria_despesa;
    }

    public void setCategoria_despesa(String categoria_despesa) {
        this.categoria_despesa = categoria_despesa;
    }

    public String getCategoria_receita() {
        return categoria_receita;
    }

    public void setCategoria_receita(String categoria_receita) {
        this.categoria_receita = categoria_receita;
    }
    
    
    
}
