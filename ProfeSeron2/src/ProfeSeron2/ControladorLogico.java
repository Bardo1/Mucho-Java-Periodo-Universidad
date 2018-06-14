/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProfeSeron2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;
import java.util.Iterator;
/**
/**
 *
 * @author Walter
 */
public class ControladorLogico {
private Tienda tienda;

public boolean agregarProductos(ArrayList productosOrig){
    
if(this.tienda == null){
this.tienda = new Tienda();
}

this.tienda.agregarProductos(productosOrig);
int cant = this.tienda.obtCantProd();
if(cant>0){
return true;
} else {
return false;
}
}

public void almacenarProductos(){
this.tienda.almacenarProductos();
}
}