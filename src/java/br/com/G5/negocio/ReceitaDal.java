/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.G5.negocio;

import br.com.G5.model.Enum.CategoriaReceitaEnum;
import br.com.G5.model.Receita;
import br.com.G5.persistencia.Conexao;
import br.com.G5.persistencia.IOperacoesReceita;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mathe
 */
public class ReceitaDal implements IOperacoesReceita {

    private Connection con;

    public ReceitaDal() {
        con = Conexao.getConnection();
    }

    @Override
    public void IAdicionar(Receita receita) {
        try {
            String sql = "INSERT INTO receita(valor_receita,dt_aquisicao,dt_disponivel,nome_receita,"
                    + "categoria_receita,descricao, id_pessoa) "
                    + "VALUES(?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, receita.getValor_receita());
            if (receita.getDataAquisicaoLocalDate() == null) {
                ps.setDate(2, Date.valueOf(LocalDate.now()));
            } else {
                ps.setDate(2, Date.valueOf(receita.getDataAquisicaoLocalDate()));
            }
            if (receita.getDataDisponivelLocalDate() == null) {
                ps.setDate(3, Date.valueOf(LocalDate.now()));
            } else {
                ps.setDate(3, Date.valueOf(receita.getDataDisponivelLocalDate()));
            }
            ps.setString(4, receita.getNome_receita());
            ps.setString(5, receita.getCategoria().toString());
            ps.setString(6, receita.getDescricao());
            ps.setInt(7, receita.getId_pessoa());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void IExcluirPorId(int id) {
        try {
            String sql = "DELETE FROM receita WHERE id_receita = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void IAlternarReceita(Receita receita) {
        try {
            String sql = "UPDATE receita SET valor_receita = ?,dt_aquisicao = ?,dt_disponivel = ?,"
                    + "nome_receita = ?,categoria_receita = ?,descricao = ?, id_pessoa = ?"
                    + "WHERE id_receita = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, receita.getValor_receita());
            if (receita.getDataAquisicaoLocalDate() == null) {
                ps.setDate(2, Date.valueOf(LocalDate.now()));
            } else {
                ps.setDate(2, Date.valueOf(receita.getDataAquisicaoLocalDate()));
            }
            if (receita.getDataDisponivelLocalDate() == null) {
                ps.setDate(3, Date.valueOf(LocalDate.now()));
            } else {
                ps.setDate(3, Date.valueOf(receita.getDataDisponivelLocalDate()));
            }
            ps.setString(4, receita.getNome_receita());
            ps.setString(5, receita.getCategoria().toString());
            ps.setString(6, receita.getDescricao());
            ps.setInt(7, receita.getId_pessoa());
            ps.setInt(8, receita.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Receita consultaPorId(int id) {
        Receita receita = new Receita();
        try {
            String sql = "SELECT * FROM receita WHERE id_receita = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                receita.setId(rs.getInt("id_receita"));
                receita.setValor_receita(rs.getDouble("valor_receita"));
                receita.setData_aquisicao(rs.getDate("dt_aquisicao").toLocalDate());
                receita.setData_disponivel(rs.getDate("dt_disponivel").toLocalDate());
                receita.setNome_receita(rs.getString("nome_receita"));
                receita.setCategoria(CategoriaReceitaEnum.valueOf(rs.getString("categoria_receita")));
                receita.setDescricao(rs.getString("descricao"));
                receita.setId_pessoa(rs.getInt("id_pessoa"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return receita;
    }

    @Override
    public List<Receita> listagem(int id) {
        List<Receita> receitas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM receita WHERE id_pessoa = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Receita receita = new Receita();
                receita.setId(rs.getInt("id_receita"));
                receita.setValor_receita(rs.getDouble("valor_receita"));
                receita.setData_aquisicao(rs.getDate("dt_aquisicao").toLocalDate());
                receita.setData_disponivel(rs.getDate("dt_disponivel").toLocalDate());
                receita.setNome_receita(rs.getString("nome_receita"));
                receita.setCategoria(CategoriaReceitaEnum.valueOf(rs.getString("categoria_receita")));
                receita.setDescricao(rs.getString("descricao"));
                receita.setId_pessoa(rs.getInt("id_pessoa"));
                receitas.add(receita);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return receitas;
    }

}
