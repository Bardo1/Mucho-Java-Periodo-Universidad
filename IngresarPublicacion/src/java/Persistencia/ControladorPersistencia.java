/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Logica.aviso;
import Logica.propietario;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Ruulon
 */
public class ControladorPersistencia {

    public ControladorPersistencia() {
    }
    public ArrayList lecturausuario(String o) throws FileNotFoundException, IOException{
        return archivo.lecturausuario(o);
    }
    public ArrayList lecturaavisos(String o) throws IOException{
        return archivo.lecturaavisos(o);
    }
    public void escribirarchivo(String o, ArrayList<aviso> a) throws IOException{
        archivo.escribirarchivo(o, a);
    }
    public ArrayList lecurapropietario(String o) throws FileNotFoundException, IOException{
        return archivo.lecturapropietario(o);
    }
    public void escribirpropietario(String o, ArrayList<propietario> a) throws IOException{
        archivo.escribirpropietario(o, a);
    }
}
