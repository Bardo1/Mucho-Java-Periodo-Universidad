/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.util.ArrayList;
/**
 *
 * @author LitOns
 */
public abstract class Publicacion {
    protected int id;
    protected String titulo;
    protected int anioPubli;
    protected String medio;
    protected int pagIni;
    protected int pagTer;
    protected ArrayList<Persona> autores;
    protected String indice;
    
    public Publicacion(int id, String titulo, int anioPub, String medio, int pagIni, int pagTer, String indice){
        this.id = id;
        this.titulo = titulo;
        this.anioPubli = anioPub;
        this.medio = medio;
        this.pagIni = pagIni;
        this.pagTer = pagTer;
        this.autores = null;
        this.indice = indice;
    }
    
    public int getId() {
        return id;
    }   

    public String getTitulo() {
        return titulo;
    }

    public int getAnioPubli() {
        return anioPubli;
    }

    public String getMedio() {
        return medio;
    }

    public int getPagIni() {
        return pagIni;
    }

    public int getPagTer() {
        return pagTer;
    }

    public ArrayList<Persona> getAutores() {
        return autores;
    }
    
    public String getIndice() {
        return indice;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAnioPubli(int anioPubli) {
        this.anioPubli = anioPubli;
    }

    public void setMedio(String medio) {
        this.medio = medio;
    }

    public void setPagIni(int pagIni) {
        this.pagIni = pagIni;
    }

    public void setPagTer(int pagTer) {
        this.pagTer = pagTer;
    }

    public void setAutores(ArrayList<Persona> autores) {
        this.autores = autores;
    }
    
    public void setIndice(String indice) {
        this.indice = indice;
    }
}
