/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.ControladorPersistencia;
import java.util.HashMap;

/**
 *
 * @author Walter
 */
public class Estudiante {
 
    String NumMatricula;
    String NumPatente;
    
    public Estudiante(String NumMatricula,String NumPatente){
    
        this.NumMatricula=NumMatricula;
        this.NumPatente=NumPatente;      
    }
    
    public void Guarda(){
    ControladorPersistencia cp= new ControladorPersistencia();
    HashMap Datos= ToCollection();
    cp.GuardaEstudiante(Datos);
    
    }
    
    
    public HashMap ToCollection(){
     
    HashMap Datos = new HashMap();
    Datos.put("NumMatricula", this.NumMatricula);
    Datos.put("NumPatente", this.NumPatente);
    return Datos;
    }
    
    
    
}
