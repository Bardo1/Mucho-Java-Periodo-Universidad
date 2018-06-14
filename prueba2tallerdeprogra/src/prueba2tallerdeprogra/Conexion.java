/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba2tallerdeprogra;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 
 */
public class Conexion {
    private String usuario;
    private String pass;
    private String nombreBD;
    private String servidor;
    private Statement conector;
    private java.sql.Connection conexion;
    
    public Conexion(){
         
        this.nombreBD="dbtp05";;
        this.pass="xYDjSjGjcsddL6Jd";;
        this.usuario="userdbtp05";;
        this.servidor="146.83.123.113";;
        this.conexion=null;
    
    }
    public boolean conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String URL="jdbc:mysql://"+this.servidor+"/"+this.nombreBD;
            
            this.conexion = DriverManager.getConnection(URL, this.usuario, this.pass);
            this.conector= conexion.createStatement();
            System.out.println("conexion abierta");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    public void cerrar(){
        try {
            this.conexion.close();
            System.out.println("conexion cerrada");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void cargarUsuario(String nom, String apell, String ru) {
        try {
            this.conectar();
            conector.executeUpdate("insert into usuario (nombre,apellidos,rut) values('"+nom+"','"+apell+"','"+ru+"')");
            this.cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void modificarUsuario(String nom, String apell, String ru) {
        try {
            this.conectar();
            conector.executeUpdate("update usuario set nombre='"+nom+"',apellidos='"+apell+"' where rut='"+ru+"'");
                                    
            this.cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void eliminarUsuario(String nom, String apell, String ru) {
        try {
            this.conectar();
            conector.executeUpdate("delete from usuario where rut='"+ru+"'");
            this.cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
