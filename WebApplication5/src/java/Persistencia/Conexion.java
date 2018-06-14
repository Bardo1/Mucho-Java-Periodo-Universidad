
package Persistencia;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

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
    
     public DefaultTableModel desplegarEvento(String dia, String mes, String ano){
        DefaultTableModel ingresoH;

        String[] nombresTabla={"dia","mes","año","hora inicio","hora final","lugar","descrpcion"};
        String[] resultadoConsulta= new String[7];
        ingresoH= new DefaultTableModel(null, nombresTabla);
            
        try{
               
            this.conectar();     
             java.sql.Statement conector= conexion.createStatement();
            // informa el estado si se conecta
            System.out.println("se Conecto");
           ResultSet resultado = conector.executeQuery("select * from horario where dia="+dia+" and ano="+ano+" and mes="+mes+"");
            //retorna los datos de la base de datos donde la id es igual a la solicitada
            while(resultado.next()){
                resultadoConsulta[0]=dia;
                resultadoConsulta[1]=mes;
                resultadoConsulta[2]=ano;
                resultadoConsulta[3]=resultado.getString("horai");
                resultadoConsulta[4]=resultado.getString("horaf");
                resultadoConsulta[5]=resultado.getString("lugar");
                resultadoConsulta[6]=resultado.getString("descripcion");
                ingresoH.addRow(resultadoConsulta);
            }
            
           this.cerrar();
            conector.close();
            
      
        } catch (SQLException e) {
            System.out.println("Error de Conexion"+e);
            return null;
        }
        return ingresoH;
    }
  public int ContarPublicacionAutorAnioJournal1(String nombreAutor,int anio1){
        
            
        int cantidad=0;       
        try{
            this.conectar();          
            java.sql.Statement conector= conexion.createStatement();
            ResultSet result = conector.executeQuery("select * FROM Persona P, AutorPublicacion AP, Publicacion PU, Journal J WHERE P.nombre='"+nombreAutor+"'and P.idPer=AP.idAutor and AP.idPub=PU.idPub and AP.idPub=J.idPub and PU.anio='"+anio1+"'");
           
            while(result.next()){
                cantidad = cantidad+1;    
            }

            System.out.println("-"+ cantidad);
            this.cerrar();
            conector.close();
            return cantidad;
        }catch(SQLException e){
            System.out.println("error");
            return cantidad;
        }
          
        }
   public int ContarPublicacionAutorAnioLibro1(String nombreAutor,int anio1){
        
            
        int cantidad=0;       
        try{
            this.conectar();         
            java.sql.Statement conector= conexion.createStatement();
            ResultSet result = conector.executeQuery("select * FROM Persona P, AutorPublicacion AP, Publicacion PU, Libro L WHERE P.nombre='"+nombreAutor+"' and P.idPer=AP.idAutor and AP.idPub=PU.idPub and AP.idPub=L.idPub and PU.anio='"+anio1+"'");
           while(result.next()){
                cantidad = cantidad+1;    
            }
             System.out.println("--"+ cantidad);
            this.cerrar();
            conector.close();
            return cantidad;
        }catch(SQLException e){
            System.out.println("error");
            return cantidad;
        }
          
        }
    public int ContarPublicacionAutorAnioArticulo1(String nombreAutor,int anio1){
        
            
        int cantidad=0;       
        try{
            this.conectar();        
           java.sql.Statement conector= conexion.createStatement();
           ResultSet result = conector.executeQuery("select * FROM Persona P, AutorPublicacion AP, Publicacion PU, Articulo A WHERE P.nombre='"+nombreAutor+"' and P.idPer=AP.idAutor and AP.idPub=PU.idPub and AP.idPub=A.idPub and PU.anio='"+anio1+"'");

            while(result.next()){
                cantidad = cantidad+1;    
            }
            System.out.println("--"+ cantidad);
            this.cerrar();
            conector.close();
            return cantidad;
        }catch(SQLException e){
            System.out.println("error");
            return cantidad;
        }
          
        }
  
 public int ContarPublicacionTipoAnio(String tipoIndice,int anio){
        
            
        int cantidad=0;       
        try{
            this.conectar();
            java.sql.Statement conector= conexion.createStatement();
            ResultSet result = conector.executeQuery("select * FROM Publicacion P WHERE P.nombreIndice='"+tipoIndice+"' P.anio='"+anio+"'");
            while(result.next()){
                cantidad = cantidad+1;   
            }
            this.cerrar();
            conector.close();
            return cantidad;
        }catch(SQLException e){
            System.out.println("error");
            return cantidad;
        }
          
        }
  
  public int ContarPublicacionTipoAnio1(String tipo,int anio1){
        
            
        int cantidad=0;       
        try{
            this.conectar();         
            java.sql.Statement conector= conexion.createStatement();
             System.out.println(tipo);
             System.out.println(anio1);
             ResultSet result = conector.executeQuery("select * FROM Publicacion P WHERE P.nombreIndice='"+tipo+"'and P.anio='"+anio1+"'" );
            while(result.next()){
                cantidad = cantidad+1;   
            }
             System.out.println(cantidad);
            this.cerrar();
            conector.close();
            return cantidad;
        }catch(SQLException e){
            System.out.println("error");
            return cantidad;
        }
          
        }
  
  public int contarpublicacionTodoOtroindice2( int anio){
        
            
        int cantidad=0;       
        try{
            this.conectar();         
            java.sql.Statement conector= conexion.createStatement();
            ResultSet result = conector.executeQuery("select * FROM Publicacion P " );
            while(result.next()){
                cantidad = cantidad+1;   
            }
            System.out.println(cantidad);
            this.cerrar();
            conector.close();
            return cantidad;
        }catch(SQLException e){
            System.out.println("error");
            return cantidad;
        }
          
        }
  
  
    
}
