/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

/**
 *
 * @author Walter
 */
public class ControladorPersistencia {
    
    
    
    public void ingresarmierda(String nombre,String apellido,int edad){
    
    ConexionBD cp= new ConexionBD();
    
    cp.ingresarmierda(nombre,apellido,edad);
    
    }
    
    
    
}
