/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package meneses;

/**
 *
 * @author Walter
 */
public class Meneses {

    public static int D[][]=new int[20][20];
    public static int k[][]=new int[20][20];
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    
    
    public static void LCS(int a,int b){
     
      for(int i= 0 ;i<a; i++){D[i][0]= 0;} 
      for(int j= 0 ;j<b; j++){k[0][j]= 0;} 
      
      
            for (int i=0; i<a; i++)
                    for (int j=0; j<; j++)
    }
    
    
   
 /*   
 public void static  LCS(int a, int b) {
     
   for(int i= 0 ;i<a; i++){D[i,0]= 0;} 

for (int j= 0;j<n; j++) do k[0,j] = 0 ;
for() i ← 1 to m do 
 for j ← 1 to n do 
 //if ai = bj
 //then L[i,j] ← L[i-1,j-1] + 1 
 //else 
 //if D[i,j-1] > D[i-1,j] then  
//D[i,j] ← D[i,j-1]   
 //else D[i,j] ← D[i-1,j]
    

    
    
    }
     * *\
     */
}
