/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.G5.negocio;

import br.com.G5.model.Despesa;
import br.com.G5.model.Enum.CategoriaDespesaEnum;
import br.com.G5.persistencia.Conexao;
import br.com.G5.persistencia.IOperacoesDespesa;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mathe
 */
public class DespesaDal implements IOperacoesDespesa {

    private Connection con;

    public DespesaDal() {
        con = Conexao.getConnection();
    }

    @Override
    public void IAdicionar(Despesa despesa) {
        try {
            String sql = "INSERT INTO despesa(nome_despesa,valor_despesa,dt_aquisicao,parcela_total,"
                    + "parcela_atual,despesa_repetitiva,categoria_despesa,descricao_despesa,id_pessoa) "
                    + "VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, despesa.getNome());
            ps.setDouble(2, despesa.getValor_despesa());
            if (despesa.getData_aquisicao() == null) {
                ps.setDate(3, Date.valueOf(LocalDate.now()));
            } else {
                ps.setDate(3, Date.valueOf(despesa.getData_aquisicao()));
            }
            if (despesa.getParcela_atual() == 0 || despesa.getParcela_total() == 0) {
                ps.setInt(4, 0);
                ps.setInt(5, 0);
            } else {
                ps.setInt(4, despesa.getParcela_total());
                ps.setInt(5, despesa.getParcela_atual());
            }
            ps.setBoolean(6, despesa.isRepetitivo());
            ps.setString(7, despesa.getCategoria().toString());
            ps.setString(8, despesa.getDescricao());
            ps.setInt(9, despesa.getId_pessoa());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void IExcluirPorId(int id) {
        try {
            String sql = "DELETE FROM despesa WHERE id_despesa = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(0, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void IAlternarDespesa(Despesa despesa) {
        try {
            String sql = "UPDATE despesa SET nome_despesa = ?,valor_despesa = ?,dt_aquisicao = ?,"
                    + "parcela_total = ?,parcela_atual = ?,despesa_repetitiva = ?,categoria_despesa = ?,descricao_despesa = ?, id_pessoa "
                    + "WHERE id_despesa = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, despesa.getNome());
            ps.setDouble(2, despesa.getValor_despesa());
            ps.setDate(3, Date.valueOf(despesa.getData_aquisicao()));
            ps.setInt(4, despesa.getParcela_total());
            ps.setInt(5, despesa.getParcela_atual());
            ps.setBoolean(6, despesa.isRepetitivo());
            ps.setString(7, despesa.getCategoria().toString());
            ps.setString(8, despesa.getDescricao());
            ps.setInt(9, despesa.getId_pessoa());
            ps.setInt(10, despesa.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Despesa consultaPorId(int id) {
        Despesa despesa = new Despesa();
        try {
            String sql = "SELECT * FROM despesa WHERE id_despesa = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                despesa.setId(rs.getInt("id_despesa"));
                despesa.setNome(rs.getString("nome_despesa"));
                despesa.setValor_despesa(rs.getDouble("valor_despesa"));
                despesa.setData_aquisicao(rs.getDate("dt_aquisicao").toLocalDate());
                despesa.setParcela_total(rs.getInt("parcela_total"));
                despesa.setParcela_atual(rs.getInt("parcela_atual"));
                despesa.setRepetitivo(rs.getBoolean("despesa_repetitiva"));
                despesa.setCategoria(CategoriaDespesaEnum.valueOf(rs.getString("categoria_despesa")));
                despesa.setDescricao(rs.getString("descricao_despesa"));
                despesa.setId_pessoa(rs.getInt("id_pessoa"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return despesa;
    }

    @Override
    public List<Despesa> listagem(int id) {
        List<Despesa> despesas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM despesa WHERE id_pessoa = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Despesa despesa = new Despesa();
                despesa.setId(rs.getInt("id_despesa"));
                despesa.setNome(rs.getString("nome_despesa"));
                despesa.setValor_despesa(rs.getDouble("valor_despesa"));
                despesa.setData_aquisicao(rs.getDate("dt_aquisicao").toLocalDate());
                despesa.setParcela_total(rs.getInt("parcela_total"));
                despesa.setParcela_atual(rs.getInt("parcela_atual"));
                despesa.setRepetitivo(rs.getBoolean("despesa_repetitiva"));
                despesa.setCategoria(CategoriaDespesaEnum.valueOf(rs.getString("categoria_despesa")));
                despesa.setDescricao(rs.getString("descricao_despesa"));
                despesa.setId_pessoa(rs.getInt("id_pessoa"));
                despesas.add(despesa);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return despesas;
    }

}
