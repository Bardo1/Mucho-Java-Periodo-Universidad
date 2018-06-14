/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package probando;

/**
 *
 * @author Walter
 */
public class ClaseHilo extends Thread{

    
    private String casa;

    public ClaseHilo(String casa){
        this.casa = casa;
    }


    @Override
    public void run() {
        try {
            while(true){
               
                System.out.println(" chuenlo con -----------: "+ casa );
        
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
          
        }
    }

}