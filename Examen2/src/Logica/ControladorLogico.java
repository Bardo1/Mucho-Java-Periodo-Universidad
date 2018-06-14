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
    
    
    
    
    public void ingresarmierda(String nombre,String apellido,int edad){
    
    ControladorPersistencia cp= new ControladorPersistencia();
    
    cp.ingresarmierda(nombre,apellido,edad);
    
    }
}
