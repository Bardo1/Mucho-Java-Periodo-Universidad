/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;



import Logica.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Walter
 */

public class ControladorPersistencia extends ConexionBD {
    public String user;

 
    public void  IngresarValores(String nombre,String apellido,int edad){

     //ingresarcosa(nombre,apellido,edad);
    
    }
    
    
    public void Conectar1(){
    
    conectar();
    }
    
    
   
    
    public DefaultTableModel cargarPreocupacional(){
        DefaultTableModel tabla= new DefaultTableModel();
        tabla = cargarPreocupa();
        return tabla;
    }
   
}
