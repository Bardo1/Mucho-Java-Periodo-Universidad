/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProfeSeron;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;
/**

/**
 *
 * @author Walter
 */
public class Noticia {
private String titulo;
private String descripcion;
private Date fecha;
private String resumen;
private String estado;
private ArrayList funcionarios;
public Noticia(String titulo, String descripcion, Date fecha,
String resumen) {
this.titulo = titulo;
this.descripcion = descripcion;
this.fecha = fecha;
this.resumen = resumen;
}
public void agregarFuncionario(Funcionario func) {
if(this.funcionarios == null){
this.funcionarios = new ArrayList();
}
this.funcionarios.add(func);
}
public void setEstado(String estado) {
this.estado=estado;
}
public String getDescripcion() {
return this.descripcion;
}
public String getEstado() {
return this.estado;
}
public Date getFecha() {
return this.fecha;
}
public String getResumen() {
return this.resumen;
}
public String getTitulo() {
return titulo;
}
}