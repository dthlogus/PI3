/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.G5.model;

/**
 *
 * @author luisg
 */
public class banco {
    int id_banco = 0;
    String numero_banco = "";
    String nome_banco ="";

    public banco() {
    }
    public banco(int id_banco, String numero_banco, String nome_banco){
        this.id_banco = id_banco;
        this.nome_banco = nome_banco;
        this.numero_banco = numero_banco;
    }

    public int getId_banco() {
        return id_banco;
    }

    public void setId_banco(int id_banco) {
        this.id_banco = id_banco;
    }

    public String getNumero_banco() {
        return numero_banco;
    }

    public void setNumero_banco(String numero_banco) {
        this.numero_banco = numero_banco;
    }

    public String getNome_banco() {
        return nome_banco;
    }

    public void setNome_banco(String nome_banco) {
        this.nome_banco = nome_banco;
    }
    
    

    
    
}
