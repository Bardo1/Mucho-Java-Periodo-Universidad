/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Logica.ControladorLogica;

/**
 *
 * @author Walter
 */
public class principal {
       public static void main(String[] args) {
        // TODO code application logic here
           ControladorLogica cl= new ControladorLogica();
           
          // int valor2 =cl.contarpublicacionTodoOtroindice(1995);
          // System.out.println("valooooooooooooooooor"+ valor2);
  /*         
        
        int valor1= cl.contarpublicacionISCIELO(1995);
    int valor2 =cl.contarpublicacionISI(1995);
    int valor3 = cl.contarpublicacionISIPROCEEDING(1995);
    int total =cl.contarpublicacionTodoOtroindice(1995);
    int valor4 = (valor1+valor2+valor3)-total;
    int porcentaje1= (valor1*100)/total;
    int porcentaje2= (valor2*100)/total;
    int porcentaje3= (valor3*100)/total;
    int porcentaje4= (valor4*100)/total;
     System.out.println("valooooooooooooooooor1"+ porcentaje1);
      System.out.println("valooooooooooooooooor2"+ porcentaje2);
       System.out.println("valooooooooooooooooor3"+ porcentaje3);
        System.out.println("valooooooooooooooooor4"+ porcentaje4);
      
    
         
            
            */
           
   
         
             int valor1= cl.contarJournalAutorAnio("carlos",1995);
    int valor2 =cl.contarConferenciaAutorAnio("carlos",1995);
    int valor3 =cl.contarLibroAutorAnio("carlos",1995);
    int total =valor1+valor2+valor3;
    int porcentaje1= (valor1*100)/total;
    int porcentaje2= (valor2*100)/total;
    int porcentaje3= (valor3*100)/total;
    
     System.out.println("valooooooooooooooooor1 "+  porcentaje1);
     System.out.println("valooooooooooooooooor2 "+  porcentaje2);
     System.out.println("valooooooooooooooooor3 "+  porcentaje3);
    
       
   
     } 
}
