/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projetojdbc;

import com.mycompany.projetojdbc.dao.CategoriaDAO;
import com.mycompany.projetojdbc.entities.Categoria;
import com.mycompany.projetojdbc.dao.FilmeDAO;
import com.mycompany.projetojdbc.entities.Categoria;
import java.sql.SQLException;



/**
 *
 * @author davi_galvao
 */
public class ProjetoJdbc {

    public static void main(String[] args) {
        try {
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            FilmeDAO filmeDAO = new FilmeDAO();
            
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
            
            Categoria catBuscada = categoriaDAO.buscarCategotiaPorId(2);
     
            System.out.println("Id: " + catBuscada.getId() + "\nNome: " + catBuscada.getNome());
            
        }catch (SQLException e){
            System.err.print("\nAlgo errado aconteceu com a manipulação do DB");
        }
    }
}
