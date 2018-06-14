package Logica;

import Persistencia.ControladorPersistencia;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author lou
 */
public class ControladorLogica {

    //private ControladorPersistencia cp;
    private SGIDISC sgi;
    

    public ControladorLogica() {
        //this.cp = new ControladorPersistencia();
        this.sgi = new SGIDISC();
        
    }

    /*
    public boolean probarConexion() {
        boolean conexion = cp.probarConexion();
        return conexion;
    }
     * 
     */

    public void selIngresarPersona() {
        this.sgi.recuperarListaPersonas();
    }

    public  boolean enviarDatosPersona(int id, String nom, String afi) {
        return !sgi.enviarDatosPersona(id, nom, afi);
    }  
    
    public boolean autenticar(String user,String clave){
         return sgi.autenticar(user, clave);
    }
    
    public ArrayList<HashMap> cargarPersonas(){
        return sgi.cargarPersonas();
    }
    
    public ArrayList<HashMap> cargarTiposPubli(){
        return sgi.cargarTiposPubli();
    }
    
    public ArrayList<HashMap> cargarIndices(){
        return sgi.cargarIndices();
    }
    
    public boolean existePublicacion(String tituloPubli){
        return sgi.existePublicacion(tituloPubli);
    }
    
    public void ingresarJournal(String titu, int anio, String medio, int pagIni, int pagTer, ArrayList<HashMap> datosAut
                                    ,String tipoPubli, String indice, int volumen,int serie){
        sgi.ingresarJournal(titu,anio,medio,pagIni,pagTer,datosAut,tipoPubli,indice,volumen,serie);
    }
    
    public void ingresarArticulo(String titu, int anio, String medio, int pagIni, int pagTer, ArrayList<HashMap> datosAut
                                    ,String tipoPubli, String indice, String ciudad,String pais){
        sgi.ingresarArticulo(titu,anio,medio,pagIni,pagTer,datosAut,tipoPubli,indice,ciudad,pais);
    }
    
    public void ingresarLibroCapLibro(String titu, int anio, String medio, int pagIni, int pagTer, ArrayList<HashMap> datosAut
                                    ,String tipoPubli, String indice, int ISBN, String editorial){
        sgi.ingresarLibroCapLibro(titu,anio,medio,pagIni,pagTer,datosAut,tipoPubli,indice,ISBN,editorial);
    }
    
    public CuentaUsuario getCuentaActiva(){
        return sgi.getCuentaActiva();
    }
}
