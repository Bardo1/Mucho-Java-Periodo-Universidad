package Logica;

import Persistencia.ControladorPersistencia;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author lou
 */
public class DeptoFinanzas {

    private ControladorPersistencia cp;
    private HashMap listaPersonas;
 //   private CuentaUsuario cuentaActiva;

    public DeptoFinanzas() {
        cp = new ControladorPersistencia();
    //  this.cargarListaPersonas();
    //  cuentaActiva = null;
    }

  /*  public void cargarListaPersonas() {
        if (listaPersonas == null) {
            listaPersonas = new HashMap();
        }
        ArrayList<HashMap> listaPers = cp.recuperarPersonas();
        Iterator it = listaPers.iterator();
        while (it.hasNext()) {
               HashMap datosPersona = (HashMap) it.next();
               Persona p = new Persona(datosPersona);
               listaPersonas.put(p.getId(), p);
        }
    }
    
    public Persona getPersonaListaActiva(int idPer){
       Persona p = (Persona)this.listaPersonas.get(idPer);
       return p;
    }

    public boolean enviarDatosPersona(String nom, String ape, String afi) {
        Persona p = new Persona(nom, ape, afi);
        HashMap datosPer = p.guardar();
        boolean existe = cp.existePersona(datosPer);
        boolean seIngreso = false;
        if (existe == false) {
            cp.almacenarPersona(datosPer);
            HashMap datosPersona = cp.obtenerPersona(nom,ape,afi);
            Persona per = new Persona(datosPersona);
            listaPersonas.put(per.getId(), per);
            seIngreso = true;
        }
        return seIngreso;
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
    */
    
     /*public boolean enviarDatosPersona(String nom, String ape, String afi) {
        Persona p = new Persona(nom, ape, afi);
        HashMap datosPer = p.guardar();
        boolean existe = cp.existePersona(datosPer);
        boolean seIngreso = false;
        if (existe == false) {
            cp.almacenarPersona(datosPer);
            HashMap datosPersona = cp.obtenerPersona(nom,ape,afi);
            Persona per = new Persona(datosPersona);
            listaPersonas.put(per.getId(), per);
            seIngreso = true;
        }
        return seIngreso;
    }
    */
    
    public ArrayList<HashMap> recuperarPersonas(){
        return cp.recuperarPersonas();
    }
    
    public ArrayList<HashMap> cargarTiposPubli(){
        return cp.cargarTiposPubli();
    }
    
    public ArrayList<HashMap> cargarIndices(){
        return cp.cargarIndices();
    }
    
    public boolean existePublicacion(String titulo){
        return cp.existePublicacion(titulo);
    }
    
    public ArrayList<HashMap> cargarTiposFinan(){
        return cp.cargarTiposFinan();
    }
    
    public ArrayList<HashMap> cargarFuentesExt(){
        return cp.cargarFuentesExt();
    }
    
    public ArrayList<HashMap> cargarEstados(){
        return cp.cargarEstados();
    }
    
    public ArrayList<HashMap> cargarRoles(){
        return cp.cargarRoles();
    }
    
    public ArrayList<HashMap> obtenerSubclasif(String unaSubclas){
        return cp.obtenerSubclasif(unaSubclas);
    }
}
