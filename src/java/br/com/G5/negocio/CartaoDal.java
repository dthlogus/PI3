/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.G5.negocio;

import br.com.G5.model.Cartao;
import br.com.G5.persistencia.Conexao;
import br.com.G5.persistencia.IOperacoesCartao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author luisg
 */
public class CartaoDal implements IOperacoesCartao{
    private Connection connection ;
    
    public CartaoDal(){
        connection = Conexao.getConnection();
    }

    @Override
    public void IAdcionar(Cartao cartao) {
         try {
           String sql = "insert into cartao(id_cartao,validade,titular,data_vencimento,data_pagamento,data_fechamento,ccv,limite,parcela) values(?,?,?,?,?,?,?,?,?)";
           PreparedStatement ps;
           ps = connection.prepareStatement(sql);
           ps.setInt(1, cartao.getId_cartao());
           ps.setDate(2, new java.sql.Date(cartao.getValidade().getTime()));
           ps.setString(3, cartao.getTitular());
           ps.setDate(4, new java.sql.Date(cartao.getData_vencimento().getTime()));
           ps.setDate(5, new java.sql.Date(cartao.getData_pagamento().getTime()));
           ps.setDate(6, new java.sql.Date(cartao.getData_fechamento().getTime()));
           ps.setString(7, cartao.getCcv());
           ps.setDouble(8, cartao.getLimite());
           ps.setInt(9,cartao.getParcela());
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
            String sql = "UPDATE cartao SET validade = ?,titular = ?,data_vencimento = ?,data_pagamento = ?,data_fechamento = ?,ccv = ?,limite = ?,parcela = ? WHERE id_cartao = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(cartao.getValidade().getTime()));
            ps.setString(2, cartao.getTitular());
            ps.setDate(3, new java.sql.Date(cartao.getData_vencimento().getTime()));
            ps.setDate(4, new java.sql.Date(cartao.getData_pagamento().getTime()));
            ps.setDate(5, new java.sql.Date(cartao.getData_fechamento().getTime()));
            ps.setString(6,cartao.getCcv());
            ps.setDouble(7, cartao.getLimite());
            ps.setInt(8, cartao.getParcela());
            ps.setInt(9, cartao.getId_cartao());
            ps.executeUpdate();
            
        } catch (SQLException e) {
           e.printStackTrace(); 
        }
    }

    @Override
    public Cartao consultarPorId(int id) {
      Cartao cartao = new Cartao();
        try {
            String sql = "select * from cartao where id_cartao";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                cartao.setId_cartao(rs.getInt("id_cartao"));
                cartao.setValidade(rs.getDate("validade"));
                cartao.setTitular(rs.getString("titular"));
                cartao.setData_vencimento(rs.getDate("data_vencimento"));
                cartao.setData_pagamento(rs.getDate("data_fachamento"));
                cartao.setCcv(rs.getString("ccv"));
                cartao.setLimite(rs.getDouble("limite"));
                cartao.setParcela(rs.getInt("parcela"));
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
                                cartao.setValidade(rs.getDate("validade"));
                                cartao.setTitular(rs.getString("titular"));
                                cartao.setData_vencimento(rs.getDate("data_vencimento"));
                                cartao.setData_pagamento(rs.getDate("data_pagamento"));
                                cartao.setData_fechamento(rs.getDate("data_fechamento"));
                                cartao.setCcv(rs.getString("ccv"));
                                cartao.setLimite(rs.getDouble("limite"));
                                cartao.setParcela(rs.getInt("parcela"));
				cartoes.add(cartao);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartoes;
    }
    
}
