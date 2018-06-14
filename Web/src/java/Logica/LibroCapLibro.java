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
public class LibroCapLibro extends Publicacion{
    private int ISBN;
    private String editorial;
    
    public LibroCapLibro() {
        super(-1,null,0,null,0,0,null);
        this.ISBN = 0;
        this.editorial = null;
    }

    public LibroCapLibro(int id, String titulo, int anioPub, String medio, int pagIni, int pagTer, String indice, int ISBN, String editorial) {
        super(id, titulo, anioPub, medio, pagIni, pagTer, indice);
        this.ISBN = ISBN;
        this.editorial = editorial;
    }

    public int getISBN() {
        return ISBN;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
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
        datos.put("ISBN", this.ISBN);
        datos.put("editorial", this.editorial);
        
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
