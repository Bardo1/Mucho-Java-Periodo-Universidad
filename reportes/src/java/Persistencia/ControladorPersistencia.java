/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;



import Logica.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Walter
 */

public class ControladorPersistencia extends ConexionBD {
   
   

   
   public ArrayList NombresDeAutores(String query){
   return NombresDeAutores(query);
   }  
 
   public ArrayList Publicaciones(String query){
   return  NombresPublicaciones(query);
   }  
 
  
     
}
