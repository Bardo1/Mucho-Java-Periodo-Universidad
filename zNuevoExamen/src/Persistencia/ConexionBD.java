/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
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
    
    public void IngresarDatosBASE(String nombre, String apellido, int edad){
    
    
    
}   
    
    public ArrayList<HashMap> damelistapersonas(){
    ArrayList<HashMap> lista= new ArrayList<HashMap>();  
    try{
    this.conectar();
    String query="select * from Persona";
    
    ResultSet resultado= this.conexion.createStatement().executeQuery(query);
    
    while(resultado.next()){
    
    HashMap<String,String> tupla= new HashMap<String,String>();
    for(int i= resultado.getMetaData().getColumnCount();i>0;i++){
    
    String ValorCampo=resultado.getString(1);
    String NombreCampo= resultado.getMetaData().getColumnName(i);
    tupla.put(NombreCampo,ValorCampo);
    
    }
    lista.add(tupla);
    }
    this.cerrar();
    }catch(SQLException e){
        e.printStackTrace();     
    }
    
     return lista;
    }
    
    
     public void ingresarmierda(String nombre,String apellido,int edad){
        
    try{
    this.conectar();
    String query="insert into Persona values(?,?,?)";
    PreparedStatement conector= (PreparedStatement) conexion.prepareStatement(query);
    conector.setString(1,nombre);
    conector.setString(2,apellido);
    conector.setInt(3,edad);  
    conector.executeUpdate();
    this.cerrar();
    }catch(SQLException e){
    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, e);
    }
    }
    
   
}
