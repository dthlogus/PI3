/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.G5.model;

import br.com.G5.model.Enum.CategoriaDespesaEnum;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author luisg
 */
public class Despesa {

    int id;
    String nome;
    LocalDate data_aquisicao;
    int parcela_total;
    int parcela_atual;
    boolean repetitivo;
    double valor_despesa;
    CategoriaDespesaEnum categoria;
    String descricao;
    int id_pessoa;

    public Despesa() {
    }

    public Despesa(LocalDate data_aquisicao, int parcela_total, int parcela_atual, boolean repetitivo, double valor_despesa) {
        this.data_aquisicao = data_aquisicao;
        this.parcela_total = parcela_total;
        this.parcela_atual = parcela_atual;
        this.repetitivo = repetitivo;
        this.valor_despesa = valor_despesa;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getData_aquisicao() {
        return data_aquisicao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public void setData_aquisicao(LocalDate data_aquisicao) {
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

    public CategoriaDespesaEnum getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDespesaEnum categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
    
    public LocalDate getDataAquisicaoLocalDate(){
        return data_aquisicao;
    }
}
