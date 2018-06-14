/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.ExamenPreocupacional;
import Logica.*;
import java.beans.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
    
    
  private String Nombrebd;
  private String user;
  private String pass;
  private String server;
  private Statement Conector;
  private java.sql.Connection conexion;
  
  public ConexionBD(){
  
        this.Nombrebd="";
        this.pass="";
        this.user="";
        this.server="";
        this.conexion=null;
  
  }
  
  
  
  public boolean conectar(){
  boolean resultado=false;
  try{
  Class.forName("com.mysql.jdbc.Driver");
  this.conexion= DriverManager.getConnection("jdbc:mysql://146.83.123.113/dbtp05", "userdbtp05", "xYDjSjGjcsddL6Jd");
  resultado=true;
  }catch(SQLException e){
  Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, e);
  }catch(ClassNotFoundException e){
  Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, e);
  }
  return resultado;
  }
  
  public void cerrar(){
  try{
  this.conexion.close();
  }catch(SQLException e){
   Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, e);
  }
 }
  
  public void ingresarcosa(String nombre, String apellido, int edad){
  try{
  this.conectar();
  String query="insert into Persona values(?,?,?)";
  PreparedStatement conector= this.conexion.prepareStatement(query);
  conector.setString(1, nombre);
  conector.setString(2, apellido);
  conector.setInt(3, edad);
  conector.executeUpdate();
  this.cerrar();
  }catch(SQLException e){
   Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, e);
  } 
  }
  
  
  public ExamenPreocupacional buscaydespliegapersona(int edad){
  
  ExamenPreocupacional exam= null;
  try{
  this.conectar();  
  String query="select* from Persona where edad=?";
  PreparedStatement conector= this.conexion.prepareStatement(query);
  conector.setInt(1, edad);
  ResultSet resultado= conector.executeQuery();
  while(resultado.next())
  {
  String fechaini= resultado.getString("fechaini");
  String fechaterm= resultado.getString("fechaterm");
  String rut= resultado.getString("rut");
  
  String nombre= resultado.getString("nombre");
  String detalleDeAprovacion=  resultado.getString("detalleDeAprovacion");
  String observacion=  resultado.getString("observacion");
  exam= new ExamenPreocupacional(fechaini,fechaterm,rut,nombre,detalleDeAprovacion,observacion);
  }  
  this.cerrar();
  
  }catch(SQLException e){
  
   Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, e);
  }
  
  return exam;
  
  }
  
   public ArrayList<HashMap> ejecutarConsulta(){
       ArrayList<HashMap> listado = null;
            try {
              ResultSet result = this.conexion.createStatement().executeQuery("select * from ExamenPreocupacional");
                        listado = new ArrayList<HashMap>();
                      while(result.next()){
                         HashMap<String, String> tupla = new HashMap<String, String>();
                         for(int i=result.getMetaData().getColumnCount(); i>0 ; i--){
                          String valorCampo = result.getString(i);
                          String nombreCampo = result.getMetaData().getColumnName(i);
                          tupla.put(nombreCampo,valorCampo);
                         }
                        listado.add(tupla);
                     
                    }

                
                result.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
       
       return listado;
    }
  
}
