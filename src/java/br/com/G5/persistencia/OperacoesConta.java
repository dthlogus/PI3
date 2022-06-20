/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.G5.persistencia;

import br.com.G5.model.Conta;
import java.util.List;

/**
 *
 * @author luisg
 */
public abstract class OperacoesConta {
    public abstract void adicionarConta(Conta conta);
    public abstract void excluirConta(int id);
    public abstract void alterarConta(Conta conta);
    public abstract Conta consultarPorId(int id);
    public abstract List<Conta> listagem(int i);
    
}
