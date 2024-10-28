/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetojdbc.dao;

import com.mycompany.projetojdbc.ConexaoDB;//ok
import com.mycompany.projetojdbc.entities.Categoria;//ok
import java.sql.Connection;//ok
import java.sql.PreparedStatement;//ok
import java.sql.ResultSet;//ok
import java.sql.SQLException;//ok
import java.sql.Statement;//ok
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author davi_galvao
 */
public class CategoriaDAO {
        // Create
    public void inserirCategoria(Categoria categoria) throws SQLException {
        String sql = "INSERT INTO Categoria (nome) VALUES (?)";
        try (Connection conn = ConexaoDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, categoria.getNome());
            stmt.executeUpdate();

            // Capturar o ID gerado automaticamente
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    categoria.setId(generatedKeys.getInt(1));  // Definir o ID no objeto Categoria
                } else {
                    throw new SQLException("Falha ao inserir categoria, nenhum ID gerado.");
                }
            }

        }
    }
    
    public Categoria buscarCategoriaPorId(int id) throws SQLException {
        String sql = "SELECT * FROM Categoria WHERE id = ?";
        try (Connection conn = ConexaoDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Categoria(rs.getInt("id"), rs.getString("nome"));
            }
        }
        return null;    
}
      // Novo método  para buscar categoria por nome
    public Categoria buscarCategoriaPorNome(String nome) throws SQLException {
        String sql = "SELECT * FROM Categoria WHERE nome = ?";
        try (Connection conn = ConexaoDB.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Categoria(rs.getInt("id"), rs.getString("nome"));
            }
        }
        return null;
    }
    
     public List<Categoria> listarCategorias() throws SQLException {
        String sql = "SELECT * FROM Categoria";
        List<Categoria> categorias = new ArrayList<>();
        try (Connection conn = ConexaoDB.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql); 
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                categorias.add(new Categoria(rs.getInt("id"), rs.getString("nome")));
            }
        }
        return categorias;
    }
     
       // Update
    public void atualizarCategoria(Categoria categoria) throws SQLException {
        String sql = "UPDATE Categoria SET nome = ? WHERE id = ?";
        try (Connection conn = ConexaoDB.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, categoria.getNome());
            stmt.setInt(2, categoria.getId());
            stmt.executeUpdate();
        }
    }
    
      // Delete
    public void deletarCategoria(int id) throws SQLException {
        String sql = "DELETE FROM Categoria WHERE id = ?";
        try (Connection conn = ConexaoDB.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

}