/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lcs;

/**
 *
 * @author Walter
 */
public class LCS {

    public static void main(String[] args) {
        String x = "CARECOTWALTERMUÑOZNETESGA"; //Mandamos la cadena de String A
        String y ="VAUDGANVWALTERMUÑOZADFSFG"; //Mandamos la cadena de String B
        int M = x.length(); // Sacamos su longitud
        int N = y.length();

        // hacemos una matriz con la longitud de nuestros string mandados con m y n
        int[][] opt = new int[M+1][N+1];

        // recorremos la matriz con el largo de nuestros strings y nos sersioramos si es que son iguales en alguno de ellos
        for (int i = M-1; i >= 0; i--) {
            for (int j = N-1; j >= 0; j--) {
                if (x.charAt(i) == y.charAt(j))
                    // le sumamos uno para que nos cuenta la oportunidad en la que se juntaron
                    opt[i][j] = opt[i+1][j+1] + 1;
                else 
                    // que nos retorne el mayor para saber la oportunidad mas larga o de mayor tamaño.
                    opt[i][j] = Math.max(opt[i+1][j], opt[i][j+1]);
            }
        }

        // para recuperar e impprimir la solucion debemos hacer un while, sin salir de los largos de los strings
       
        int i = 0, j = 0;
        while(i < M && j < N) {
            // si los valores son iguales los imprimimos
            if (x.charAt(i) == y.charAt(j)) {
                System.out.print(x.charAt(i));
                i++;
                j++;
            }
            //avanzamos el i o el j dependiendo de el valor almacenado en la matriz
            else if (opt[i+1][j] >= opt[i][j+1]) i++;
            else                                 j++;
        }
        System.out.println();

    }
}

   

