/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.G5.negocio;

import br.com.G5.model.Pessoa;
import br.com.G5.persistencia.Conexao;
import br.com.G5.persistencia.IOperacoesPessoa;
import br.com.G5.validation.validaCPF;
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
public class PessoaDal implements IOperacoesPessoa {

    private Connection connection;

    public PessoaDal() {
        connection = Conexao.getConnection();
    }

    @Override
    public void IAdcionar(Pessoa objeto) throws SQLException {
        String sql = "insert into pessoa(nome_completo,cpf_pessoa,email,senha) values(?,?,?,?)";
        PreparedStatement ps;
        ps = connection.prepareStatement(sql);
        if (validaCPF.isCPF(objeto.getCpf())) {
            ps.setString(1, objeto.getNome_completo());
            ps.setString(2, objeto.getCpf());
            ps.setString(3, objeto.getEmail());
            ps.setString(4, objeto.getSenha());
            ps.executeUpdate();
        } else {
            throw new SQLException();
        }
    }

    @Override
    public void IExcluirPorId(int id) {
        try {
            String sql = "DELETE FROM pessoa WHERE id_pessoa= ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void IAlterarPessoa(Pessoa objeto) {
        try {
            String sql = "UPDATE pessoa SET nome_completo = ?,cpf_pessoa = ?,email = ?,senha = ? WHERE id_pessoa = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, objeto.getNome_completo());
            ps.setString(2, objeto.getCpf());
            ps.setString(3, objeto.getEmail());
            ps.setString(4, objeto.getSenha());
            ps.setInt(5, objeto.getId_pessoa());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Pessoa consultarPorCpf(Pessoa pessoa) throws SQLException {
        Pessoa pessoaBanco = new Pessoa();
        String sql = "select * from pessoa where cpf_pessoa = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, pessoa.getCpf());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            pessoaBanco.setId_pessoa(rs.getInt("id_pessoa"));
            pessoaBanco.setNome_completo(rs.getString("nome_completo"));
            pessoaBanco.setCpf(rs.getString("cpf_pessoa"));
            pessoaBanco.setEmail(rs.getString("email"));
            pessoaBanco.setSenha(rs.getString("senha"));
        }
        if (pessoaBanco.getSenha().equals(pessoa.getSenha())) {
            return pessoaBanco;
        } else {
            throw new SQLException();
        }
    }

    @Override
    public ArrayList<Pessoa> listagem() {
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from pessoa");
            while (rs.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setId_pessoa(rs.getInt("id_pessoa"));
                pessoa.setNome_completo(rs.getString("nome_completo"));
                pessoa.setCpf(rs.getString("cpf_pessoa"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setSenha("senha");
                pessoas.add(pessoa);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pessoas;
    }

}
