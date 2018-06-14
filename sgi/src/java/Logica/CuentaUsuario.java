/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.HashMap;

/**
 *
 * @author LitOns
 */
public class CuentaUsuario {
   
    private String usuario;
    private String clave;
    private String tipoUsuario;
    
    public CuentaUsuario(HashMap datosCuenta){
        this.usuario = (String)datosCuenta.get("usuario");
        this.clave = (String)datosCuenta.get("clave");
        this.tipoUsuario = (String)datosCuenta.get("tipoUsuario");
    }

    public String getUsuario() {
        return usuario;
    }

    public String getClave() {
        return clave;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPass(String pass) {
        this.clave = clave;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    public boolean verificarClave(String unaClave){
        if(this.clave.equals(unaClave)){
            return true;
        }else{
            return false;
        }
    }
}
