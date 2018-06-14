/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.Persona;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author Walter
 */

    
   public class Conexionbd {
    private String usuario;
    private String pass;
    private String nombreBD;
    private String servidor;
    private Statement conector;
    private java.sql.Connection conexion;
    
    public Conexionbd(){
         
        this.nombreBD="dbtp05";
        this.pass="xYDjSjGjcsddL6Jd";
        this.usuario="userdbtp05";
        this.servidor="146.83.123.113";
        this.conexion=null;
    
    }
    
       public boolean conectar()
    {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            String URL = "jdbc:mysql://" + this.servidor + "/" + this.nombreBD;            
            System.out.println(URL);
            this.conexion= DriverManager.getConnection("jdbc:mysql://146.83.123.113/dbtp05", "userdbtp05", "xYDjSjGjcsddL6Jd");
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(Conexionbd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexionbd.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
       
       
        public boolean ejecutarEscritura(String p_sql){
        try {
            conexion.createStatement().executeUpdate(p_sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Conexionbd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false; 
        }
    public void cerrar(){
        try {
            this.conexion.close();
            System.out.println("conexion cerrada");
        } catch (SQLException ex) {
            Logger.getLogger(Conexionbd.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
    
    public void IngresarValores1(String nombre, String apellido,int edad) {
        
        try {
            this.conectar();
            String query="insert into Persona values(?,?,?)";
            PreparedStatement conector= this.conexion.prepareStatement(query);           
            conector.setString(1, nombre);
            conector.setString(2, apellido);
            conector.setInt(3, edad);
            //se inserta en la base de datos la solicitud
            conector.executeUpdate();
            this.cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(Conexionbd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    void ModificaValores(String nombre, String apellido, int edad) {
       
        try {
            this.conectar();
            String query="update Persona set nombre=? ,apellido=? where edad=?";
            PreparedStatement conector = conexion.prepareStatement(query);
            conector.setString(1, nombre);
            conector.setString(2, apellido);
            conector.setInt(3,edad);           
            // se inserta en la base de datos la solicitud
            conector.executeUpdate();
         
            this.cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(Conexionbd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   public Persona DespliegaDatos( int edad) {
      Persona perso= null;
       try {
                      
            this.conectar();
            String query="select * from Persona where edad=?";
            PreparedStatement conector = conexion.prepareStatement(query);
            conector.setInt(1,edad);            
            //se inserta en la base de datos la solicitud
            ResultSet resultado=conector.executeQuery();
            
            while(resultado.next()){
                
            String nombre1=resultado.getString("nombre");
            String apellido2=resultado.getString("apellido");
            int edad3=resultado.getInt("edad");
            perso= new Persona(nombre1,apellido2,edad3);
            
            }
         
            this.cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(Conexionbd.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       return perso;
    }

    public void EliminarPersona(int edad){
      try {
            this.conectar();
            String query="Delete from Persona where edad=?";
            PreparedStatement conector = conexion.prepareStatement(query);
            conector.setInt(1,edad);
            conector.executeUpdate();
            this.cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(Conexionbd.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
   
     
    
     public ArrayList<HashMap> ejecutarConsulta(){
       ArrayList<HashMap> listado = null;
       if(this.conexion != null){
            ResultSet result = null;
            try {
                result = this.conexion.createStatement().executeQuery("select * from Persona");
                if(result != null){
                    boolean valido = result.next();
                    listado = new ArrayList<HashMap>();
                    while(valido){
                        HashMap<String, String> tupla = new HashMap<String, String>();
                         for(int i=result.getMetaData().getColumnCount(); i>0 ; i--){
                             String valorCampo = result.getString(i);
                             String nombreCampo = result.getMetaData().getColumnName(i);
                             
                             tupla.put(nombreCampo,valorCampo);
                         }
                         
                        listado.add(tupla);
                        valido = result.next();
                    }

                }
                result.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

       }
       return listado;
    }
    
     public ArrayList<HashMap> damelistapersonas(){
    ArrayList<HashMap> lista= new ArrayList<HashMap>();  
    try{
    this.conectar();
    String query="select * from Persona";
    ResultSet resultado =this.conexion.createStatement().executeQuery(query); 
    while(resultado.next()){
    HashMap<String,String> tupla= new HashMap<String,String>();
    for(int i= resultado.getMetaData().getColumnCount();i>0;i--){
         String ValorCampo=resultado.getString(i);
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
    
    
  
    }