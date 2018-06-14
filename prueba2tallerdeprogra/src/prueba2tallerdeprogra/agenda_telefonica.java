/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba2tallerdeprogra;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;

/**
 *
 * @author Walter
 */
public class agenda_telefonica {
    
   
   public void agenda_telefonica( ){
     
   }
   
    
    public String getcontacto(int id){
     String DatosContacto= "";
        try {          
            // instancia el driver a utilizar
           
            Class.forName("com.mysql.jdbc.Driver");
            // crear el objetio de conexion
            Connection conexion= DriverManager.getConnection("jdbc:mysql://146.83.123.113/dbtp05", "userdbtp05", "xYDjSjGjcsddL6Jd");
            Statement conector= conexion.createStatement();
            ResultSet resultado2= conector.executeQuery("select * from agenda_telefonicawalter where id='"+id+"'");
            // para que nos de posicionemos en la tupla y su ultimo lugar
            while(resultado2.next()){
            String id1= String.valueOf(resultado2.getInt("id"));
            DatosContacto=(id1+"-"+resultado2.getString("nombre")+"-"+resultado2.getString("apellidos")+"-"+resultado2.getString("telefono"));
            }
            //cerramos la clase conector
            conector.close();
            conexion.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Prueba2tallerdeprogra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            
            System.out.println("Error de Conexion"+e);
        }
           return DatosContacto;
   }
    
    
    public int cuentacontacto(){
    // retorna la cantidad de las cuentas en la base de datos
        int Conteo=0;
        try {
               
            // instancia el driver a utilizar
            Class.forName("com.mysql.jdbc.Driver");
            // crear el objetio de conexion
            Connection conexion= DriverManager.getConnection("jdbc:mysql://146.83.123.113/dbtp05", "userdbtp05", "xYDjSjGjcsddL6Jd");
            Statement conector= conexion.createStatement();
            // contamos en nuestra query
            ResultSet resultado= conector.executeQuery("select count(*)valor from agenda_telefonicawalter ");
            Conteo=resultado.getInt("valor");
            conector.close();
            conexion.close();
            System.out.println( resultado.getString("conexion cerrada"));
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Prueba2tallerdeprogra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            
            System.out.println("Error de Conexion"+e);
        }
  
        return Conteo;
    }
    
   
     public void setTelefono(int id, String nuevoTelefono){
         
        try {     
            // instancia el driver a utilizar
            Class.forName("com.mysql.jdbc.Driver");
            // crear el objetio de conexion
            Connection conexion= DriverManager.getConnection("jdbc:mysql://146.83.123.113/dbtp05", "userdbtp05", "xYDjSjGjcsddL6Jd");
            Statement conector= conexion.createStatement();
            // informo el estado
            conector.executeUpdate("update agenda_telefonicawalter set telefono='"+nuevoTelefono+"' where id="+id+" ");
            conector.close();
            conexion.close();   
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Prueba2tallerdeprogra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            
            System.out.println("Error de Conexion"+e);
        }
         
         
    }
     public String getNombre(int id){
         String DatosContacto="";
         try {          
            // instancia el driver a utilizar
            Class.forName("com.mysql.jdbc.Driver");
            // crear el objetio de conexion
            Connection conexion= DriverManager.getConnection("jdbc:mysql://146.83.123.113/dbtp05", "userdbtp05", "xYDjSjGjcsddL6Jd");
            Statement conector= conexion.createStatement();
            ResultSet resultado2= conector.executeQuery("select * from agenda_telefonicawalter where id='"+id+"'");
            
            while(resultado2.next()){
            DatosContacto= resultado2.getString("nombre")+"-"+resultado2.getString("apellidos");
            }
            // cerramos la conexion
            conector.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Prueba2tallerdeprogra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            
            System.out.println("Error de Conexion"+e);
        }
           return DatosContacto;
     
     }
     
     public void InsertarContacto(String nombre, String apellidos, String telefono){
       try {
          // instancia el driver a utilizar
            Class.forName("com.mysql.jdbc.Driver");
            // crear el objetio de conexion
            Connection conexion= DriverManager.getConnection("jdbc:mysql://146.83.123.113/dbtp05", "userdbtp05", "xYDjSjGjcsddL6Jd");
            Statement conector= conexion.createStatement();
            // informo el estado
            System.out.println("se Conecto");
            // inserto nuevos datos
            conector.executeUpdate("insert into agenda_telefonicawalter(nombre,apellidos,telefono) values ('"+nombre+"','"+apellidos+"','"+telefono+"')");
            conector.close();
            conexion.close();
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Prueba2tallerdeprogra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            
            System.out.println("Error de Conexion"+e);
        }
     }
    
     
     
     
     public int eliminar(int id){
    // retorna la cantidad de las cuentas en la base de datos
        int Conteo=0;
        try {
               
            // instancia el driver a utilizar
            Class.forName("com.mysql.jdbc.Driver");
            // crear el objetio de conexion
            Connection conexion= DriverManager.getConnection("jdbc:mysql://146.83.123.113/dbtp05", "userdbtp05", "xYDjSjGjcsddL6Jd");
            Statement conector= conexion.createStatement();
            // contamos en nuestra query
            conector.executeUpdate("Delete from agenda_telefonicawalter where id='"+id+"' ");
          
            conector.close();
            conexion.close();
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Prueba2tallerdeprogra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            
            System.out.println("Error de Conexion"+e);
        }
        
        
        return Conteo;
    }
     
     
     
     
}
