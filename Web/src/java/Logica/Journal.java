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
    private String serie;

    public Journal() {
        super(-1,null,0,null,0,0,null);
        this.volumen = 0;
        this.serie = null;
    }
    
    public Journal(int id,String titulo, int anioPub, String medio, int pagIni, int pagTer, String indice,int volumen, String serie) {
        super(id, titulo, anioPub, medio, pagIni, pagTer, indice);
        this.volumen = volumen;
        this.serie = serie;
    }

    public int getVolumen() {
        return volumen;
    }

    public String getSerie() {
        return serie;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }
    
    public HashMap Guardar(){
       return this.toCollection();
    }
    
    private HashMap toCollection(){
        HashMap datos = new HashMap();
        
        datos.put("idPubli", this.id);
        datos.put("titulo", this.titulo);
        datos.put("anio", this.anioPubli);
        datos.put("medio", this.medio);
        datos.put("pagIni", this.pagIni);
        datos.put("pagTer", this.pagTer);
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
