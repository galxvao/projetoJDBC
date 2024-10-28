/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projetojdbc;

import com.mycompany.projetojdbc.dao.CategoriaDAO;
import com.mycompany.projetojdbc.entities.Categoria;
import java.sql.SQLException;
import java.util.List;



/**
 *
 * @author davi_galvao
 */
public class ProjetoJdbc {

    public static void main(String[] args) {
        try {
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            
            //Criar algumas categorias
            Categoria cat1 = new Categoria(0, "Ação");
            Categoria cat2 = new Categoria(0, "Comédia");
            Categoria cat3 = new Categoria(0, "Drama");
            Categoria cat4 = new Categoria(0, "Sci-Fi");
            
            
            // Inserir as categorias no banco 
            categoriaDAO.inserirCategoria(cat1);
            categoriaDAO.inserirCategoria(cat2);
            categoriaDAO.inserirCategoria(cat3);
            categoriaDAO.inserirCategoria(cat4);
            
            
           Categoria catBuscada = categoriaDAO.buscarCategoriaPorId(2);
     
           System.out.println("Id: " + catBuscada.getId() + "\nNome: " + catBuscada.getNome());
           
           // Buscar categoria por ID
            Categoria categoriaBuscada = categoriaDAO.buscarCategoriaPorId(1);
            System.out.println("Categoria ID 1: " + (categoriaBuscada != null ? cat1.getNome() : "Não encontrada"));
            
               // Buscar categoria por ID não existente
            categoriaBuscada = categoriaDAO.buscarCategoriaPorId(100);
            System.out.println("Categoria ID 100: " + (categoriaBuscada != null ? cat1.getNome() : "Não encontrada"));
            
             // Listar todas as categorias
            List<Categoria> categorias = categoriaDAO.listarCategorias();
            System.out.println("Lista de categorias:");
            for (Categoria categoria : categorias) {
                System.out.println("ID: " + categoria.getId() + ", Nome: " + categoria.getNome());
            }
            
             // Atualizar uma categoria
            cat1.setNome("Ação Atualizada");
            categoriaDAO.atualizarCategoria(cat1);
            System.out.println("Categoria ID 1 atualizada para: " + cat1.getNome());
            
              // Deletar uma categoria
            categoriaDAO.deletarCategoria(4);
            System.out.println("Categoria com nome id=4 foi deletada.");
            
            
        }catch (SQLException e) {
            System.err.print("\nAlgo errado aconteceu com a manipulação do DB!");
        }
    }
}
