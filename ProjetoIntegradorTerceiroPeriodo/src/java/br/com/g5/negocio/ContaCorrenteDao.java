/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.g5.negocio;

import br.com.g5.model.Conta;
import br.com.g5.persistencia.Conexao;
import br.com.g5.persistencia.OperacoesConta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicholas
 */
public class ContaCorrenteDao extends OperacoesConta {

    private Connection connection;

    //obter instância da conexão/sessão ativa
    public ContaCorrenteDao() {
        this.connection = Conexao.getConnection();
    }

    @Override
    public void adicionarConta(Conta cc) {
        try {
            String sql = "INSERT INTO conta_corrente(nome_titular, nome_banco, numero_contacorrente, limite_contacorrente) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cc.getNomeTitular());
            ps.setString(2, cc.getNomeBanco());
            ps.setInt(3, cc.getNumeroConta());
            ps.setDouble(4, cc.getLimiteConta());
            ps.executeUpdate();
        } catch (SQLException erro) {
            Logger.getLogger(ContaCorrenteDao.class.getName()).log(Level.SEVERE, null, erro);
        }
    }

    @Override
    public void excluirConta(int id) {
        try {
            String sql = "DELETE FROM conta_corrente WHERE id_contacorrente = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException erro) {
            Logger.getLogger(ContaCorrenteDao.class.getName()).log(Level.SEVERE, null, erro);
        }
    }

    @Override
    public void alterarConta(Conta cc) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE conta_corrente SET nome_titular = ?, nome_banco = ?, numero_contacorrente = ?, limite_contacorrente = ? WHERE id_contacorrente = ?");
            ps.setString(1, cc.getNomeTitular());
            ps.setString(2, cc.getNomeBanco());
            ps.setInt(3, cc.getNumeroConta());
            ps.setDouble(4, cc.getLimiteConta());
            ps.executeQuery();
        
        } catch (SQLException erro) {
            Logger.getLogger(ContaCorrenteDao.class.getName()).log(Level.SEVERE, null, erro);
        }
    }

    @Override
    public Conta consultarPorId(int id) {
        Conta cc = new Conta();

        try {
            String sql = "SELECT * FROM conta_corrente WHERE id_contacorrente = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cc.setIdConta(rs.getInt("id_contacorrente"));
                cc.setNomeTitular(rs.getString("nome_titular"));
                cc.setNomeBanco(rs.getString("nome_banco"));
                cc.setNumeroConta(rs.getInt("numero_contacorrente"));
                cc.setLimiteConta(rs.getDouble("limite_contacorrente"));
            }
        } catch (SQLException erro) {
            Logger.getLogger(ContaCorrenteDao.class.getName()).log(Level.SEVERE, null, erro);
        }
        return cc;
    }

    @Override
    public List<Conta> listagem() {
        List<Conta> listaContaCorrente = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM conta_corrente");
            while (rs.next()) {
                Conta cc = new Conta();
                cc.setIdConta(rs.getInt("id_contacorrente"));
                cc.setNomeTitular(rs.getString("nome_titular"));
                cc.setNomeBanco(rs.getString("nome_banco"));
                cc.setNumeroConta(rs.getInt("numero_contacorrente"));
                cc.setLimiteConta(rs.getDouble("limite_contacorrente"));
                listaContaCorrente.add(cc);
            }
            }catch (SQLException erro) {
            Logger.getLogger(ContaCorrenteDao.class.getName()).log(Level.SEVERE, null, erro); 
            }
         return listaContaCorrente;
        }
    }