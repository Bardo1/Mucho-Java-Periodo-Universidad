
package Persistencia;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jgonzalez
 */
public class Conexion {
    private String nombreBD;
    private String usuario;
    private String password;
    private String server;
    private Connection conexion;
    private String nom;
    
    public Conexion() {
        this.nombreBD="dbtp05";
        this.usuario="userdbtp05";
        this.password="xYDjSjGjcsddL6Jd";
        this.server="146.83.123.113";
        this.conexion=null;
    }
    
    
     public  void  ModificaDatosEstudiante(String MatriculaActual, String NuevaMatricula, String NuevaPatente) {
        try {
            this.conectar();
          conexion.createStatement().executeUpdate("update Estudiante set rut='"+NuevaMatricula+"',  patente='"+NuevaPatente+"' where rut='"+MatriculaActual+"'");
                                    
            this.cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    
     public  void  ModificaDatosFuncionario(String rut,String Nrut, String Nunidad, String Npatente) {
        try {
            this.conectar();
          conexion.createStatement().executeUpdate("update Funcionario set rut='"+Nrut+"',unidad='"+Nunidad+"', patente='"+Npatente+"' where rut='"+rut+"'");
                                    
            this.cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   /* void eliminarUsuario(String nom, String apell, String ru) {
        try {
            this.conectar();
            conector.executeUpdate("delete from usuario where rut='"+ru+"'");
            this.cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
        */
      
        
        
    public boolean conectar()
    {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            String URL = "jdbc:mysql://" + this.server + "/" + this.nombreBD;
            System.out.println(URL);

            this.conexion = DriverManager.getConnection("jdbc:mysql://146.83.123.113/dbtp05", "userdbtp05", "xYDjSjGjcsddL6Jd");

            return true;


        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
    
       public void cargarUsuario(String rut, String patente) {
        try {
            this.conectar();
            conexion.createStatement().executeUpdate("insert into Estudiante(rut,patente) values('"+rut+"','"+patente+"')");
            this.cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     /**
     * cierra la conexion a la bd.
     *
     * @return verdadero si la operacion se realza exitosamente, falso en tros caso.
     */
    public void cerrar() {
        try {
            this.conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
    }

    /**
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
    public ArrayList<HashMap> ejecutarConsulta(String query){
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
    
    public boolean ejecutarEscritura(String p_sql){
        try {
            conexion.createStatement().executeUpdate(p_sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false; 
    }
}

    

