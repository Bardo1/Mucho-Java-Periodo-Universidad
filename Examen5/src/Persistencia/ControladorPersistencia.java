/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.Persona;

/**
 *
 * @author Walter
 */
public class ControladorPersistencia extends ConexionBD {
    
    
    
    
    public Persona buscarpersona(int edad1){
    ConexionBD co= new ConexionBD();
    return buscarpersona1(edad1);  
    }
    
    public void guardarpersona(String nombre, String apellido, int edad){
    ConexionBD co= new ConexionBD();
    co.guardarPersona(nombre,apellido,edad); 
    }
    
    public ArrayList <Persona> getListaPersonas(){
    
   this.conectar();
   
   ArrayList<Persona> listapersona=
   this.cerrar();
     }
   
}
