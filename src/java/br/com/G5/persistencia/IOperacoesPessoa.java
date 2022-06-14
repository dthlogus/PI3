/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.G5.persistencia;

import br.com.G5.model.Pessoa;
import java.util.ArrayList;

/**
 *
 * @author luisg
 */
public interface IOperacoesPessoa {
     void IAdcionar(Pessoa objeto);
     void IExcluirPorId(int id);
     void IAlterarCartao(Pessoa objeto);
     Pessoa consultarPorId(int id);
     ArrayList<Pessoa> listagem();
    
    
}
