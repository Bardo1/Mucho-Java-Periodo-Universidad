/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.ControladorPersistencia;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
 
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Walter
 */
public class ControladorLogica {
    private ControladorPersistencia cp;
   
    public ControladorLogica(){     
    cp= new ControladorPersistencia();  
    }
    public ControladorPersistencia getCp() {
        return cp;
    }
    public void setCp(ControladorPersistencia cp) {
        this.cp = cp;
    }
    
    
    
   public ArrayList BusquedaNombresDeAutores(String query){
   return cp.NombresDeAutores(query);
   }  
 
   public ArrayList BusquedaPublicaciones(String query){
   return  cp.Publicaciones(query);
   }  
    
   
}
