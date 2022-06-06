/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.G5.model;

/**
 *
 * @author luisg
 */
public class contato {
    int id_contato = 0;
    String tel_residencial ;
    String email ;
    String tel_celular ;

    public contato() {
    }

    public contato(String tel_residencial, String email, String tel_celular) {
        this.tel_residencial = tel_residencial;
        this.email = email;
        this.tel_celular = tel_celular;
    }

    public int getId_contato() {
        return id_contato;
    }

    public void setId_contato(int id_contato) {
        this.id_contato = id_contato;
    }

    public String getTel_residencial() {
        return tel_residencial;
    }

    public void setTel_residencial(String tel_residencial) {
        this.tel_residencial = tel_residencial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel_celular() {
        return tel_celular;
    }

    public void setTel_celular(String tel_celular) {
        this.tel_celular = tel_celular;
    }
    
    
    
    
    
}
