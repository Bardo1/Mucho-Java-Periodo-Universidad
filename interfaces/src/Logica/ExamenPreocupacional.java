/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author Walter
 */
public class ExamenPreocupacional {
    private String fechaini;
    private String fechaterm;
    private String rut;
    private String nombre;
    private String detalleDeAprobacion;
    private String observacion;
    
    
    public ExamenPreocupacional( String fechaini, String fechaterm, String rut, String nombre, String detalleDeAprobacion,String observacion){
    
     this.fechaini=fechaini;
     this.fechaterm=fechaterm;
     this.rut=rut;
     this.nombre=nombre;
     this.detalleDeAprobacion=detalleDeAprobacion;
     this.observacion=observacion;
    }

    /**
     * @return the fechaini
     */
    public String getFechaini() {
        return fechaini;
    }

    /**
     * @param fechaini the fechaini to set
     */
    public void setFechaini(String fechaini) {
        this.fechaini = fechaini;
    }

    /**
     * @return the fechaterm
     */
    public String getFechaterm() {
        return fechaterm;
    }

    /**
     * @param fechaterm the fechaterm to set
     */
    public void setFechaterm(String fechaterm) {
        this.fechaterm = fechaterm;
    }

    /**
     * @return the rut
     */
    public String getRut() {
        return rut;
    }

    /**
     * @param rut the rut to set
     */
    public void setRut(String rut) {
        this.rut = rut;
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
     * @return the detalleDeAprobacion
     */
    public String getDetalleDeAprobacion() {
        return detalleDeAprobacion;
    }

    /**
     * @param detalleDeAprobacion the detalleDeAprobacion to set
     */
    public void setDetalleDeAprobacion(String detalleDeAprobacion) {
        this.detalleDeAprobacion = detalleDeAprobacion;
    }

    /**
     * @return the observacion
     */
    public String getObservacion() {
        return observacion;
    }

    /**
     * @param observacion the observacion to set
     */
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
    
    
}
