/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;

/**
 *
 * @author Ruulon
 */
public class usuario {
    private String nombre;
    private String login;
    private String pass;

    public usuario(String nombre, String login, String pass) {
        this.nombre = nombre;
        this.login = login;
        this.pass = pass;
    }

    public String getLogin() {
        return login;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


}
