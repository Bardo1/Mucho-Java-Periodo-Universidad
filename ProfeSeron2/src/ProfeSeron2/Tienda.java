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
 *
 * @author Walter
 */


public class Tienda {
    
private ArrayList productos;

public void agregarProductos(ArrayList productosOrig) {
this.productos = new ArrayList();

Iterator it = productosOrig.iterator();
while(it.hasNext()){
ArrayList dato = (ArrayList) it.next();
Iterator itd = dato.iterator();
String nom = (String) itd.next();
String desc = (String) itd.next();
int prec = ((Integer)itd.next()).intValue();
Producto prod = new Producto(nom, desc, prec);
this.productos.add(prod);
}
}
public int obtCantProd() {
return this.productos.size();
}

void almacenarProductos() {    
new ControladorPersistencia().almacenarProductos(this.productos);
}
}
