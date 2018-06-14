/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevaguiprueba;



import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author PDI
 */
public class NuevaGuiPrueba extends  JFrame implements ActionListener {
private String[] listaPalabrasBuenas= {"felicidad", "esperanza", "risa"};
private String[] listaPalabrasMalas= {"pena", "egoismo", "odio"};
private JButton boton;
private JTextField ingresaretiqueta;
private JTextField ingresaretiqueta2;
private JTextField ingresaretiqueta3;
private JTextField ingresaretiqueta4;
private JLabel resultado;
private JComboBox cosas; 


public class hilo extends Thread{

}

    public NuevaGuiPrueba()  {
        
        super("ventana de prueba");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,400);
        JLabel etiqueta= new JLabel("primer parametro ");
        JLabel etiqueta2= new JLabel("segundo parametro ");
        JLabel etiqueta3= new JLabel("tercer parametro ");
        JLabel etiqueta4= new JLabel("cuarto parametro ");
        boton= new JButton ("accionar");
        boton.addActionListener(this);
        ingresaretiqueta = new JTextField(20);
        ingresaretiqueta2 = new JTextField(20);
        ingresaretiqueta3 = new JTextField(20);
        ingresaretiqueta4 = new JTextField(20);
        cosas= new JComboBox ();
        cosas.addItem("MERMELA DE COCO");
        cosas.addItem("WALDOLOOOOOOORS");
        cosas.addItem("NOSSA NOSSA");
        cosas.addItem("PRUEBA");
        
        add(etiqueta);
        add(ingresaretiqueta);
        add(etiqueta2);
        add(ingresaretiqueta2);
        add(etiqueta3);
        add(ingresaretiqueta3);
        add(etiqueta4);
        add(ingresaretiqueta4);
        add(cosas);
        add(boton);
        FlowLayout dis= new  FlowLayout();
        setLayout(dis);
    
        setVisible(true);
        
        /*
         * 
        textoBusqueda= new JTextField(10);
        botonBuscar= new JButton("Buscar");
        botonBuscar.addActionListener(this);
        botonBuscar.setName("botonBusqueda");
        resultado= new JLabel();
        setLayout(new FlowLayout());
        add(etiqueta);
        add(textoBusqueda);
        add(botonBuscar);
        add(resultado);
        add(etiqueta2);
        setVisible(true);
         
         
         
         
         
         
         
           JComboBox cosas= new JComboBox ();
        cosas.addItem("MERMELA DE COCO");
        cosas.addItem("WALDOLOOOOOOORS");
        cosas.addItem("NOSSA NOSSA");
        cosas.addItem("PRUEBA");
         
         
         
         
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
         
         if(cosas.getSelectedItem().equals("PRUEBA")){
          ingresaretiqueta2.setText(ingresaretiqueta.getText());
          ingresaretiqueta3.setText(ingresaretiqueta.getText());
          ingresaretiqueta4.setText(ingresaretiqueta.getText());
         }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        NuevaGuiPrueba graficador= new NuevaGuiPrueba();
        graficador.setVisible(true);
    }
}
