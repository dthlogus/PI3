/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.G5.negocio;

import br.com.G5.model.Cartao;
import br.com.G5.persistencia.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import br.com.G5.persistencia.IOperacoesCartao;

/**
 *
 * @author luisg
 */
public abstract class CartaoDal implements IOperacoesCartao{
    private Connection connection ;
    
    public CartaoDal(){
        connection = Conexao.getConnection();
    }
    public abstract boolean sequenciaOrdenacao (Cartao c1, Cartao c2);
    

    @Override
    public void IAdcionar(Cartao cartao) {
         try {
           String sql = "insert into cartao(nome_cartao,bandeira_cartao,numero_cartao,validade_cartao,ccv,limite_cartao,dt_fechamento,dt_vencimento,dt_pagamento) values(?,?,?,?,?,?,?,?,?,?)";
           PreparedStatement ps;
           ps = connection.prepareStatement(sql);
           ps.setString(1, cartao.getTitular());
           ps.setString(2, cartao.getBandeira_Cartao());
           ps.setString(3, cartao.getNumeroDoCartao());
           ps.setDate(4, Date.valueOf(cartao.getValidade()));
           ps.setString(5, cartao.getCcv());
           ps.setDouble(6, cartao.getLimite());
           ps.setDate(7, Date.valueOf(cartao.getData_fechamento()));
           ps.setDate(8, Date.valueOf(cartao.getData_vencimento()));
           ps.setDate(9, Date.valueOf(cartao.getData_pagamento()));
           ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        
    }

    @Override
    public void IExcluirPorId(int id) {
        try {
            String sql = "DELETE FROM cartao WHERE id_cartao = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void IAlterarCartao(Cartao cartao) {
        try {
            String sql = "UPDATE cartao SET nome_cartao = ?, bandeira_cartao = ?,numero_cartao = ?,validade= ?,ccv = ?,limite_cartao = ?,dt_fechamento = ?, dt_vencimento = ?,dt_pagamento = ? WHERE id_cartao = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(10, cartao.getId_cartao());
            ps.setString(1, cartao.getTitular());
            ps.setString(2, cartao.getBandeira_Cartao());
            ps.setString(3, cartao.getNumeroDoCartao());
            ps.setDate(4, Date.valueOf(cartao.getValidade()));
            ps.setString(5, cartao.getCcv());
            ps.setDouble(6, cartao.getLimite());
            ps.setDate(7, Date.valueOf(cartao.getData_fechamento()));
            ps.setDate(8, Date.valueOf(cartao.getData_vencimento()));
            ps.setDate(9, Date.valueOf(cartao.getData_pagamento()));
            ps.executeUpdate();
            
        } catch (SQLException e) {
           e.printStackTrace(); 
        }
    }

    @Override
    public Cartao consultarPorId(int id) {
      Cartao cartao = new Cartao();
        try {
            String sql = "select * from cartao where id_cartao = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                cartao.setId_cartao(rs.getInt("id_cartao"));
                cartao.setTitular(rs.getString("nome_cartao"));
                cartao.setBandeira_Cartao(rs.getString("bandeira_cartao"));
                cartao.setNumeroDoCartao(rs.getString("numero_cartao"));
                cartao.setValidade(rs.getDate("validade_cartao").toLocalDate());
                cartao.setCcv(rs.getString("ccv"));
                cartao.setLimite(rs.getDouble("limite_cartao"));
                cartao.setData_fechamento(rs.getDate("dt_fechamento").toLocalDate());
                cartao.setData_vencimento(rs.getDate("dt_vencimento").toLocalDate());
                cartao.setData_pagamento(rs.getDate("dt_pagamento").toLocalDate());
            
                
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartao;
    }

    @Override
    public ArrayList<Cartao> listagem() {
        ArrayList<Cartao> cartoes = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs =statement.executeQuery("select * from cartao");
            while(rs.next()) {
                Cartao cartao = new Cartao();
				cartao.setId_cartao(rs.getInt("id_cartao"));
                                cartao.setTitular(rs.getString("nome_cartao"));
                                cartao.setBandeira_Cartao(rs.getString("bandeira_cartao"));
                                cartao.setNumeroDoCartao(rs.getString("numero_cartao"));
                                cartao.setValidade(rs.getDate("validade_cartao").toLocalDate());
                                cartao.setData_fechamento(rs.getDate("data_fechamento").toLocalDate());
                                cartao.setData_vencimento(rs.getDate("data_vencimento").toLocalDate());
                                cartao.setData_pagamento(rs.getDate("data_pagamento").toLocalDate());
				cartoes.add(cartao);
            }
            
             for(int i = 0; i <cartoes.size();i++ ){
                for(int j = i; j < cartoes.size(); j++){
                    if(!sequenciaOrdenacao(cartoes.get(i),cartoes.get(j))){
                        Cartao temp = cartoes.get(j);
                        cartoes.set(j, cartoes.get(i));
                        cartoes.set(i, temp);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartoes;
    }
 
            
       
}
