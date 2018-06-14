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
    
    public Persona getPersonaListaActiva(int idPer){
       Persona p = (Persona)this.listaP.get(idPer);
       return p;
    }

    public boolean enviarDatosPersona(int id, String nom, String ape, String afi) {
        Persona p = new Persona(id, nom, ape, afi);
        boolean existe = listaP.containsKey(id);
        if (existe == false) {
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
    
    public boolean existePublicacion(int idPubli){
        return cp.existePublicacion(idPubli);
    }
    
    public void ingresarJournal(Journal jou){
        HashMap guardarJournal = jou.Guardar();
        cp.almacenarJournal(guardarJournal);
    }
   
    public void ingresarArticulo(Articulo art){
        HashMap guardarArticulo = art.Guardar();
        cp.almacenarArticulo(guardarArticulo);
    }
    
     public void ingresarLibroCapLibro(LibroCapLibro lib){
        HashMap guardarLibroOCap = lib.Guardar();
        cp.almacenarLibroOCapitulo(guardarLibroOCap);
    }
     
    public CuentaUsuario getCuentaActiva(){
        return this.cuentaActiva;
    }
}
