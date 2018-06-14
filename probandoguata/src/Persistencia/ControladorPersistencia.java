/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;
import Logica.ControladorLogica;
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
public class ControladorPersistencia {
    private Conexion con;
    
    public void ControladorPersistencia(){
    
        con= new Conexion();
    }
    
    
   public void RegistrarEstudiante(String rut, String patente){
       Conexion cone= new Conexion();
       cone.cargarUsuario(rut, patente);
        
     }
   public void ModificaDatosEstudiante(String MatriculaActual, String NuevaMatricula, String NuevaPatente){
   
       Conexion cone= new Conexion();
       cone.ModificaDatosEstudiante(MatriculaActual,NuevaMatricula,NuevaPatente);
   
   }
   
   public void ModificaDatosFuncionario(String rut,String Nrut,String Nunidad, String Npatente){
   
       Conexion cone= new Conexion();
       cone.ModificaDatosFuncionario(rut,Nrut,Nunidad,Npatente);
   
   }
    
}

