/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;

/**
 *
 * @author Ruulon
 */
public class propietario {
    private int id;
    private String log;

    public propietario(int id, String log) {
        this.id = id;
        this.log = log;
    }

    public int getId() {
        return id;
    }

    public String getLog() {
        return log;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLog(String log) {
        this.log = log;
    }
    

}
