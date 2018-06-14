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
public class ControladorLogica {
    
    
    public void  IngresarValores(String nombre,String apellido,int edad){
    
    ControladorPersistencia cp= new ControladorPersistencia();
     cp.IngresarValores(nombre,apellido,edad);
    
    }
    
  
    
    public Persona  buscaydespliega(int edad){
    
     ControladorPersistencia cp= new ControladorPersistencia();
     return cp.buscaydespliega(edad);
    
    }
    
    public ArrayList<Persona> BuscarPersonas(){
    
        ControladorPersistencia cp= new ControladorPersistencia();
    
        return cp.getListaPersonas();
    
    }
    
    
   
    
    
}
