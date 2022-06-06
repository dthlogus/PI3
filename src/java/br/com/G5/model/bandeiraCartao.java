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

    public bandeiraCartao() {
    }
    public bandeiraCartao(int id_bandeira, String nome_bandeira){
        this.id_bandeira = id_bandeira;
        this.nome_bandeira = nome_bandeira;
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

    @Override
    public String toString() {
        return "bandeiraCartao{" + "id_bandeira=" + id_bandeira + ", nome_bandeira=" + nome_bandeira + '}';
    }
    
    
  
    
}
