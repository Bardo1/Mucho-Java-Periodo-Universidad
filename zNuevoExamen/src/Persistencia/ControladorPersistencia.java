/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.Persona;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Walter
 */
public class ControladorPersistencia extends ConexionBD {

    
    
   
   public void IngresarDatos(String nombre, String apellido, int edad){
    ControladorPersistencia cp= new ControladorPersistencia();
    
    cp.IngresarDatosBASE(nombre,apellido,edad);
}

     public ArrayList<Persona> damelistapersonas1(){
         
      ConexionBD cone= new ConexionBD();
      ArrayList<Persona> listado= new ArrayList<Persona>();
       
       ArrayList<HashMap> lista= cone.damelistapersonas();
       for (int i=0; i<lista.size();i++){
       HashMap objeto= lista.get(i);
       String nombre=(String)objeto.get("nombre");
       String apellido=(String)objeto.get("apellido");
       int edad=(Integer)objeto.get("edad");
       Persona P= new Persona(nombre,apellido,edad);
       listado.add(P);
       }
     
     return listado;
     }
     
   
    
}
