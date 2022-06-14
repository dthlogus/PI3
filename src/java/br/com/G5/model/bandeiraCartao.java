/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.G5.model;

/**
 *
 * @author luisg
 */
public class bandeiraCartao {
    int id_bandeira = 0;
    String nome_bandeira = "";
    String tipo_cartao = "";


    public bandeiraCartao() {
    }
    public bandeiraCartao(int id_bandeira, String nome_bandeira, String tipo_cartao){
        this.id_bandeira = id_bandeira;
        this.nome_bandeira = nome_bandeira;
        this.tipo_cartao = tipo_cartao;
    }
    
    public int getId_bandeira() {
        return id_bandeira;
    }

    public void setId_bandeira(int id_bandeira) {
        this.id_bandeira = id_bandeira;
    }

    public String getNome_bandeira() {
        return nome_bandeira;
    }

    public void setNome_bandeira(String nome_bandeira) {
        this.nome_bandeira = nome_bandeira;
    }

    public String getTipo_cartao() {
        return tipo_cartao;
    }

    public void setTipo_cartao(String tipo_cartao) {
        this.tipo_cartao = tipo_cartao;
    }

    @Override
    public String toString() {
        return "bandeiraCartao{" + "id da bandeira=" + id_bandeira + ", nome da bandeira=" + nome_bandeira + ", tipo da bandeira"+ tipo_cartao + '}';
    }
    
    
  
    
}
