/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

/**
 *
 * @author Walter
 */
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.Statement;
 
public class Test {
        private  String userName = "sa";
        private  String password = "5371569";
        private  String statement = "select * from TABLADATOS;";
        private java.sql.Connection connection = null;
         //   private Connection conexion;

      
        
        public Test() {
        }
 
        private java.sql.Connection getConnection() {
                try {
                      // Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
         //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                      //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       //  connection = java.sql.DriverManager.getConnection("jdbc:sqlserver://WALTER-HP/PROBANDO\\sqlserver;databaseName=NuevaBase;user=usuario1;password=5371569");
            //            DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS;DatabaseName=DATABASE", "user", "passwd");
                     
         
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            //en la ultima parte va el nombre que creamos en el odbcad32
            connection=java.sql.DriverManager.getConnection("jdbc:odbc:datos");
         if (connection != null)
                                System.out.println("Connection Successful!");
                } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Error Trace in getConnection() : "
                                        + e.getMessage());
                }
                return connection;
        }
 
        
          public boolean conectar() {
        this.connection = null;
        try {
            //Get connection
            System.out.println("paso 2");
            // Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            //en la ultima parte va el nombre que creamos en el odbcad32
            // String URL = "jdbc:mysql://"+this.server+":"+this.port+"/"+this.nombreBD;
            System.out.println("paso 4");
            //System.out.println(URL);
            System.out.println("paso 5");
            
            System.out.println("paso 6");
            //this.connection = java.sql.DriverManager.getConnection("jdbc:sqlserver://WALTER-HP/PROBANDO\\sqlserver;databaseName=NuevaBase;user=usuario1;password=5371569");
           this.connection  = java.sql.DriverManager.getConnection("jdbc:sqlserver://WALTER-HP/PROBANDO;databaseName=NuevaBase;integratedSecurity=true");
            //connection=java.sql.DriverManager.getConnection("jdbc:odbc:NuevaBase");    
          
          
            System.out.println("paso 7");
            
            
             if (this.connection != null) {
                  System.out.println();
                  System.out.println("Conexion Exitosa!!!");
                  System.out.println();
                  // Meta data
                  DatabaseMetaData meta = this.connection.getMetaData();
                  System.out.println("\nDriver Information");
                  System.out.println("Driver Name: " + meta.getDriverName());
                  System.out.println("Driver Version: " + meta.getDriverVersion());
                  System.out.println("\nDatabase Information ");
                  System.out.println("Database Name: " + meta.getDatabaseProductName());
                  System.out.println("Database Version: " + meta.getDatabaseProductVersion());
                  return true;
             }

        }catch(SQLException se) {
            System.out.println("No esntro 1");
             se.printStackTrace();
             
        }catch (ClassNotFoundException cnf){
           System.out.println("No esntro 2");
            cnf.printStackTrace();
            
        }
        return false;
    }

          
        
          
          public void displayDbProperties() {
                java.sql.DatabaseMetaData dm = null;
                java.sql.ResultSet result = null;
                try {
                        connection = this.getConnection();
                        if (connection != null) {
                                dm = connection.getMetaData();
                                System.out.println("Driver Information");
                                System.out.println("\tDriver Name: " + dm.getDriverName());
                                System.out
                                                .println("\tDriver Version: " + dm.getDriverVersion());
                                System.out.println("\nDatabase Information ");
                                System.out.println("\tDatabase Name: "
                                                + dm.getDatabaseProductName());
                                System.out.println("\tDatabase Version: "
                                                + dm.getDatabaseProductVersion());
                               
                                Statement select = connection.createStatement();
                                result = select.executeQuery(statement);
                               
                               /* while (result.next()) {
                                        System.out.println("Nombre: " + result.getString(1) + "\n");
                                        System.out.println("Apellido: " + result.getString(2) + "\n");
                                        System.out.println("Dni: " + result.getString(3) + "\n");
                                }*/
                                result.close();
                                result = null;
                                closeConnection();
                        } else
                                System.out.println("Error: No active Connection");
                } catch (Exception e) {
                        e.printStackTrace();
                }
                dm = null;
        }
 
        private void closeConnection() {
                try {
                        if (connection != null)
                                connection.close();
                        connection = null;
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }
 
        public static void main(String[] args) throws Exception {
                Test myDbTest = new Test();
                myDbTest.displayDbProperties();
        }
}
