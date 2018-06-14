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
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Walter
 */
public class ControladorPersistencia {
    private Conexion con;
    
    public void ControladorPersistencia(){
    
        con= new Conexion();
    }
    
    
    public ArrayList DameListaEstudiantes() throws SQLException, ClassNotFoundException{
      Conexion cone= new Conexion(); 
      return cone.DaneListaEstudiantes();
    }
    
   public boolean GuardaEstudiante(HashMap Datos){
      Conexion cone= new Conexion();
      boolean exito= cone.GuardarEstudiante(Datos);
      return exito;    
   }
   
    public boolean RegistrarSolicitud(String nmatricula, String patente){
       Conexion cone= new Conexion();
      boolean exito= cone.RegistraSolicitud(nmatricula, patente);
      return exito;
        
     }
   public void ModificaDatosEstudiante(String MatriculaActual, String NuevaMatricula, String NuevaPatente){
   
       Conexion cone= new Conexion();
       cone.ModificaDatosEstudiante(MatriculaActual,NuevaMatricula,NuevaPatente);
   
   }
   
   public void ModificaDatosFuncionario(String rut,String Nrut,String Nunidad, String Npatente){
   
       Conexion cone= new Conexion();
       cone.ModificaDatosFuncionario(rut,Nrut,Nunidad,Npatente);
   
   }
    
   public boolean ComprobarExistenciaFuncionario(String rutf){
    
    Conexion cone= new Conexion();
    boolean exito= cone.ComprobarExistenciaFuncionario(rutf);
    return exito;
    
    }
   
   public DefaultTableModel DatosDeSolicitudes(){
     Conexion cone= new Conexion();
     return  cone.DatosDeSolicitudes();
   }
   
    public void EliminarSolicitud(String numMatricula ,String numPatente){
    Conexion cone= new Conexion();
    cone.EliminarSolicitud(numMatricula ,numPatente);  }
    
   
}

