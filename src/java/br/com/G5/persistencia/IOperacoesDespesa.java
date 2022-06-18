/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.G5.persistencia;

import br.com.G5.model.Despesa;
import java.util.List;

/**
 *
 * @author mathe
 */
public interface IOperacoesDespesa {

    void IAdicionar(Despesa despesa);

    void IExcluirPorId(int id);

    void IAlternarDespesa(Despesa despesa);

    Despesa consultaPorId(int id);

    List<Despesa> listagem(int id);
}
