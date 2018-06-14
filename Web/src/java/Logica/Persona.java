/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.ControladorPersistencia;
import java.util.HashMap;

/**
 *
 * @author lou
 */
public class Persona {

    private String nombre;
    private int id;
    private String apellido;
    private String afiliacion;
    private ControladorPersistencia cp;

    public Persona(int id, String nom, String ape, String afi) {
        this.id = id;
        this.nombre = nom;
        this.apellido = ape;
        this.afiliacion = afi;
        this.cp=new ControladorPersistencia();
    }

    public Persona(HashMap datos) {
        String ids = (String) datos.get("idPer");
        this.id = Integer.parseInt(String.valueOf(ids));
        this.nombre = (String) datos.get("nombre");
        this.apellido = (String) datos.get("apellido");
        this.afiliacion = (String) datos.get("afiliacion");
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the afiliacion
     */
    public String getAfiliacion() {
        return afiliacion;
    }

    /**
     * @param afiliacion the afiliacion to set
     */
    public void setAfiliacion(String afiliacion) {
        this.afiliacion = afiliacion;
    }

    public void guardar() {
        HashMap datos = toCollection();
        cp.almacenarPersona(datos);
    }

    private HashMap toCollection() {
        HashMap datos = new HashMap();
        datos.put("idPer", id);
        datos.put("nombre", nombre);
        datos.put("apellido", apellido);
        datos.put("afiliacion", afiliacion);
        return datos;
    }
}
