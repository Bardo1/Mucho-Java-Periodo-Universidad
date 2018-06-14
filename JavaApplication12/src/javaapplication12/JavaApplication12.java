/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication12;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;

/**
 *
 * @author Walter
 */

public class JavaApplication12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      
        
        guardarbd(81,"peter","carcamo");
        
    }
    
    
    
    
    public static void guardarbd(int id2,String nombre2,String apellido2){
    
        
         try {
            // instancia el driver a utilizar
            Class.forName("com.mysql.jdbc.Driver");
            // crear el objetio de conexion
            Connection conexion= DriverManager.getConnection("jdbc:mysql://146.83.123.113/dbtp05", "userdbtp05", "xYDjSjGjcsddL6Jd");
            Statement conector= conexion.createStatement();
            // informo el estado
            System.out.println("se Conecto");
            //muestro los datos
            System.out.println("Lista de Alumnos");
            ResultSet resultado= conector.executeQuery("select * from walter3 ");
            // inserto nuevos datos
           conector.executeUpdate("insert into walter3(rut,nombre,apellido) values ('"+id2+"','"+nombre2+"','"+apellido2+"')");
                       

            conector.close();
            conexion.close();
         //   System.out.println( resultado.getString("conexion cerrada"));
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JavaApplication12.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            
            System.out.println("Error de Conexion"+e);
        }
    
    }

}