/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.G5.negocio;

import br.com.G5.model.Contato;
import br.com.G5.persistencia.Conexao;
import br.com.G5.persistencia.IOperacoesContato;
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
public class ContatoDal implements IOperacoesContato{
    private Connection connection;
    
   

    public ContatoDal() {
        connection = Conexao.getConnection();
    }
    

    @Override
    public void IAdcionar(Contato objeto) {
        try {
           String sql = "insert into contato(id_contato,residencial,email,celular) values(?,?,?,?)";
           PreparedStatement ps;
           ps = connection.prepareStatement(sql);
           ps.setInt(1, objeto.getId_contato());
           ps.setString(2,objeto.getTel_residencial());
           ps.setString(3,objeto.getEmail());
           ps.setString(4,objeto.getTel_celular());
           ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            
        }   
    }

    @Override
    public void IExcluirPorId(int id) {
        try {
            String sql = "DELETE FROM contato WHERE id_contato= ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void IAlterarContato(Contato objeto) {
        try {
            String sql = "UPDATE contato SET residencial = ?,email = ?,celular = ? WHERE id_contato = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,objeto.getTel_residencial());
            ps.setString(2, objeto.getEmail());
            ps.setString(3, objeto.getTel_celular());
            ps.setInt(6, objeto.getId_contato());
            ps.executeUpdate();
            
        } catch (SQLException e) {
           e.printStackTrace(); 
        }
    }

    @Override
    public Contato consultarPorId(int id) {
       Contato contato = new Contato();
          try {
            String sql = "select * from contato where id_contato";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                contato.setId_contato(rs.getInt("id_contato"));
                contato.setTel_residencial(rs.getString("residencial"));
                contato.setEmail(rs.getString("email"));
                contato.setTel_celular(rs.getString("celular"));
             
               
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contato;
      
       
    }

    @Override
    public ArrayList<Contato> listagem() {
       ArrayList<Contato> contatos = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs =statement.executeQuery("select * from endereco");
            while(rs.next()) {
                Contato contato = new Contato();
				contato.setId_contato(rs.getInt("id_contato"));
                                contato.setTel_residencial(rs.getString("residencial"));
                                contato.setEmail(rs.getString("email"));
                                contato.setTel_celular(rs.getString("celular"));
                             
				contatos.add(contato);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contatos;
    }
    
}
