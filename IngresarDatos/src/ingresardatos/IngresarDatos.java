/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ingresardatos;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Walter
 */
public class IngresarDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        InsertarContacto("10","B","9","2012","Prueba de taller de progra","Ladeco");
       // buscarId(1, 1, 1);
        
        // TODO code application logic here
        
    }
    
    
     public static void InsertarEvento(String dia, String bloque, String mes, String  ano, String descripción, String lugar){
       try {
           
            // instancia el driver a utilizar
            Class.forName("com.mysql.jdbc.Driver");
            // crear el objetio de conexion
            Connection conexion= DriverManager.getConnection("jdbc:mysql://146.83.123.113/dbtp05", "userdbtp05", "xYDjSjGjcsddL6Jd");
            Statement conector= conexion.createStatement();
            // informo el estado
            System.out.println("se Conecto");
            // inserto nuevos datos
            conector.executeUpdate("insert into horario(dia,bloque,mes,ano,descripción,lugar) values ('"+dia+"','"+bloque+"','"+mes+"','"+ano+"','"+descripción+"','"+lugar+"')");
            conector.close();
            conexion.close();
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IngresarDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            
            System.out.println("Error de Conexion"+e);
        }
     }

 

public  static DefaultTableModel BuscaryDesplegarEvento(String dia, String mes,String ano){
        DefaultTableModel ingresoH;

        String[] nombresTabla={"dia","mes","año","bloque","lugar"};
        String[] resultadoConsulta= new String[5];
        ingresoH= new DefaultTableModel(null, nombresTabla);
            
        try{
            // instancia el driver a utilizar
            Class.forName("com.mysql.jdbc.Driver");
            // crear el objetio de conexion
            Connection conexion= DriverManager.getConnection("jdbc:mysql://146.83.123.113/dbtp05", "userdbtp05", "xYDjSjGjcsddL6Jd");
            Statement conector= conexion.createStatement();
            // informa el estado si se conecta
            System.out.println("se Conecto");
            ResultSet resultado= conector.executeQuery("select * from horario where dia="+dia+" and ano="+ano+" and mes="+mes+"");
            //retorna los datos de la base de datos donde la id es igual a la solicitada
            while(resultado.next()){
                resultadoConsulta[0]=dia;
                resultadoConsulta[1]=mes;
                resultadoConsulta[2]=ano;
                resultadoConsulta[3]=resultado.getString("bloque");
                resultadoConsulta[4]=resultado.getString("descripcion");
                ingresoH.addRow(resultadoConsulta);
            }
            
            conector.close();
            conexion.close();
            
        }catch (ClassNotFoundException ex) {
            
            Logger.getLogger(IngresarDatos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (SQLException e) {
            System.out.println("Error de Conexion"+e);
            return null;
        }
        return ingresoH;
    }
}