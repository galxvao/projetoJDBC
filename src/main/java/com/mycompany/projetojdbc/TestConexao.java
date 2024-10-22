/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetojdbc;

import java.sql.Connection;
import java.sql.SQLException;


/**
 *
 * @author davi_galvao
 */
public class TestConexao {
    public static void main(String[] args) {
        Connection conexao = null;
        try {
            // Obtém a conexão com o banco de dados
            conexao = ConexaoDB.getConnection();
            System.out.println("Conexão ao banco de dados bem sucedida");
            conexao.close();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }  
        
        
    }
}
   
