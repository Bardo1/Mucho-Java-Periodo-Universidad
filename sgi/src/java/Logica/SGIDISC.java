package Logica;

import Persistencia.ControladorPersistencia;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author lou
 */
public class SGIDISC {

    private ControladorPersistencia cp;
    private HashMap listaP;
    private CuentaUsuario cuentaActiva;

    public SGIDISC() {
        cp = new ControladorPersistencia();
        cuentaActiva = null;
    }

    public void recuperarListaPersonas() {
        if (listaP == null) {
            ArrayList<HashMap> listaPersonas = cp.recuperarListaPersonas();
            listaP = new HashMap();
            Iterator it = listaPersonas.iterator();
            while (it.hasNext()) {
                HashMap datosPersona = (HashMap) it.next();
                Persona p = new Persona(datosPersona);
                listaP.put(p.getId(), p);
            }
        }

    }

    public boolean enviarDatosPersona(int id, String nom, String afi) {
        Persona p = new Persona(id, nom, afi);
        boolean existe = listaP.containsKey(id);
        if (!existe) {
            p.guardar();
            listaP.put(id, p);
        }
        return existe;
    }
    
    public boolean autenticar(String user,String clave){
        boolean resp;
        HashMap datosCuenta = cp.cargarCuenta(user);
        if(datosCuenta == null){
            return false;
        }
        cuentaActiva = new CuentaUsuario(datosCuenta);
        resp = cuentaActiva.verificarClave(clave);
        return resp;
    }
    
    public ArrayList<HashMap> cargarPersonas(){
        return cp.recuperarListaPersonas();
    }
    
    public ArrayList<HashMap> cargarTiposPubli(){
        return cp.cargarTiposPubli();
    }
    
    public ArrayList<HashMap> cargarIndices(){
        return cp.cargarIndices();
    }
    
    public boolean existePublicacion(String tituloPubli){
        return cp.existePublicacion(tituloPubli);
    }
    
    public void ingresarJournal(String titu, int anio, String medio, int pagIni, int pagTer, ArrayList<HashMap> datosAut
                                    ,String tipoPubli, String indice, int volumen, int serie){
         Journal journal = new Journal(titu, anio, medio, pagIni, pagTer, tipoPubli, indice, volumen, serie);
         
         ArrayList<Persona> autores = new ArrayList<Persona>();
         
         Iterator it = datosAut.iterator();
         
         while(it.hasNext()){
             HashMap datoAutor = (HashMap)it.next();
             int idAutor = Integer.parseInt(String.valueOf(datoAutor.get("idAutor")));
             HashMap otrosDatos = cp.cargarPersona(idAutor);
             String nombre = (String)otrosDatos.get("nom");
             String afiliacion = (String)otrosDatos.get("afi");
             
             Persona autor = new Persona(idAutor,nombre,afiliacion);
             
             autores.add(autor);
         }
         journal.setAutores(autores);
         
         HashMap guardarJournal = journal.Guardar();
         cp.almacenarJournal(guardarJournal);
    }
   
    public void ingresarArticulo(String titu, int anio, String medio, int pagIni, int pagTer, ArrayList<HashMap> datosAut
                                    ,String tipoPubli, String indice, String ciudad, String pais){
         Articulo artConf = new Articulo(titu, anio, medio, pagIni, pagTer, tipoPubli, indice, ciudad, pais);
         
         ArrayList<Persona> autores = new ArrayList<Persona>();
         
         Iterator it = datosAut.iterator();
         
         while(it.hasNext()){
             HashMap datoAutor = (HashMap)it.next();
             int idAutor = Integer.parseInt(String.valueOf(datoAutor.get("idAutor")));
             HashMap otrosDatos = cp.cargarPersona(idAutor);
             String nombre = (String)otrosDatos.get("nom");
             String afiliacion = (String)otrosDatos.get("afi");
             
             Persona autor = new Persona(idAutor,nombre,afiliacion);
             
             autores.add(autor);
         }
         artConf.setAutores(autores);
         
         HashMap guardarArticulo = artConf.Guardar();
         cp.almacenarArticulo(guardarArticulo);
    }
    
     public void ingresarLibroCapLibro(String titu, int anio, String medio, int pagIni, int pagTer, ArrayList<HashMap> datosAut
                                    ,String tipoPubli, String indice, int ISBN, String editorial){
         LibroCapLibro libroCapLibro = new LibroCapLibro(titu, anio, medio, pagIni, pagTer, tipoPubli, indice, ISBN, editorial);
         
         ArrayList<Persona> autores = new ArrayList<Persona>();
         
         Iterator it = datosAut.iterator();
         
         while(it.hasNext()){
             HashMap datoAutor = (HashMap)it.next();
             int idAutor = Integer.parseInt(String.valueOf(datoAutor.get("idAutor")));
             HashMap otrosDatos = cp.cargarPersona(idAutor);
             String nombre = (String)otrosDatos.get("nom");
             String afiliacion = (String)otrosDatos.get("afi");
             
             Persona autor = new Persona(idAutor,nombre,afiliacion);
             
             autores.add(autor);
         }
         libroCapLibro.setAutores(autores);
         
         HashMap guardarLibroOCap = libroCapLibro.Guardar();
         cp.almacenarLibroOCapitulo(guardarLibroOCap);
    }
     
    public CuentaUsuario getCuentaActiva(){
        return this.cuentaActiva;
    }
}
