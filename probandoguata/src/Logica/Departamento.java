/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.ControladorPersistencia;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Walter
 */
public class Departamento {
    
    
    public Departamento(){}
    
    public void agregarnoticio(Noticia noti){
    
    
    }
    ArrayList <String > datos= new ArrayList <String >();
   
    public void cargafuncionarios(int id){
    ControladorPersistencia cp= new ControladorPersistencia();
    
    HashMap ListaFunc=cp.CargarFuncionario(id);
     HashMap ListaFunc1= new HashMap();
    
   Iterator it = ListaFunc1.entrySet().iterator();
   while (it.hasNext()) {
   Map.Entry e = (Map.Entry)it.next();
   System.out.println(e.getKey() + " " + e.getValue());
   
   
   
   
      for(int i=0; i<datos.size();i++){
           String resultado = datos.get(i);
           
           letraBloque.addItem(resultado);
           }
}
    
    
    }
}
