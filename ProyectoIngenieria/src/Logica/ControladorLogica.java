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
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Walter
 */
public class ControladorLogica {
    
   
  private EncargadoEstacionamiento Encar;
    
   
   public void ControladorLogica(){ 
       
    }  
    
   
     public void RegistrarEstudiante(String NumMatricula, String NumPatente){
    
    Encar= new EncargadoEstacionamiento();
    Encar.crearEstudiante(NumMatricula,NumPatente);
    
    }
     
     public void ControlarIngreso(String patente) throws SQLException, ClassNotFoundException{
         Universidad Uni= new Universidad();
         
         boolean existeVehiculo= Uni.BuscarVehiculo(patente);
     boolean noSancion;    
     if(existeVehiculo){
     //noSancion= Uni.ValidarNoSancion();
     }
     
     }
    
     public boolean BuscaEstudiante(String MatriculaActual){
     
       //  Universidad Uni=new Universidad();
         //return Uni.BuscaEstudiante(MatriculaActual);
         return true;
     }
     
     
    public boolean RegistrarSolicitud(String NumMatricula,String NumPatente){
     ControladorPersistencia cp=  new ControladorPersistencia();
     boolean exito= cp.RegistrarSolicitud(NumMatricula,NumPatente);  
     return exito; 
    }

    public void ModificaDatosEstudiante(String MatriculaActual, String NuevaMatricula, String NuevaPatente){
     ControladorPersistencia cp=  new ControladorPersistencia();
     cp.ModificaDatosEstudiante(MatriculaActual,NuevaMatricula,NuevaPatente);
    }
  
    public void ModificaDatosFuncionarios(String rut, String Nrut , String Nunidad, String Npatente){
    ControladorPersistencia cp= new ControladorPersistencia();
    cp.ModificaDatosFuncionario(rut, Nrut, Nunidad, Npatente);
    }
 
    public boolean ComprobarExistenciaFuncionario(String rutf){
    ControladorPersistencia cp= new ControladorPersistencia();
    boolean exito= cp.ComprobarExistenciaFuncionario(rutf);
    return exito;
    }
    
    public DefaultTableModel DatosDeSolicitudes(){
    ControladorPersistencia cp= new ControladorPersistencia();
    return  cp.DatosDeSolicitudes();
    }
    
    public void EliminarSolicitud(String numMatricula ,String numPatente){
    ControladorPersistencia cp= new ControladorPersistencia();
    cp.EliminarSolicitud(numMatricula ,numPatente);  }
    
   //////////////////////////////////////////////////////////////
    
   
    
}
      

