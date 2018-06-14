/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProfeSeron;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;
/**
 *
 * @author Walter
 */
public class ControladorLogica {
    
private Departamento depto;

public ArrayList ingresarNoticia(String titulo, String descripcion, Date fecha, String resumen){
Date fechaAct = Utils.getFechaActual();


if(fecha.before(fechaAct)){
return null;
}

if(this.depto == null){
this.depto = new Departamento();
}

this.depto.ingresarNoticia(titulo, descripcion, fecha, resumen);
ArrayList listaFunc = this.depto.cargarFunc();
return listaFunc;
}


public void agregarFuncionarioNoticia(int idFuncionario){
this.depto.agregarFuncionarioNoticia(idFuncionario);
}



public void confirmarPublicacion(){
this.depto.confirmarPublicacion();
}

}

