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
   
   

   
   public int ContarPublicacionAutorAnioJournal(String autor,int anio){
   return ContarPublicacionAutorAnioJournal1(autor,anio);
   }  
   public int ContarPublicacionAutorAnioArticulo(String autor,int anio){
   return ContarPublicacionAutorAnioArticulo1(autor,anio);
   }
   public int ContarPublicacionAutorAnioLibro(String autor,int anio){
   return ContarPublicacionAutorAnioLibro1(autor,anio);
   }
   public int ContarPublicacionTipoAnio(String tipo,int anio){
   return ContarPublicacionTipoAnio1(tipo, anio);
   }
   public int contarpublicacionTodoOtroindice1(int anio){
   return contarpublicacionTodoOtroindice2(anio);
   }
 
  
     
}
