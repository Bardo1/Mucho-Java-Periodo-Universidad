/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author LitOns
 */
public class Journal extends Publicacion{
    private int volumen;
    private int serie;

    public Journal(String titulo, int anioPub, String medio, int pagIni, int pagTer, String tipoPub, String indice,int volumen, int serie) {
        super(titulo, anioPub, medio, pagIni, pagTer, tipoPub, indice);
        this.volumen = volumen;
        this.serie = serie;
    }

    public int getVolumen() {
        return volumen;
    }

    public int getSerie() {
        return serie;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }
    
    public HashMap Guardar(){
       return this.toCollection();
    }
    
    private HashMap toCollection(){
        HashMap datos = new HashMap();
        
        datos.put("titulo", this.titulo);
        datos.put("anio", this.anioPubli);
        datos.put("medio", this.medio);
        datos.put("pagIni", this.pagIni);
        datos.put("pagTer", this.pagTer);
        datos.put("tipoPubli", this.tipoPubli);
        datos.put("indice", this.indice);
        datos.put("volumen", this.volumen);
        datos.put("serie", this.serie);
        
        Iterator it = this.autores.iterator();
        ArrayList<HashMap> lstIDAutores = new ArrayList();
       
        while(it.hasNext()){
          HashMap datosAutor = new HashMap();
           Persona p = (Persona)it.next();
           datosAutor.put("idAutor", p.getId());
           lstIDAutores.add(datosAutor);
        }
        datos.put("autores", lstIDAutores);
        
        return datos;
    }
}
