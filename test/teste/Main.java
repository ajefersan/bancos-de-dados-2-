/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import com.bd2.controler.Aluno;
import com.bd2.controler.Nota;
import com.bd2.model.dao.AlunoDAO;
import com.bd2.model.dao.NotaDAO;
import java.sql.SQLException;

/**
 *
 * @author jeferson
 */
public class Main {
    public static void main(String[] args) throws SQLException{
    
        Aluno aluno = new Aluno();
        
        /*aluno.setMatricula("1234568");
        aluno.setNome("nome");
        
        AlunoDAO teste = new AlunoDAO();
        
       teste.cadastrar(aluno);
        Nota nota = new Nota();
       
       nota.setMatricula("1234568");
       nota.setNota(9);
       
       NotaDAO n = new NotaDAO();
       n.cadastrar(nota);
        
        */
         
        AlunoDAO teste = new AlunoDAO();
        
        teste.deletar("1234568");
       
   
       
       
       
       
       
    
    
    
    }
}
