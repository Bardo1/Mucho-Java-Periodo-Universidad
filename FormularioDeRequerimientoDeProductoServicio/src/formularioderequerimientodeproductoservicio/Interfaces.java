/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package formularioderequerimientodeproductoservicio;

import Persistencia.ConexionDB;
import Persistencia.ControladorPersistencia;
import Persistencia.Test;
//import com.mysql.jdbc.Connection;

/**
 *
 * @author Walter
 */


public class Interfaces {
    /**
     * @param args the command line arguments
     */
   public static String nomb;
   public static Test pruebe;
   public static ConexionDB CBD;
    public static void main(String[] args) {
      pruebe=new Test();
      
      pruebe.conectar();
        
    }
    public static void nombre(String n){
        nomb= n;
        
    }
    public static String getnom(){
        return nomb;
    }
}

