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
public class ControladorPersistencia extends Conexionbd {
    
    
    
    
    
     public void IngresarValores(String nombre, String apellido, int edad){
     Conexionbd n= new Conexionbd();
     this.IngresarValores1(nombre,apellido,edad); 
     }
    
     public void ModificaValores(String nombre, String apellido, int edad){
     Conexionbd n= new Conexionbd();
     n.ModificaValores(nombre,apellido,edad); 
     }
     
     public void ElimminarPersona(int edad){
     Conexionbd n= new Conexionbd();
     n.EliminarPersona(edad); 
     }
     
     public Persona DespliegaDatos(int edad){ 
     Conexionbd n= new Conexionbd();
     return n.DespliegaDatos(edad); 
     }     
     
     public ArrayList <Persona> DamelistaPersonas(){
     Conexionbd n= new Conexionbd();
     ArrayList <Persona> lista= new ArrayList<Persona>();
     
//     ArrayList<HashMap> listaObjetos= n.DamelistaPersonas();
      
     return lista;
     }
     
  public ArrayList<Persona> DamelistaPersonas1(){
    
     ArrayList<Persona> listaLibros= new ArrayList<Persona>();
       if (this.conectar())
       {
          
            ArrayList<HashMap> listaDb= this.damelistapersonas();
            for (int i=0 ; i< listaDb.size();i++){
                 HashMap registro= listaDb.get(i);
                 Persona libro= new Persona((String) registro.get("nombre"),(String)registro.get("apellido"),Integer.parseInt((String)registro.get("edad")));
                 listaLibros.add(libro);
            }     
        }  
       
       
       return listaLibros;
    }
  
   public ArrayList<Persona> damelistapersonas1(){
         
      Conexionbd cone= new Conexionbd();
      ArrayList<Persona> listado= new ArrayList<Persona>();
       
       ArrayList<HashMap> lista= cone.damelistapersonas();
       for (int i=0; i<lista.size();i++){
       HashMap objeto= lista.get(i);
       String nombre=(String)objeto.get("nombre");
       String apellido=(String)objeto.get("apellido");
       int edad=Integer.parseInt((String)objeto.get("edad"));
       Persona P= new Persona(nombre,apellido,edad);
       listado.add(P);
       }
     
     return listado;
     }
      
      
}