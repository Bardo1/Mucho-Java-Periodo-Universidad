/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;

/**
 *
 * @author Ruulon
 */
public class aviso {
    private String aviso;
    private int id;
    private String nom;
    public aviso(String aviso, int id, String nom) {
        this.aviso = aviso;
        this.id = id;
        this.nom=nom;
    }

    public String getAviso() {
        return aviso;
    }

    public void setAviso(String aviso) {
        this.aviso = aviso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
