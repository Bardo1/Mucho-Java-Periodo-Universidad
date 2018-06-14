/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author lou
 */
public class ControladorPersistencia {

    public boolean probarConexion() {
        Conexion c=new Conexion();
        boolean b=c.conectar();
        return b;
    }
    
    public ArrayList<HashMap> recuperarListaPersonas() {
        Conexion c=new Conexion();
        String query= "SELECT * FROM Persona;";
        c.conectar();
        ArrayList <HashMap> listaPersonas=c.ejecutarConRetorno(query);
        c.cerrar();
        return listaPersonas;
                  
    }

    public void almacenarPersona(HashMap datos) {//revisar
        Conexion c = new Conexion();
        int id=(Integer) datos.get("id");
        String nom=(String)datos.get("nom");
        String afi=(String)datos.get("afi");
        String query = "INSERT INTO Persona (id,nom,afi) VALUES ('"+id+"','"+nom+"','"+afi+"');";
        c.conectar();
        c.ejecutarSinRetorno(query);
        c.cerrar();
        
    }
    
    public HashMap cargarCuenta(String user){
        HashMap datosCuenta = null;
        ArrayList<HashMap> datos;
        Conexion c = new Conexion();
        String consulta = "SELECT * FROM CuentaUsuario WHERE usuario ='"+user+"'";
        
        c.conectar();
        datos = c.ejecutarConRetorno(consulta);
        c.cerrar();
        if(datos.size() > 0){
            datosCuenta = datos.get(0);
        }
        
        return datosCuenta;
    }
    
    public ArrayList<HashMap> cargarTiposPubli(){
        Conexion c=new Conexion();
        String query= "SELECT * FROM TipoPublicacion;";
        c.conectar();
        ArrayList <HashMap> lstTipoPubli=c.ejecutarConRetorno(query);
        c.cerrar();
        return lstTipoPubli;
    }
    
    public ArrayList<HashMap> cargarIndices(){
        Conexion c=new Conexion();
        String query= "SELECT * FROM Indice;";
        c.conectar();
        ArrayList <HashMap> lstIndices=c.ejecutarConRetorno(query);
        c.cerrar();
        return lstIndices;
    }
    
    public boolean existePublicacion(String tituloPubli){
        boolean resp = false;
        Conexion c=new Conexion();
        String query= "SELECT titulo FROM publicacion WHERE titulo='"+tituloPubli+"'";
        c.conectar();
        ArrayList <HashMap> existe=c.ejecutarConRetorno(query);
        c.cerrar();
        if(existe.size() > 0){
            resp = true;
        }
        return resp;
    }
    
    public void almacenarJournal(HashMap datos){
        Conexion c = new Conexion();
        
        String titulo = (String)datos.get("titulo");
        int anio = Integer.parseInt(String.valueOf(datos.get("anio")));
        String medio = (String)datos.get("medio");
        int pagIni = Integer.parseInt(String.valueOf(datos.get("pagIni")));
        int pagTer = Integer.parseInt(String.valueOf(datos.get("pagTer")));
        String tipoPubli = (String)datos.get("tipoPubli");
        String indice = (String)datos.get("indice");
        
        String query = "INSERT INTO Publicacion VALUES (id,'"+titulo+"','"+anio+"','"+medio+"','"+pagIni+"',"
                + "                                     '"+pagTer+"','"+tipoPubli+"','"+indice+"');";
        c.conectar();
        c.ejecutarSinRetorno(query);
        c.cerrar();
        
        
        query= "SELECT id FROM Publicacion WHERE titulo='"+titulo+"'";
        c.conectar();
        ArrayList <HashMap> datosPubli=c.ejecutarConRetorno(query);
        c.cerrar();
        
        
        HashMap dato = datosPubli.get(0);
        int idPublic = Integer.parseInt(String.valueOf(dato.get("id")));
        
        int volumen = Integer.parseInt(String.valueOf(datos.get("volumen")));
        int serie = Integer.parseInt(String.valueOf(datos.get("serie")));
        
        query = "INSERT INTO Journal VALUES ('"+idPublic+"','"+volumen+"','"+serie+"');";
        c.conectar();
        c.ejecutarSinRetorno(query);
        c.cerrar();
        
        ArrayList<HashMap> lstIDAutores = (ArrayList)datos.get("autores");
        Iterator it = lstIDAutores.iterator();
        while (it.hasNext()) {
            HashMap autor = (HashMap) it.next();
            int idAutor = Integer.parseInt(String.valueOf(autor.get("idAutor")));

            query = "INSERT INTO AutorPublicacion VALUES ('" + idAutor + "','" + idPublic + "');";
            c.conectar();
            c.ejecutarSinRetorno(query);
            c.cerrar();
        }
    }

    public HashMap cargarPersona(int idPersona) {
        HashMap datosPersona = null;
        ArrayList<HashMap> datos;
        Conexion c = new Conexion();
        String consulta = "SELECT * FROM Persona WHERE id ='" + idPersona + "'";

        c.conectar();
        datos = c.ejecutarConRetorno(consulta);
        c.cerrar();
        if (datos.size() > 0) {
            datosPersona = datos.get(0);
        }

        return datosPersona;
    }
    
    public void almacenarArticulo(HashMap datos){
        Conexion c = new Conexion();
        
        String titulo = (String)datos.get("titulo");
        int anio = Integer.parseInt(String.valueOf(datos.get("anio")));
        String medio = (String)datos.get("medio");
        int pagIni = Integer.parseInt(String.valueOf(datos.get("pagIni")));
        int pagTer = Integer.parseInt(String.valueOf(datos.get("pagTer")));
        String tipoPubli = (String)datos.get("tipoPubli");
        String indice = (String)datos.get("indice");
        
        String query = "INSERT INTO Publicacion VALUES (id,'"+titulo+"','"+anio+"','"+medio+"','"+pagIni+"',"
                + "                                     '"+pagTer+"','"+tipoPubli+"','"+indice+"');";
        c.conectar();
        c.ejecutarSinRetorno(query);
        c.cerrar();
        
        
        query= "SELECT id FROM Publicacion WHERE titulo='"+titulo+"'";
        c.conectar();
        ArrayList <HashMap> datosPubli=c.ejecutarConRetorno(query);
        c.cerrar();
        
        
        HashMap dato = datosPubli.get(0);
        int idPublic = Integer.parseInt(String.valueOf(dato.get("id")));
        
        String ciudad = (String)datos.get("ciudad");
        String pais = (String)datos.get("pais");
        
        query = "INSERT INTO ArtConferencia VALUES ('"+idPublic+"','"+ciudad+"','"+pais+"');";
        c.conectar();
        c.ejecutarSinRetorno(query);
        c.cerrar();
        
        ArrayList<HashMap> lstIDAutores = (ArrayList)datos.get("autores");
        Iterator it = lstIDAutores.iterator();
        while (it.hasNext()) {
            HashMap autor = (HashMap) it.next();
            int idAutor = Integer.parseInt(String.valueOf(autor.get("idAutor")));
            
            query = "INSERT INTO AutorPublicacion VALUES ('" + idAutor + "','" + idPublic + "');";
            c.conectar();
            c.ejecutarSinRetorno(query);
            c.cerrar();
        }
    }
    
    public void almacenarLibroOCapitulo(HashMap datos){
        Conexion c = new Conexion();
        
        String titulo = (String)datos.get("titulo");
        int anio = Integer.parseInt(String.valueOf(datos.get("anio")));
        String medio = (String)datos.get("medio");
        int pagIni = Integer.parseInt(String.valueOf(datos.get("pagIni")));
        int pagTer = Integer.parseInt(String.valueOf(datos.get("pagTer")));
        String tipoPubli = (String)datos.get("tipoPubli");
        String indice = (String)datos.get("indice");
        
        String query = "INSERT INTO Publicacion VALUES (id,'"+titulo+"','"+anio+"','"+medio+"','"+pagIni+"',"
                + "                                     '"+pagTer+"','"+tipoPubli+"','"+indice+"');";
        c.conectar();
        c.ejecutarSinRetorno(query);
        c.cerrar();
        
        
        query= "SELECT id FROM Publicacion WHERE titulo='"+titulo+"'";
        c.conectar();
        ArrayList <HashMap> datosPubli=c.ejecutarConRetorno(query);
        c.cerrar();
        
        
        HashMap dato = datosPubli.get(0);
        int idPublic = Integer.parseInt(String.valueOf(dato.get("id")));
        
        int ISBN = Integer.parseInt(String.valueOf(datos.get("ISBN")));
        String editorial = (String)datos.get("editorial");
        
        query = "INSERT INTO LibroCapLibro VALUES ('"+idPublic+"','"+ISBN+"','"+editorial+"');";
        c.conectar();
        c.ejecutarSinRetorno(query);
        c.cerrar();
        
        ArrayList<HashMap> lstIDAutores = (ArrayList)datos.get("autores");
        Iterator it = lstIDAutores.iterator();
        while (it.hasNext()) {
            HashMap autor = (HashMap) it.next();
            int idAutor = Integer.parseInt(String.valueOf(autor.get("idAutor")));
            
            query = "INSERT INTO AutorPublicacion VALUES ('" + idAutor + "','" + idPublic + "');";
            c.conectar();
            c.ejecutarSinRetorno(query);
            c.cerrar();
        }
    }
}

 