/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.G5.persistencia;

import br.com.G5.model.Cartao;
import br.com.G5.negocio.CartaoDal;

/**
 *
 * @author luisg
 */
public class OrdenarCartaoPorNumeroCartao extends CartaoDal{

    public OrdenarCartaoPorNumeroCartao(String numCartao) {
        super();
    }
    

    @Override
    public boolean sequenciaOrdenacao(Cartao c1, Cartao c2) {
        return c1.getNumeroDoCartao().compareTo(c2.getNumeroDoCartao()) <= 0;
    }

}
