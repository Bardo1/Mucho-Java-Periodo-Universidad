/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ProfeSeron;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mseron
 */
public class ManejadorBD {

    private String nombreBD;
    private String usuario;
    private String password;
    private String server;
    private int port;
    private Connection conexion;

    public ManejadorBD() {
        this.nombreBD = "SegundaPrueba";
        this.usuario = "Taller";
        this.password = "taller123";
        this.server="146.83.123.20";
        this.port=5432;
    }

    public boolean conectar() throws ClassNotFoundException, SQLException{
        Class.forName("org.postgresql.Driver");
        this.conexion = DriverManager.getConnection("jdbc:postgresql://"+this.server+":"+this.port+"/"+this.nombreBD,this.usuario,this.password);
        if(this.conexion!=null)
            return true;
        else
            return false;
    }

    public void close() throws SQLException{
        this.conexion.close();
    }

    public boolean almacenarEmpleado(HashMap persona) throws SQLException, ClassNotFoundException{
        boolean result =false;
        if(this.conectar()){
            String query ="insert into persona (nombre,rut,edad) values('"+
                                    persona.get("nombre")+"','"+
                                    persona.get("rut")+"',"+
                                    persona.get("edad")+")";

            Logger.getLogger(ManejadorBD.class.getName()).log(Level.INFO, query);
            result = this.conexion.createStatement().execute(query);
        }
        this.close();
        return result;
    }

    public List<HashMap> listarEmpleados() throws SQLException, ClassNotFoundException{
        ArrayList<HashMap> listado = null;

       if(this.conectar()){
            ResultSet result = null;
            String query = "select * from persona;";
            Logger.getLogger(ManejadorBD.class.getName()).log(Level.INFO, query);
            result = this.conexion.createStatement().executeQuery(query);

            if(result != null){
                boolean valido = result.next();
                listado = new ArrayList<HashMap>();
                while(valido){
                    HashMap<String, String> tupla = new HashMap<String, String>();
                    String nombre = result.getString("nombre");
                    String rut = result.getString("rut");
                    String edad = result.getString("edad");

                    tupla.put("nombre",nombre);
                    tupla.put("rut",rut);
                    tupla.put("edad",edad);

                    listado.add(tupla);

                    valido = result.next();
                }
            }


        }
        this.close();
        return listado;
    }

    public HashMap buscarEmpleado(String rutEmp) throws SQLException, ClassNotFoundException{
        
        HashMap<String, String> tupla = null;
        if(this.conectar()){
            ResultSet result = null;
            String query = "select * from persona where rut="+rutEmp+";";
            Logger.getLogger(ManejadorBD.class.getName()).log(Level.INFO, query);
            result = this.conexion.createStatement().executeQuery(query);

            tupla = new HashMap<String, String>();
            if(result != null){
                result.next();

                String nombre = result.getString("nombre");
                String rut = result.getString("rut");
                String edad = result.getString("edad");

                tupla.put("nombre",nombre);
                tupla.put("rut",rut);
                tupla.put("edad",edad);
            }
        }
        this.close();
        return tupla;

    }
}
