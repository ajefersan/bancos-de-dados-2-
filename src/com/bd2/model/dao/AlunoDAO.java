/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bd2.model.dao;

import com.bd2.ConnectionFactory;
import com.bd2.controler.Aluno;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jeferson
 */
public class AlunoDAO extends ConnectionFactory  {
    
    public void cadastrar(Aluno aluno) throws SQLException
    {   
        
       
        String qr = "INSERT INTO aluno(matricula,nome) VALUES (?,?)";  
                                                                  
          try(PreparedStatement stmt = this.query(qr))
        {
            stmt.setString(1, aluno.getMatricula());
            stmt.setString(2, aluno.getNome());
            stmt.execute();
            stmt.close();
        
               
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
    public void deletar(String matricula){
        
        String qr = "DELETE FROM nota WHERE aluno_matricula = " + matricula;  
                                                                  
          try(PreparedStatement stmt = this.query(qr))
        {
           
            stmt.execute();
            stmt.close();
        
               
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
          
        String qr2 = "DELETE FROM aluno WHERE matricula = " + matricula;  
                                                                  
          try(PreparedStatement stmt = this.query(qr2))
        {
           
            stmt.execute();
            stmt.close();
        
               
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    
    }
    
}
