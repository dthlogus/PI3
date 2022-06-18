/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.G5.negocio;

import br.com.G5.model.Conta;
import br.com.G5.persistencia.Conexao;
import br.com.G5.persistencia.OperacoesConta;
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
 * @author luisg
 */
public class ContaPoupancaDao extends OperacoesConta{
    
    private Connection connection;

    //obter instância da conexão/sessão ativa
    public ContaPoupancaDao() {
        this.connection = Conexao.getConnection();
    }

    @Override
    public void adicionarConta(Conta cp) {
        try {
            String sql = "INSERT INTO conta_poupanca(nome_titular, nome_banco, numero_contapoupanca, limite_contapoupanca) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cp.getNomeTitular());
            ps.setString(2, cp.getNomeBanco());
            ps.setInt(3, cp.getNumeroConta());
            ps.setDouble(4, cp.getLimiteConta());
            ps.executeUpdate();
        } catch (SQLException erro) {
            Logger.getLogger(ContaPoupancaDao.class.getName()).log(Level.SEVERE, null, erro);
        }
    }

    @Override
    public void excluirConta(int id) {
        try {
            String sql = "DELETE FROM conta_poupanca WHERE id_contapoupanca = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException erro) {
            Logger.getLogger(ContaPoupancaDao.class.getName()).log(Level.SEVERE, null, erro);
        }
    }

    @Override
    public void alterarConta(Conta cp) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE conta_corrente SET nome_titular = ?, nome_banco = ?, numero_contacorrente = ?, limite_contacorrente = ? WHERE id_contacorrente = ?");
            ps.setString(1, cp.getNomeTitular());
            ps.setString(2, cp.getNomeBanco());
            ps.setInt(3, cp.getNumeroConta());
            ps.setDouble(4, cp.getLimiteConta());
            ps.executeQuery();

        } catch (SQLException erro) {
            Logger.getLogger(ContaPoupancaDao.class.getName()).log(Level.SEVERE, null, erro);
        }
   
    }

    @Override
    public Conta consultarPorId(int id) {
          Conta cp = new Conta();

        try {
            String sql = "SELECT * FROM conta_corrente WHERE id_contacorrente = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cp.setIdConta(rs.getInt("id_contacorrente"));
                cp.setNomeTitular(rs.getString("nome_titular"));
                cp.setNomeBanco(rs.getString("nome_banco"));
                cp.setNumeroConta(rs.getInt("numero_contacorrente"));
                cp.setLimiteConta(rs.getDouble("limite_contacorrente"));
            }
        } catch (SQLException erro) {
            Logger.getLogger(ContaPoupancaDao.class.getName()).log(Level.SEVERE, null, erro);
        }
        return cp;
    }

    @Override
    public List<Conta> listagem() {
       List<Conta> listaContaCorrente = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM conta_corrente");
            while (rs.next()) {
                Conta cp = new Conta();
                cp.setIdConta(rs.getInt("id_contacorrente"));
                cp.setNomeTitular(rs.getString("nome_titular"));
                cp.setNomeBanco(rs.getString("nome_banco"));
                cp.setNumeroConta(rs.getInt("numero_contacorrente"));
                cp.setLimiteConta(rs.getDouble("limite_contacorrente"));
                listaContaCorrente.add(cp);
            }
        } catch (SQLException erro) {
            Logger.getLogger(ContaPoupancaDao.class.getName()).log(Level.SEVERE, null, erro);
        }
        return listaContaCorrente;
    }
    
}
