/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.G5.model;

/**
 *
 * @author luisg
 */
public class perfilAcesso {
    int id_perfil = 0;
    String tipo_perfil;

    public perfilAcesso() {
    }

    public perfilAcesso(String tipo_perfil, int id_perfil) {
        this.id_perfil = id_perfil;
        this.tipo_perfil = tipo_perfil;
    }

    public int getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(int id_perfil) {
        this.id_perfil = id_perfil;
    }

    public String getTipo_perfil() {
        return tipo_perfil;
    }

    public void setTipo_perfil(String tipo_perfil) {
        this.tipo_perfil = tipo_perfil;
    }
    
    
    
}
