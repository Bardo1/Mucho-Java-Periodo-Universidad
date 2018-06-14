/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

/**
 *
 * @author Ruul
 */
public class logeado {
    private String nombre;
    private String pass;

    public logeado(String nom) {
        this.nombre=nom;
        this.pass= "";
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPass() {
        return pass;
    }
    
    
    
}
