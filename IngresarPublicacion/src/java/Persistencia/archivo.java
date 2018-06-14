/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

/**
 *
 * @author Ruulon
 */
import Logica.aviso;
import Logica.propietario;
import Logica.usuario;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.StringTokenizer;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class archivo {
    public static ArrayList lecturausuario(String o) throws FileNotFoundException, IOException{
        BufferedReader leer = new BufferedReader(new FileReader(o));
        ArrayList<usuario> temp= new ArrayList<usuario>();
        String lin= leer.readLine();

        while(lin!=null){
            StringTokenizer buff = new StringTokenizer(lin,",");
            String log= buff.nextToken();
            String pas= buff.nextToken();
            String nom= buff.nextToken();
            usuario us= new usuario(nom, log, pas);
            temp.add(us);
            lin=leer.readLine();
        }
        leer.close();
        return temp;
    }
    public static ArrayList lecturaavisos(String o) throws IOException{
        BufferedReader leer= new BufferedReader(new FileReader(o));
        ArrayList<aviso> temp= new ArrayList<aviso>();
        String lin= leer.readLine();
        while(lin!=null){
            StringTokenizer buff= new StringTokenizer(lin,",");
            String avis= buff.nextToken();
            int id= Integer.parseInt(buff.nextToken());
            String nom=buff.nextToken();
            aviso av= new aviso(avis, id, nom);
            temp.add(av);
            lin=leer.readLine();
        }
        leer.close();
        return temp;
    }
    public static void escribirarchivo(String o, ArrayList<aviso> a) throws IOException{
        BufferedWriter escribir= new BufferedWriter(new FileWriter(o));
        if(escribir!=null){
            for(int i=0; i<a.size(); i++){
                escribir.write(a.get(i).getAviso()+","+a.get(i).getId()+","+a.get(i).getNom()+"\n");
            }
        }
        escribir.close();
    }
    public static void escribirpropietario(String o, ArrayList<propietario> a) throws IOException{
        BufferedWriter escribir= new BufferedWriter(new FileWriter(o));
        if(escribir!=null){
            for(int i=0; i<a.size(); i++){
                escribir.write(a.get(i).getId()+","+a.get(i).getLog()+"\n");
            }
        }
        escribir.close();
    }
    public static ArrayList lecturapropietario(String o) throws FileNotFoundException, IOException{
        BufferedReader leer= new BufferedReader(new FileReader(o));
        ArrayList<propietario> temp= new ArrayList<propietario>();
        String lin= leer.readLine();
        while(lin!=null){
            StringTokenizer buff= new StringTokenizer(lin,",");
            int id= Integer.parseInt(buff.nextToken());
            String log= buff.nextToken();
            propietario p= new propietario(id, log);
            temp.add(p);
            lin=leer.readLine();
        }
        leer.close();
        return temp;
    }
}

