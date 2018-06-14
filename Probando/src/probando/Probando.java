/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package probando;

/**
 *
 * @author Walter
 */
public class Probando {

    /**
     * @param args the command line arguments
     */

    
    public static void main(String[] args) {
        new NewJFrame().setVisible(true);
        new Forma().setVisible(true);
        // TODO codenew application logic here
        
       new ClaseHilo("mayo").start();
    }
}
