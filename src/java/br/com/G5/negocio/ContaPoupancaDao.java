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
public class ContaPoupancaDao extends OperacoesConta {

    private Connection connection;

    //obter instância da conexão/sessão ativa
    public ContaPoupancaDao() {
        this.connection = Conexao.getConnection();
    }

    @Override
    public void adicionarConta(Conta cp) {
        try {
            String sql = "INSERT INTO conta_poupanca(nome_titular, nome_banco, numero_contapoupanca, limite_contapoupanca, id_pessoa) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cp.getNomeTitular());
            ps.setString(2, cp.getNomeBanco());
            ps.setInt(3, cp.getNumeroConta());
            ps.setDouble(4, cp.getLimiteConta());
            ps.setInt(5, cp.getId_pessoa());
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
            PreparedStatement ps = connection.prepareStatement("UPDATE conta_poupanca SET nome_titular = ?, nome_banco = ?, "
                    + "numero_contapoupanca = ?, limite_contapoupanca = ? WHERE id_contapoupanca = ?");
            ps.setString(1, cp.getNomeTitular());
            ps.setString(2, cp.getNomeBanco());
            ps.setInt(3, cp.getNumeroConta());
            ps.setDouble(4, cp.getLimiteConta());
            ps.setInt(5, cp.getIdConta());
            ps.executeUpdate();

        } catch (SQLException erro) {
            Logger.getLogger(ContaPoupancaDao.class.getName()).log(Level.SEVERE, null, erro);
        }

    }

    @Override
    public Conta consultarPorId(int id) {
        Conta cp = new Conta();

        try {
            String sql = "SELECT * FROM conta_poupanca WHERE id_contapoupanca = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cp.setIdConta(rs.getInt("id_contapoupanca"));
                cp.setNomeTitular(rs.getString("nome_titular"));
                cp.setNomeBanco(rs.getString("nome_banco"));
                cp.setNumeroConta(rs.getInt("numero_contapoupanca"));
                cp.setLimiteConta(rs.getDouble("limite_contapoupanca"));
                cp.setId_pessoa(rs.getInt("id_pessoa"));
            }
        } catch (SQLException erro) {
            Logger.getLogger(ContaPoupancaDao.class.getName()).log(Level.SEVERE, null, erro);
        }
        return cp;
    }

    @Override
    public List<Conta> listagem(int i) {
        List<Conta> listaContaPoupanca = new ArrayList<>();
        try {
            String sql = "SELECT * FROM conta_poupanca WHERE id_pessoa = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, i);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Conta cp = new Conta();
                cp.setIdConta(rs.getInt("id_contapoupanca"));
                cp.setNomeTitular(rs.getString("nome_titular"));
                cp.setNomeBanco(rs.getString("nome_banco"));
                cp.setNumeroConta(rs.getInt("numero_contapoupanca"));
                cp.setLimiteConta(rs.getDouble("limite_contapoupanca"));
                cp.setId_pessoa(rs.getInt("id_pessoa"));
                listaContaPoupanca.add(cp);
            }
        } catch (SQLException erro) {
            Logger.getLogger(ContaPoupancaDao.class.getName()).log(Level.SEVERE, null, erro);
        }
        return listaContaPoupanca;
    }

}
