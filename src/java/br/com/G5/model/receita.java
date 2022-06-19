/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.G5.model;

import br.com.G5.model.Enum.CategoriaReceitaEnum;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author luisg
 */
public class Receita {

    int id;
    String nome_receita;
    LocalDate data_aquisicao;
    LocalDate data_disponivel;
    double valor_receita;
    CategoriaReceitaEnum categoria;
    String descricao;
    int id_pessoa;

    public Receita() {
    }

    public Receita(String nome_receita, LocalDate data_aquisicao, LocalDate data_disponivel, double valor_receita, CategoriaReceitaEnum categoria, String descricao) {
        this.nome_receita = nome_receita;
        this.data_aquisicao = data_aquisicao;
        this.data_disponivel = data_disponivel;
        this.valor_receita = valor_receita;
        this.categoria = categoria;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id_receita) {
        this.id = id_receita;
    }

    public String getNome_receita() {
        return nome_receita;
    }

    public void setNome_receita(String nome_receita) {
        this.nome_receita = nome_receita;
    }

    public String getData_aquisicao() {
        return data_aquisicao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public void setData_aquisicao(LocalDate data_aquisicao) {
        this.data_aquisicao = data_aquisicao;
    }

    public String getData_disponivel() {
        return data_disponivel.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public void setData_disponivel(LocalDate data_disponivel) {
        this.data_disponivel = data_disponivel;
    }

    public double getValor_receita() {
        return valor_receita;
    }

    public void setValor_receita(double valor_receita) {
        this.valor_receita = valor_receita;
    }

    public CategoriaReceitaEnum getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaReceitaEnum categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public LocalDate getDataDisponivelLocalDate(){
        return data_disponivel;
    }
    
    public LocalDate getDataAquisicaoLocalDate(){
        return data_disponivel;
    }
    
}
