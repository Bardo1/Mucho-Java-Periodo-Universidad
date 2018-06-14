/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.ControladorPersistencia;

/**
 *
 * @author Walter
 */
public class ControladorLogico {
   
    
    
    
    public Persona buscarpersona(int edad1){
    ControladorPersistencia cp= new ControladorPersistencia();
    return cp.buscarpersona(edad1);
    
    }
    public void guardarpersona(String nombre, String apellido, int edad){
    ControladorPersistencia cp= new ControladorPersistencia();
    cp.guardarPersona(nombre,apellido,edad); 
    }
    
    
    }
}
