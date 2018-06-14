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

    /**
     * @return the cp
     */
    public ControladorPersistencia getCp() {
        return cp;
    }
  
    

    /**
     * @param cp the cp to set
     */
    public void setCp(ControladorPersistencia cp) {
        this.cp = cp;
    }
    
     
      
    
}
