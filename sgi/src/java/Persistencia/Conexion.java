
package Persistencia;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.*;

/**
 *
 * @author lou
 */
public class Conexion {

   
    private String nombreBD;
    private String usuario;
    private String password;
    private String server;
    private int port;
    private Connection conexion;
    
      public Conexion() {
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
     /*
     * Ejecuta una query  en la bd y no espera un resultado de la operacion.
     * @param query a ejecutar en la bd.
     * @return verdadero si la operacion se realiza exitosamente, 
     * falso en caso contrario.
     */
    public boolean ejecutarSinRetorno(String query){
        boolean result = true;
        if(this.conexion != null){
            
            try {
                result = this.conexion.createStatement().execute(query);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
    
     /**
     * Ejecuta una query en la bd, y espera un retorno desde la misma de acuerdo
     * a la query ejecutada.
     * @param query que se ejecuta en la bd.
     * @return un listado de mapas que contienen los datos de los objetos a ser
     * instanciados.
     */
    public ArrayList<HashMap> ejecutarConRetorno(String query){
       ArrayList<HashMap> listado = null;
       
       if(this.conexion != null){
            ResultSet result = null;
            try {
                result = this.conexion.createStatement().executeQuery(query);
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
    
}
