/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.ControladorPersistencia;
import java.util.ArrayList;

/**
 *
 * @author Walter
 */
public class ControladorLogico {
    
    
    
     
     
     
     public void IngresarValores(String nombre, String apellido, int edad){      
      ControladorPersistencia cp= new ControladorPersistencia();
      cp.IngresarValores(nombre,apellido,edad);  
     }
     public void ModificaValores(String nombre, String apellido, int edad){    
     ControladorPersistencia cp= new ControladorPersistencia();
     cp.ModificaValores(nombre,apellido,edad); 
     }
     public void ElimminarPersona(int edad){
      ControladorPersistencia cp= new ControladorPersistencia();
      cp.ElimminarPersona(edad); 
     }    
     public Persona DespliegaDatos(int edad){
     ControladorPersistencia cp= new ControladorPersistencia();
     return cp.DespliegaDatos(edad); 
     }     
     
     
     public ArrayList <Persona> DamelistaPersonas(){
     ControladorPersistencia cp= new ControladorPersistencia();
     return cp.damelistapersonas1(); 
     
     }
     
     
     
     
}
