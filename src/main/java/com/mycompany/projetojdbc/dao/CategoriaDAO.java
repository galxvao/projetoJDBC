/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetojdbc.dao;

import com.mycompany.projetojdbc.ConexaoDB;
import com.mycompany.projetojdbc.entities.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    
    public Categoria buscarCategotiaPorId(int id) throws SQLException {
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
}