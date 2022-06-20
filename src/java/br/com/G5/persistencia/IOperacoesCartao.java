package br.com.G5.persistencia;

import java.util.ArrayList;
import br.com.G5.model.Cartao;

public interface IOperacoesCartao {
     void IAdcionar(Cartao objeto);
     void IExcluirPorId(int id);
     void IAlterarCartao(Cartao objeto);
     Cartao consultarPorId(int id);
     ArrayList<Cartao> listagem(int id);
}
