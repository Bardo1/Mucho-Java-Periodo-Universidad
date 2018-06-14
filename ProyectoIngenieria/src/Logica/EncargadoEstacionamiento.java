/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author Walter
 */
public class EncargadoEstacionamiento {
    


public void crearEstudiante(String NumMatricula,String NumEstudiante){

Estudiante E= new Estudiante(NumMatricula,NumEstudiante);
E.Guarda();

}
}