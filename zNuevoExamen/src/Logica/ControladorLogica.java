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
    
     public void IngresarDatos(String nombre, String apellido, int edad){
        ControladorPersistencia cp= new ControladorPersistencia();
    
    cp.IngresarDatos(nombre,apellido,edad);
}
     
     public ArrayList<Persona> damelistapersonas(){
       ControladorPersistencia cp= new ControladorPersistencia();
     
     return cp.damelistapersonas1();
     }
     
     
}
