package Logica;

import Persistencia.ControladorPersistencia;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JTable;

/**
 *
 * @author lou
 */
public class ControladorLogica {

    //private ControladorPersistencia cp;
    private SGIDISC sgi;
    
 private ControladorPersistencia cp;
   
      
     
    
    public ControladorLogica() {
        //this.cp = new ControladorPersistencia();
        this.sgi = new SGIDISC();
        cp= new ControladorPersistencia(); 
        
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

    public  boolean enviarDatosPersona(int id, String nom, String ape, String afi) {
        return sgi.enviarDatosPersona(id, nom, ape, afi);
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
    
    public boolean existePublicacion(int idPubli){
        return sgi.existePublicacion(idPubli);
    }
    
    public void ingresarJournal(Journal jou){
        sgi.ingresarJournal(jou);
    }
    
    public void ingresarArticulo(Articulo art){
        sgi.ingresarArticulo(art);
    }
    
    public void ingresarLibroCapLibro(LibroCapLibro lib){
        sgi.ingresarLibroCapLibro(lib);
    }
    
    public CuentaUsuario getCuentaActiva(){
        return sgi.getCuentaActiva();
    }
    public Persona getPersonaListaActiva(int idPer){
        return sgi.getPersonaListaActiva(idPer);
    }
    
     
    public int contarJournalAutorAnio (String Autor, int anio){
    System.out.println("entra");
    return cp.ContarPublicacionAutorAnioJournal(Autor,anio);
    } 
    public int contarConferenciaAutorAnio (String Autor, int anio){
    return cp.ContarPublicacionAutorAnioArticulo(Autor,anio);
    }    
     public int contarLibroAutorAnio (String Autor, int anio){
    return cp.ContarPublicacionAutorAnioLibro(Autor,anio);
    }  
     
    
    
    
    public int contarpublicacionISI (int anio){
    return cp.ContarPublicacionTipoAnio("ISI",anio);
    }
    public int contarpublicacionISCIELO (int anio){ 
    return cp.ContarPublicacionTipoAnio("SCIELO",anio);
    }
    public int contarpublicacionISIPROCEEDING (int anio){
    return cp.ContarPublicacionTipoAnio("ISI PROCEEDING",anio);
    }      
    public int contarpublicacionTodoOtroindice (int anio){      
    return cp.contarpublicacionTodoOtroindice1(anio);
    }
      
    
    
    
     public void crearReporte(String diaInicio, String mesInicio, String anioInicio, JTable jTable) {
        /**metodo que nos desplegara el reporte de los eventos a nuestro jframe
         mediante una jtable sacando los eventos desde la base de datos*/
        
        jTable.setModel(cp.desplegarEvento(diaInicio, mesInicio, anioInicio));
    }
}
