package br.com.G5.persistencia;

import java.util.ArrayList;

public interface IOperacoes {
     void IAdcionar(Object objeto) throws Exception;
     void IExcluirPorId(int id) throws Exception;
     void IAlterar(Object objeto) throws Exception;
     Object consultarPorId(int id) throws Exception;
     ArrayList<Object> listagem() throws Exception;
}
