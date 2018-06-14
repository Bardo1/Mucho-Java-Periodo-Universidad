/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.Persona;
import java.beans.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Walter
 */
public class ConexionBD {
    
    
    
    private String user;
    private String pass;
    private Statement Conector;
    private String server;
    private String Nombrebd;
    private java.sql.Connection Conexion;
    
    
     public ConexionBD( ){
   
      this.Nombrebd="dbtp05";
        this.pass="xYDjSjGjcsddL6Jd";
        this.user="userdbtp05";
        this.server="146.83.123.113";
        this.Conexion=null;
    
    
    }
     
     public void conectar(){
     
     try{
          System.out.println("pasoooo");
       Class.forName("com.mysql.jdbc.Driver");
        
      String URL = "jdbc:mysql://" + this.server + "/" + this.Nombrebd;
      System.out.println(URL);
      
      this.Conexion= DriverManager.getConnection(URL,"userdbtp05","xYDjSjGjcsddL6Jd");         
     }catch(SQLException  e){
      Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, e);
     }catch(ClassNotFoundException e){
      Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, e);
     }
    

}
     public void cerrar(){
     try{
     this.Conexion.close();
     }catch(SQLException e){
      Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, e);
     }    
         
     }
     
     public Persona buscarpersona1(int edad1){
     Persona perso= null;
     
     try{
         this.conectar();
         String query="select * from Persona where edad=?";
         PreparedStatement conector= this.Conexion.prepareStatement(query);
         conector.setInt(1, edad1);
         ResultSet resultado= conector.executeQuery();
         
         while (resultado.next()){
         String nombre=resultado.getString("nombre");
         String apellido=resultado.getString("apellido");
         int edad2=resultado.getInt("edad");
         perso = new Persona (nombre, apellido,edad2);
        
         }
        
         this.cerrar();
     }catch(SQLException e){
     
      Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, e);
     }
      return perso;
     
     }
     
     
     public void guardarPersona(String nombre, String apellido, int edad){
     
     try{
     
     this.conectar();
     String query= "insert into Persona values(?,?,?)";
     PreparedStatement conector= this.Conexion.prepareStatement(query);
     conector.setString(1, nombre);
     conector.setString(2, apellido);
     conector.setInt(3, edad);
     conector.executeUpdate();
     this.cerrar();
     
     }catch(SQLException e){
     Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE,null,e);
     
     }
     
     
     
     }
     
}
