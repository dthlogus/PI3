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
public class CartaoDal implements IOperacoesCartao {

    private Connection connection;

    public CartaoDal() {
        connection = Conexao.getConnection();
    }

    @Override
    public void IAdcionar(Cartao cartao) {
        try {
            String sql = "INSERT INTO cartao(nome_cartao,bandeira_cartao,numero_cartao,validade_cartao,limite_cartao,dt_fechamento,dt_vencimento,dt_pagamento,ccv,id_pessoa) VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps;
            ps = connection.prepareStatement(sql);
            ps.setString(1, cartao.getNome_cartao());
            ps.setString(2, cartao.getBandeira_cartao());
            ps.setString(3, cartao.getNumero_cartao());
            ps.setDate(4, Date.valueOf(cartao.getValidadeLocalDate()));
            ps.setDouble(5, cartao.getLimite());
            ps.setDate(6, Date.valueOf(cartao.getData_fechamento()));
            ps.setDate(7, Date.valueOf(cartao.getData_vencimento()));
            ps.setDate(8, Date.valueOf(cartao.getData_pagamento()));
            ps.setString(9, cartao.getCcv());
            ps.setInt(10, cartao.getId_pessoa());
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
            String sql = "UPDATE cartao SET nome_cartao = ?, bandeira_cartao = ?,numero_cartao = ?,validade_cartao= ?,limite_cartao = ?,dt_fechamento = ?, dt_vencimento = ?,dt_pagamento = ?,ccv = ? WHERE id_cartao = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setString(1, cartao.getNome_cartao());
            ps.setString(2, cartao.getBandeira_cartao());
            ps.setString(3, cartao.getNumero_cartao());
            ps.setDate(4, Date.valueOf(cartao.getValidadeLocalDate()));
            ps.setDouble(5, cartao.getLimite());
            ps.setDate(6, Date.valueOf(cartao.getData_fechamento()));
            ps.setDate(7, Date.valueOf(cartao.getData_vencimento()));
            ps.setDate(8, Date.valueOf(cartao.getData_pagamento()));
            ps.setString(9, cartao.getCcv());
            ps.setInt(10, cartao.getId_cartao());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cartao consultarPorId(int id) {
        Cartao cartao = new Cartao();
        try {
            String sql = "SELECT * FROM cartao WHERE id_cartao = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cartao.setId_cartao(rs.getInt("id_cartao"));
                cartao.setNome_cartao(rs.getString("nome_cartao"));
                cartao.setBandeira_cartao(rs.getString("bandeira_cartao"));
                cartao.setNumero_cartao(rs.getString("numero_cartao"));
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
    public ArrayList<Cartao> listagem(int id) {
        ArrayList<Cartao> cartoes = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM cartao");
            while (rs.next()) {
                Cartao cartao = new Cartao();
                cartao.setId_cartao(rs.getInt("id_cartao"));
                cartao.setNome_cartao(rs.getString("nome_cartao"));
                cartao.setBandeira_cartao(rs.getString("bandeira_cartao"));
                cartao.setNumero_cartao(rs.getString("numero_cartao"));
                cartao.setValidade(rs.getDate("validade_cartao").toLocalDate());
                cartao.setLimite(rs.getDouble("limite_cartao"));
                cartao.setCcv(rs.getString("ccv"));
                cartao.setData_fechamento(rs.getDate("dt_fechamento").toLocalDate());
                cartao.setData_vencimento(rs.getDate("dt_vencimento").toLocalDate());
                cartao.setData_pagamento(rs.getDate("dt_pagamento").toLocalDate());
                cartao.setId_pessoa(rs.getInt("id_pessoa"));
                cartoes.add(cartao);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartoes;
    }

}
