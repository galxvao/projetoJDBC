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

//Create 

public class FilmeDAO {
    
    public void inserirFilme(Filme filme) throws SQLException {
    String sql = "INSERT INTO Filme (titulo, ano, diretor, categoriaId) VALUES (?)";
    
    try (Connection conn = ConexaoDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        stmt.setString(1, filme.getTitulo());
        stmt.setInt(1, filme.getId());
        stmt.setInt(1, filme.getAno());
        stmt.setString(1,filme.getDiretor());
        stmt.setInt(1,filme.getCategoriaId());
        stmt.executeUpdate();
        
        
        // Capturar o ID gerado automaticamente
        try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                filme.setId(generatedKeys.getInt(1)); // Definir o ID no objeto Categoria
               filme.setTitulo(filme.getTitulo());
               filme.setAno(filme.getAno());
               filme.setDiretor(filme.getDiretor());
               filme.setCategoriaId(filme.getCategoriaId());
            } else {
                throw new SQLException("Falha ao inserir filme, nenhum ID gerado.");
            }
        }
    }
}
    
        public Filme buscarFilmePorId(int id) throws SQLException {
        String sql = "SELECT * FROM Filme WHERE id = ?";
        try (Connection conn = ConexaoDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Filme(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getInt("ano"),
                    rs.getString("diretor"),
                    rs.getInt("categoriaId")
                );
            }
        }
        return null;    
}
    
    
    
    
    
}
