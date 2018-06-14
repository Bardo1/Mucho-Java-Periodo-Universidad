/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;



import Logica.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Walter
 */
public class ControladorPersistencia extends ConexionBD {
    
 
    public void  IngresarValores(String nombre,String apellido,int edad){

     ingresarcosa(nombre,apellido,edad);
    
    }
    
    public ExamenPreocupacional buscaydespliega(int edad){
    
   
     return buscaydespliegapersona(edad);
    
    }
    
      public  ArrayList<ExamenPreocupacional> getListaPersonas (){
    
        ArrayList<ExamenPreocupacional> listaPesonas= new ArrayList<ExamenPreocupacional>();
        if (this.conectar())
        {
           
            ArrayList<HashMap> listaDb= this.ejecutarConsulta();
            for (int i=0 ; i< listaDb.size();i++){
                 HashMap registro= listaDb.get(i);
                 ExamenPreocupacional libro= new ExamenPreocupacional((String)registro.get("fechaini"),(String) registro.get("fechaterm"),(String) registro.get("rut"),(String) registro.get("nombre"),(String) registro.get("detalleDeAprovacion"),(String) registro.get("observacion"));
                 listaPesonas.add(libro);
            }
            
        }
        this.cerrar();
        return listaPesonas; 
    }
   
    
}
