/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bd2.model.dao;

import com.bd2.ConnectionFactory;
import com.bd2.controler.Nota;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jeferson
 */
public class NotaDAO extends ConnectionFactory {
    
    public void cadastrar(Nota nota) throws SQLException
    {   
        
       
        String qr = "INSERT INTO nota(aluno_matricula,codigo,nota) VALUES (?,?,?)";  
                                                                  
          try(PreparedStatement stmt = this.query(qr))
        {
            stmt.setString(1, nota.getMatricula());
            stmt.setInt(2, nota.getCodigo());
             stmt.setFloat(3, nota.getNota());
            stmt.execute();
            
        
               
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
    public float mediaAluno(String matricula)
    {
            
         float soma = 0;
         int colunas = 0;
         String qr = "SELECT sum(nota) FROM nota WHERE aluno_matricula = " + matricula;
          try (PreparedStatement stmt = this.query(qr)) 
        {
           // stmt.setInt(1,id);
           
            ResultSet rs = stmt.executeQuery();
            rs.next();
             soma = rs.getFloat("sum(nota)");
            
           
        }catch(Exception e ){
            System.out.println(e.getMessage());
        }
          
         String qr2 = "SELECT COUNT(nota) FROM nota WHERE aluno_matricula = " + matricula;
          try (PreparedStatement stmt = this.query(qr2)) 
        {
           // stmt.setInt(1,id);
           
            ResultSet rs = stmt.executeQuery();
            rs.next();
             colunas = rs.getInt("COUNT(nota)");
            
           
        }catch(Exception e ){
            System.out.println(e.getMessage());
        }
          
         return soma/colunas;
    
        

    }
    
    public float mediaTotal()
    {
            
         float soma = 0;
         int colunas = 0;
         String qr = "SELECT sum(nota) FROM nota ";
          try (PreparedStatement stmt = this.query(qr)) 
        {
           // stmt.setInt(1,id);
           
            ResultSet rs = stmt.executeQuery();
            rs.next();
             soma = rs.getFloat("sum(nota)");
            
           
        }catch(Exception e ){
            System.out.println(e.getMessage());
        }
           String qr2 = "SELECT COUNT(nota) FROM nota ";
          try (PreparedStatement stmt = this.query(qr2)) 
        {
           // stmt.setInt(1,id);
           
            ResultSet rs = stmt.executeQuery();
            rs.next();
             colunas = rs.getInt("COUNT(nota)");
            
           
        }catch(Exception e ){
            System.out.println(e.getMessage());
        }
          
        return soma/colunas;
    
        

    }
}
