/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.ControladorPersistencia;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


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
    
    
    
    public int contarJournalAutorAnio (String Autor, int anio){
    System.out.println("entra");
    return cp.ContarPublicacionAutorAnioJournal(Autor,anio);
    } 
    public int contarConferenciaAutorAnio (String Autor, int anio){
    return cp.ContarPublicacionAutorAnioArticulo(Autor,anio);
    }    
     public int contarLibroAutorAnio (String Autor, int anio){
    return cp.ContarPublicacionAutorAnioLibro(Autor,anio);
    }  
     
    
    
    
    public int contarpublicacionISI (int anio){
    return cp.ContarPublicacionTipoAnio("ISI",anio);
    }
    public int contarpublicacionISCIELO (int anio){ 
    return cp.ContarPublicacionTipoAnio("SCIELO",anio);
    }
    public int contarpublicacionISIPROCEEDING (int anio){
    return cp.ContarPublicacionTipoAnio("ISI PROCEEDING",anio);
    }      
    public int contarpublicacionTodoOtroindice (int anio){      
    return cp.contarpublicacionTodoOtroindice1(anio);
    }
      
   
}
