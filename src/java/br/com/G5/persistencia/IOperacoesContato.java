/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.G5.persistencia;

import br.com.G5.model.Contato;
import java.util.ArrayList;

/**
 *
 * @author luisg
 */
public interface IOperacoesContato {
     void IAdcionar(Contato objeto);
     void IExcluirPorId(int id);
     void IAlterarContato(Contato objeto);
     Contato consultarPorId(int id);
     ArrayList<Contato> listagem();
}
