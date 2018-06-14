/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.ControladorPersistencia;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Walter
 */
public class Universidad {
 
 private ArrayList ListaEstudiantes ; 
 private ArrayList ListaVehiculos;
    
    public Universidad() throws SQLException, ClassNotFoundException{
        ControladorPersistencia cp= new ControladorPersistencia();
        ListaEstudiantes= cp.DameListaEstudiantes();
       //ListaVehiculos=cp.DameListaVehiculos();
      //String Dato= ListaEstudiantes.;
      System.out.println( );
    
    }
    
    public boolean buscarEstudiante(){
   
    return true; 
    } 
    
    public boolean BuscarVehiculo(String patente){
    
       
        boolean ExisteVehiculo=false;
     Vehiculo ve=null;
    for(int i=0;i<ListaVehiculos.size();i++){
        ve=(Vehiculo) ListaVehiculos.get(i);
     if(ve.getPatente().equals(patente)){
         break;
     }
    }
    
       
        if(ve!=null){
        ExisteVehiculo=true;
        }
    return ExisteVehiculo;
    }
}
