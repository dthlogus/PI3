/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.G5.persistencia;

import br.com.G5.model.Receita;
import java.util.List;

/**
 *
 * @author mathe
 */
public interface IOperacoesReceita {

    void IAdicionar(Receita receita);

    void IExcluirPorId(int id);

    void IAlternarReceita(Receita receita);

    Receita consultaPorId(int id);

    List<Receita> listagem(int id);
}
