/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.Persona;
import java.beans.Statement;
import java.sql.Connection;
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
    
    private String usuario;
    private String pass;
    private String nombreBD;
    private String servidor;
    private Statement conector;
    private java.sql.Connection conexion;
    
    
    
    
    
    public ConexionBD(){
       
        this.nombreBD="dbtp05";
        this.pass="xYDjSjGjcsddL6Jd";
        this.usuario="userdbtp05";
        this.servidor="146.83.123.113";
        this.conexion=null;
    
    
    }
      public boolean conectar1()
    {
    try {
            Class.forName("com.mysql.jdbc.Driver");
            String URL = "jdbc:mysql://"+this.servidor+"/"+this.nombreBD;
            System.out.println(URL);
            this.conexion= DriverManager.getConnection("jdbc:mysql://146.83.123.113/dbtp05", "userdbtp05", "xYDjSjGjcsddL6Jd");
           
            return true;
      } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
      } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
      }
   
        return false;
        
        
    }
    
    public boolean conectar(){ 
    try{
    Class.forName("com.mysql.jdbc.Driver");
    String URL = "jdbc:mysql://" + this.servidor + "/" + this.nombreBD;
    System.out.println("pasooooo");
    System.out.println(URL);
    this.conexion= DriverManager.getConnection("jdbc:mysql://146.83.123.113/dbtp05", "userdbtp05", "xYDjSjGjcsddL6Jd");        
     return true;  
    }catch(SQLException e){
          Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, e); 
    } catch (ClassNotFoundException e) {
           Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, e);   
    }
     return false;
    }
    
    
    public boolean cerrar(){
        try{
        this.conexion.close();
        }catch(SQLException e){
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, e);
        }
        return true;  
    }
    
    
    public void ingresarmierda(String nombre,String apellido,int edad){
        
    try{
    this.conectar();
    String query="insert into Persona values(?,?,?)";
    PreparedStatement conector= conexion.prepareStatement(query);
    conector.setString(1,nombre);
    conector.setString(2,apellido);
    conector.setInt(3,edad);  
    conector.executeUpdate();
    this.cerrar();
    }catch(SQLException e){
    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, e);
    }
    }
    
    
    public void modificarhueá(String nombre, String apellido,int edad){
    
    try{
    this.conectar();
    String query="update Persona set nombre=?, apellido=? where edad=? ";
    PreparedStatement conector= this.conexion.prepareStatement(query);
    conector.setString(1, nombre);
    conector.setString(2, apellido);
    conector.setInt(3,edad);
    conector.executeUpdate();
    this.cerrar();
    }catch(SQLException e){
    
      Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, e);
    }
    
    
    
    }
    
    
    public Persona retornaPersona(int edad){
    
    Persona perso= null;
    
    try{
    
    this.conectar();
    String query="select * from Persona where edad=?";
    PreparedStatement conector= this.conexion.prepareStatement(query);
    conector.setInt(1, edad);
    
    ResultSet resultado= conector.executeQuery();
    
    while(resultado.next()){
    
    String nombre= resultado.getString("nombre");
    String apellido= resultado.getString("apellido");
    int edad1= resultado.getInt("edad");  
    perso= new Persona(nombre,apellido,edad1);
    
    }
    this.cerrar();
    
    }catch(SQLException e){
    
    
    }
    return perso;
    
    }
    
    
}
