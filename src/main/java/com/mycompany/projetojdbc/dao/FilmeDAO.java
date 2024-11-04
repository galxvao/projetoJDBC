/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetojdbc.dao;

import com.mycompany.projetojdbc.ConexaoDB;
import com.mycompany.projetojdbc.entities.Filme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author davi_galvao
 */
public class FilmeDAO {
    public void inserirFilme(Filme filme) throws SQLException {
    String sql = "INSERT INTO Filme (nome) VALUES (?)";
    
    try (Connection conn = ConexaoDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        stmt.setString(1, filme.getTitulo());
        stmt.executeUpdate();

        // Capturar o ID gerado automaticamente
        try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                filme.setId(generatedKeys.getInt(1)); // Definir o ID no objeto Categoria
            } else {
                throw new SQLException("Falha ao inserir filme, nenhum ID gerado.");
            }
        }
    }
}
    
}
