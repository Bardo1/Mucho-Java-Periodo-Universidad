/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.ControladorLogica;
import Logica.*;
//import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetMetaData;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Walter
 */

/*
public class ConexionBD {
    
    
  private String Nombrebd;
  private String user;
  private String pass;
  private String server;
  private Statement Conector;
  private java.sql.Connection conexion;
  
  public ConexionBD(){
  /*
        this.Nombrebd="ingSoft2012db08";
        this.pass=".vW(yJR%";
        this.user="ryabire08";
        this.server="146.83.123.113";
        this.conexion=null;
     
 * 
 * 
 *  this.Nombrebd="ingSoft2012db08";
        this.pass="x1]Xa/qs";
        this.user="crojas08";
        this.server="146.83.123.113";
        this.conexion=null;
  }
       * */    
     
  
  /*
 /* 
  user: RAyabire
pass: a_R%2XMk
ip:146.83.123.113
puerto: 3306
nombre base dato: DBrayabire_2012
URL: http://svnserver.disc.ucn.cl/phpmyadmin/

*/
  /*
public Connection conectar(){
        java.sql.Connection resultado=conexion;
          
    try{

            Class.forName("com.mysql.jdbc.Driver");
            String URL = "jdbc:mysql://" + this.server + "/" + this.Nombrebd;

            System.out.println(URL);

            this.conexion = DriverManager.getConnection(URL, "ryabire08", ".vW(yJR%");
          
            System.out.println("conectado");
           
        resultado=conexion;
    }catch(SQLException e){
        Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, e);
    }catch(ClassNotFoundException e){
        Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, e);
    }
    return (Connection) resultado;
  }


 public Connection conectar1(){
        java.sql.Connection resultado=conexion;
        try{
           
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("CONECTAR1");
                String URL = "jdbc:mysql://" + this.server + "/" + this.Nombrebd;
                 
                System.out.println(URL);
                this.conexion = DriverManager.getConnection(URL, this.user, this.pass);
                System.out.println("conectado");
            resultado=conexion;
        }catch(SQLException e){
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, e);
        }catch(ClassNotFoundException e){
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, e);
        }
        return (Connection) resultado;
    }
  
public void cerrar(){
    try{
        this.conexion.close();
    }catch(SQLException e){
        Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, e);
    }
}
  
*/
  
  public class ConexionBD {

   
    private String nombreBD;
    private String usuario;
    private String password;
    private String server;
    private int port;
    private Connection conexion;
    
      public ConexionBD() {
        this.nombreBD = "ingSoft2012db08";
        this.usuario = "crojas08";
        this.password = "x1]Xa/qs";
        this.server="svnserver.disc.ucn.cl";
        this.port=3306;        
    }
      public boolean conectar() {
        this.conexion = null;
        try {
             // Get connection

            Class.forName("com.mysql.jdbc.Driver");
            String URL = "jdbc:mysql://"+this.server+":"+this.port+"/"+this.nombreBD;
            System.out.println(URL);
            try{
            this.conexion = DriverManager.getConnection(URL,this.usuario,this.password);
            }catch(SQLException ex){
                return false;
            }
             if (this.conexion != null) {
                 System.out.println();
                  System.out.println("Conexion Exitosa!!!");
                  System.out.println();
                  // Meta data
                  DatabaseMetaData meta = this.conexion.getMetaData();
                  System.out.println("\nDriver Information");
                  System.out.println("Driver Name: " + meta.getDriverName());
                  System.out.println("Driver Version: " + meta.getDriverVersion());
                  System.out.println("\nDatabase Information ");
                  System.out.println("Database Name: " + meta.getDatabaseProductName());
                  System.out.println("Database Version: " + meta.getDatabaseProductVersion());
                  return true;
             }

        }catch(SQLException se) {
             se.printStackTrace();
             
        }catch (ClassNotFoundException cnf){
            cnf.printStackTrace();
            
        }
        return false;

    }
      public boolean cerrar() {
        try {
            this.conexion.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
  public int ContarPublicacionAutorAnioJournal1(String nombreAutor,int anio1){
        
            
        int cantidad=0;       
        try{
            this.conectar();          
            java.sql.Statement conector= conexion.createStatement();
            ResultSet result = conector.executeQuery("select * FROM Persona P, AutorPublicacion AP, Publicacion PU, Journal J WHERE P.nombre='"+nombreAutor+"'and P.idPer=AP.idAutor and AP.idPub=PU.idPub and AP.idPub=J.idPub and PU.anio='"+anio1+"'");
           
            while(result.next()){
                cantidad = cantidad+1;    
            }

            System.out.println("-"+ cantidad);
            this.cerrar();
            conector.close();
            return cantidad;
        }catch(SQLException e){
            System.out.println("error");
            return cantidad;
        }
          
        }
   public int ContarPublicacionAutorAnioLibro1(String nombreAutor,int anio1){
        
            
        int cantidad=0;       
        try{
            this.conectar();         
            java.sql.Statement conector= conexion.createStatement();
            ResultSet result = conector.executeQuery("select * FROM Persona P, AutorPublicacion AP, Publicacion PU, Libro L WHERE P.nombre='"+nombreAutor+"' and P.idPer=AP.idAutor and AP.idPub=PU.idPub and AP.idPub=L.idPub and PU.anio='"+anio1+"'");
           while(result.next()){
                cantidad = cantidad+1;    
            }
             System.out.println("--"+ cantidad);
            this.cerrar();
            conector.close();
            return cantidad;
        }catch(SQLException e){
            System.out.println("error");
            return cantidad;
        }
          
        }
    public int ContarPublicacionAutorAnioArticulo1(String nombreAutor,int anio1){
        
            
        int cantidad=0;       
        try{
            this.conectar();        
           java.sql.Statement conector= conexion.createStatement();
           ResultSet result = conector.executeQuery("select * FROM Persona P, AutorPublicacion AP, Publicacion PU, Articulo A WHERE P.nombre='"+nombreAutor+"' and P.idPer=AP.idAutor and AP.idPub=PU.idPub and AP.idPub=A.idPub and PU.anio='"+anio1+"'");

            while(result.next()){
                cantidad = cantidad+1;    
            }
            System.out.println("--"+ cantidad);
            this.cerrar();
            conector.close();
            return cantidad;
        }catch(SQLException e){
            System.out.println("error");
            return cantidad;
        }
          
        }
  
 public int ContarPublicacionTipoAnio(String tipoIndice,int anio){
        
            
        int cantidad=0;       
        try{
            this.conectar();
            java.sql.Statement conector= conexion.createStatement();
            ResultSet result = conector.executeQuery("select * FROM Publicacion P WHERE P.nombreIndice='"+tipoIndice+"' P.anio='"+anio+"'");
            while(result.next()){
                cantidad = cantidad+1;   
            }
            this.cerrar();
            conector.close();
            return cantidad;
        }catch(SQLException e){
            System.out.println("error");
            return cantidad;
        }
          
        }
  
  public int ContarPublicacionTipoAnio1(String tipo,int anio1){
        
            
        int cantidad=0;       
        try{
            this.conectar();         
            java.sql.Statement conector= conexion.createStatement();
             System.out.println(tipo);
             System.out.println(anio1);
             ResultSet result = conector.executeQuery("select * FROM Publicacion P WHERE P.nombreIndice='"+tipo+"'and P.anio='"+anio1+"'" );
            while(result.next()){
                cantidad = cantidad+1;   
            }
             System.out.println(cantidad);
            this.cerrar();
            conector.close();
            return cantidad;
        }catch(SQLException e){
            System.out.println("error");
            return cantidad;
        }
          
        }
  
  public int contarpublicacionTodoOtroindice2( int anio){
        
            
        int cantidad=0;       
        try{
            this.conectar();         
            java.sql.Statement conector= conexion.createStatement();
            ResultSet result = conector.executeQuery("select * FROM Publicacion P " );
            while(result.next()){
                cantidad = cantidad+1;   
            }
            System.out.println(cantidad);
            this.cerrar();
            conector.close();
            return cantidad;
        }catch(SQLException e){
            System.out.println("error");
            return cantidad;
        }
          
        }
  
  
   
    }
    
   
    
  
  
  
