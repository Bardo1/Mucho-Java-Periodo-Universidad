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
public class ControladorPersistencia extends Conexion {

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
        int idPer=(Integer) datos.get("idPer");
        String nom=(String)datos.get("nombre");
        String ape=(String)datos.get("apellido");
        String afi=(String)datos.get("afiliacion");
        String query = "INSERT INTO Persona VALUES ('"+idPer+"','"+nom+"','"+ape+"','"+afi+"');";
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
    
    public boolean existePublicacion(int idPubli){
        boolean resp = false;
        Conexion c=new Conexion();
        String query= "SELECT idPub FROM Publicacion WHERE idPub='"+idPubli+"'";
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
        
        int idPubli = Integer.parseInt(String.valueOf(datos.get("idPubli")));
        String titulo = (String)datos.get("titulo");
        int anio = Integer.parseInt(String.valueOf(datos.get("anio")));
        String medio = (String)datos.get("medio");
        int pagIni = Integer.parseInt(String.valueOf(datos.get("pagIni")));
        int pagTer = Integer.parseInt(String.valueOf(datos.get("pagTer")));
        String indice = (String)datos.get("indice");
        
        String query = "INSERT INTO Publicacion VALUES ('"+idPubli+"','"+titulo+"','"+anio+"','"+medio+"','"+pagIni+"',"
                + "                                     '"+pagTer+"','"+indice+"');";
        c.conectar();
        c.ejecutarSinRetorno(query);
        c.cerrar();
        
        int volumen = Integer.parseInt(String.valueOf(datos.get("volumen")));
        String serie = (String) datos.get("serie");
        
        query = "INSERT INTO Journal VALUES ('"+idPubli+"','"+volumen+"','"+serie+"');";
        c.conectar();
        c.ejecutarSinRetorno(query);
        c.cerrar();
        
        ArrayList<HashMap> lstIDAutores = (ArrayList)datos.get("autores");
        Iterator it = lstIDAutores.iterator();
        while (it.hasNext()) {
            HashMap autor = (HashMap) it.next();
            int idAutor = Integer.parseInt(String.valueOf(autor.get("idAutor")));

            query = "INSERT INTO AutorPublicacion VALUES ('" + idAutor + "','" + idPubli + "');";
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
        
        int idPubli = Integer.parseInt(String.valueOf(datos.get("idPubli")));
        String titulo = (String)datos.get("titulo");
        int anio = Integer.parseInt(String.valueOf(datos.get("anio")));
        String medio = (String)datos.get("medio");
        int pagIni = Integer.parseInt(String.valueOf(datos.get("pagIni")));
        int pagTer = Integer.parseInt(String.valueOf(datos.get("pagTer")));
        String indice = (String)datos.get("indice");
        
        String query = "INSERT INTO Publicacion VALUES ('"+idPubli+"','"+titulo+"','"+anio+"','"+medio+"','"+pagIni+"',"
                + "                                     '"+pagTer+"','"+indice+"');";
        c.conectar();
        c.ejecutarSinRetorno(query);
        c.cerrar();
        
        String ciudad = (String)datos.get("ciudad");
        String pais = (String)datos.get("pais");
        
        query = "INSERT INTO Articulo VALUES ('"+idPubli+"','"+ciudad+"','"+pais+"');";
        c.conectar();
        c.ejecutarSinRetorno(query);
        c.cerrar();
        
        ArrayList<HashMap> lstIDAutores = (ArrayList)datos.get("autores");
        Iterator it = lstIDAutores.iterator();
        while (it.hasNext()) {
            HashMap autor = (HashMap) it.next();
            int idAutor = Integer.parseInt(String.valueOf(autor.get("idAutor")));
            
            query = "INSERT INTO AutorPublicacion VALUES ('" + idAutor + "','" + idPubli + "');";
            c.conectar();
            c.ejecutarSinRetorno(query);
            c.cerrar();
        }
    }
    
    public void almacenarLibroOCapitulo(HashMap datos){
        Conexion c = new Conexion();
        
        int idPubli = Integer.parseInt(String.valueOf(datos.get("idPubli")));
        String titulo = (String)datos.get("titulo");
        int anio = Integer.parseInt(String.valueOf(datos.get("anio")));
        String medio = (String)datos.get("medio");
        int pagIni = Integer.parseInt(String.valueOf(datos.get("pagIni")));
        int pagTer = Integer.parseInt(String.valueOf(datos.get("pagTer")));
        String indice = (String)datos.get("indice");
        
        String query = "INSERT INTO Publicacion VALUES ('"+idPubli+"','"+titulo+"','"+anio+"','"+medio+"','"+pagIni+"',"
                + "                                     '"+pagTer+"','"+indice+"');";
        c.conectar();
        c.ejecutarSinRetorno(query);
        c.cerrar();
        
        int ISBN = Integer.parseInt(String.valueOf(datos.get("ISBN")));
        String editorial = (String)datos.get("editorial");
        
        query = "INSERT INTO Libro VALUES ('"+idPubli+"','"+ISBN+"','"+editorial+"');";
        c.conectar();
        c.ejecutarSinRetorno(query);
        c.cerrar();
        
        ArrayList<HashMap> lstIDAutores = (ArrayList)datos.get("autores");
        Iterator it = lstIDAutores.iterator();
        while (it.hasNext()) {
            HashMap autor = (HashMap) it.next();
            int idAutor = Integer.parseInt(String.valueOf(autor.get("idAutor")));
            
            query = "INSERT INTO AutorPublicacion VALUES ('" + idAutor + "','" + idPubli + "');";
            c.conectar();
            c.ejecutarSinRetorno(query);
            c.cerrar();
        }
    }
    
    
    
   public int ContarPublicacionAutorAnioJournal(String autor,int anio){
   return ContarPublicacionAutorAnioJournal1(autor,anio);
   }  
   public int ContarPublicacionAutorAnioArticulo(String autor,int anio){
   return ContarPublicacionAutorAnioArticulo1(autor,anio);
   }
   public int ContarPublicacionAutorAnioLibro(String autor,int anio){
   return ContarPublicacionAutorAnioLibro1(autor,anio);
   }
   public int ContarPublicacionTipoAnio(String tipo,int anio){
   return ContarPublicacionTipoAnio1(tipo, anio);
   }
   public int contarpublicacionTodoOtroindice1(int anio){
   return contarpublicacionTodoOtroindice2(anio);
   }
 
  
     
}

 