/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProfeSeron;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author Walter
 */

public class Departamento {
    
private int idDepto;
private Noticia noti;
private ArrayList noticias;
private ArrayList listaFunc;

public void ingresarNoticia(String titulo, String descripcion, Date fecha,String resumen) {
if(this.noticias == null){
this.noticias = new ArrayList();
}
this.noti = new Noticia(titulo, descripcion, fecha, resumen);
this.noticias.add(this.noti);
}


public ArrayList cargarFunc() {
    
ControladorPersistencia cp = ControladorPersistencia.getControlador();
ArrayList datosFunc = cp.getListaFuncionarios(this.idDepto);
this.listaFunc = new ArrayList();
Iterator it = datosFunc.iterator();
while(it.hasNext()){
HashMap dato = (HashMap)it.next();
Funcionario func = new Funcionario(dato);
this.listaFunc.add(func);
}
return this.listaFunc;
}




public void agregarFuncionarioNoticia(int idFuncionario) {
Funcionario func = (Funcionario) this.listaFunc.get(idFuncionario);
this.noti.agregarFuncionario(func);
}


public void confirmarPublicacion() {
    
HashMap datosNoticia = new HashMap();
this.noti.setEstado("publicado");
String nom = this.noti.getTitulo();
datosNoticia.put("nombre", nom);
String desc = this.noti.getDescripcion();
datosNoticia.put("descripcion", desc);
Date fecha = this.noti.getFecha();
datosNoticia.put("fecha", fecha);
String res = this.noti.getResumen();
datosNoticia.put("resumen", res);
String est = this.noti.getEstado();
datosNoticia.put("estado", est);
ControladorPersistencia cp = ControladorPersistencia.getControlador();
cp.almacenarNoticia(datosNoticia);
}
}