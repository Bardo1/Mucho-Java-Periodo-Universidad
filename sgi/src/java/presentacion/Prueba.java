package presentacion;

import Logica.ControladorLogica;
import Logica.Persona;
import Persistencia.ControladorPersistencia;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Prueba {

    public static void main(String[] args) {
        ControladorLogica cl = new ControladorLogica(); 
        ArrayList<HashMap> lstPersonas = cl.cargarPersonas();
        Iterator it = lstPersonas.iterator();
        while (it.hasNext()) {
            HashMap p = (HashMap) it.next();
            String id = (String) p.get("idPer");
            String nom = (String) p.get("nombre");
            String ape = (String) p.get("apellido");
            System.out.println("id :" + id);
            System.out.println("Nombre :" + nom);
        }
    }
}