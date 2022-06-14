/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.G5.negocio;

import br.com.G5.model.Cartao;
import br.com.G5.model.Pessoa;
import br.com.G5.persistencia.Conexao;
import br.com.G5.persistencia.IOperacoesPessoa;
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
    
     public PessoaDal(){
        connection = Conexao.getConnection();
    }

    @Override
    public void IAdcionar(Pessoa objeto) {
          try {
           String sql = "insert into pessoa(id_pessoa,nome_completo,cpf,usuario,senha) values(?,?,?,?,?,?)";
           PreparedStatement ps;
           ps = connection.prepareStatement(sql);
           ps.setInt(1, objeto.getId_pessoa());
           ps.setString(2,objeto.getNome_completo());
           ps.setString(3,objeto.getCpf());
           ps.setString(4,objeto.getUsuario());
           ps.setString(5,objeto.getSenha());
           ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            
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
    public void IAlterarCartao(Pessoa objeto) {
        try {
            String sql = "UPDATE pessoa SET nome_completo = ?,cpf = ?,usuario = ?,senha = ? WHERE id_pessoa = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,objeto.getNome_completo());
            ps.setString(2, objeto.getCpf());
            ps.setString(3, objeto.getUsuario());
            ps.setString(4, objeto.getSenha());
            ps.setInt(9, objeto.getId_pessoa());
            ps.executeUpdate();
            
        } catch (SQLException e) {
           e.printStackTrace(); 
        }
    }

    @Override
    public Pessoa consultarPorId(int id) {
         Pessoa pessoa = new Pessoa();
        try {
            String sql = "select * from pessoa where id_pessoa";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                pessoa.setId_pessoa(rs.getInt("id_pessoa"));
                pessoa.setNome_completo(rs.getString("nome_completo"));
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setUsuario(rs.getString("usuario"));
                pessoa.setSenha(rs.getString("senha"));
               
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pessoa;
    }

    @Override
    public ArrayList<Pessoa> listagem() {
       ArrayList<Pessoa> pessoas = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs =statement.executeQuery("select * from pessoa");
            while(rs.next()) {
                Pessoa pessoa = new Pessoa();
				pessoa.setId_pessoa(rs.getInt("id_pessoa"));
                                pessoa.setNome_completo(rs.getString("nome_completo"));
                                pessoa.setCpf(rs.getString("cpf"));
                                pessoa.setUsuario(rs.getString("usuario"));
                                pessoa.setSenha("senha");
                                
				pessoas.add(pessoa);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pessoas;
    }
    
}
