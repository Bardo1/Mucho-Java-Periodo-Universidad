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
public class Articulo extends Publicacion{
    private String ciudad;
    private String pais;

    public Articulo(String titulo, int anioPub, String medio, int pagIni, int pagTer, String tipoPub, String indice, String ciudad, String pais) {
        super(titulo, anioPub, medio, pagIni, pagTer, tipoPub, indice);
        this.ciudad = ciudad;
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setPais(String pais) {
        this.pais = pais;
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
        datos.put("ciudad", this.ciudad);
        datos.put("pais", this.pais);
        
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
