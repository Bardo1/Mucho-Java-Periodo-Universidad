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
public class ControladorPersistencia {
    
public static ControladorPersistencia getControlador() {
    ControladorPersistencia cp =new ControladorPersistencia();
    return cp;
}
public ArrayList getListaFuncionarios(int idDepto) {
    ArrayList ar= new ArrayList();
    return ar;
}
public void almacenarNoticia(HashMap datosNoticia) {
}
}