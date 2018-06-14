/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;

import Persistencia.ControladorPersistencia;
import Persistencia.archivo;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Ruulon
 */
public class ControladorLogica {
    ControladorPersistencia cp;
    aviso av;
    usuario us;
    public ControladorLogica() {
    }

    public ArrayList lecturausuario(String o) throws FileNotFoundException, IOException{
        cp= new ControladorPersistencia();
        return cp.lecturausuario(o);
    }
    public ArrayList lecturaavisos(String o) throws IOException{
        cp=new ControladorPersistencia();
        return cp.lecturaavisos(o);
    }
    public void escribirarchivo(String o, ArrayList<aviso> a) throws IOException{
        cp.escribirarchivo(o, a);
    }
    public void escribirpropietario(String o, ArrayList<propietario> a) throws IOException{
        cp.escribirpropietario(o, a);
    }
    public ArrayList lecturapropietario(String o) throws FileNotFoundException, IOException{
        cp= new ControladorPersistencia();
        return cp.lecurapropietario(o);
    }
}
