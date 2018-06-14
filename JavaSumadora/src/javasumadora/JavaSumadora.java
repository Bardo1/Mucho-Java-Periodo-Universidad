/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javasumadora;

/**
 *
 * @author Walter
 */
public class JavaSumadora {

 private int numero1;
 private int numero2;

    /**
     * @param numero1 the numero1 to set
     */
    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    /**
     * @param numero2 the numero2 to set
     */
    public void setNumero2(int numero2) {
        this.numero2 = numero2;
    }
    
    public int calcular(){
    int resultado=numero1+numero2;
    return resultado;
    }
    public int calcular(String numero1, String numero2){
        this.numero1=Integer.parseInt(numero1);
        this.numero2=Integer.parseInt(numero2);
        int Resultado=this.numero1+this.numero2;
        return Resultado;
    
    }
 
}
