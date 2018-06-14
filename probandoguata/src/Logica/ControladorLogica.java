/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import Persistencia.ControladorPersistencia;
import Persistencia.Conexion;
import Persistencia.ControladorPersistencia;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;


/**
 *
 * @author Walter
 */
public class ControladorLogica {
    
   
  
   private Secretaria secre; 
   
   public void ControladorLogica(){ 
       secre= new Secretaria("cod1234");
    }
    
    
    
    public void IngresarDatos(String titulo,String descripcion,String fecha, String resumen){
     ControladorPersistencia cp=  new ControladorPersistencia();
     Utils u= new Utils();
     boolean resulvalido= u.validarfecha();
     if(resulvalido=true){
      secre.CrearNoticia(titulo,descripcion,fecha,resumen);
     
     }
     
     
     
    }


    public void ModificaDatosEstudiante(String MatriculaActual, String NuevaMatricula, String NuevaPatente){
     ControladorPersistencia cp=  new ControladorPersistencia();
     cp.ModificaDatosEstudiante(MatriculaActual,NuevaMatricula,NuevaPatente);
    
    }
    
    
   
       
}
      

