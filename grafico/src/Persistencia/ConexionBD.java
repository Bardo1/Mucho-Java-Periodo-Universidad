/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.ControladorLogica;
import Logica.*;
//import com.mysql.jdbc.Connection;
import java.beans.Statement;
import java.sql.Connection;
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
public class ConexionBD {
    
    
  private String Nombrebd;
  private String user;
  private String pass;
  private String server;
  private Statement Conector;
  private java.sql.Connection conexion;
  
  public ConexionBD(){
  
        this.Nombrebd="DBrayabire_2012";
        this.pass=".vW(yJR%";
        this.user="ryabire08";
        this.server="146.83.123.113";
        this.conexion=null;
        
  }
 /* 
  user: RAyabire
pass: a_R%2XMk
ip:146.83.123.113
puerto: 3306
nombre base dato: DBrayabire_2012
URL: http://svnserver.disc.ucn.cl/phpmyadmin/

*/
  
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
  
public void cerrar(){
    try{
        this.conexion.close();
    }catch(SQLException e){
        Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, e);
    }
}
  


    public boolean modificarPreocupacional(String rut, int diai, String mesi, int anoi, int diaf, String mesf, int anof, String deta, String obser){
        String nombre="";
        try{
            Connection conex =this.conectar();
            java.sql.Statement conector= conex.createStatement();
            ResultSet result = conector.executeQuery("select * from preocupacional where rut = '"+rut+"' ");
            while(result.next()){
                nombre= result.getString("observacion");
                System.out.println(nombre);
                 
            }
            if(nombre.equals(obser)){
                conector.executeUpdate("update preocupacional set diai= '"+diai+"', mesi= '"+mesi+"', anoi= '"+anoi+"', diaf= '"+diaf+"', mesf= '"+mesf+"', anof='"+anof+"', detalle= '"+deta+"' where rut = "+rut+"");
                conector.close();
                conex.close();
                System.out.println("modificasi");
                return true;
            }else{
                return false;
            }
            
        }catch(SQLException e){
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
    
    // autor, año, tipo de ´publicacion, indice especifico
    
    public DefaultTableModel cargarPreocupa(){
        DefaultTableModel ingreso;
        String[] nombreTabla= {"rut","nombre","Fecha Inicio","Fecha Termino","detalle","observacion"};
        String[] resultado= new String[6];
        ingreso = new DefaultTableModel(null, nombreTabla);
        try{
            Connection conex =this.conectar();
            java.sql.Statement conector= conex.createStatement();
            ResultSet result = conector.executeQuery("select * from preocupacional");
            while(result.next()){
                resultado[0]= result.getString("rut");
                resultado[1]= result.getString("nombre");
                String aux= result.getString("diai")+"/"+ result.getString("mesi") + "/"+ result.getString("anoi");
                resultado[2]= aux;
                String aux1=result.getString("diaf")+"/"+ result.getString("mesf") + "/"+ result.getString("anof");
                resultado[3]= aux1;
                resultado[4]= result.getString("detalle");
                resultado[5]= result.getString("observacion");
                ingreso.addRow(resultado);
                
            }
            conex.close();
            conector.close();
            return ingreso;
        }catch(SQLException e){
            System.out.println("error");
            return ingreso;
        }
    }
    
    
    public boolean ingresarPsicosensotecnico(String rut, String nom, int diai, String mes1, int numAnoI, int diaf, String mes2, int numAnoF, String detal, String usuario){
        try{
            Connection conex =this.conectar();
            java.sql.Statement conector= conex.createStatement();
            conector.executeUpdate("insert into psicosensotecnico (rut,nombre,diai,mesi,anoi,diaf,mesf,anof,detalle,observacion) values('"+rut+"', '"+nom+"', '"+diai+"', '"+mes1+"', '"+numAnoI+"', '"+diaf+"', +'"+mes2+"', '"+numAnoF+"', '"+detal+"', '"+usuario+"')");
            conector.close();
            conex.close();
            return true;
        }catch(SQLException e){
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
    
  
   
  
}
