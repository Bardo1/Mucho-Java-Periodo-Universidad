/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevaprueba;




import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;
/**
 *
 * Walter
 */
public class NuevaPrueba extends  JFrame implements ActionListener {
private JButton boton;
private JTextField ingresaretiqueta;
private JTextField ingresaretiqueta2;
private JTextField ingresaretiqueta3;
private JTextField ingresaretiqueta4;
private JLabel resultado1;
private JLabel resultado2;
private JLabel selecop1;
private JLabel selecop2;
private JComboBox cosas;
private JComboBox cosas2;
private Hilocalculadora hc;
private Hilocalculadora1 hc1;

    public NuevaPrueba()  {
        
        super("ventana de prueba");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);
        JLabel etiqueta= new JLabel(" ingrese primer numero ");
        JLabel etiqueta2= new JLabel(" ingrese segundo numero ");
        JLabel resultado1= new JLabel("Resultado 1 ");
        JLabel resultado2= new JLabel("Resultado 2 ");
        JLabel selecop1= new JLabel("Seleccione su operacion");
        JLabel selecop2= new JLabel("Seleccione su operacion ");
         boton= new JButton ("RESULTADOS");
         boton.addActionListener(this);
         ingresaretiqueta = new JTextField(20);
         ingresaretiqueta2 = new JTextField(20);
         ingresaretiqueta3 = new JTextField(20);
         ingresaretiqueta4 = new JTextField(20);
         
        cosas= new JComboBox ();
        cosas.addItem("+");
        cosas.addItem("-");
        cosas.addItem("*");
        cosas.addItem("/");
        cosas2= new JComboBox ();
        cosas2.addItem("+");
        cosas2.addItem("-");
        cosas2.addItem("*");
        cosas2.addItem("/");
        FlowLayout dis= new  FlowLayout();
        setLayout(dis);
    
        add(etiqueta);
        add(ingresaretiqueta);
        add(etiqueta2);
        add(ingresaretiqueta2);
        add(selecop1);
        add(cosas);
        add(resultado1);
        add(ingresaretiqueta3);
        add(selecop2);
        add(cosas2);
        add(resultado2);
        add(ingresaretiqueta4);
        add(boton);
       
        setVisible(true);
        
        
        /*
       public void actionPerformed(ActionEvent e) {
         if (e.getSource()== botonBuscar )
         {
             String palabraIngresada= textoBusqueda.getText();
             for(String palabraBuena : listaPalabrasBuenas) 
             {
                   if (palabraBuena.equals(palabraIngresada))
                   {
                      resultado.setText("Buena Palabra");
                   }
                   
             }
             for(String palabraMala : listaPalabrasMalas) 
             {
                   if (palabraMala.equals(palabraIngresada))
                   {
                      resultado.setText("Mala Palabra");
                   }
                   
             }
         }
         */
    
    }
    
     public void actionPerformed(ActionEvent e) {
        try { 
  
         Double primero=Double.parseDouble(ingresaretiqueta.getText());
         ingresaretiqueta.setBackground(Color.white);
         try { 
         Double segundo=Double.parseDouble(ingresaretiqueta2.getText());
         String s= cosas.getSelectedItem().toString();
         String s1= cosas2.getSelectedItem().toString();
         hc= new Hilocalculadora(primero,segundo,s);
         hc1= new Hilocalculadora1(primero,segundo,s1);
         hc.start();
         hc1.start();
       
         ingresaretiqueta2.setBackground(Color.white);
         }catch(Exception e1){
              ingresaretiqueta2.setText("error al escribir");
              ingresaretiqueta2.setBackground(Color.red);
         }   
        }catch(Exception e1){
              ingresaretiqueta.setText("error al escribir");
               ingresaretiqueta.setBackground(Color.red);
        }
            
       
    }

  
    
   public class Hilocalculadora extends Thread{

    
    private Double numero1;
    private Double numero2;
    private String signo;
    private String escribir;
 

    public Hilocalculadora (Double numero1, Double numero2,String signo){
        this.numero1=numero1;
        this.numero2=numero2;
        this.signo=signo;
        this.escribir="";
       
        
        
    }

    @Override
    public void run() {
        try {
              // variable que guardará el resultado de nuestra correspondiente operacion según el signo a comprobar
               Double resultadooperacion=0.0;
                if(signo.equals("+")){
                    resultadooperacion=numero1+ numero2;
                }else if(signo.equals("-")){
                    resultadooperacion=numero1- numero2;
                 }else if(signo.equals("*")){
                     resultadooperacion=numero1* numero2;
                   }else if(signo.equals("/")){
                     resultadooperacion=numero1/ numero2;  
                   }
                escribir= String.valueOf(resultadooperacion);
                // despues de pasar a string nuestro resultado, lo desplegamos por el interfaz en pantalla
                 
                ingresaretiqueta3.setText(escribir);
        
         // comprobamos si nuestra operacion no es division de cero
        } catch (ArithmeticException e) {
            System.out.println("division por cero");
            ingresaretiqueta3.setText("division por cero");
            
        }
    }

}
   
   
    public class Hilocalculadora1 extends Thread{

    
    private Double numero1;
    private Double numero2;
    private String signo;
    private String escribir;
 

    public Hilocalculadora1 (Double numero1, Double numero2,String signo){
        this.numero1=numero1;
        this.numero2=numero2;
        this.signo=signo;
        this.escribir="";
       
        
        
    }

    @Override
    public void run() {
        try {
              // variable que guardará el resultado de nuestra correspondiente operacion según el signo a comprobar
               Double resultadooperacion=0.0;
                if(signo.equals("+")){
                    resultadooperacion=numero1+ numero2;
                }else if(signo.equals("-")){
                    resultadooperacion=numero1- numero2;
                 }else if(signo.equals("*")){
                     resultadooperacion=numero1* numero2;
                   }else if(signo.equals("/")){
                     resultadooperacion=numero1/ numero2;  
                   }
                escribir= String.valueOf(resultadooperacion);
                // despues de pasar a string nuestro resultado, lo desplegamos por el interfaz en pantalla
                ingresaretiqueta4.setText(escribir);
        
         // comprobamos si nuestra operacion no es division de cero
        } catch (ArithmeticException e) {
            System.out.println("division por cero");
            ingresaretiqueta4.setText("division por cero");
            
        }
    }

}
   
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        NuevaPrueba graficador= new NuevaPrueba();
        graficador.setVisible(true);
        
    }
}
